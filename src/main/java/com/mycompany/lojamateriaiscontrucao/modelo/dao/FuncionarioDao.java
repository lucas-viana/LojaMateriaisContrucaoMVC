/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojamateriaiscontrucao.modelo.dao;

import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lucas
 */
public class FuncionarioDao extends GenericoDAO<Funcionario> {
        public void salvar(Funcionario f){
        String insert = "INSERT INTO FUNCIONARIOS (NOME,CARGO,SALARIO,DATA_ADMISSAO) VALUES (?,?,?,?)";
        save(insert, f.getNome(), f.getCargo(), f.getSalario(), f.getDataAdmissao());
    }
    
    public void alterar(Funcionario f){
        String update = "UPDATE FUNCIONARIOS SET NOME=?,CARGO=?,SALARIO=?,DATA_ADMISSAO=? WHERE ID_FUNCIONARIO=?";
        save(update, f.getNome(), f.getCargo(), f.getSalario(), f.getDataAdmissao(),f.getID_Funcionario());
    }
    
    public void excluir(Funcionario f){
        String delete="DELETE FROM FUNCIONARIOS WHERE ID_FUNCIONARIO=?";
        save(delete, f.getID_Funcionario());
    }
    
    public Funcionario buscarPorId(int id){
        String select = "SELECT * FROM FUNCIONARIOS WHERE ID_FUNCIONARIO=??";
        return buscarPorId(select, new FuncionarioRowMapper(), id);
    }
    
    public List<Funcionario> buscarTodosFuncionarios(){
         String select = "SELECT * FROM FUNCIONARIOS";
        return buscarTodos(select, new FuncionarioRowMapper());
    }
    
    public static class FuncionarioRowMapper implements RowMapper<Funcionario>{

        @Override
        public Funcionario mapRow(ResultSet rs) throws SQLException {
            Funcionario funcionario = new Funcionario();
            funcionario.setID_Funcionario(rs.getInt("ID_Funcionario"));
            funcionario.setNome(rs.getString("NOME"));
            funcionario.setCargo(rs.getString("CARGO"));
            funcionario.setSalario(rs.getFloat("SALARIO"));
            funcionario.setDataAdmissao(rs.getDate("Data_Admissao"));
            return funcionario;
        }
        
    }
}
