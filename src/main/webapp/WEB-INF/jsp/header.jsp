<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="page" type="java.lang.String"--%>
<%--@elvariable id="msg" type="java.lang.String"--%>
<%--@elvariable id="history" type="java.lang.String"--%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <title>${page}</title>

    <style>
        .navbar-expand-lg .navbar-collapse {
            display: -ms-flexbox!important;
            display: flex!important;
            -ms-flex-preferred-size: auto;
            flex-basis: auto;
        }
        .navbar-nav {
            -ms-flex-direction: row;
            flex-direction: row;
        }
        .navbar-nav .nav-link {
            padding-right: .5rem;
            padding-left: .5rem;
        }

        input[type='checkbox'] {
            width: 30px;
        }

        .form-inline {
            align-items: flex-end;
        }

        .form-inline .form-group {
            flex-direction: column;
            align-items: start;
        }

        .form-group {
            margin-right: 15px;
        }

    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="">PetSystem</a>

        <div class="navbar-collapse show" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item ${page == 'Home' ? 'active' : '' }">
                    <a class="nav-link" href="/">Home</a>
                </li>

                <li class="nav-item ${page == 'Pets' ? 'active' : '' }">
                    <a class="nav-link" href="/pets">Pets</a>
                </li>

                <li class="nav-item ${page == 'Cupom de Descontos' ? 'active' : '' }">
                    <a class="nav-link" href="/cupom-descontos">Cupom de Descontos</a>
                </li>

                <li class="nav-item ${page == 'Vacinas' ? 'active' : '' }">
                    <a class="nav-link" href="/vacinas">Vacinas</a>
                </li>

                <li class="nav-item ${page == 'Tosas' ? 'active' : '' }">
                    <a class="nav-link" href="/tosas">Tosas</a>
                </li>

                <li class="nav-item ${page == 'Consultas' ? 'active' : '' }">
                    <a class="nav-link" href="/consultas">Consultas</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid p-5">
        <div class="row">
            <h3>${page}</h3>
        </div>


        <c:if test="${history != null && history != ''}">
            <div class="row" style="display: flex; align-items: baseline;">
                <b style="margin-right: 10px">Ultimas paginas acessadas:</b>
                <div style="font-size: 12px">
                    <c:forEach items="${history}" var="item" varStatus="loop">
                        ${item}

                        <c:if test="${!loop.last}"> > </c:if>
                    </c:forEach>
                </div>
            </div>
        </c:if>
        <br>

        <c:if test="${msg != null && msg != ''}">
            <div class="alert alert-success" role="alert">
                ${msg}
            </div>
        </c:if>

        <c:if test="${page != 'Home' && inserindoText == null && editandoText == null}">
            <a class="btn btn-primary btn-lg mb-3 text-white" href="/${pagePath}/inserir">
                Adicionar
            </a>
        </c:if>







