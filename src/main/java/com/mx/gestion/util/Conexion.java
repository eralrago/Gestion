package com.mx.gestion.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;


public class Conexion {
	private static final String dburl = "jdbc:sqlanywhere:uid=dba;pwd=iresadbpwd;eng=iresa_V2;database=iresa_V3;links=tcpip(host=127.0.0.1:2371)";

//	public static Connection getConnection() throws SQLException{
//		return DriverManager.getConnection(dburl);
//	}
	private static Logger logger = Logger.getLogger(Conexion.class);
	
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		String driver = null;
		String dburl = null;

		Properties pr = null;

		try {
			pr = getProperties();
			driver = pr.getProperty("driver");
			dburl = pr.getProperty("dburl");
			Class.forName(driver);
			con = DriverManager.getConnection(dburl, pr);
//		con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		} catch (Exception ex) {
			logger.error("Problema para obtener la conexion a la BD...", ex);
		}

		return con;
	}
	
	public static Properties getProperties()
	{
		String user     = null;
		String password = null;
		String driver   = null;
		String dburl    = null;
		Properties pr   = new Properties();
		ResourceBundle paramBD = ResourceBundle.getBundle("com.mx.gestion.util.Conexion");	
		
		user     = paramBD.getString("user");
		password = paramBD.getString("password");
		driver   = paramBD.getString("driver");
		dburl    = paramBD.getString("dburl");
		
		pr.setProperty("user", user);
		pr.setProperty("password", password);
		pr.setProperty("driver", driver);
		pr.setProperty("dburl", dburl);
		
		pr.put("user",user);
		pr.put("password",password);
		
		return pr;
	}

	public static void close(ResultSet resultSet) throws SQLException {
		resultSet.close();
	}

	public static void close(Statement statement) throws SQLException {
		statement.close();
	}

	public static void close(Connection connection) throws SQLException {
		connection.close();
	}

}
