<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"/>

    <table class="table">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Raca</th>
                <th scope="col">Cupom de Desconto</th>
                <th scope="col">Consultas</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${models}" var="model">
                <tr>
                    <th scope="row">${model.getId()}</th>
                    <td>${model.getNome()}</td>
                    <td>${model.getRaca()}</td>

                    <td>
                        <c:if test="${model.getCupomDesconto() != null}">
                            <a href="/cupom-descontos/${model.getCupomDesconto().id}">
                                ${model.getCupomDesconto().codigo} (${model.getCupomDesconto().desconto}%)
                            </a>
                        </c:if>
                        <c:if test="${model.getCupomDesconto() == null}">
                            Sem Cupom
                        </c:if>
                    </td>

                    <td>
                        <c:forEach items="${model.getConsultas()}" var="consulta" varStatus="loop">
                            <a href="/consultas/${consulta.getId()}">
                                    ${consulta.getNome()}
                            </a>

                            <c:if test="${!loop.last}">,</c:if>
                        </c:forEach>

                        <c:if test="${model.getConsultas().size() == 0}">
                            Sem consultas
                        </c:if>
                    </td>

                    <td>
                        <a class="btn btn-outline-secondary"
                           href="/pets/${model.getId()}"
                        >editar</a>

                        <a class="btn btn-outline-danger"
                           href="/pets/${model.getId()}/deletar"
                        >deletar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<jsp:include page="../footer.jsp"/>