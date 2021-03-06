<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"/>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Preco</th>
                <th scope="col">Banho</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${models}" var="model">
                <tr>
                    <th scope="row">${model.getId()}</th>
                    <td>${model.getNome()}</td>
                    <td>R$ ${model.getPreco()}</td>
                    <td>${model.isComBanho() ? "Sim" : "Nao"}</td>
                    <td>
                        <a class="btn btn-outline-secondary"
                           href="/${pagePath}/${model.getId()}"
                        >editar</a>

                        <a class="btn btn-outline-danger"
                           href="/${pagePath}/${model.getId()}/deletar"
                        >deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<jsp:include page="../footer.jsp"/>