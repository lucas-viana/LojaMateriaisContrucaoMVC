/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojamateriaisconstrucao.modelo.entidade;

import java.util.Date;

/**
 *
 * @author lucas
 */
public class Funcionario {
    private int ID_Funcionario;
    private String nome;
    private String cargo;
    private double salario;
    private Date dataAdmissao;

        public Funcionario(int ID_Funcionario, String nome, String cargo, double salario, Date data_Admissao) {
        this.ID_Funcionario = ID_Funcionario;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmissao = data_Admissao;
    }

    public Funcionario() {
    }
    
    public int getID_Funcionario() {
        return ID_Funcionario;
    }

    public void setID_Funcionario(int ID_Funcionario) {
        this.ID_Funcionario = ID_Funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    
}
