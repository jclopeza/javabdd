package com.xebialabs.congruencias.bdd.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAOGeneral {

	private static Connection DBconn_CongruenciasDB = null;

	public DAOGeneral() {
		//Este es el constructor de la clase
		//Este es el constructor de la clase
	}

	public static Connection getConexion_bdd() {
		try {
			if (DBconn_CongruenciasDB == null || DBconn_CongruenciasDB.isClosed()) {
				Context initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:comp/env");
				DataSource ds = (DataSource) envCtx
						.lookup("jdbc/CongruenciasDB");
				DBconn_CongruenciasDB = ds.getConnection();
			}
			return DBconn_CongruenciasDB;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DBconn_CongruenciasDB;
	}

	public static void closeConnection_bdd() {
		try {
			if (DBconn_CongruenciasDB != null) {
				DBconn_CongruenciasDB.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
