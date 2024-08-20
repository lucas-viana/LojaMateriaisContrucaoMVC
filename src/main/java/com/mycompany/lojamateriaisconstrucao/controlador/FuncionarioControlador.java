/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.lojamateriaisconstrucao.controlador;

import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Funcionario;
import com.mycompany.lojamateriaiscontrucao.modelo.dao.FuncionarioDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
@WebServlet(name = "FuncionarioControlador", urlPatterns = {"/FuncionarioControlador"})
public class FuncionarioControlador extends HttpServlet {

    private Funcionario funcionario;
    private FuncionarioDao funcionarioDao;
    private String ID_Funcionario="";
    private String nome="";
    private String cargo="";
    private String salario="";
    private String dataAdmissao="";
    private String opcao="";

    @Override
    public void init() {
        funcionario = new Funcionario();
        funcionarioDao = new FuncionarioDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            ID_Funcionario = request.getParameter("ID_Funcionario");
            nome = request.getParameter("nome");
            cargo = request.getParameter("cargo");
            salario = request.getParameter("salario");
            dataAdmissao = request.getParameter("dataAdmissao");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }

            switch (opcao) {
                case "cadastrar":
                    cadastrar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "confirmarEditar":
                    confirmarEditar(request, response);
                    break;
                case "excluir":
                    excluir(request, response);
                    break;
                case "confirmarExcluir":
                    confirmarExcluir(request, response);
                    break;
                case "Cancelar":
                    cancelar(request, response);
                    break;
                case "mostrarLista":
                    encaminharParaPagina(request, response);
                    break;
                default:
                    throw new IllegalAccessError("Opcao invalida" + opcao);
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parâmetros não são numeros válidos");
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        processRequest(request, response);

    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setSalario(Double.parseDouble(salario));
        funcionario.setDataAdmissao(convertStringToDate(dataAdmissao));
        funcionarioDao.salvar(funcionario);
        encaminharParaPagina(request, response);
    }

    public static Date convertStringToDate(String s) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date data = format.parse(s);
        return data;        
    }
    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Funcionario", ID_Funcionario);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("nome", nome);
        request.setAttribute("cargo", cargo);
        request.setAttribute("salario", salario);
        request.setAttribute("dataAdmissao", dataAdmissao);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        funcionario.setID_Funcionario(Integer.parseInt(ID_Funcionario));
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setSalario(Double.parseDouble(salario));
        funcionario.setDataAdmissao(convertStringToDate(dataAdmissao));
        funcionarioDao.alterar(funcionario);
        cancelar(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        funcionario.setID_Funcionario(Integer.parseInt(ID_Funcionario));
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setSalario(Double.parseDouble(salario));
        funcionario.setDataAdmissao(convertStringToDate(dataAdmissao));
        funcionarioDao.excluir(funcionario);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Funcionario", "");
        request.setAttribute("nome", "");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("cargo", "");
        request.setAttribute("salario", "");
        request.setAttribute("dataAdmissao", "");
        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Funcionario", ID_Funcionario);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nome", nome);
        request.setAttribute("cargo", cargo);
        request.setAttribute("salario", salario);
        request.setAttribute("dataAdmissao", dataAdmissao);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusao dos dados");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Funcionario> funcionarios = funcionarioDao.buscarTodosFuncionarios();
        request.setAttribute("funcionarios", funcionarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroFuncionario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FuncionarioControlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FuncionarioControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
