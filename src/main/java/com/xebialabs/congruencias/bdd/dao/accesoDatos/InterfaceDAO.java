package com.xebialabs.congruencias.bdd.dao.accesoDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import com.xebialabs.congruencias.bdd.dao.bean.Bean;

public interface InterfaceDAO {

	public int insert(Bean bean) throws SQLException;
	public int update(Bean bean, String condicion) throws SQLException;
	public Bean find(int codigo) throws SQLException;
	public Vector select(String condicion) throws SQLException; 
	public int delete(String condicion) throws SQLException;
	public void setConnection(Connection connection);
	
}
