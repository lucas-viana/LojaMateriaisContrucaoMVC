/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.lojamateriaisconstrucao.controlador;

import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Categoria;
import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Cliente;
import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Funcionario;
import com.mycompany.lojamateriaiscontrucao.modelo.dao.CategoriaDao;
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
@WebServlet(name = "CategoriaControlador", urlPatterns = {"/CategoriaControlador"})
public class CategoriaControlador extends HttpServlet {

    private CategoriaDao categoriaDao;
    private Categoria categoria;
    private String opcao="";
    private String ID_Categoria="";
    private String nome="";

    @Override
    public void init() {
        categoriaDao = new CategoriaDao();
        categoria = new Categoria();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            ID_Categoria = request.getParameter("selectCategoria");
            nome = request.getParameter("nome");

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

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> categorias = categoriaDao.buscarTodasCategorias();
        request.setAttribute("categorias", categorias);
        request.setAttribute("selectCategoria", ID_Categoria);
        request.setAttribute("nome", nome);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroCategoria.jsp");
        dispatcher.forward(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoria.setNome(nome);
        categoriaDao.salvar(categoria);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Categoria", ID_Categoria);
        request.setAttribute("nome", nome);
        request.setAttribute("opcao", "confirmarEditar");
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoria.setID_Categoria(Integer.parseInt(ID_Categoria));
        categoria.setNome(nome);
        request.setAttribute("nome", nome);
        request.setAttribute("selectCategoria", ID_Categoria);
        categoriaDao.alterar(categoria);
        cancelar(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoria.setID_Categoria(Integer.parseInt(ID_Categoria));
        categoria.setNome(nome);
        categoriaDao.excluir(categoria);
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Categoria", "0");
        request.setAttribute("nome", "");
        request.setAttribute("opcao", "cadastrar");
        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Categoria", ID_Categoria);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("nome", nome);
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusao dos dados");
        encaminharParaPagina(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroCategoria</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastroCategoria at " + request.getContextPath() + "</h1>");
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
     *
     *
     * /**
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
