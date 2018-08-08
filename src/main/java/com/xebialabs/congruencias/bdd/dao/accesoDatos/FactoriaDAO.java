package com.xebialabs.congruencias.bdd.dao.accesoDatos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FactoriaDAO {

	private static boolean propiedadesCargadas = false;
	private static java.util.Properties prop = new java.util.Properties();
	
	public static InterfaceDAO getDAO(String nombre) {
		try {
			Class clase = Class.forName(getClase(nombre));
			return (InterfaceDAO)clase.newInstance();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String getClase(String nombrePropiedad) {
		String nombreClase = null;
		try {
			if ( !propiedadesCargadas ) {
				ClassLoader loader = FactoriaDAO.class.getClassLoader();
				InputStream in = loader.getResourceAsStream("com/xebialabs/congruencias/bdd/dao/accesoDatos/dao.properties");
				prop.load(in); 
				propiedadesCargadas = true;
			}
			nombreClase = prop.getProperty(nombrePropiedad);
			if (nombreClase.length() == 0) return null;
		} catch ( FileNotFoundException e) {
			e.printStackTrace();
		} catch ( IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombreClase;
	}
}
