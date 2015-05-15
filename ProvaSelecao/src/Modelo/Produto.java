/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.ProdutoDAO;
import java.sql.Date;

/**
 *
 * @author Renato Diniz Ferreira - 1220735
 */
public class Produto {

    private String nome;
    private String marca;
    private Date dataCadastro;
    private double valorUnitario;
    private int quantidade;
    private String fornecedor;

    public Produto(String nome, String marca, Date dataCadastro, double valorUnitario, int quantidade, String fornecedor) {
        this.nome = nome;
        this.marca = marca;
        this.dataCadastro = dataCadastro;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }
    
     public Produto() {

    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the fornecedor
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void salvar() {
        ProdutoDAO.salvar(this);
    }
}
