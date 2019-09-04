<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="page" type="java.lang.String"--%>
<%--@elvariable id="msg" type="java.lang.String"--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <title>${page}</title>
</head>
<body>
    <div class="container-fluid p-5">
        <div class="row">
            <a href="">
                <h2>${page}</h2>
            </a>
        </div>
        <br>

        <c:if test="${msg != null}">
            <div class="alert alert-success" role="alert">
                ${msg}
            </div>
        </c:if>

        <c:if test="${page != 'Home' && inserindoText == null && editandoText == null}">
            <a class="btn btn-primary btn-lg mb-3 text-white" href="/${pagePath}/inserir">
                Adicionar
            </a>
        </c:if>







