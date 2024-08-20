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
public class Compra {
    int ID_Compra;
    int ID_Fornecedor;
    Date data_compra;
    double valor_total;

    public Compra() {
    }

    public int getID_Compra() {
        return ID_Compra;
    }

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public int getID_Fornecedor() {
        return ID_Fornecedor;
    }

    public void setID_Fornecedor(int ID_Fornecedor) {
        this.ID_Fornecedor = ID_Fornecedor;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
}
