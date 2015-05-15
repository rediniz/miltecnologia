/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Controle.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class ProdutoDAO {
    
    public static void salvar(Produto produto){
        Connection con = Conexao.getConexao();
        
        PreparedStatement strInsert = null;
        
        String sql = "";
        
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
        } finally{
            
            try {
                strInsert.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        

    }

}
