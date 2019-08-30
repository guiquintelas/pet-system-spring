<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="../header.jsp"/>

<%--@elvariable id="pet" type="self.quintelas.main.model.Pet"--%>

<h5>Editando o Pet ${pet.getNome()}</h5>


<form:form
        action="/pets/editar"
        method="post"
        modelAttribute="pet"
>
    <form:hidden path="id" cssClass="form-control"/>

    <div class="form-group">
        <label for="nome">Nome</label>
        <form:input path="nome" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="raca">Raca</label>
        <form:input path="raca" cssClass="form-control"/>
    </div>

    <form:button class="btn btn-primary">
        Editar
    </form:button>
</form:form>

<c:import url="../footer.jsp"/>