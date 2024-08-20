/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojamateriaisconstrucao.modelo.entidade;

/**
 *
 * @author lucas
 */
public class Categoria {
    int ID_Categoria;
    String nome;

    public Categoria(int ID_Categoria, String nome) {
        this.ID_Categoria = ID_Categoria;
        this.nome = nome;
    }

    public Categoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public void setID_Categoria(int ID_Categoria) {
        this.ID_Categoria = ID_Categoria;
    }
    
    
}
