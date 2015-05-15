/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class ProdutoDAO {

    public static void salvar(Produto produto) {
        Connection con = Conexao.getConexao();

        PreparedStatement strInsert = null;

        String sql = "INSERT INTO produto (nome, marca, data_cadastro, valor_unitario, quantidade, fornecedor) VALUES (?,?,?,?,?,?)";

        try {
            strInsert = con.prepareStatement(sql);

            strInsert.setString(1, produto.getNome());
            strInsert.setString(2, produto.getMarca());
            strInsert.setDate(3, produto.getDataCadastro());
            strInsert.setDouble(4, produto.getValorUnitario());
            strInsert.setInt(5, produto.getQuantidade());
            strInsert.setString(6, produto.getFornecedor());

            strInsert.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                strInsert.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void consultar(int tipoConsulta) {

        Connection con = Conexao.getConexao();
        Statement stm = null;
        String strConsulta = "";
        try {
            stm = con.createStatement();

            switch (tipoConsulta) {
                case 1:
                    strConsulta = "SELECT * FROM produto";
                    break;
                case 2:
                    strConsulta = "SELECT SUM(valor_unitario) as soma, fornecedor FROM produto GROUP BY fornecedor";
                    break;
                case 3:
                    strConsulta = "SELECT * FROM produto WHERE valor_unitario = (SELECT MAX(valor_unitario) FROM produto)";
                    break;
                case 4:
                    strConsulta = "SELECT * FROM fornecedor WHERE cnpj NOT IN (select fornecedor from produto)";
                    break;
                default:
                    break;
            }

            stm.execute(strConsulta);
            ResultSet resultado = stm.getResultSet();
            
            stm.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void consultarPeriodo(Date dataInicial, Date dataFinal) {

        String strConsulta = "SELECT COUNT( *) as total, data_cadastro from produto where data_cadastro between  " + dataInicial + " and " + dataFinal + " group by data_cadastro";

    }

}
