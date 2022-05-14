package com.mx.gestion.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


import com.mx.clientes.beans.MbInventario;
import com.mx.clientes.mail.beans.Adjunto;
import com.mx.clientes.mail.beans.ClienteContacto;
import com.mx.clientes.mail.beans.Correo;
import com.mx.clientes.mail.beans.Mail;
import com.mx.clientes.mail.beans.MedioContacto;
import com.mx.clientes.mail.beans.Planta;
import com.mx.clientes.mail.beans.Usuario;
import com.mx.clientes.mail.business.ContactosBL;
import com.mx.clientes.mail.mngr.MedioContactoManager;
import com.mx.clientes.mail.mngr.PlantaManager;
import com.mx.clientes.mail.mngr.UsuarioManager;

public class JasperReportUtil {
	
	public void createPdf(String nameFile, Map<String, Object> parameters, String path) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		OutputStream outputStream = null;

        JasperDesign desing = null;
		try {
//			desing = JRXmlLoader.load(this.getClass().getResourceAsStream(path));
			desing = JRXmlLoader.load(path);
			JasperReport report = JasperCompileManager.compileReport(desing);
			JasperPrint       jasperPrint  = JasperFillManager.fillReport(report, parameters);
	        
	        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

	        response.setHeader("Content-Disposition", "inline; filename="+nameFile);
	        outputStream = response.getOutputStream();
	        response.setContentType("application/pdf");

	        File f = File.createTempFile(nameFile, ".pdf");
	        JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(f));

	        byte[] bytes = Base64.encodeBase64(FileUtils.readFileToByteArray(f));// FileUtils.readFileToByteArray(f);// ;

	        byte[] output = new String(bytes, StandardCharsets.US_ASCII).getBytes();;

	        outputStream.write(output);
	        outputStream.flush();
	        outputStream.close();
		} catch (JRException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	}

////	public static ByteArrayOutputStream getOutputStreamFromReport(List list, Map map, String pathJasper) throws Exception {
//	public static ByteArrayOutputStream getOutputStreamFromReport(Map map, String pathJasper) throws Exception {
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
////		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
//
////		JasperPrint jp = JasperFillManager.fillReport(pathJasper, map, dataSource);
//		InputStream reportStream = MbInventario.class.getResourceAsStream(pathJasper);
//		if (reportStream == null) {
//		    throw new Exception("Report not found!");
//		}
//		JasperPrint jp = JasperFillManager.fillReport(pathJasper, map);
//
//		JasperExportManager.exportReportToPdfStream(jp, os);
//		os.flush();
//		os.close();
//		return os;
//	}
	
//	public static StreamedContent getStreamContentFromOutputStream(ByteArrayOutputStream os, String contentType,
//			String nameFile) throws Exception {
//		StreamedContent file = null;
//		InputStream is = new ByteArrayInputStream(os.toByteArray());
//		file = new DefaultStreamedContent();
//		return file;
//	}

////	public static StreamedContent getStreamContentReport(List list, Map map, String pathJasper, String nameFilePdf) throws Exception {
//	public static StreamedContent getStreamContentReport(Map map, String pathJasper, String nameFilePdf) throws Exception {
//		StreamedContent pdf = null;
////		JasperPrint jp = JasperFillManager.fillReport(pathJasper, map, dataSource);
//		JasperPrint jp = JasperFillManager.fillReport(pathJasper, map);
//
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
//		JasperExportManager.exportReportToPdfStream(jp, os);
//		os.flush();
//		os.close();
//
//		InputStream is = new ByteArrayInputStream(os.toByteArray());
//		pdf = new DefaultStreamedContent();
//		return pdf;
//	}
	
