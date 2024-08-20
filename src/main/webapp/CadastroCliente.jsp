<%-- 
    Document   : MostraCliente
    Created on : 28 de jul. de 2024, 21:41:43
    Author     : lucas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
        <h1>Cadastro Cliente</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/ClienteControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="ID_Cliente" value="${ID_Cliente}" />
                <input type="hidden" name="nome" value="${nome}" />
                <input type="hidden" name="endereco" value="${endereco}" />
                <input type="hidden" name="telefone" value="${telefone}" />
                <input type="hidden" name="email" value="${email}" />
                <p> 
                    <label> Nome cliente:</label>  
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

            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/ClienteControlador" method="get">
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