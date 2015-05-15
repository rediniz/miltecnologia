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

    private static final String STR_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE = "hostess";
    private static final String IP = "127.0.0.1";
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection objConexao = null;

    public Conexao() {
        try {
            Class.forName(STR_DRIVER);
            objConexao = DriverManager.getConnection(STR_CON, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver de conexão não encontrado: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMsg, "Mensagem", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            String errorMsg = "Erro ao tentar obter a conexao: " + e.getMessage();
            JOptionPane.showMessageDialog(null, errorMsg, "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Connection getConexao() {
        if (objConexao == null) {
            Conexao objGlobal = new Conexao();
        }
        return objConexao;
    }
}
