<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="form-group">
    <label for="nome">Nome</label>
    <form:input path="nome" cssClass="form-control"/>
</div>

<div class="form-group">
    <label for="preco">Preco</label>
    <form:input path="preco" cssClass="form-control"/>
</div>

<div class="form-group">
    <label for="pet">Pet</label>
    <form:select path="pet">
        <form:option value="" label="Escolher o Pet"/>

        <form:options
                items="${pets}"
                itemValue="id"
                itemLabel="nome"
        />
    </form:select>
</div>