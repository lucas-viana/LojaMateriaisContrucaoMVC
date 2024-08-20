/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.lojamateriaisconstrucao.controlador;

import static com.mycompany.lojamateriaisconstrucao.controlador.FuncionarioControlador.convertStringToDate;
import com.mycompany.lojamateriaisconstrucao.modelo.entidade.Compra;
import com.mycompany.lojamateriaiscontrucao.modelo.dao.CompraDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
@WebServlet(name = "CompraControlador", urlPatterns = {"/CompraControlador"})
public class CompraControlador extends HttpServlet {


    private CompraDao compraDao;
    private Compra compra;
    private String opcao="";
    private String ID_Compra="";
    private String ID_Fornecedor="";
    private String Data_Compra="";
    private String Valor_Total="";

    @Override
    public void init() {
        compra = new Compra();
        compraDao = new CompraDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            opcao = request.getParameter("opcao");
            ID_Compra = request.getParameter("ID_Compra");
            ID_Fornecedor = request.getParameter("ID_Fornecedor");
            Data_Compra = request.getParameter("Data_Compra");
            Valor_Total = request.getParameter("Valor_Total");
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
            Logger.getLogger(CompraControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        processRequest(request, response);

    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        compra.setID_Fornecedor(Integer.parseInt(ID_Fornecedor));
        compra.setData_compra(convertStringToDate(Data_Compra));
        compra.setValor_total(Double.parseDouble(Valor_Total));
        compraDao.salvar(compra);
        encaminharParaPagina(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Compra", ID_Compra);
        request.setAttribute("ID_Fornecedor", ID_Fornecedor);
        request.setAttribute("Data_Compra", Data_Compra);        
        request.setAttribute("Valor_Total", Valor_Total);        
        encaminharParaPagina(request, response);
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        compra.setID_Compra(Integer.parseInt(ID_Compra));
        compra.setID_Fornecedor(Integer.parseInt(ID_Fornecedor));
        compra.setData_compra(convertStringToDate(Data_Compra));
        compra.setValor_total(Double.parseDouble(Valor_Total));
        compraDao.alterar(compra);
        cancelar(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        compra.setID_Compra(Integer.parseInt(ID_Compra));
        compraDao.excluir(Integer.parseInt(ID_Compra));
        cancelar(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID_Compra", "0");
        request.setAttribute("ID_FOrnecedor", "");
        request.setAttribute("Data_Compra", "");
        request.setAttribute("Valor_Compra", "");
        request.setAttribute("opcao", "mostrarLista");
        encaminharParaPagina(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setAttribute("ID_Compra", ID_Compra);
        request.setAttribute("ID_Fornecedor", ID_Fornecedor);
        request.setAttribute("Data_Compra", Data_Compra);        
        request.setAttribute("Valor_Total", Valor_Total);        
        request.setAttribute("opcao", "confirmarExcluir");        
        request.setAttribute("mensagem", "Clique em salvar para confirmar a exclusao dos dados");
        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Compra> compras = compraDao.buscarTodas();
        request.setAttribute("compras", compras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroCompras.jsp");
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
            out.println("<title>Servlet CompraControlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompraControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
