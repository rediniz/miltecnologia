/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String BANCO = "prova";
    private static final String HOST = "127.0.0.1";
    private static final String STR_CON = "jdbc:mysql://" + HOST + ":3306/" + BANCO;
    private static final String USUARIO = "root";
    private static final String PASSWORD = "admin";
    private static Connection con = null;

    public Conexao() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(STR_CON, USUARIO, PASSWORD);
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver de conexão não encontrado: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMsg, "Mensagem", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            String errorMsg = "Erro ao tentar obter a conexao: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMsg, "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Connection getConexao() {
        if (con == null) {
            Conexao con= new Conexao();
        }
        return con;
    }
}
