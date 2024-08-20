/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojamateriaiscontrucao.modelo.dao;

import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Compra;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
Columns:
ID_Compra int AI PK 
ID_Fornecedor int 
Data_Compra date 
Valor_Total
 */
public class CompraDao extends GenericoDAO<Compra> {
    public void salvar(Compra c) {
        String insert = "INSERT INTO COMPRAS (ID_FORNECEDOR, DATA_COMPRA, VALOR_TOTAL) VALUES (?,?,?)";
        save(insert, c.getID_Fornecedor(), c.getData_compra(),c.getValor_total());
    }

    public void excluir(int id) {
        String delete = "DELETE FROM COMPRAS WHERE ID_COMPRA=?";
        save(delete, id);
    }

    public Compra buscarPorId(int id) {
        String select = "SELECT * FROM COMPRAS WHERE ID_COMPRA=?";
        return buscarPorId(select, new CompraRowMapper(), id);
    }

    public List<Compra> buscarTodas() {
        String select = "SELECT * FROM COMPRAS";
        return buscarTodos(select, new CompraRowMapper());
    }

    public void alterar(Compra c) {
        String update = "UPDATE COMPRAS SET ID_FORNECEDOR=?, DATA_COMPRA=?, VALOR_TOTAL=? WHERE ID_COMPRA= ?";
        save(update, c.getID_Fornecedor(), c.getData_compra(), c.getValor_total(),c.getID_Compra());
    }


    public static class CompraRowMapper implements RowMapper<Compra> {

        @Override
        public Compra mapRow(ResultSet rs) throws SQLException {
            Compra compra = new Compra();
            compra.setID_Compra(rs.getInt("ID_Compra")); // pode dar erro por keySensitive, consultar o banco
            compra.setID_Fornecedor(rs.getInt("ID_Fornecedor"));
            compra.setData_compra(rs.getDate("DATA_COMPRA"));
            compra.setValor_total(rs.getDouble("VALOR_TOTAL"));
            return compra;
        }
    }
}
