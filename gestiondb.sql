-- gestion.[DBA].bancos definition

-- Drop table

-- DROP TABLE bancos;

CREATE TABLE bancos (
	id int AUTO_INCREMENT NOT NULL,
	clave varchar(30) NOT NULL,
	nombre varchar(30) NOT NULL,
	CONSTRAINT ASA100 PRIMARY KEY (id)
);


-- gestion.[DBA].bitacora definition

-- Drop table

-- DROP TABLE bitacora;

CREATE TABLE bitacora (
	id_bitacora int NOT NULL,
	id_usuario int NOT NULL,
	usuario varchar(15) NOT NULL,
	usuario_nombre varchar(30) NOT NULL,
	host_ip varchar(20) NOT NULL,
	host_nombre varchar(200) NOT NULL,
	cte_cve int NOT NULL,
	numero_cte varchar(15) NOT NULL,
	cte_nombre varchar(150) NOT NULL,
	cte_rfc varchar(20) NOT NULL,
	modulo_nombre varchar(50) NOT NULL,
	accion varchar(100) NOT NULL,
	valor_ant_nombre varchar(100) NOT NULL,
	valor_ant varchar(100) NOT NULL,
	valor_act_nombre varchar(100) NOT NULL,
	valor_act varchar(100) NOT NULL,
	otro_dato varchar(200) NOT NULL,
	fecha_cambio timestamp NOT NULL,
	CONSTRAINT ASA156 PRIMARY KEY (id_bitacora)
);


-- gestion.[DBA].candado_salida definition

-- Drop table

-- DROP TABLE candado_salida;

CREATE TABLE candado_salida (
	id int AUTO_INCREMENT NOT NULL,
	habilitado bit NOT NULL,
	cte_cve int NOT NULL,
	num_salidas int DEFAULT 1 NOT NULL,
	CONSTRAINT ASA154 PRIMARY KEY (id)
);

SHOW INDEX FROM  candado_salida;

-- gestion.[DBA].categoria definition

-- Drop table

-- DROP TABLE categoria;

CREATE TABLE categoria (
	categoria_cve int AUTO_INCREMENT NOT NULL,
	categoria_ds varchar(80) NOT NULL,
	CONSTRAINT pk_categoria_cve PRIMARY KEY (categoria_cve)
);


-- gestion.[DBA].CFG_SERIE_TP_FACTURA definition

-- Drop table

-- DROP TABLE CFG_SERIE_TP_FACTURA;

CREATE TABLE CFG_SERIE_TP_FACTURA (
	ID_SERIE int NOT NULL,
	ID_TP_FACTURA int NOT NULL
);


-- gestion.[DBA].cheque definition

-- Drop table

-- DROP TABLE cheque;

CREATE TABLE cheque (
	id int AUTO_INCREMENT NOT NULL,
	numero varchar(30) NOT NULL,
	banco int NOT NULL,
	monto numeric(12,2) NOT NULL,
	CONSTRAINT ASA101 PRIMARY KEY (id)
);


-- gestion.[DBA].CLIENTE definition

-- Drop table

-- DROP TABLE CLIENTE;

CREATE TABLE CLIENTE (
	CTE_CVE int AUTO_INCREMENT NOT NULL,
	CTE_NOMBRE varchar(150) NULL,
	CTE_RFC varchar(20) NULL,
	numero_cte varchar(15) NOT NULL,
	cte_mail varchar(255) NULL,
	habilitado bit DEFAULT 1 NOT NULL,
	COD_UNICO varchar(3) NULL,
	CONSTRAINT ASA81 PRIMARY KEY (CTE_CVE)
);


-- gestion.[DBA].cliente_contacto definition

-- Drop table

-- DROP TABLE cliente_contacto;

CREATE TABLE cliente_contacto (
	id_cliente int NOT NULL,
	id_contacto int NOT NULL,
	st_habilitado bit NOT NULL,
	nb_usuario varchar(50) NULL,
	nb_password varchar(1024) NULL,
	st_usuario varchar(1) DEFAULT 'A' NOT NULL,
	fh_alta date DEFAULT(curdate()) NOT NULL,
	fh_cad_passwd date NULL,
	fh_ult_acceso date NULL,
	CONSTRAINT ASA175 PRIMARY KEY (id_cliente,id_contacto)
);

-- gestion.[DBA].contacto definition

-- Drop table

-- DROP TABLE contacto;

CREATE TABLE contacto (
	id_contacto int NOT NULL,
	nb_nombre varchar(50) NOT NULL,
	nb_apellido_1 varchar(50) NOT NULL,
	nb_apellido_2 varchar(50) NOT NULL,
	CONSTRAINT ASA177 PRIMARY KEY (id_contacto)
);


-- gestion.[DBA].entidad_postal definition

-- Drop table

-- DROP TABLE entidad_postal;

CREATE TABLE entidad_postal (
	entidadpostal_cve int NOT NULL,
	entidadpostal_ds varchar(100) NULL,
	CONSTRAINT ASA104 PRIMARY KEY (entidadpostal_cve)
);


-- gestion.[DBA].estado_constancia definition

-- Drop table

-- DROP TABLE estado_constancia;

CREATE TABLE estado_constancia (
	edo_cve int NOT NULL,
	descripcion varchar(50) NOT NULL,
	CONSTRAINT ASA105 PRIMARY KEY (edo_cve)
);


-- gestion.[DBA].estado_inventario definition

-- Drop table

-- DROP TABLE estado_inventario;

CREATE TABLE estado_inventario (
	edo_inv_cve int NOT NULL,
	edo_descripcion varchar(50) NOT NULL,
	CONSTRAINT ASA106 PRIMARY KEY (edo_inv_cve)
);


-- gestion.[DBA].FORMATO definition

-- Drop table

-- DROP TABLE FORMATO;

CREATE TABLE FORMATO (
	FORMATO_CVE int NOT NULL,
	NOMBRE varchar(30) NULL,
	LONGITUD smallint NULL,
	`PRECISION` smallint NULL,
	CONSTRAINT ASA91 PRIMARY KEY (FORMATO_CVE)
);





-- gestion.[DBA].mail definition

-- Drop table

-- DROP TABLE mail;

CREATE TABLE mail (
	id_medio int NOT NULL,
	nb_mail varchar(100) NOT NULL,
	st_principal bit DEFAULT 1 NOT NULL,
	tp_mail smallint NOT NULL,
	CONSTRAINT ASA173 PRIMARY KEY (id_medio)
);


-- gestion.[DBA].medio_cnt definition

-- Drop table

-- DROP TABLE medio_cnt;

CREATE TABLE medio_cnt (
	id_medio int NOT NULL,
	tp_medio varchar(1) NOT NULL,
	st_medio bit DEFAULT 1 NOT NULL,
	id_contacto int NOT NULL,
	CONSTRAINT ASA174 PRIMARY KEY (id_medio,tp_medio)
);


-- gestion.[DBA].medio_pago definition

-- Drop table

-- DROP TABLE medio_pago;

CREATE TABLE medio_pago (
	mp_id int NOT NULL,
	mp_descripcion varchar(100) NOT NULL,
	mp_req_referencia bit NOT NULL,
	CONSTRAINT ASA165 PRIMARY KEY (mp_id)
);


-- gestion.[DBA].PAIS definition

-- Drop table

-- DROP TABLE PAIS;

CREATE TABLE PAIS (
	pais_cve int NOT NULL,
	pais_desc varchar(150) NOT NULL,
	CONSTRAINT PK_PAIS PRIMARY KEY (pais_cve)
);


-- gestion.[DBA].paises definition

-- Drop table

-- DROP TABLE paises;

CREATE TABLE paises (
	pais_cve int NOT NULL,
	pais_desc char(30) NOT NULL,
	pais_ds_corta char(4) NULL,
	CONSTRAINT ASA110 PRIMARY KEY (pais_cve)
);


-- gestion.[DBA].parametro definition

-- Drop table

-- DROP TABLE parametro;

CREATE TABLE parametro (
	id int NOT NULL,
	nombre varchar(100) NOT NULL,
	valor varchar(1000) NOT NULL,
	CONSTRAINT ASA163 PRIMARY KEY (id)
);
CREATE UNIQUE INDEX [parametro UNIQUE (nombre)] ON parametro (nombre);

-- gestion.[DBA].pbcatcol definition

-- Drop table

-- DROP TABLE pbcatcol;

CREATE TABLE pbcatcol (
	pbc_tnam char(129) NOT NULL,
	pbc_tid int NULL,
	pbc_ownr char(129) NOT NULL,
	pbc_cnam char(129) NOT NULL,
	pbc_cid smallint NULL,
	pbc_labl char(254) NULL,
	pbc_lpos smallint NULL,
	pbc_hdr char(254) NULL,
	pbc_hpos smallint NULL,
	pbc_jtfy smallint NULL,
	pbc_mask char(31) NULL,
	pbc_case smallint NULL,
	pbc_hght smallint NULL,
	pbc_wdth smallint NULL,
	pbc_ptrn char(31) NULL,
	pbc_bmap char(1) NULL,
	pbc_init char(254) NULL,
	pbc_cmnt char(254) NULL,
	pbc_edit char(31) NULL,
	pbc_tag char(254) NULL
);
CREATE UNIQUE INDEX pbcatc_x ON pbcatcol (pbc_tnam,pbc_ownr,pbc_cnam);

-- gestion.[DBA].pbcatedt definition

-- Drop table

-- DROP TABLE pbcatedt;

