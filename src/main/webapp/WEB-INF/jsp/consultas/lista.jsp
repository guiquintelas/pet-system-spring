<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"/>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Preco</th>
                <th scope="col">Vacinas</th>
                <th scope="col">Pet</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${models}" var="model">
                <tr>
                    <th scope="row">${model.getId()}</th>
                    <td>${model.getNome()}</td>
                    <td>R$ ${model.getPreco()}</td>

                    <td>
                        <c:forEach items="${model.getVacinas()}" var="vacina" varStatus="loop">
                            <a href="/vacinas/${vacina.getId()}">
                                ${vacina.getNome()}
                            </a>

                            <c:if test="${!loop.last}">,</c:if>
                        </c:forEach>

                        <c:if test="${model.getVacinas().size() == 0}">
                            Sem vacinas
                        </c:if>
                    </td>

                    <td>
                        <c:if test="${model.getPet() != null}">
                            <a href="/pets/${model.getPet().id}">
                                    ${model.getPet().nome}
                            </a>
                        </c:if>
                        <c:if test="${model.getPet() == null}">
                            Sem pet
                        </c:if>
                    </td>

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