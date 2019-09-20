<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${msg}

<c:if test="${finalizaCampos != null}">
    <br>
    <br>
</c:if>

<c:forEach var="campoValor" items="${finalizaCampos}">
    <b>${campoValor.key}:</b> ${campoValor.value}
    <br>
</c:forEach>