CREATE TABLE pbcatedt (
	pbe_name char(30) NOT NULL,
	pbe_edit char(254) NULL,
	pbe_type smallint NULL,
	pbe_cntr int NULL,
	pbe_seqn smallint NOT NULL,
	pbe_flag int NULL,
	pbe_work char(32) NULL
);
CREATE UNIQUE INDEX pbcate_x ON pbcatedt (pbe_name,pbe_seqn);


-- gestion.[DBA].pbcatfmt definition

-- Drop table

-- DROP TABLE pbcatfmt;

CREATE TABLE pbcatfmt (
	pbf_name char(30) NOT NULL,
	pbf_frmt char(254) NULL,
	pbf_type smallint NULL,
	pbf_cntr int NULL
);
CREATE UNIQUE INDEX pbcatf_x ON pbcatfmt (pbf_name);


-- gestion.[DBA].pbcattbl definition

-- Drop table

-- DROP TABLE pbcattbl;

CREATE TABLE pbcattbl (
	pbt_tnam char(129) NOT NULL,
	pbt_tid int NULL,
	pbt_ownr char(129) NOT NULL,
	pbd_fhgt smallint NULL,
	pbd_fwgt smallint NULL,
	pbd_fitl char(1) NULL,
	pbd_funl char(1) NULL,
	pbd_fchr smallint NULL,
	pbd_fptc smallint NULL,
	pbd_ffce char(18) NULL,
	pbh_fhgt smallint NULL,
	pbh_fwgt smallint NULL,
	pbh_fitl char(1) NULL,
	pbh_funl char(1) NULL,
	pbh_fchr smallint NULL,
	pbh_fptc smallint NULL,
	pbh_ffce char(18) NULL,
	pbl_fhgt smallint NULL,
	pbl_fwgt smallint NULL,
	pbl_fitl char(1) NULL,
	pbl_funl char(1) NULL,
	pbl_fchr smallint NULL,
	pbl_fptc smallint NULL,
	pbl_ffce char(18) NULL,
	pbt_cmnt char(254) NULL
);
CREATE UNIQUE INDEX pbcatt_x ON pbcattbl (pbt_tnam,pbt_ownr);


-- gestion.[DBA].pbcatvld definition

-- Drop table

-- DROP TABLE pbcatvld;

CREATE TABLE pbcatvld (
	pbv_name char(30) NOT NULL,
	pbv_vald char(254) NULL,
	pbv_type smallint NULL,
	pbv_cntr int NULL,
	pbv_msg char(254) NULL
);
CREATE UNIQUE INDEX pbcatv_x ON pbcatvld (pbv_name);


-- gestion.[DBA].perfil definition

-- Drop table

-- DROP TABLE perfil;

CREATE TABLE perfil (
	id int NOT NULL,
	nombre varchar(30) NOT NULL,
	descripcion varchar(255) NULL,
	CONSTRAINT ASA125 PRIMARY KEY (id)
);


-- gestion.[DBA].PLANTA definition

-- Drop table

-- DROP TABLE PLANTA;

CREATE TABLE PLANTA (
	PLANTA_CVE int NOT NULL,
	PLANTA_DS varchar(80) NULL,
	planta_abrev varchar(6) NULL,
	planta_sufijo varchar(6) NULL,
	PLANTA_COD varchar(10) NULL,
	id_usuario int NULL,
	CONSTRAINT ASA93 PRIMARY KEY (PLANTA_CVE)
);
CREATE INDEX Index_1 ON PLANTA (PLANTA_CVE);


-- gestion.[DBA].posicion definition

-- Drop table

-- DROP TABLE posicion;

CREATE TABLE posicion (
	id_posicion int NOT NULL,
	id_planta int NOT NULL,
	id_camara int NOT NULL,
	cod_posicion varchar(10) NOT NULL,
	desc_posicion varchar(200) NOT NULL,
	temp_ini decimal(5,2) NOT NULL,
	temp_fin decimal(5,2) NOT NULL,
	habilitada bit NOT NULL,
	CONSTRAINT ASA169 PRIMARY KEY (id_posicion)
);


-- gestion.[DBA].pre_salida definition

-- Drop table

-- DROP TABLE pre_salida;

CREATE TABLE pre_salida (
	id_pre_salida int AUTO_INCREMENT NOT NULL,
	cd_folio_salida varchar(10) NOT NULL,
	st_estado varchar(1) DEFAULT 'A' NOT NULL,
	fh_salida date NOT NULL,
	tm_salida time(0) NOT NULL,
	nb_placa_tte varchar(8) NULL,
	nb_operador_tte varchar(100) NULL,
	partida_cve int NOT NULL,
	folio int NOT NULL,
	nu_cantidad int NOT NULL,
	CONSTRAINT ASA179 PRIMARY KEY (id_pre_salida)
);


-- gestion.[DBA].pre_salida_obs definition

-- Drop table

-- DROP TABLE pre_salida_obs;

CREATE TABLE pre_salida_obs (
	cd_folio_salida varchar(10) NOT NULL,
	nb_observaciones varchar(200) NOT NULL
);


-- gestion.[DBA].pre_salida_srv definition

-- Drop table

-- DROP TABLE pre_salida_srv;

CREATE TABLE pre_salida_srv (
	cd_folio_salida varchar(10) NOT NULL,
	id_servicio int NOT NULL,
	nu_cantidad int NOT NULL
);


-- gestion.[DBA].PRODUCTO definition

-- Drop table

-- DROP TABLE PRODUCTO;

CREATE TABLE PRODUCTO (
	PRODUCTO_CVE int AUTO_INCREMENT NOT NULL,
	PRODUCTO_DS varchar(80) NULL,
	NUMERO_PROD varchar(15) NOT NULL,
	categoria int DEFAULT 0 NOT NULL,
	CONSTRAINT ASA130 PRIMARY KEY (PRODUCTO_CVE)
);
CREATE INDEX Index_1 ON PRODUCTO (PRODUCTO_CVE);


-- gestion.[DBA].producto_constancia definition

-- Drop table

-- DROP TABLE producto_constancia;

CREATE TABLE producto_constancia (
	id int AUTO_INCREMENT NOT NULL,
	descripcion varchar(255) NOT NULL,
	constancia int NOT NULL,
	catidad_cobro decimal(12,3) NOT NULL,
	unidad_cobro varchar(255) NOT NULL,
	cantidad_manejo numeric(12,2) NULL,
	unidad_manejo varchar(255) NULL,
	planta_cve int NULL,
	planta_ds varchar(80) NULL,
	planta_abrev varchar(6) NULL,
	camara_cve int NULL,
	camara_ds varchar(80) NULL,
	camara_abrev varchar(6) NULL,
	CONSTRAINT ASA112 PRIMARY KEY (id)
);
CREATE INDEX IDX_PRODUCTO_CONSTANCIA_ID ON producto_constancia (id);
CREATE INDEX IDX_PRODUCTO_CONSTANCIA_ID_CONST ON producto_constancia (constancia);


-- gestion.[DBA].serie_constancia definition

-- Drop table

-- DROP TABLE serie_constancia;

CREATE TABLE serie_constancia (
	id_cliente int NOT NULL,
	tp_serie varchar(1) NOT NULL,
	nu_serie int NOT NULL,
	CONSTRAINT ASA178 PRIMARY KEY (id_cliente,tp_serie)
);


-- gestion.[DBA].servicio_constancia definition

-- Drop table

-- DROP TABLE servicio_constancia;

CREATE TABLE servicio_constancia (
	id int AUTO_INCREMENT NOT NULL,
	descripcion varchar(255) NOT NULL,
	constancia int NOT NULL,
	costo numeric(13,5) NOT NULL,
	tarifa numeric(13,5) NULL,
	baseCargo numeric(12,3) NULL,
	planta_cve int NULL,
	planta_ds varchar(80) NULL,
	planta_abrev varchar(6) NULL,
	camara_cve int NULL,
	camara_ds varchar(80) NULL,
	camara_abrev varchar(80) NULL,
	unidad_medida varchar(20) NULL,
	codigo varchar(20) NULL,
	planta_cod varchar(10) NULL,
	CONSTRAINT ASA113 PRIMARY KEY (id)
);
CREATE INDEX IDX_SERVICIO_CONSTANCIA_ID ON servicio_constancia (id);
CREATE INDEX IDX_SERVICIO_CONSTANCIA_ID_CONST ON servicio_constancia (constancia);


-- gestion.[DBA].SERVICIO_UD_COBRO definition

-- Drop table

-- DROP TABLE SERVICIO_UD_COBRO;

CREATE TABLE SERVICIO_UD_COBRO (
	id_servicio int NOT NULL,
	id_unidad varchar(10) NOT NULL,
	cd_servicio varchar(20) NOT NULL
);


-- gestion.[DBA].STATUS_CONSTANCIA_SALIDA definition

-- Drop table

-- DROP TABLE STATUS_CONSTANCIA_SALIDA;

CREATE TABLE STATUS_CONSTANCIA_SALIDA (
	ID int NOT NULL,
	NOMBRE varchar(20) NULL,
	DESCRIPCION varchar(75) NULL,
	CONSTRAINT ASA150 PRIMARY KEY (ID)
);


-- gestion.[DBA].STATUS_CONSTANCIA_SERVICIO definition

-- Drop table

-- DROP TABLE STATUS_CONSTANCIA_SERVICIO;

CREATE TABLE STATUS_CONSTANCIA_SERVICIO (
	ID int NOT NULL,
	NOMBRE varchar(20) NULL,
	DESCRIPCION varchar(50) NULL,
	CONSTRAINT ASA142 PRIMARY KEY (ID)
);


-- gestion.[DBA].status_factura definition

-- Drop table

-- DROP TABLE status_factura;

