/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojamateriaiscontrucao.modelo.dao;

import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Cliente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lucas
 */
/*ID_Cliente INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100),
    Endereço VARCHAR(255),
    Telefone VARCHAR(20),
    Email VARCHAR(100)
 */
public class ClienteDao extends GenericoDAO<Cliente> {

    public void salvar(Cliente c) {
        String insert = "INSERT INTO CLIENTES (NOME,ENDEREçO,TELEFONE,EMAIL) VALUES (?,?,?,?)";
        save(insert, c.getNome(), c.getEndereco(), c.getTelefone(), c.getEmail());
    }

    public void excluir(Cliente c) {
        String delete = "DELETE FROM CLIENTES WHERE ID_CLIENTE=?";
        save(delete, c.getID_Cliente());
    }

    public Cliente buscarPorId(int id) {
        String select = "SELECT * FROM CLIENTES WHERE CODIGO=?";
        return buscarPorId(select, new ClienteRowMapper(), id);
    }

    public List<Cliente> buscarTodas() {
        String select = "SELECT * FROM CLIENTES";
        return buscarTodos(select, new ClienteRowMapper());
    }

    public void alterar(Cliente cliente) {
        String update = "UPDATE CLIENTES SET NOME=?, ENDEREçO=?, TELEFONE=?, EMAIL=? WHERE ID_CLIENTE = ?";
        save(update, cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(), cliente.getEmail(), cliente.getID_Cliente());
    }

    public List<Cliente> BuscarTodosClientes(HttpServletRequest request, HttpServletResponse response) {
        String select = "SELECT * FROM CLIENTES";
        return buscarTodos(select, new ClienteRowMapper());
    }

    public static class ClienteRowMapper implements RowMapper<Cliente> {

        @Override
        public Cliente mapRow(ResultSet rs) throws SQLException {
            Cliente cliente = new Cliente();
            cliente.setID_Cliente(rs.getInt("ID_Cliente")); // pode dar erro por keySensitive, consultar o banco
            cliente.setNome(rs.getString("NOME"));
            cliente.setEndereco(rs.getString("ENDEREÇO"));
            cliente.setTelefone(rs.getString("TELEFONE"));
            cliente.setEmail(rs.getString("EMAIL"));
            return cliente;
        }
    }
}
