/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojamateriaiscontrucao.modelo.dao;

import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lucas
 */
public class CategoriaDao extends GenericoDAO<Categoria> {
    public void salvar(Categoria c) {
        String insert = "INSERT INTO Categorias (NOME) VALUES (?)";
        save(insert, c.getNome());
    }

    public void excluir(Categoria c) {
        String delete = "DELETE FROM CATEGORIAS WHERE ID_CATEGORIA=?";
        save(delete, c.getID_Categoria());
    }

    public Categoria buscarPorId(int id) {
        String select = "SELECT * FROM CATEGORIAS WHERE ID_CATEGORIA=?";
        return buscarPorId(select, new CategoriaRowMapper(), id);
    }

    public void alterar(Categoria categoria) {
        String update = "UPDATE CATEGORIAS SET NOME=? WHERE ID_CATEGORIA = ?";
        save(update, categoria.getNome(), categoria.getID_Categoria());
    }

    public List<Categoria> buscarTodasCategorias() {
        String select = "SELECT * FROM CATEGORIAS";
        return buscarTodos(select, new CategoriaRowMapper());
    }

    public static class CategoriaRowMapper implements RowMapper<Categoria> {

        @Override
        public Categoria mapRow(ResultSet rs) throws SQLException {
            Categoria categoria = new Categoria();
            categoria.setID_Categoria(rs.getInt("ID_Categoria")); // pode dar erro por keySensitive, consultar o banco
            categoria.setNome(rs.getString("NOME"));
            return categoria;
        }
    }
}