CREATE TABLE status_factura (
	id int AUTO_INCREMENT NOT NULL,
	nombre varchar(30) NOT NULL,
	descripcion varchar(255) NULL,
	CONSTRAINT ASA115 PRIMARY KEY (id)
);

-- gestion.[DBA].STATUS_NOTA_CREDITO definition

-- Drop table

-- DROP TABLE STATUS_NOTA_CREDITO;

CREATE TABLE STATUS_NOTA_CREDITO (
	ID int AUTO_INCREMENT NOT NULL,
	DESCRIPCION varchar(50) NULL,
	CONSTRAINT ASA138 PRIMARY KEY (ID)
);


-- gestion.[DBA].status_serie definition

-- Drop table

-- DROP TABLE status_serie;

CREATE TABLE status_serie (
	id int AUTO_INCREMENT NOT NULL,
	descripcion varchar(30) NOT NULL,
	CONSTRAINT ASA126 PRIMARY KEY (id)
);


-- gestion.[DBA].telefono definition

-- Drop table

-- DROP TABLE telefono;

CREATE TABLE telefono (
	id_medio int NOT NULL,
	nb_telefono varchar(16) NOT NULL,
	st_principal bit DEFAULT 1 NOT NULL,
	tp_telefono smallint NOT NULL,
	CONSTRAINT ASA176 PRIMARY KEY (id_medio)
);


-- gestion.[DBA].tipo_asentamiento definition

-- Drop table

-- DROP TABLE tipo_asentamiento;

CREATE TABLE tipo_asentamiento (
	tipoasntmnto_cve smallint NOT NULL,
	tipoasntmnto_ds varchar(100) NULL,
	tipoasntmnto_ds_corta char(4) NULL,
	CONSTRAINT ASA117 PRIMARY KEY (tipoasntmnto_cve)
);


-- gestion.[DBA].tipo_cobro definition

-- Drop table

-- DROP TABLE tipo_cobro;

CREATE TABLE tipo_cobro (
	id int NOT NULL,
	nombre varchar(30) NOT NULL,
	descripcion varchar(255) NULL,
	CONSTRAINT ASA118 PRIMARY KEY (id)
);


-- gestion.[DBA].TIPO_FACTURACION definition

-- Drop table

-- DROP TABLE TIPO_FACTURACION;

CREATE TABLE TIPO_FACTURACION (
	ID int NULL,
	NOMBRE varchar(30) NULL,
	DESCRIPCION varchar(75) NULL
);


-- gestion.[DBA].tipo_mail definition

-- Drop table

-- DROP TABLE tipo_mail;

CREATE TABLE tipo_mail (
	tp_mail smallint NOT NULL,
	nb_tipo varchar(50) NOT NULL,
	CONSTRAINT ASA171 PRIMARY KEY (tp_mail)
);


-- gestion.[DBA].TIPO_MOVIMIENTO definition

-- Drop table

-- DROP TABLE TIPO_MOVIMIENTO;

CREATE TABLE TIPO_MOVIMIENTO (
	CLAVE int NOT NULL,
	TIPO varchar(50) NULL,
	CONSTRAINT ASA96 PRIMARY KEY (CLAVE)
);


-- gestion.[DBA].tipo_pago definition

-- Drop table

-- DROP TABLE tipo_pago;

CREATE TABLE tipo_pago (
	id int AUTO_INCREMENT NOT NULL,
	nombre varchar(30) NOT NULL,
	descripcion varchar(255) NULL,
	CONSTRAINT ASA119 PRIMARY KEY (id)
);


-- gestion.[DBA].tipo_telefono definition

-- Drop table

-- DROP TABLE tipo_telefono;

CREATE TABLE tipo_telefono (
	tp_telefono smallint NOT NULL,
	nb_telefono varchar(50) NOT NULL,
	CONSTRAINT ASA172 PRIMARY KEY (tp_telefono)
);


-- gestion.[DBA].tipos_domicilio definition

-- Drop table

-- DROP TABLE tipos_domicilio;

CREATE TABLE tipos_domicilio (
	domicilio_tipo_cve smallint AUTO_INCREMENT NOT NULL,
	domicilio_tipo_desc char(30) NOT NULL,
	CONSTRAINT ASA121 PRIMARY KEY (domicilio_tipo_cve)
);


-- gestion.[DBA].tmp_entradas_a_facturar definition

-- Drop table

-- DROP TABLE tmp_entradas_a_facturar;

CREATE TABLE tmp_entradas_a_facturar (
	tmp_cve int AUTO_INCREMENT NOT NULL,
	usuario varchar(15) NOT NULL,
	folio int NOT NULL,
	folio_cliente char(8) NOT NULL,
	ingreso date NOT NULL,
	vencimiento date NOT NULL,
	servicio varchar(80) NOT NULL,
	cuota numeric(13,5) NOT NULL,
	unidad varchar(100) NOT NULL,
	cantidad decimal(12,3) NOT NULL,
	importe numeric(12,4) NOT NULL,
	iva numeric(12,4) NOT NULL,
	total numeric(12,4) NOT NULL,
	servicio_cve int NOT NULL,
	producto_cve int NULL,
	producto varchar(80) NOT NULL,
	cantidad_ser numeric(6,2) NOT NULL,
	peso int NOT NULL,
	unidad_cobro varchar(100) NOT NULL,
	valor numeric(12,4) NULL,
	partida_cve int NULL,
	plazo int NULL,
	planta_cve int NULL,
	camara_cve int NULL,
	CONSTRAINT ASA168 PRIMARY KEY (tmp_cve)
);


-- gestion.[DBA].TMP_FACTURAR_INVENTARIO definition

-- Drop table

-- DROP TABLE TMP_FACTURAR_INVENTARIO;

CREATE TABLE TMP_FACTURAR_INVENTARIO (
	usuario varchar(15) NOT NULL,
	cte_cve int NOT NULL,
	tmp_cve int NOT NULL,
	folio int NOT NULL,
	folio_cliente char(8) NOT NULL,
	fecha_deposito date NOT NULL,
	servicio_inicio date NOT NULL,
	servicio_fin date NOT NULL,
	servicio_dias int NOT NULL,
	servicio_cve int NOT NULL,
	servicio varchar(80) NOT NULL,
	cantidad_ser numeric(6,2) NOT NULL,
	cuota numeric(13,5) NOT NULL,
	cuota_diaria numeric(15,7) NOT NULL,
	producto_cve int NULL,
	producto varchar(80) NOT NULL,
	peso numeric(13,3) NOT NULL,
	unidad varchar(100) NOT NULL,
	cantidad numeric(12,3) NOT NULL,
	unidad_cobro varchar(100) NOT NULL,
	valor numeric(12,4) NULL,
	partida_cve int NULL,
	importe numeric(12,4) NOT NULL,
	iva numeric(12,4) NOT NULL,
	total numeric(12,4) NOT NULL,
	plazo int NULL,
	planta_cve int NULL,
	camara_cve int NULL,
	no_tarimas decimal(9,3) DEFAULT 0 NOT NULL,
	CONSTRAINT PK_TMP_FACTURAR_INVENTARIO PRIMARY KEY (usuario,cte_cve,tmp_cve)
);


-- gestion.[DBA].ud_cobro definition

-- Drop table

-- DROP TABLE ud_cobro;

CREATE TABLE ud_cobro (
	id_unidad varchar(10) NOT NULL,
	nb_unidad varchar(100) NOT NULL,
	cd_unidad varchar(20) NOT NULL,
	CONSTRAINT ASA170 PRIMARY KEY (id_unidad)
);


-- gestion.[DBA].UNIDAD_DE_MANEJO definition

-- Drop table

-- DROP TABLE UNIDAD_DE_MANEJO;

CREATE TABLE UNIDAD_DE_MANEJO (
	UNIDAD_DE_MANEJO_CVE int AUTO_INCREMENT NOT NULL,
	UNIDAD_DE_MANEJO_DS varchar(100) NULL,
	CONSTRAINT ASA97 PRIMARY KEY (UNIDAD_DE_MANEJO_CVE)
);


-- gestion.[DBA].usuario definition

-- Drop table

-- DROP TABLE usuario;

CREATE TABLE usuario (
	id int AUTO_INCREMENT NOT NULL,
	usuario varchar(15) NOT NULL,
	password varchar(15) NOT NULL,
	nombre varchar(30) NULL,
	descripcion varchar(255) NULL,
	perfil int NOT NULL,
	apellido_1 varchar(50) NULL,
	apellido_2 varchar(50) NULL,
	mail varchar(100) NULL,
	id_planta int NULL,
	st_ntf_srv_ext bit DEFAULT 0 NOT NULL,
	st_usuario varchar(1) DEFAULT 'A' NOT NULL,
	CONSTRAINT ASA124 PRIMARY KEY (id)
);


-- gestion.[DBA].asentamiento_humano definition

-- Drop table

-- DROP TABLE asentamiento_humano;

