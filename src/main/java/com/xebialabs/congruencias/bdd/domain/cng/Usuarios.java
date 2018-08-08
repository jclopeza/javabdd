package com.xebialabs.congruencias.bdd.domain.cng;

// Generated 07-dic-2011 17:33:07 by Hibernate Tools 3.4.0.CR1

import com.xebialabs.congruencias.bdd.dao.bean.Bean;

public class Usuarios implements java.io.Serializable, Bean {

	private Integer id;
	private String login;
	private String password;

	public Usuarios() {
	}

	public Usuarios(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public boolean esIgual(Bean bean) {
		Usuarios p = (Usuarios) bean;
		if (p.getId() == this.getId()) return true;
		return false;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
