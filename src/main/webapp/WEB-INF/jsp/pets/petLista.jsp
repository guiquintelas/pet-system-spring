<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"/>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Raca</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pets}" var="pets">
                <tr>
                    <th scope="row">${pets.getId()}</th>
                    <td>${pets.getNome()}</td>
                    <td>${pets.getRaca()}</td>
                    <td>
                        <a class="btn btn-light"
                           href="/pets/${pets.getId()}"
                        >editar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<jsp:include page="../footer.jsp"/>