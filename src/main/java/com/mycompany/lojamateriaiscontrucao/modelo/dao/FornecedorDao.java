/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojamateriaiscontrucao.modelo.dao;
import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Fornecedor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lucas
 */
public class FornecedorDao extends GenericoDAO<Fornecedor>{
    public void salvar(Fornecedor fornecedor) {
        String insert = "INSERT INTO FORNECEDORES (NOME,ENDERECO,TELEFONE,EMAIL) VALUES (?,?,?,?)";
        save(insert, fornecedor.getNome(), fornecedor.getEndereco(), fornecedor.getTelefone(), fornecedor.getEmail());
    }

    public void excluir(Fornecedor fornecedor) {
        String delete = "DELETE FROM FORNECEDORES WHERE ID_FORNECEDOR=?";
        save(delete, fornecedor.getID_Fornecedor());
    }

    public Fornecedor buscarPorId(int id) {
        String select = "SELECT * FROM FORNECEDORES WHERE CODIGO=?";
        return buscarPorId(select, new ClienteRowMapper(), id);
    }

    public List<Fornecedor> buscarTodas() {
        String select = "SELECT * FROM FORNECEDORES";
        return buscarTodos(select, new ClienteRowMapper());
    }

    public void alterar(Fornecedor fornecedor) {
        String update = "UPDATE FORNECEDORES SET NOME=?, ENDERECO=?, TELEFONE=?, EMAIL=? WHERE ID_FORNECEDOR = ?";
        save(update, fornecedor.getNome(), fornecedor.getEndereco(), fornecedor.getTelefone(), fornecedor.getEmail(), fornecedor.getID_Fornecedor());
    }

    public List<Fornecedor> BuscarTodosFuncionarios(HttpServletRequest request, HttpServletResponse response) {
        String select = "SELECT * FROM FORNECEDORES";
        return buscarTodos(select, new ClienteRowMapper());
    }

    public static class ClienteRowMapper implements RowMapper<Fornecedor> {

        @Override
        public Fornecedor mapRow(ResultSet rs) throws SQLException {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setID_Fornecedor(rs.getInt("ID_Fornecedor")); // pode dar erro por keySensitive, consultar o banco
            fornecedor.setNome(rs.getString("NOME"));
            fornecedor.setEndereco(rs.getString("ENDERECO"));
            fornecedor.setTelefone(rs.getString("TELEFONE"));
            fornecedor.setEmail(rs.getString("EMAIL"));
            return fornecedor;
        }
    }
}
