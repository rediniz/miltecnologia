/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.Produto;
import java.sql.Date;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class ProdutoControle {
    private Produto produto;
    
      public void salvar(String nome, String marca, Date dataCadastro, double valorUnitario, int quantidade, String fornecedor) {
        produto.setNome(nome);
        produto.setMarca(marca);
        produto.setDataCadastro(dataCadastro);
        produto.setValorUnitario(valorUnitario);
        produto.setQuantidade(quantidade);
        produto.setFornecedor(fornecedor);
        
        produto.salvar();

    }
}
