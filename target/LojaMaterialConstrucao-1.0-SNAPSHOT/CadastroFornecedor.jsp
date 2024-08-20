<%-- 
    Document   : CadastroFornecedor
    Created on : 13 de ago. de 2024, 21:06:54
    Author     : lucas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Fornecedor</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
        <h1>Cadastro Fornecedor</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FornecedorControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="ID_Fornecedor" value="${ID_Fornecedor}" />
                <input type="hidden" name="nome" value="${nome}" />
                <input type="hidden" name="endereco" value="${endereco}" />
                <input type="hidden" name="telefone" value="${telefone}" />
                <input type="hidden" name="email" value="${email}" />
                <p> 
                    <label> Nome fornecedor:</label>  
                    <input type="text" name="nome" value="${nome}" size="40" /> 
                </p>
                <p>
                    <label>Endereço</label> 
                    <input type="text" name="endereco" value="${endereco}" size="50" /> 
                </p>
                <p>
                    <label>Telefone</label> 
                    <input type="text" name="telefone" value="${telefone}" size="50" /> 
                </p>
                <p>
                    <label>Email</label> 
                    <input type="text" name="email" value="${email}" size="50" /> 
                </p>
                <td>
                    <input type="submit"  value="Salvar" name="Salvar" />
                </td>
            </form>

            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FornecedorControlador" method="get">
                <td> 
                    <input type="submit" value="cancelar" name="Cancelar">
                </td>
                <input type="hidden" name="opcao" value="Cancelar" />
            </form>
        </table>        
        ${mensagem}
        <table border="1"> 
            <c:if test="${not empty fornecedores}">
                <tr>
                    <th>Cod.</th>
                    <th>Nome Fornecedor</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </c:if>

            <c:forEach var="fornecedor" items="${fornecedores}">
                <tr>
                    <td>${fornecedor.ID_Fornecedor}</td>
                    <td>${fornecedor.nome}</td>
                    <td>${fornecedor.endereco}</td>
                    <td>${fornecedor.telefone}</td>
                    <td>${fornecedor.email}</td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FornecedorControlador" method="get">
                            <input type="hidden" name="ID_Fornecedor" value="${fornecedor.ID_Fornecedor}">
                            <input type="hidden" name="nome" value="${fornecedor.nome}">
                            <input type="hidden" name="endereco" value="${fornecedor.endereco}">
                            <input type="hidden" name="telefone" value="${fornecedor.telefone}">
                            <input type="hidden" name="email" value="${fornecedor.email}">
                            <input type="hidden" name="opcao" value="editar">
                            <button  type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FornecedorControlador" method="get">
                            <input type="hidden" name="ID_Fornecedor" value="${fornecedor.ID_Fornecedor}">
                            <input type="hidden" name="nome" value="${fornecedor.nome}">
                            <input type="hidden" name="endereco" value="${fornecedor.endereco}">
                            <input type="hidden" name="telefone" value="${fornecedor.telefone}">
                            <input type="hidden" name="email" value="${fornecedor.email}">
                            <input type="hidden" name="opcao" value="excluir">
                            <button  type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>