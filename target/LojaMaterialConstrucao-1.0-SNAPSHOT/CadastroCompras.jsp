<%-- 
    Document   : CadastroCompras
    Created on : 19 de ago. de 2024, 07:47:06
    Author     : lucas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de Compra</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
        <h1>Cadastro Compra</h1>
        <table>
            <form action="${pageContext.request.contextPath}${URL_BASE}/CompraControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="ID_Compra" value="${ID_Compra}" />
                <input type="hidden" name="ID_Fornecedor" value="${ID_Fornecedor}" />
                <input type="hidden" name="Data_Compra" value="${Data_Compra}" />
                <input type="hidden" name="Valor_Total" value="${Valor_Total}" />

                <label for="ID_Fornecedor">ID Fornecedor:</label>
                <input type="text" id="ID_Fornecedor" name="ID_Fornecedor" required><br><br>

                <label for="data_compra">Data da Compra:</label>
                <input type="date" id="data_compra" name="data_compra" required><br><br>

                <label for="valor_total">Valor Total:</label>
                <input type="number" id="valor_total" name="valor_total" step="0.01" required><br><br>

                <input type="submit" value="${opcao}">

                <td>
                    <input type="submit"  value="Salvar" name="Salvar" />
                </td>
            </form>

            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CompraControlador" method="get">
                <td> 
                    <input type="submit" value="cancelar" name="Cancelar">
                </td>
                <input type="hidden" name="opcao" value="Cancelar" />
            </form>
        </table>        
        ${mensagem}
        <table border="1"> 
            <c:if test="${not empty clientes}">
                <tr>
                    <th>Cod.</th>
                    <th>Nome Cliente</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </c:if>

            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.ID_Cliente}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.endereco}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.email}</td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/ClienteControlador" method="get">
                            <input type="hidden" name="ID_Cliente" value="${cliente.ID_Cliente}">
                            <input type="hidden" name="nome" value="${cliente.nome}">
                            <input type="hidden" name="endereco" value="${cliente.endereco}">
                            <input type="hidden" name="telefone" value="${cliente.telefone}">
                            <input type="hidden" name="email" value="${cliente.email}">
                            <input type="hidden" name="opcao" value="editar">
                            <button  type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/ClienteControlador" method="get">
                            <input type="hidden" name="ID_Cliente" value="${cliente.ID_Cliente}">
                            <input type="hidden" name="nome" value="${cliente.nome}">
                            <input type="hidden" name="endereco" value="${cliente.endereco}">
                            <input type="hidden" name="telefone" value="${cliente.telefone}">
                            <input type="hidden" name="email" value="${cliente.email}">
                            <input type="hidden" name="opcao" value="excluir">
                            <button  type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