CREATE TABLE asentamiento_humano (
	pais_cve int NOT NULL,
	estado_cve int NOT NULL,
	municipio_cve int NOT NULL,
	ciudad_cve int NOT NULL,
	tipoasntmnto_cve smallint NOT NULL,
	entidadpostal_cve int NOT NULL,
	asentamiento_cve int NOT NULL,
	asentamiento_ds varchar(150) NULL,
	cp char(5) NULL,
	CONSTRAINT ASA99 PRIMARY KEY (pais_cve,estado_cve,municipio_cve,ciudad_cve,tipoasntmnto_cve,entidadpostal_cve,asentamiento_cve),
	CONSTRAINT FK_ASENTAMI_ENTDADPST_ENTIDAD_ FOREIGN KEY (entidadpostal_cve) REFERENCES entidad_postal(entidadpostal_cve) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_ASENTAMI_TPOASNTMN_TIPO_ASE FOREIGN KEY (tipoasntmnto_cve) REFERENCES tipo_asentamiento(tipoasntmnto_cve) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX ciddes_asntmntohmno_fk ON asentamiento_humano (pais_cve,estado_cve,municipio_cve,ciudad_cve);
CREATE INDEX entdadpstal_asntnmtoh_fk ON asentamiento_humano (entidadpostal_cve);
CREATE INDEX tpoasntmnto_antmntoh_fk ON asentamiento_humano (tipoasntmnto_cve);


-- gestion.[DBA].aviso definition

-- Drop table

-- DROP TABLE aviso;

CREATE TABLE aviso (
	aviso_cve int AUTO_INCREMENT NOT NULL,
	aviso_po bit DEFAULT 0 NOT NULL,
	aviso_pedimento bit DEFAULT 0 NOT NULL,
	aviso_sap bit DEFAULT 0 NOT NULL,
	aviso_lote bit DEFAULT 0 NOT NULL,
	aviso_caducidad bit DEFAULT 0 NOT NULL,
	aviso_tarima bit DEFAULT 0 NOT NULL,
	aviso_otro bit DEFAULT 0 NOT NULL,
	aviso_temp varchar(50) NULL,
	aviso_fecha date DEFAULT(current_timestamp()) NOT NULL,
	planta_cve int NULL,
	aviso_observaciones varchar(255) NULL,
	cte_cve int NULL,
	categoria_cve int NULL,
	aviso_vigencia int DEFAULT 30 NOT NULL,
	aviso_val_seg numeric(6,4) NULL,
	aviso_plazo int DEFAULT 8 NOT NULL,
	aviso_tp_facturacion varchar(1) DEFAULT 'K' NOT NULL,
	CONSTRAINT pk_aviso_cve PRIMARY KEY (aviso_cve),
	CONSTRAINT fk_aviso_categoria FOREIGN KEY (categoria_cve) REFERENCES categoria(categoria_cve) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_aviso_cliente FOREIGN KEY (cte_cve) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_aviso_planta FOREIGN KEY (planta_cve) REFERENCES PLANTA(PLANTA_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CAMARA definition

-- Drop table

-- DROP TABLE CAMARA;

CREATE TABLE CAMARA (
	CAMARA_CVE int AUTO_INCREMENT NOT NULL,
	PLANTA_CVE int NULL,
	CAMARA_DS varchar(80) NULL,
	CAMARA_ABREV varchar(6) NULL,
	CONSTRAINT ASA80 PRIMARY KEY (CAMARA_CVE),
	CONSTRAINT FK_CAMARA_RELATIONS_PLANTA FOREIGN KEY (PLANTA_CVE) REFERENCES PLANTA(PLANTA_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX RELATIONSHIP_5_FK ON CAMARA (PLANTA_CVE);


-- gestion.[DBA].CONSTANCIA_DE_DEPOSITO definition

-- Drop table

-- DROP TABLE CONSTANCIA_DE_DEPOSITO;

CREATE TABLE CONSTANCIA_DE_DEPOSITO (
	FOLIO int AUTO_INCREMENT NOT NULL,
	CTE_CVE int NOT NULL,
	FECHA_INGRESO date NULL,
	NOMBRE_TRANSPORTISTA varchar(100) NULL,
	PLACAS_TRANSPORTE char(5) NULL,
	OBSERVACIONES varchar(200) NULL,
	folio_cliente char(8) NOT NULL,
	valor_declarado numeric(12,2) NULL,
	status int DEFAULT 1 NULL,
	aviso_cve int NULL,
	temperatura varchar(50) NULL,
	CONSTRAINT ASA84 PRIMARY KEY (FOLIO),
	CONSTRAINT FK_CONSTANC_RECIBIMOS_CLIENTE FOREIGN KEY (CTE_CVE) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CONSTANC_REFERENCE_ESTADO_C FOREIGN KEY (status) REFERENCES estado_constancia(edo_cve) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_cdd_aviso FOREIGN KEY (aviso_cve) REFERENCES aviso(aviso_cve) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX RECIBIMOS_DE_FK ON CONSTANCIA_DE_DEPOSITO (CTE_CVE);
CREATE INDEX foliocliente ON CONSTANCIA_DE_DEPOSITO (folio_cliente);
CREATE INDEX numfolio ON CONSTANCIA_DE_DEPOSITO (FOLIO);


-- gestion.[DBA].CONSTANCIA_DE_SERVICIO definition

-- Drop table

-- DROP TABLE CONSTANCIA_DE_SERVICIO;

CREATE TABLE CONSTANCIA_DE_SERVICIO (
	FOLIO int NOT NULL,
	CTE_CVE int NOT NULL,
	FECHA date NULL,
	NOMBRE_TRANSPORTISTA varchar(100) NULL,
	PLACAS_TRANSPORTE char(6) NULL,
	OBSERVACIONES varchar(200) NULL,
	FOLIO_CLIENTE char(8) NOT NULL,
	VALOR_DECLARADO numeric(12,2) NULL,
	STATUS int NULL,
	CONSTRAINT ASA144 PRIMARY KEY (FOLIO),
	CONSTRAINT FK_CONSTANC_REFERENCE_CLIENTE FOREIGN KEY (CTE_CVE) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CONSTANC_REFERENCE_ESTADO_CO FOREIGN KEY (STATUS) REFERENCES estado_constancia(edo_cve) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CONSTANCIA_SALIDA definition

-- Drop table

-- DROP TABLE CONSTANCIA_SALIDA;

CREATE TABLE CONSTANCIA_SALIDA (
	ID int AUTO_INCREMENT NOT NULL,
	FECHA date NOT NULL,
	NUMERO varchar(15) NOT NULL,
	CLIENTE_CVE int NOT NULL,
	NOMBRE_CTE varchar(150) NULL,
	STATUS int NULL,
	OBSERVACIONES varchar(75) NULL,
	CONSTRAINT ASA135 PRIMARY KEY (ID),
	CONSTRAINT FK_CONSTANC_S_REFERENCE_CLIENTE FOREIGN KEY (CLIENTE_CVE) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CONSTANCIA_SERVICIOS definition

-- Drop table

-- DROP TABLE CONSTANCIA_SERVICIOS;

CREATE TABLE CONSTANCIA_SERVICIOS (
	ID int AUTO_INCREMENT NOT NULL,
	FECHA date NULL,
	NUMERO varchar(15) NULL,
	CLIENTE_CVE int NULL,
	NOMBRE_CTE varchar(150) NULL,
	OBSERVACIONES varchar(150) NULL,
	STATUS int NULL,
	CONSTRAINT ASA141 PRIMARY KEY (ID),
	CONSTRAINT FK_CONSTANC_SE_REFERENCE_CLIENTE FOREIGN KEY (CLIENTE_CVE) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CONSTANCIA_TRASPASO definition

-- Drop table

-- DROP TABLE CONSTANCIA_TRASPASO;

CREATE TABLE CONSTANCIA_TRASPASO (
	id int AUTO_INCREMENT NOT NULL,
	cliente int NOT NULL,
	numero varchar(10) NOT NULL,
	fecha date NOT NULL,
	observacion varchar(500) NOT NULL,
	nombreCliente varchar(250) NOT NULL,
	fecha_cadena varchar(25) DEFAULT ' ' NULL,
	CONSTRAINT ASA132 PRIMARY KEY (id),
	CONSTRAINT FK_CONSTANC_T_REFERENCE_CLIENTE FOREIGN KEY (cliente) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].cuota_minima definition

-- Drop table

-- DROP TABLE cuota_minima;

CREATE TABLE cuota_minima (
	cte_cve int NOT NULL,
	cuota_id int NOT NULL,
	cuota_enabled bit NOT NULL,
	cuota_value decimal(12,2) NOT NULL,
	CONSTRAINT ASA167 PRIMARY KEY (cte_cve,cuota_id),
	CONSTRAINT fk_cuota_minima_cliente FOREIGN KEY (cte_cve) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].DATOS_ESPECIALES definition

-- Drop table

-- DROP TABLE DATOS_ESPECIALES;

CREATE TABLE DATOS_ESPECIALES (
	DATO_ESP_CVE int NOT NULL,
	FORMATO_CVE int NULL,
	NOMBRE varchar(50) NOT NULL,
	LONGITUD int NULL,
	´PRECISION´ int NULL,
	CONSTRAINT ASA85 PRIMARY KEY (DATO_ESP_CVE),
	CONSTRAINT FK_DATOS_ES_REFERENCE_FORMATO FOREIGN KEY (FORMATO_CVE) REFERENCES FORMATO(FORMATO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].DETALLE_CTE_PROD definition

-- Drop table

-- DROP TABLE DETALLE_CTE_PROD;

CREATE TABLE DETALLE_CTE_PROD (
	DET_CTE_PROD_CVE int NOT NULL,
	VALOR varchar(30) NULL,
	DATO_ESP_CVE int NULL,
	DET_PART_CVE int NULL,
	CONSTRAINT ASA86 PRIMARY KEY (DET_CTE_PROD_CVE),
	CONSTRAINT FK_DETALLE__REFERENCE_DATOS_ES FOREIGN KEY (DATO_ESP_CVE) REFERENCES DATOS_ESPECIALES(DATO_ESP_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].DETALLE_FACTURACION definition

-- Drop table

-- DROP TABLE DETALLE_FACTURACION;

CREATE TABLE DETALLE_FACTURACION (
	DETALLE_CVE int NOT NULL,
	CTE_CVE int NOT NULL,
	DATO_ESP_CVE int NOT NULL,
	det_fac_secuencia int NOT NULL,
	CONSTRAINT ASA87 PRIMARY KEY (DETALLE_CVE,CTE_CVE,det_fac_secuencia),
	CONSTRAINT FK_DETALLE_FA_REFERENCE_CLIENTE FOREIGN KEY (CTE_CVE) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_DETALLE_FA_REFERENCE_DATOS_ES FOREIGN KEY (DATO_ESP_CVE) REFERENCES DATOS_ESPECIALES(DATO_ESP_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].estados definition

-- Drop table

-- DROP TABLE estados;

CREATE TABLE estados (
	pais_cve int NOT NULL,
	estado_cve int NOT NULL,
	estado_ds_corta char(4) NOT NULL,
	estado_desc char(30) NOT NULL,
	CONSTRAINT ASA107 PRIMARY KEY (pais_cve,estado_cve),
	CONSTRAINT FK_ESTADOS_PAIS_EDO_PAISES FOREIGN KEY (pais_cve) REFERENCES paises(pais_cve) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].factura definition

-- Drop table

-- DROP TABLE factura;

CREATE TABLE factura (
	id int AUTO_INCREMENT NOT NULL,
	cliente int NULL,
	numero varchar(30) NOT NULL,
	moneda varchar(30) NOT NULL,
	rfc varchar(14) NOT NULL,
	nombre_cliente varchar(80) NOT NULL,
	fecha date NOT NULL,
	observacion varchar(255) NOT NULL,
	subtotal numeric(12,2) NOT NULL,
	iva numeric(12,2) NOT NULL,
	total numeric(12,2) NOT NULL,
	pais varchar(30) NOT NULL,
	estado varchar(30) NOT NULL,
	municipio varchar(30) NOT NULL,
	ciudad varchar(30) NOT NULL,
	colonia varchar(30) NOT NULL,
	cp varchar(5) NOT NULL,
	calle varchar(75) NOT NULL,
	num_ext varchar(10) NOT NULL,
	num_int varchar(10) NOT NULL,
	telefono varchar(10) NOT NULL,
	fax varchar(10) NULL,
	porcentaje_iva numeric(6,3) NOT NULL,
	numero_cliente varchar(30) NULL,
	valor_declarado numeric(12,2) NULL,
	inicio_servicios date NULL,
	fin_servicios date NULL,
	monto_letra varchar(255) NULL,
	status int DEFAULT 1 NULL,
	tipo_facturacion int DEFAULT 0 NULL,
	planta int NULL,
	plazo int DEFAULT 8 NOT NULL,
	retencion numeric(12,2) NULL,
	nom_serie varchar(5) DEFAULT '' NOT NULL,
	CONSTRAINT ASA108 PRIMARY KEY (id),
	CONSTRAINT FAC_REFEREN_STATUS_FAC FOREIGN KEY (status) REFERENCES status_factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_FACTURA_REFERENCE_CLIENTE FOREIGN KEY (cliente) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX IDX_FACTURA_FECHA ON factura (fecha);


-- gestion.[DBA].factura_medio_pago definition

-- Drop table

-- DROP TABLE factura_medio_pago;

CREATE TABLE factura_medio_pago (
	factura_id int NOT NULL,
	fmp_id int NOT NULL,
	mp_id int NOT NULL,
	mp_descripcion varchar(100) NOT NULL,
	fmp_porcentaje int NOT NULL,
	fmp_referencia varchar(50) NULL,
	CONSTRAINT ASA166 PRIMARY KEY (factura_id,fmp_id),
	CONSTRAINT fk_fmp_factura FOREIGN KEY (factura_id) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].log_seguridad definition

-- Drop table

-- DROP TABLE log_seguridad;

CREATE TABLE log_seguridad (
	id int  AUTO_INCREMENT NOT NULL,
	fecha date NOT NULL,
	usuario int NOT NULL,
	descripcion varchar(255) NOT NULL,
	CONSTRAINT ASA128 PRIMARY KEY (id),
	CONSTRAINT FK_LOG_SEGU_REFERENCE_USUARIO FOREIGN KEY (usuario) REFERENCES usuario(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].municipios definition

-- Drop table

-- DROP TABLE municipios;

CREATE TABLE municipios (
	pais_cve int NOT NULL,
	estado_cve int NOT NULL,
	municipio_cve int NOT NULL,
	municipio_ds char(30) NOT NULL,
	CONSTRAINT ASA109 PRIMARY KEY (pais_cve,estado_cve,municipio_cve),
	CONSTRAINT FK_MUNICIPI_EDO_MUNI_ESTADOS FOREIGN KEY (pais_cve,estado_cve) REFERENCES estados(pais_cve,estado_cve) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX edo_muni_fk ON municipios (pais_cve,estado_cve);


-- gestion.[DBA].NOTA_CREDITO definition

-- Drop table

-- DROP TABLE NOTA_CREDITO;

CREATE TABLE NOTA_CREDITO (
	ID int AUTO_INCREMENT NOT NULL,
	NUMERO varchar(10) NOT NULL,
	IDCLIENTE int NULL,
	CLIENTE varchar(50) NOT NULL,
	DOMICILIO varchar(255) NULL,
	RFC varchar(20) NULL,
	SUBTOTAL numeric(12,2) NULL,
	IVA numeric(12,2) NOT NULL,
	TOTAL numeric(12,2) NOT NULL,
	TOTAL_LETRA varchar(255) NOT NULL,
	SERVICIOS varchar(50) NULL,
	CONSTANCIA varchar(15) NULL,
	PERIODO varchar(20) NULL,
	OBSERVACIONES varchar(200) NULL,
	FECHA date NOT NULL,
	CAJERO varchar(40) NULL,
	STATUS int NOT NULL,
	CONSTRAINT ASA137 PRIMARY KEY (ID),
	CONSTRAINT FK_NOTA_CRE_REFERENCE_STATUS_N FOREIGN KEY (STATUS) REFERENCES STATUS_NOTA_CREDITO(ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].NOTA_X_FACTURAS definition

-- Drop table

-- DROP TABLE NOTA_X_FACTURAS;

CREATE TABLE NOTA_X_FACTURAS (
	NOTA int NULL,
	FACTURA int NULL,
	CANTIDAD numeric(12,2) NOT NULL,
	CONSTRAINT FK_NOTA_X_F_REFERENCE_FACTURA FOREIGN KEY (FACTURA) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_NOTA_X_F_REFERENCE_NOTA_CRE FOREIGN KEY (NOTA) REFERENCES NOTA_CREDITO(ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].pago definition

-- Drop table

-- DROP TABLE pago;

CREATE TABLE pago (
	id int AUTO_INCREMENT NOT NULL,
	factura int NOT NULL,
	tipo int NOT NULL,
	monto numeric(12,2) NOT NULL,
	fecha date NOT NULL,
	banco int NULL,
	referencia varchar(20) NULL,
	cheque char(10) NULL,
	cheque_devuelto bit DEFAULT 0 NULL,
	CONSTRAINT ASA129 PRIMARY KEY (id),
	CONSTRAINT FK_PAGO_REFERENCE_BANCOS FOREIGN KEY (banco) REFERENCES bancos(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_PAGO_REFERENCE_FACTURA FOREIGN KEY (factura) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_PAGO_REFERENCE_TIPO_PAG FOREIGN KEY (tipo) REFERENCES tipo_pago(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].PARTIDA definition

-- Drop table

-- DROP TABLE PARTIDA;

CREATE TABLE PARTIDA (
	PARTIDA_CVE int AUTO_INCREMENT NOT NULL,
	CAMARA_CVE int NULL,
	FOLIO int NOT NULL,
	PESO_TOTAL decimal(9,3) NULL,
	CANTIDAD_TOTAL int NULL,
	UNIDAD_DE_PRODUCTO_CVE int NULL,
	cantidad_de_cobro numeric(12,2) NULL,
	unidad_de_cobro int NULL,
	partida_seq int NULL,
	valorMercancia numeric(12,2) NULL,
	rendimiento numeric(12,2) NULL,
	no_tarimas decimal(9,3) DEFAULT 0 NOT NULL,
	CONSTRAINT ASA92 PRIMARY KEY (PARTIDA_CVE),
	CONSTRAINT FK_PARTIDA_REFERENCE_UNIDAD_COBRO FOREIGN KEY (unidad_de_cobro) REFERENCES UNIDAD_DE_MANEJO(UNIDAD_DE_MANEJO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_PARTIDA_RELATIONS_CAMARA FOREIGN KEY (CAMARA_CVE) REFERENCES CAMARA(CAMARA_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_PARTIDA_RELATIONS_CONSTANC FOREIGN KEY (FOLIO) REFERENCES CONSTANCIA_DE_DEPOSITO(FOLIO) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX RELATIONSHIP_10_FK ON PARTIDA (FOLIO);
CREATE INDEX RELATIONSHIP_8_FK ON PARTIDA (CAMARA_CVE);


-- gestion.[DBA].PARTIDA_SERVICIO definition

-- Drop table

-- DROP TABLE PARTIDA_SERVICIO;

CREATE TABLE PARTIDA_SERVICIO (
	PARTIDA_CVE int NOT NULL,
	FOLIO int NULL,
	CANTIDAD_DE_COBRO numeric(12,2) NULL,
	CANTIDAD_TOTAL int NULL,
	PRODUCTO_CVE int NULL,
	UNIDAD_DE_MANEJO_CVE int NULL,
	UNIDAD_DE_COBRO int NULL,
	CONSTRAINT ASA146 PRIMARY KEY (PARTIDA_CVE),
	CONSTRAINT FK_PARTIDA__REFERENCE_CONSTANC FOREIGN KEY (FOLIO) REFERENCES CONSTANCIA_DE_SERVICIO(FOLIO) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_PARTIDA__REFERENCE_PRODUCTO FOREIGN KEY (PRODUCTO_CVE) REFERENCES PRODUCTO(PRODUCTO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_PARTIDA__REFERENCE_UNIDAD_D_1 FOREIGN KEY (UNIDAD_DE_MANEJO_CVE) REFERENCES UNIDAD_DE_MANEJO(UNIDAD_DE_MANEJO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_PARTIDA__REFERENCE_UNIDAD_D_2 FOREIGN KEY (UNIDAD_DE_COBRO) REFERENCES UNIDAD_DE_MANEJO(UNIDAD_DE_MANEJO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].POSICION_PARTIDA definition

-- Drop table

-- DROP TABLE POSICION_PARTIDA;

CREATE TABLE POSICION_PARTIDA (
	ID_POSICION int NOT NULL,
	ID_PARTIDA int NOT NULL,
	ST_POSICION bit NOT NULL,
	CONSTRAINT FK_posicion_id FOREIGN KEY (ID_POSICION) REFERENCES posicion(id_posicion) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_posicion_partida_id FOREIGN KEY (ID_PARTIDA) REFERENCES PARTIDA(PARTIDA_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].PRODUCTO_POR_CLIENTE definition

-- Drop table

-- DROP TABLE PRODUCTO_POR_CLIENTE;

CREATE TABLE PRODUCTO_POR_CLIENTE (
	PROD_X_CTE_CVE int AUTO_INCREMENT NOT NULL,
	CTE_CVE int NOT NULL,
	PRODUCTO_CVE int NOT NULL,
	CONSTRAINT ASA94 PRIMARY KEY (PROD_X_CTE_CVE),
	CONSTRAINT FK_PRODUCTO_RELATIONS_CLIENTE FOREIGN KEY (CTE_CVE) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX RELATIONSHIP_11_FK ON PRODUCTO_POR_CLIENTE (CTE_CVE);
CREATE INDEX RELATIONSHIP_12_FK ON PRODUCTO_POR_CLIENTE (PRODUCTO_CVE);


-- gestion.[DBA].serie_factura definition

-- Drop table

-- DROP TABLE serie_factura;

CREATE TABLE serie_factura (
	id int AUTO_INCREMENT NOT NULL,
	fecha_inicio date NOT NULL,
	numero_inicial int NOT NULL,
	numero_actual int NOT NULL,
	numero_final int NULL,
	status_serie int NOT NULL,
	nom_serie varchar(5) NOT NULL,
	IS_DFLT bit DEFAULT 0 NOT NULL,
	CONSTRAINT ASA127 PRIMARY KEY (id),
	CONSTRAINT FK_SERIE_FA_REFERENCE_STATUS_S FOREIGN KEY (status_serie) REFERENCES status_serie(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].SERIE_NOTA definition

-- Drop table

-- DROP TABLE SERIE_NOTA;

CREATE TABLE SERIE_NOTA (
	ID int AUTO_INCREMENT NOT NULL,
	FECHA_INICIO date NULL,
	NUMERO_INICIAL int NULL,
	NUMERO_ACTUAL int NULL,
	NUMERO_FINAL int NULL,
	STATUS_SERIE int NOT NULL,
	CONSTRAINT ASA140 PRIMARY KEY (ID),
	CONSTRAINT FK_SERIE_NO_REFERENCE_STATUS_S FOREIGN KEY (STATUS_SERIE) REFERENCES status_serie(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].SERVICIO definition

-- Drop table

-- DROP TABLE SERVICIO;

CREATE TABLE SERVICIO (
	SERVICIO_CVE int AUTO_INCREMENT NOT NULL,
	SERVICIO_DS varchar(80) NULL,
	COBRO int NULL,
	SERVICIO_COD varchar(20) NULL,
	CONSTRAINT ASA95 PRIMARY KEY (SERVICIO_CVE),
	CONSTRAINT FK_SERVICIO_REFERENCE_TIPO_COB FOREIGN KEY (COBRO) REFERENCES tipo_cobro(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].servicio_factura definition

-- Drop table

-- DROP TABLE servicio_factura;

CREATE TABLE servicio_factura (
	id int AUTO_INCREMENT NOT NULL,
	factura int NOT NULL,
	descripcion varchar(255) NOT NULL,
	cantidad numeric(12,2) NOT NULL,
	unidad varchar(255) NOT NULL,
	costo numeric(12,2) NOT NULL,
	tipo_cobro int NULL,
	tarifa numeric(13,5) NULL,
	ud_cobro varchar(10) NULL,
	codigo varchar(20) NULL,
	CONSTRAINT ASA114 PRIMARY KEY (id),
	CONSTRAINT FK_SERVICIO_REFERENCE_FACTURA FOREIGN KEY (factura) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].traspaso_partida definition

-- Drop table

-- DROP TABLE traspaso_partida;

CREATE TABLE traspaso_partida (
	id int AUTO_INCREMENT NOT NULL,
	traspaso int NOT NULL,
	constancia varchar(10) NOT NULL,
	partida int NOT NULL,
	descripcion varchar(255) NOT NULL,
	cantidad numeric(10,0) NOT NULL,
	origen varchar(150) NOT NULL,
	destino varchar(150) NOT NULL,
	CONSTRAINT ASA133 PRIMARY KEY (id),
	CONSTRAINT FK_TRASPASO_REFERENCE_CONSTANC FOREIGN KEY (traspaso) REFERENCES CONSTANCIA_TRASPASO(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].traspaso_servicio definition

-- Drop table

-- DROP TABLE traspaso_servicio;

CREATE TABLE traspaso_servicio (
	id int AUTO_INCREMENT NOT NULL,
	traspaso int NOT NULL,
	servicio varchar(150) NOT NULL,
	cantidad numeric(10,2) NOT NULL,
	precio numeric(10,2) NOT NULL,
	subtotal numeric(10,2) NOT NULL,
	CONSTRAINT ASA134 PRIMARY KEY (id),
	CONSTRAINT FK_TRASPASO_S_REFERENCE_CONSTANC FOREIGN KEY (traspaso) REFERENCES CONSTANCIA_TRASPASO(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].UNIDAD_DE_PRODUCTO definition

-- Drop table

-- DROP TABLE UNIDAD_DE_PRODUCTO;

CREATE TABLE UNIDAD_DE_PRODUCTO (
	UNIDAD_DE_PRODUCTO_CVE int AUTO_INCREMENT NOT NULL,
	PRODUCTO_CVE int NOT NULL,
	UNIDAD_DE_MANEJO_CVE int NOT NULL,
	CONSTRAINT ASA98 PRIMARY KEY (UNIDAD_DE_PRODUCTO_CVE),
	CONSTRAINT FK_UNIDAD_D_RELATIONS_UNIDAD_D FOREIGN KEY (UNIDAD_DE_MANEJO_CVE) REFERENCES UNIDAD_DE_MANEJO(UNIDAD_DE_MANEJO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX RELATIONSHIP_6_FK ON UNIDAD_DE_PRODUCTO (PRODUCTO_CVE);
CREATE INDEX RELATIONSHIP_7_FK ON UNIDAD_DE_PRODUCTO (UNIDAD_DE_MANEJO_CVE);


-- gestion.[DBA].cancela_factura definition

-- Drop table

-- DROP TABLE cancela_factura;

CREATE TABLE cancela_factura (
	id int AUTO_INCREMENT NOT NULL,
	factura int NOT NULL,
	descripcion varchar(75) NOT NULL,
	CONSTRAINT ASA131 PRIMARY KEY (id),
	CONSTRAINT FK_CANCELA__REFERENCE_FACTURA FOREIGN KEY (factura) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CANCELA_NOTA_CREDITO definition

-- Drop table

-- DROP TABLE CANCELA_NOTA_CREDITO;

CREATE TABLE CANCELA_NOTA_CREDITO (
	ID int AUTO_INCREMENT NOT NULL,
	NOTA int NOT NULL,
	DESCRIPCION varchar(75) NOT NULL,
	CONSTRAINT ASA139 PRIMARY KEY (ID),
	CONSTRAINT FK_CANCELA__REFERENCE_NOTA_CRE FOREIGN KEY (NOTA) REFERENCES NOTA_CREDITO(ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CHEQUE_DEVUELTO definition

-- Drop table

-- DROP TABLE CHEQUE_DEVUELTO;

CREATE TABLE CHEQUE_DEVUELTO (
	ID int AUTO_INCREMENT NOT NULL,
	FACTURA_ID int NULL,
	CHEQUE char(10) NULL,
	FECHA_DEVUELTO date NOT NULL,
	FECHA_PAGO date NOT NULL,
	MONTO_PAGO numeric(12,2) NOT NULL,
	BANCO int NOT NULL,
	REFERENCIA varchar(20) NULL,
	MOTIVO varchar(80) NULL,
	CONSTRAINT PK_CHEQUE_DEVUELTO PRIMARY KEY (ID),
	CONSTRAINT FK_CHEQUE_D_CHEQUE_DE_FACTURA FOREIGN KEY (FACTURA_ID) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].ciudades definition

-- Drop table

-- DROP TABLE ciudades;

CREATE TABLE ciudades (
	pais_cve int NOT NULL,
	estado_cve int NOT NULL,
	municipio_cve int NOT NULL,
	ciudad_cve int NOT NULL,
	ciudad_ds char(50) NOT NULL,
	CONSTRAINT ASA103 PRIMARY KEY (pais_cve,estado_cve,municipio_cve,ciudad_cve),
	CONSTRAINT FK_CIUDADES_MUNI_CIUD_MUNICIPI FOREIGN KEY (pais_cve,estado_cve,municipio_cve) REFERENCES municipios(pais_cve,estado_cve,municipio_cve) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX muni_ciudad_fk ON ciudades (pais_cve,estado_cve,municipio_cve);


-- gestion.[DBA].CONSTANCIA_DEPOSITO_DETALLE definition

-- Drop table

-- DROP TABLE CONSTANCIA_DEPOSITO_DETALLE;

CREATE TABLE CONSTANCIA_DEPOSITO_DETALLE (
	CONSTANCIA_DEPOSITO_DETALLE_CVE int NOT NULL,
	SERVICIO_CVE int NULL,
	FOLIO int NOT NULL,
	servicio_cantidad numeric(6,2) NULL,
	CONSTRAINT ASA83 PRIMARY KEY (CONSTANCIA_DEPOSITO_DETALLE_CVE),
	CONSTRAINT FK_CONSTANC_PARA_LOS__CONSTANC FOREIGN KEY (FOLIO) REFERENCES CONSTANCIA_DE_DEPOSITO(FOLIO) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CONSTANC_SERVICIOS_SERVICIO FOREIGN KEY (SERVICIO_CVE) REFERENCES SERVICIO(SERVICIO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX PARA_LOS_SERVICIOS_DE_FK ON CONSTANCIA_DEPOSITO_DETALLE (FOLIO);
CREATE INDEX SERVICIOS_FK ON CONSTANCIA_DEPOSITO_DETALLE (SERVICIO_CVE);


-- gestion.[DBA].constancia_factura definition

-- Drop table

-- DROP TABLE constancia_factura;

CREATE TABLE constancia_factura (
	id int AUTO_INCREMENT NOT NULL,
	factura int NULL,
	folio int NOT NULL,
	folio_cliente varchar(30) NULL,
	vigencia_inicio date NULL,
	vigencia_fin date NULL,
	planta_cve int NULL,
	planta_ds varchar(80) NULL,
	planta_abrev varchar(6) NULL,
	camara_cve int NULL,
	camara_ds varchar(80) NULL,
	camara_abrev varchar(6) NULL,
	CONSTRAINT ASA123 PRIMARY KEY (id),
	CONSTRAINT FK_CONSTANC_REFERENCE_FACTURA FOREIGN KEY (factura) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX IDX_CONSTANCIA_FACTURA_ID_FACT ON constancia_factura (factura);


-- gestion.[DBA].constancia_factura_cmp definition

-- Drop table

-- DROP TABLE constancia_factura_cmp;

CREATE TABLE constancia_factura_cmp (
	id int NOT NULL,
	factura int NOT NULL,
	folio int NOT NULL,
	folio_cliente varchar(30) NOT NULL,
	vigencia_inicio date NOT NULL,
	vigencia_fin date NOT NULL,
	CONSTRAINT ASA161 PRIMARY KEY (id),
	CONSTRAINT FK_FACTURA_CONSTANCIA_FACTURA_CMP FOREIGN KEY (factura) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CONSTANCIA_FACTURA_DS definition

-- Drop table

-- DROP TABLE CONSTANCIA_FACTURA_DS;

CREATE TABLE CONSTANCIA_FACTURA_DS (
	ID int AUTO_INCREMENT NOT NULL,
	FACTURA int NULL,
	FOLIO int NULL,
	FOLIO_CLIENTE varchar(30) NULL,
	CONSTRAINT ASA147 PRIMARY KEY (ID),
	CONSTRAINT FK_CONSTANC_FAC_REFERENCE_FACTURA FOREIGN KEY (FACTURA) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CONSTANCIA_SERVICIO_DETALLE definition

-- Drop table

-- DROP TABLE CONSTANCIA_SERVICIO_DETALLE;

CREATE TABLE CONSTANCIA_SERVICIO_DETALLE (
	CONSTANCIA_SERVICIO_DETALLE_CVE int NOT NULL,
	SERVICIO_CVE int NOT NULL,
	FOLIO int NULL,
	SERVICIO_CANTIDAD numeric(6,2) NULL,
	CONSTRAINT ASA145 PRIMARY KEY (CONSTANCIA_SERVICIO_DETALLE_CVE),
	CONSTRAINT FK_CONSTANC_REFERENCE_CONSTANC FOREIGN KEY (FOLIO) REFERENCES CONSTANCIA_DE_SERVICIO(FOLIO) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CONSTANC_REFERENCE_SERVICIO FOREIGN KEY (SERVICIO_CVE) REFERENCES SERVICIO(SERVICIO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].control_factura_constancia definition

-- Drop table

-- DROP TABLE control_factura_constancia;

CREATE TABLE control_factura_constancia (
	constancia int NOT NULL,
	factura int NOT NULL,
	status int NULL,
	CONSTRAINT FK_CONTROL__REFERENCE_CONSTANC FOREIGN KEY (constancia) REFERENCES CONSTANCIA_DE_DEPOSITO(FOLIO) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CONTROL__REFERENCE_FACTURA FOREIGN KEY (factura) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CONTROL__REFERENCE_STATUS_F FOREIGN KEY (status) REFERENCES status_factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CONTROL_FACTURA_CONSTANCIA_DS definition

-- Drop table

-- DROP TABLE CONTROL_FACTURA_CONSTANCIA_DS;

CREATE TABLE CONTROL_FACTURA_CONSTANCIA_DS (
	CONSTANCIA int NULL,
	FACTURA int NULL,
	STATUS int NULL,
	CONSTRAINT FK_CONTROL_FAC_REFERENCE_CONSTANC FOREIGN KEY (CONSTANCIA) REFERENCES CONSTANCIA_DE_SERVICIO(FOLIO) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CONTROL_FAC_REFERENCE_FACTURA FOREIGN KEY (FACTURA) REFERENCES factura(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CUOTA_MENSUAL_SERVICIO definition

-- Drop table

-- DROP TABLE CUOTA_MENSUAL_SERVICIO;

CREATE TABLE CUOTA_MENSUAL_SERVICIO (
	id int AUTO_INCREMENT NOT NULL,
	aviso_cve int NOT NULL,
	cte_cve int NOT NULL,
	servicio_cve int NOT NULL,
	cuota numeric(13,5) NOT NULL,
	unidad_de_manejo_cve int NULL,
	CONSTRAINT PK_CUOTA_MENSUAL_SRV PRIMARY KEY (id),
	CONSTRAINT FK_CUOTA_MENSUAL_AVISO FOREIGN KEY (aviso_cve) REFERENCES aviso(aviso_cve) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CUOTA_MENSUAL_CLIENTE FOREIGN KEY (cte_cve) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CUOTA_MENSUAL_SERVICIO FOREIGN KEY (servicio_cve) REFERENCES SERVICIO(SERVICIO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CUOTA_MENSUAL_SERVICIO_DET definition

-- Drop table

-- DROP TABLE CUOTA_MENSUAL_SERVICIO_DET;

CREATE TABLE CUOTA_MENSUAL_SERVICIO_DET (
	id int auto_increment NOT NULL,
	aviso_cve int NOT NULL,
	cte_cve int NOT NULL,
	servicio_cve int NOT NULL,
	cuota_det_cve int NOT NULL,
	cuota numeric(13,5) NOT NULL,
	CONSTRAINT ASA159 PRIMARY KEY (id),
	CONSTRAINT FK_CTA_MENSUAL_SRV_DET FOREIGN KEY (id) REFERENCES CUOTA_MENSUAL_SERVICIO(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].detalle_constancia_cmp definition

-- Drop table

-- DROP TABLE detalle_constancia_cmp;

CREATE TABLE detalle_constancia_cmp (
	id int NOT NULL,
	constancia int NOT NULL,
	servicio_cve int NOT NULL,
	servicio_ds varchar(255) NOT NULL,
	cantidad_ser numeric(6,2) NOT NULL,
	cuota numeric(13,5) NOT NULL,
	cuota_diaria numeric(15,7) NOT NULL,
	dias int NOT NULL,
	producto_cve int NOT NULL,
	producto_ds varchar(255) NOT NULL,
	peso numeric(13,3) NOT NULL,
	unidad_peso varchar(100) NOT NULL,
	cantidad numeric(12,2) NOT NULL,
	unidad_manejo varchar(100) NOT NULL,
	valor numeric(12,2) NOT NULL,
	importe numeric(12,2) NOT NULL,
	iva numeric(12,2) NOT NULL,
	total numeric(12,2) NOT NULL,
	partida_cve int NOT NULL,
	planta_cve int NOT NULL,
	planta_ds varchar(80) NOT NULL,
	planta_abrev varchar(6) NOT NULL,
	camara_cve int NOT NULL,
	camara_ds varchar(80) NOT NULL,
	camara_abrev varchar(6) NOT NULL,
	no_tarimas decimal(9,3) DEFAULT 0 NOT NULL,
	planta_cod varchar(10) NULL,
	servicio_cod varchar(20) NULL,
	CONSTRAINT ASA162 PRIMARY KEY (id),
	CONSTRAINT fk_detalle_constancia_cmp FOREIGN KEY (constancia) REFERENCES constancia_factura_cmp(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].DETALLE_CONSTANCIA_SALIDA definition

-- Drop table

-- DROP TABLE DETALLE_CONSTANCIA_SALIDA;

CREATE TABLE DETALLE_CONSTANCIA_SALIDA (
	ID int AUTO_INCREMENT NOT NULL,
	CONSTANCIA_CVE int NOT NULL,
	PARTIDA_CVE int NOT NULL,
	CAMARA_CVE int NOT NULL,
	CANTIDAD int NULL,
	PESO decimal(10,3) NOT NULL,
	UNIDAD varchar(10) NULL,
	PRODUCTO varchar(150) NULL,
	FOLIO_ENTRADA varchar(10) NULL,
	CAMARA_CADENA varchar(50) NULL,
	DET_PART_CVE int NULL,
	TEMPERATURA varchar(6) NULL,
	CONSTRAINT ASA136 PRIMARY KEY (ID),
	CONSTRAINT FK_DETALLE__REFERENCE_CONSTANC FOREIGN KEY (CONSTANCIA_CVE) REFERENCES CONSTANCIA_SALIDA(ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_DETALLE__REFERENCE_PARTIDA FOREIGN KEY (PARTIDA_CVE) REFERENCES PARTIDA(PARTIDA_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].DETALLE_CONSTANCIA_SERVICIOS definition

-- Drop table

-- DROP TABLE DETALLE_CONSTANCIA_SERVICIOS;

CREATE TABLE DETALLE_CONSTANCIA_SERVICIOS (
	ID int AUTO_INCREMENT NOT NULL,
	CONSTANCIA_CVE int NULL,
	SERVICIO_CVE int NULL,
	SERVICIO_DES varchar(200) NULL,
	CANTIDAD int NULL,
	CONSTRAINT ASA143 PRIMARY KEY (ID),
	CONSTRAINT FK_DETALLE_CONS_REFERENCE_CONSTANC FOREIGN KEY (CONSTANCIA_CVE) REFERENCES CONSTANCIA_SERVICIOS(ID) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_DETALLE_CONS_REFERENCE_SERVICIO FOREIGN KEY (SERVICIO_CVE) REFERENCES SERVICIO(SERVICIO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].DETALLE_PARTIDA definition

-- Drop table

-- DROP TABLE DETALLE_PARTIDA;

CREATE TABLE DETALLE_PARTIDA (
	DET_PART_CVE int NOT NULL,
	PARTIDA_CVE int NOT NULL,
	tipo_mov_cve int NULL,
	edo_inv_cve int NULL,
	det_anterior int NULL,
	det_part_anterior int NULL,
	det_padre int NULL,
	det_part_padre int NULL,
	cantidad_u_manejo int NULL,
	u_medida_cve int NULL,
	cantidad_u_medida numeric(9,3) NULL,
	dtp_codigo varchar(12) NULL,
	dtp_lote varchar(20) NULL,
	dtp_caducidad date NULL,
	dtp_PO varchar(12) NULL,
	dtp_MP varchar(20) NULL,
	dtp_pedimento varchar(13) NULL,
	dtp_SAP varchar(20) NULL,
	dtp_tarimas varchar(15) DEFAULT '' NULL,
	CONSTRAINT ASA88 PRIMARY KEY (DET_PART_CVE,PARTIDA_CVE),
	CONSTRAINT FK_DETALLE_REFERENCE_UNIDADES FOREIGN KEY (u_medida_cve) REFERENCES UNIDAD_DE_MANEJO(UNIDAD_DE_MANEJO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_DETALLE_PAR_REFERENCE_DETALLE_ FOREIGN KEY (det_anterior,det_part_anterior) REFERENCES DETALLE_PARTIDA(DET_PART_CVE,PARTIDA_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_DETALLE_PAR_REFERENCE_ESTADO_I FOREIGN KEY (edo_inv_cve) REFERENCES estado_inventario(edo_inv_cve) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_DETALLE_PAR_REFERENCE_PARTIDA FOREIGN KEY (PARTIDA_CVE) REFERENCES PARTIDA(PARTIDA_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_DETALLE_PAR_REFERENCE_TIPO_MOV FOREIGN KEY (tipo_mov_cve) REFERENCES TIPO_MOVIMIENTO(CLAVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX INDEX_1 ON DETALLE_PARTIDA (PARTIDA_CVE);


-- gestion.[DBA].DOMICILIOS definition

-- Drop table

-- DROP TABLE DOMICILIOS;

CREATE TABLE DOMICILIOS (
	domicilio_tipo_cve smallint NOT NULL,
	dom_cve int AUTO_INCREMENT NOT NULL,
	pais_cve int NULL,
	estado_cve int NULL,
	municipio_cve int NULL,
	ciudad_cve int NULL,
	domicilio_calle char(75) DEFAULT ' ' NULL,
	domicilio_num_ext char(10) DEFAULT '__' NULL,
	domicilio_num_int char(10) DEFAULT '__' NULL,
	domicilio_colonia int NULL,
	domicilio_cp char(5) DEFAULT '_____' NULL,
	domicilio_tel1 varchar(10) DEFAULT ' ' NULL,
	domicilio_tel2 varchar(10) DEFAULT ' ' NULL,
	domicilio_fax varchar(10) DEFAULT ' ' NULL,
	CONSTRAINT ASA89 PRIMARY KEY (dom_cve),
	CONSTRAINT FK_DOMICILI_CDDS_DMCL_CIUDADES FOREIGN KEY (pais_cve,estado_cve,municipio_cve,ciudad_cve) REFERENCES ciudades(pais_cve,estado_cve,municipio_cve,ciudad_cve) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_DOMICILI_DOM_TIPOS_TIPOS_DO FOREIGN KEY (domicilio_tipo_cve) REFERENCES tipos_domicilio(domicilio_tipo_cve) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_domicilios_pais FOREIGN KEY (pais_cve) REFERENCES PAIS(pais_cve) ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX cdds_dmclos_fk ON DOMICILIOS (pais_cve,estado_cve,municipio_cve,ciudad_cve);
CREATE INDEX dom_tiposdom_fk ON DOMICILIOS (domicilio_tipo_cve);
CREATE INDEX personas_dom_fk ON DOMICILIOS (dom_cve);



-- gestion.[DBA].partidas_afectadas definition

-- Drop table

-- DROP TABLE partidas_afectadas;

CREATE TABLE partidas_afectadas (
	traspaso int NULL,
	partida int NULL,
	PARTIDA_TRASPASO int NULL,
	CONSTRAINT FK_PARTIDAS_REFERENCE_PARTIDA FOREIGN KEY (partida) REFERENCES PARTIDA(PARTIDA_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_PARTIDAS_REFERENCE_TRASPASO FOREIGN KEY (PARTIDA_TRASPASO) REFERENCES traspaso_partida(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].precio_servicio definition

-- Drop table

-- DROP TABLE precio_servicio;

CREATE TABLE precio_servicio (
	cliente int NOT NULL,
	servicio int NOT NULL,
	unidad int NOT NULL,
	precio numeric(13,5) NOT NULL,
	aviso_cve int DEFAULT 1 NOT NULL,
	CONSTRAINT FK_PRECIO_S_REFERENCE_CLIENTE FOREIGN KEY (cliente) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_PRECIO_S_REFERENCE_SERVICIO FOREIGN KEY (servicio) REFERENCES SERVICIO(SERVICIO_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT fk_aviso_precio_ser FOREIGN KEY (aviso_cve) REFERENCES aviso(aviso_cve) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- gestion.[DBA].PRODUCTO_CONSTANCIA_DS definition

-- Drop table

-- DROP TABLE PRODUCTO_CONSTANCIA_DS;

CREATE TABLE PRODUCTO_CONSTANCIA_DS (
	ID int AUTO_INCREMENT NOT NULL,
	DESCRIPCION varchar(255) NOT NULL,
	CONSTANCIA int NOT NULL,
	CATIDAD_COBRO numeric(12,2) NOT NULL,
	UNIDAD_COBRO varchar(255) NOT NULL,
	CANTIDAD_MANEJO numeric(12,2) NULL,
	UNIDAD_MANEJO varchar(255) NULL,
	CONSTRAINT ASA148 PRIMARY KEY (ID),
	CONSTRAINT FK_PRODUCTO_REFERENCE_CONSTANC FOREIGN KEY (CONSTANCIA) REFERENCES CONSTANCIA_FACTURA_DS(ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].SERVICIO_CONSTANCIA_DS definition

-- Drop table

-- DROP TABLE SERVICIO_CONSTANCIA_DS;

CREATE TABLE SERVICIO_CONSTANCIA_DS (
	ID int AUTO_INCREMENT NOT NULL,
	DESCRIPCION varchar(255) NOT NULL,
	CONSTANCIA int NOT NULL,
	COSTO numeric(12,2) NOT NULL,
	TARIFA numeric(13,5) NOT NULL,
	codigo varchar(20) NULL,
	UD_COBRO varchar(10) NULL,
	CONSTRAINT ASA149 PRIMARY KEY (ID),
	CONSTRAINT FK_SERVICIO_REFERENCE_CONSTANC FOREIGN KEY (CONSTANCIA) REFERENCES CONSTANCIA_FACTURA_DS(ID) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- gestion.[DBA].CLIENTE_DOMICILIOS definition

-- Drop table

-- DROP TABLE CLIENTE_DOMICILIOS;

CREATE TABLE CLIENTE_DOMICILIOS (
	id int AUTO_INCREMENT not null,
	CTE_CVE int NOT NULL,
	domicilio_tipo_cve smallint NULL,
	dom_cve int NOT NULL,
	CONSTRAINT ASA82 PRIMARY KEY (id),
	CONSTRAINT DOMICILIOS FOREIGN KEY (domicilio_tipo_cve,dom_cve) REFERENCES DOMICILIOS(domicilio_tipo_cve,dom_cve) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FK_CLIENTE__REFERENCE_CLIENTE FOREIGN KEY (CTE_CVE) REFERENCES CLIENTE(CTE_CVE) ON DELETE RESTRICT ON UPDATE RESTRICT
);