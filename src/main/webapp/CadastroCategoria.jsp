<%-- 
    Document   : CadastroCategoria
    Created on : 17 de ago. de 2024, 14:12:48
    Author     : lucas
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Categoria</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CategoriaControlador" method="get">
                <input type="hidden" name="nome" value="${nome}"/>
                <input type="hidden" name="ID_Categoria" value="${ID_Categoria}"/>
                <input type="hidden" name="opcao" value="${opcao}"/>

                <label>Nome categoria:</label>
                <input type="text" name="nome" value="${nome}"/>
                <input type="submit" value="Salvar" name="Salvar"/>
            </form>

        </table>
        <table>
            <form action="${pageContext.request.contextPath}${URL_BASE}/CategoriaControlador" method="get">
                <select name="selectCategoria">
                    <c:forEach var="categoria" items="${categorias}">
                        <option value="${categoria.ID_Categoria}">${categoria.nome}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="opcao" value="mostrarLista"/>
                <input type="submit" value="Selecionar"/>
            </form>
            <form  id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/CategoriaControlador" method="get">
                <input type="hidden" name="selectCategoria" value="${selectCategoria}"/>
                <input type="hidden" name="opcao" value="confirmarExcluir"/>
                <input type="submit" value="Excluir" />
            </form>
            </form>
        </table>   

    </body>
</html>
