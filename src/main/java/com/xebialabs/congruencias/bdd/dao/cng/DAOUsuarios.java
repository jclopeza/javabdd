package com.xebialabs.congruencias.bdd.dao.cng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.xebialabs.congruencias.bdd.dao.accesoDatos.InterfaceDAO;
import com.xebialabs.congruencias.bdd.dao.bean.Bean;
import com.xebialabs.congruencias.bdd.domain.cng.Usuarios;


public class DAOUsuarios implements InterfaceDAO {

    Connection conn;

    public int insert(Bean bean) throws SQLException {
        int id_registro = 0;
        Usuarios my_user = (Usuarios) bean;
        //query de insert 3
        String orden = "INSERT INTO user (id, login, password)" +
                " VALUES (?, ?, ?)";
        
        PreparedStatement sentencia = conn.prepareStatement(orden);
        sentencia.setInt(1, my_user.getId());
        sentencia.setString(2, my_user.getLogin());
        sentencia.setString(3, my_user.getPassword());
        id_registro = sentencia.executeUpdate();
        sentencia.close();
        return id_registro;
    }

    public int update(Bean bean, String condicion) throws SQLException {
        return 0;
    }

    public Bean find(int id_usuario) throws SQLException {
        Usuarios user = new Usuarios();
        //Solucionado el acceso a la tabla usuarios
        String orden = "SELECT * FROM user where id = " + id_usuario;
        Statement sentencia = conn.createStatement();
        ResultSet rs = sentencia.executeQuery(orden);
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
        }
        rs.close();
        sentencia.close();
        return user;
    }

    public Vector<Usuarios> select(String condicion) throws SQLException {
        Vector<Usuarios> vectorUsuarios = new Vector<Usuarios>();
        String orden = "SELECT * FROM user where " + condicion;
        Statement sentencia = conn.createStatement();
        //Resuelto el código.
        //Mejora el acceso a la tabla de usuarios
        ResultSet rs = sentencia.executeQuery(orden);
        while (rs.next()) {
            Usuarios user = new Usuarios();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            vectorUsuarios.add(user);
        }
        rs.close();
        sentencia.close();
        return vectorUsuarios;

    }

    public int delete(String condicion) throws SQLException {
        // URL de publicación
        return 0;
    }

    public void setConnection(Connection conn) {
        this.conn = conn;
    }

}
