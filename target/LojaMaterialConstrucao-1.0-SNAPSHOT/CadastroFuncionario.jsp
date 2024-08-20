<%-- 
    Document   : CadastroFuncionario
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
        <title>Cadastro Funcionario</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
        <h1>Cadastro Funcionário</h1>
        <table>
            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador" method="get">
                <input type="hidden" name="opcao" value="${opcao}" />
                <input type="hidden" name="ID_Funcionario" value="${ID_Funcionario}" />
                <input type="hidden" name="nome" value="${nome}" />
                <input type="hidden" name="cargo" value="${cargo}" />
                <input type="hidden" name="salario" value="${salario}" />
                <input type="hidden" name="dataAdmissao" value="${dataAdmissao}" />
                <p> 
                    <label> Nome funcionário</label>  
                    <input type="text" name="nome" value="${nome}" size="40" /> 
                </p>
                <p>
                    <label>Cargo</label> 
                    <input type="text" name="cargo" value="${cargo}" size="50" /> 
                </p>
                <p>
                    <label>Salário</label> 
                    <input type="text" name="salario" value="${salario}" size="50" /> 
                </p>
                <p>
                    <label>Data de Admissão</label> 
                    <input type="date" name="dataAdmissao" value="${dataAdmissao}"/> 
                </p>
                <td>
                    <input type="submit"  value="Salvar" name="Salvar" />
                </td>
            </form>

            <form id="cadastroForm" name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador" method="get">
                <td> 
                    <input type="submit" value="cancelar" name="Cancelar">
                </td>
                <input type="hidden" name="opcao" value="Cancelar" />
            </form>
        </table>        
        ${mensagem}
        <table border="1"> 
            <c:if test="${not empty funcionarios}">
                <tr>
                    <th>Cod.</th>
                    <th>Nome Funcionário</th>
                    <th>Cargo</th>
                    <th>Salário</th>
                    <th>Data Admissão</th>
                    <th>Alterar</th>
                    <th>Excluir</th>
                </tr>
            </c:if>

            <c:forEach var="funcionario" items="${funcionarios}">
                <tr>
                    <td>${funcionario.ID_Funcionario}</td>
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.cargo}</td>
                    <td>${funcionario.salario}</td>
                    <td><input type="date" value="${funcionario.dataAdmissao}" disabled="true"></td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador" method="get">
                            <input type="hidden" name="ID_Funcionario" value="${funcionario.ID_Funcionario}">
                            <input type="hidden" name="nome" value="${funcionario.nome}">
                            <input type="hidden" name="cargo" value="${funcionario.cargo}">
                            <input type="hidden" name="salario" value="${funcionario.salario}">
                            <input type="hidden" name="dataAdmissao" value="${funcionario.dataAdmissao}">
                            <input type="hidden" name="opcao" value="editar">
                            <button  type="submit">Editar</button>
                        </form>
                    </td>
                    <td>
                        <form name="cadastroForm" action="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador" method="get">
                            <input type="hidden" name="ID_Funcionario" value="${funcionario.ID_Funcionario}">
                            <input type="hidden" name="nome" value="${funcionario.nome}">
                            <input type="hidden" name="cargo" value="${funcionario.cargo}">
                            <input type="hidden" name="salario" value="${funcionario.salario}">
                            <input type="hidden" name="dataAdmissao" value="${funcionario.dataAdmissao}">
                            <input type="hidden" name="opcao" value="excluir">
                            <button  type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>