<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="form-group">
    <label for="nome">Nome</label>
    <form:input path="nome" cssClass="form-control"/>
</div>

<div class="form-group">
    <label for="raca">Raca</label>
    <form:input path="raca" cssClass="form-control"/>
</div>

<div class="form-group">
    <label for="cupomDesconto">Cupom Desconto</label>
    <form:select path="cupomDesconto">
        <form:option value="" label="Escolher Cupom de Desconto"/>

        <form:options
                items="${cupoms}"
                itemValue="id"
                itemLabel="codigo"
        />
    </form:select>
</div>

