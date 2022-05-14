package com.mx.gestion.manager;

import static com.mx.gestion.util.Conexion.close;
import static com.mx.gestion.util.Conexion.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mx.gestion.manager.BancoManager;
import com.mx.gestion.model.Bancos;

public class BancoManager implements IBancoManager {
	
	private static Logger log = Logger.getLogger(BancoManager.class);

	private static final String SELECT_BANCOS = "SELECT clave, nombre FROM bancos;";

	@Override
	public List<Bancos> getBanco() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Bancos> listaBancos = null;
		Bancos bancos = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SELECT_BANCOS);
			resultSet = preparedStatement.executeQuery();
			listaBancos = new ArrayList<>();
			while (resultSet.next()) {
				bancos = new Bancos();
				bancos.setClave(resultSet.getString("clave"));
				bancos.setNombre(resultSet.getString("nombre"));
				listaBancos.add(bancos);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			try {
				close(resultSet);
				close(preparedStatement);
				close(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaBancos;
	}

}
