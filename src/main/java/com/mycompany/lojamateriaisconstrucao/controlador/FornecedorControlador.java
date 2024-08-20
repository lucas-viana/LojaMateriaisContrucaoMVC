/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.lojamateriaisconstrucao.controlador;

import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Fornecedor;
import com.mycompany.lojamateriaiscontrucao.modelo.dao.FornecedorDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author lucas
 */
@WebServlet(name = "FornecedorControlador", urlPatterns = {"/FornecedorControlador"})
public class FornecedorControlador extends HttpServlet {

   private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private String ID_Fornecedor="";
    private String nome="";
    private String endereco="";
    private String telefone="";
    private String email="";
    private String opcao="";

    @Override
    public void init() {
        fornecedor = new Fornecedor();
        fornecedorDao = new FornecedorDao();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            ID_Fornecedor = request.getParameter("ID_Fornecedor");
            nome = request.getParameter("nome");
            endereco = request.getParameter("endereco");
            telefone = request.getParameter("telefone");
            email = request.getParameter("email");
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
        }
        processRequest(request, response);

    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fornecedor.setNome(nome);
        fornecedor.setEndereco(endereco);
        fornecedor.setTelefone(telefone);
        fornecedor.setEmail(email);
        fornecedorDao.salvar(fornecedor);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Fornecedor", ID_Fornecedor);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("nome", nome);
        request.setAttribute("endereco", endereco);
        request.setAttribute("telefone", telefone);
        request.setAttribute("email", email);
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fornecedor.setID_Fornecedor(Integer.parseInt(ID_Fornecedor));
        fornecedor.setNome(nome);
        fornecedor.setEndereco(endereco);
        fornecedor.setTelefone(telefone);
        fornecedor.setEmail(email);
        fornecedorDao.alterar(fornecedor);
        cancelar(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fornecedor.setID_Fornecedor(Integer.parseInt(ID_Fornecedor));
        fornecedor.setNome(nome);
        fornecedor.setEndereco(endereco);
        fornecedor.setTelefone(telefone);
        fornecedor.setEmail(email);
        fornecedorDao.excluir(fornecedor);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Fornecedor", "0");
        request.setAttribute("nome", "");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("endereco", "");
        request.setAttribute("telefone", "");
        request.setAttribute("email", "");
        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Fornecedor", ID_Fornecedor);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nome", nome);
        request.setAttribute("endereco", endereco);
        request.setAttribute("telefone", telefone);
        request.setAttribute("email", email);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusao dos dados");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Fornecedor> fornecedores = fornecedorDao.buscarTodas();
        request.setAttribute("fornecedores", fornecedores);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroFornecedor.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FornecedorControlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FornecedorControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
