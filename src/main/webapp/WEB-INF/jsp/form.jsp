<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="header.jsp"/>

<c:if test="${editandoText != null}">
    <h5>${editandoText}</h5>
</c:if>

<c:if test="${inserindoText != null}">
    <h5>${inserindoText}</h5>
</c:if>

<form:form
        action="${inserindoText == null ? 'editar' : ''}"
        method="post"
        modelAttribute="model"
        cssClass="form-inline"
>
    <form:hidden path="id" cssClass="form-control"/>

    <c:import url="${pagePath}/form.jsp"/>

    <form:button class="btn btn-primary">
        ${inserindoText == null ? 'Editar' : 'Inserir'}
    </form:button>
</form:form>

<c:import url="footer.jsp"/>