//	private void processReport(Connection conn, String folio, Integer idPlanta, Boolean isHorarioEspecial) {
//
//		String reportNameJASPER = null;
//		String logoPath = null;
//		File logoFile = null;
//		File reportFile = null;
//		String mailInventarioHTML = null;
//		File mailInventarioFile = null;
//		FileReader mailInventarioReader = null;
//		BufferedReader reader = null;
//		Map<String, Object> parameters = null;
//		StringBuilder sb = null;
//		String subject = null;
//		JRExporter            exporter         = null;
//		ByteArrayOutputStream output           = null;
//
//		log.info(String.format("Iniciando envío de correo para la orden de salida %s, idPlanta %d", folio, idPlanta));
//
//		try {
//			reportNameJASPER = "/recursos/jasper/SolicitudSalidaMercanciaNew.jrxml";
//			reportFile = new File(getClass().getResource(reportNameJASPER).getFile());
//
//			logoPath = "/recursos/images/logo.jpeg";
//			logoFile = new File(getClass().getResource(logoPath).getFile());
//			
//			parameters = new HashMap<String, Object>();
//			parameters.put("REPORT_CONNECTION", conn);
//			parameters.put("folioSalida", folio);
//			parameters.put("idPlanta", idPlanta);
//			parameters.put("esHorarioEspecial", isHorarioEspecial);
//			parameters.put("logoPath", logoFile.getPath());
//
//			subject = String.format("Orden de salida %s", folio);
//			log.info("Preparando para ejecutar el reporte...");
//			
//			JasperDesign      objJasperDesign = JRXmlLoader.load(reportFile);
//			JasperReport      objJasperReport = JasperCompileManager.compileReport(objJasperDesign);
//			
//			JasperPrint       objJasperPrint  = JasperFillManager.fillReport(objJasperReport, parameters);
//			output = new ByteArrayOutputStream();
//			
//			exporter = new JRPdfExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, objJasperPrint);
//			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
//			exporter.exportReport();
//			
//			byte[] bytes = output.toByteArray();
//			
//			//byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn);
//			log.info("Reporte jasper ejecutado, preparando envío de correo...");
//			mailInventarioHTML = "/recursos/mail/mailOrdenSalida.html";
//			mailInventarioFile = new File(getClass().getResource(mailInventarioHTML).getFile());
//			log.info("Ruta html mail: " + mailInventarioFile.getPath());
//			if(mailInventarioFile.exists() == false)
//				log.error("El archivo no existe: " + mailInventarioFile.getPath());
//			
//			mailInventarioReader = new FileReader(mailInventarioFile);
//			reader = new BufferedReader(mailInventarioReader);
//			sb = new StringBuilder();
//			String linea = null;
//			while ((linea = reader.readLine()) != null) {
//				sb.append(linea);
//			}
//			
//			String html = sb.toString();
//			MailHelper mailUtil = new MailHelper();
//			
//			ContactosBL contactosBO = new ContactosBL(idCliente);
//			ClienteContacto[] cteContactos = contactosBO.getClienteContactos(conn, this.idCliente);
//			Correo buzon = null;
//			log.info("Leyendo contactos del cliente...");
//			for (ClienteContacto cteContacto : cteContactos) {
//				log.info("Contacto: " + cteContacto.getContacto().getNombre() + " "
//						+ cteContacto.getContacto().getApellido1());
//				if (cteContacto.isHabilitado() == false)
//					continue;
//
//				MedioContacto[] medios = MedioContactoManager.get(conn, cteContacto.getIdContacto());
//
//				for (MedioContacto medio : medios) {
//					if ("M".equals(medio.getTipoMedio())) {
//						Mail mail = (Mail) medio;
//						log.info("Mail: " + mail.getMail());
//						buzon = new Correo(mail.getMail(),
//								cteContacto.getContacto().getNombre() + " " + cteContacto.getContacto().getApellido1()
//										+ " " + cteContacto.getContacto().getApellido2());
//						mailUtil.addTo(buzon);
//					}
//				}
//			}
//
//			Planta planta = PlantaManager.getPlanta(conn, idPlanta);
//			Usuario usuarioResponsable = null;
//			if (planta.getIdUsuario() != null) {
//				usuarioResponsable = UsuarioManager.getByIdUsuario(conn, planta.getIdUsuario());
//			}
//
//			if (usuarioResponsable != null) {
//				buzon = new Correo(usuarioResponsable.getMail(), usuarioResponsable.getNombre() + " "
//						+ usuarioResponsable.getApellido1() + " " + usuarioResponsable.getApellido2());
//				mailUtil.addCC(buzon);
//			}
//			
//			Adjunto attachment = new Adjunto("OrdenSalida" + folio + ".pdf", Adjunto.TP_ARCHIVO_PDF, bytes);
//
//			mailUtil.setMailBody(html);
//			mailUtil.setSubject(subject);
//			mailUtil.addAttachment(attachment);
//			mailUtil.sendJndiMailMessage();
//
//		} catch (JRException ex) {
//			ex.printStackTrace();
//			log.error("Problema para generar la orden de salida...", ex);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			log.error("Problema para enviar el correo electronico para la orden de salida " + folio, ex);
//		}
//
//	}

}
