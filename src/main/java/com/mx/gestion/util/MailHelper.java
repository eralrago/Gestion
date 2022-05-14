package com.mx.gestion.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.mx.clientes.mail.beans.Adjunto;
import com.mx.clientes.mail.beans.Correo;

public class MailHelper {
	private static Logger log = Logger.getLogger(MailHelper.class);
	private List<Correo> alTo = null;
	private List<Correo> alCC = null;
	private List<Correo> alBCC = null;
	private List<Adjunto> alAttachtments = null;
	private String mailBody = null;
	private String subject = null;
	
	public MailHelper() {
		alTo = new ArrayList<Correo>();
		alCC = new ArrayList<Correo>();
		alBCC = new ArrayList<Correo>();
		alAttachtments = new ArrayList<Adjunto>();
	}
	
	public void addTo(Correo bean) {
		alTo.add(bean);
	}
	
	public void addCC(Correo bean) {
		alCC.add(bean);
	}
	
	public void addBCC(Correo bean) {
		alBCC.add(bean);
	}
	
	public void addAttachment(Adjunto bean) {
		alAttachtments.add(bean);
	}
	
	public void sendJndiMailMessage() {
		
		Session     sesionE = null;
		Properties  props = null;
		String      user = null;
		String      password = null;
		
		try {
			log.info("Enviando notificacion por correo electronico..");
			
			
			
			log.debug("Obteniendo propiedades de configuracion JNDI...");
			//props = this.getProperties();
			props = this.getServerProperties();
			
			user = props.getProperty("mail.smtp.user");
			password = props.getProperty("mail.smtp.password");
			
			log.debug("Estableciendo autenticador...");
			SmtpAuthenticator authenticator = new SmtpAuthenticator();
			authenticator.setUserName(user);
			authenticator.setPassword(password);
			sesionE = Session.getInstance(props, authenticator);
			
			log.debug("Creando mensaje...");
			
			
			Message message = new MimeMessage(sesionE);
			message.setFrom(new InternetAddress(props.getProperty("mail.from"), props.getProperty("mail.from.name")));
			message.setSubject(this.subject);
			message.setContent(this.mailBody, "text/html; charset=UTF-8");
			
			log.debug("Estableciendo solicitud de acuse de recibo...");
			message.addHeader("Disposition-Notification-To", user);
			
			for(Correo bean : alTo) {
				//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(bean.getMail()));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(bean.getMail(), bean.getNombreBuzon()));
			}
			
			for(Correo bean : alCC) {
				//message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(bean.getMail()));
				message.addRecipient(Message.RecipientType.CC, new InternetAddress(bean.getMail(), bean.getNombreBuzon()));
			}
			
			for(Correo bean : alBCC) {
				//message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bean.getMail()));
				message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bean.getMail(), bean.getNombreBuzon()));
			}
			
			BodyPart messageBodyPart = new MimeBodyPart(); 
			messageBodyPart.setText(this.mailBody);
			messageBodyPart.setContent(this.mailBody, "text/html; charset=UTF-8");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			for(Adjunto bean : alAttachtments) {
				DataSource dataSource = new ByteArrayDataSource(bean.getContenido(), bean.getTipoArchivo());
	            MimeBodyPart fileBodyPart = new MimeBodyPart();
	            fileBodyPart.setDataHandler(new DataHandler(dataSource));
	            fileBodyPart.setFileName(bean.getNombreArchivo());
				multipart.addBodyPart(fileBodyPart);
			}
			
			message.setContent(multipart);
			
			
			log.debug("Enviando mensaje...");
			Transport.send(message);
			
			log.info("Notificacion enviada por correo electronico.");
			
		} catch (MessagingException ex) {
			log.error(ex);
		} catch (Exception ex) {
			log.error(ex);
		}
		
	}
	
	public Properties getServerProperties() throws NamingException {
		Session     sesion = null;
		Object      obj = null;
		Context     ic = null;
		Context     env = null;
		String      jndiName = null;
		
		jndiName = this.getJndiName("java:comp/env/MailNOTIFICACIONES");
		jndiName = "mail/notificaciones";
		
		ic = new InitialContext();
		env = (Context) ic.lookup("java:/comp/env");
		obj = env.lookup(jndiName);
		sesion = (Session) obj;
		
		log.debug("Obteniendo propiedades de configuracion JNDI...");
		Properties props = sesion.getProperties();
		return props;
	}
	
	public String getJndiName(String name){
		InitialContext initContext = null;
		String jniName = null;
			
		try {
			initContext = new InitialContext();
			jniName = (String) initContext.lookup(name);
		} catch(NamingException ex) {
			log.error(ex);
		} catch(Exception ex) {
			log.error(ex);
		}
		
		return jniName;
	}
	
	private Properties getProperties() {
		Properties prop = null;
		InputStream input = null;
		String propertiesPath = null;
		File propertiesFile = null;
		try {
			propertiesPath = "/recursos/mail/mail.properties";
			propertiesFile = new File(getClass().getResource(propertiesPath).getFile());
			input = new FileInputStream(propertiesFile);

            prop = new Properties();
            prop.load(input);
            
            log.debug(prop.getProperty("mail.debug"));
            log.debug(prop.getProperty("mail.from"));
            log.debug(prop.getProperty("mail.from.name"));
            log.debug(prop.getProperty("mail.smtp.auth"));
            log.debug(prop.getProperty("mail.smtp.debug"));
            log.debug(prop.getProperty("mail.smtp.dsn.notify"));
            log.debug(prop.getProperty("mail.smtp.dsn.ret"));
            log.debug(prop.getProperty("mail.smtp.host"));
            log.debug(prop.getProperty("mail.smtp.password"));
            log.debug(prop.getProperty("mail.smtp.port"));
            log.debug(prop.getProperty("mail.smtp.socketFactory.class"));
            log.debug(prop.getProperty("mail.smtp.socketFactory.fallback"));
            log.debug(prop.getProperty("mail.smtp.socketFactory.port"));
            log.debug(prop.getProperty("mail.smtp.starttls.enable"));
            log.debug(prop.getProperty("mail.smtp.user"));
            log.debug(prop.getProperty("mail.transport.protocol"));
            
        } catch (IOException ex) {
            log.error("Problema para obtener las propiedades de e-mail...", ex);
        }
		return prop;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}