/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojamateriaisconstrucao.modelo.entidade;

/**
 *
 * @author lucas
 */
public class Fornecedor {
    private int ID_Fornecedor;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public Fornecedor(int ID_Fornecedor, String nome, String endereço, String telefone, String email) {
        this.ID_Fornecedor = ID_Fornecedor;
        this.nome = nome;
        this.endereco = endereço;
        this.telefone = telefone;
        this.email = email;
    }

    public Fornecedor() {
    }

    public int getID_Fornecedor() {
        return ID_Fornecedor;
    }

    public void setID_Fornecedor(int ID_Fornecedor) {
        this.ID_Fornecedor = ID_Fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
