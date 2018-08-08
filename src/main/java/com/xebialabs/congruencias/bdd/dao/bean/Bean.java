package com.xebialabs.congruencias.bdd.dao.bean;

public interface Bean {

	// Me indica si los objetos corresponden al mismo registro de base de datos
	// (identidad de clave primaria)
	public boolean esIgual(Bean bean);
	// Sería necesario obtener un código de retorno distinto de 0

}
