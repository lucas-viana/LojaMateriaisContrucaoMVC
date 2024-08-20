<!DOCTYPE html>
<html lang="pt">
    <head>
        <meta charset="UTF-8">
        <title>Página Principal</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
    </head>
    <body>
       
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/ClienteControlador?opcao=mostrarLista">Cliente</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/FuncionarioControlador?opcao=mostrarLista">Funcionário</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/FornecedorControlador?opcao=mostrarLista">Fornecedor</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/CategoriaControlador?opcao=mostrarLista">Categorias</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/CompraControlador?opcao=mostrarLista">Compras</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
                <li><a href="${pageContext.request.contextPath}${URL_BASE}/LogoutControlador">Logout</a></li>   
            </ul>
        </nav>
    </body>
</html>
