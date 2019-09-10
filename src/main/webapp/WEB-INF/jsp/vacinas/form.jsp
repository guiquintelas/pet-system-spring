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
    <label for="consulta">Consulta</label>
    <form:select path="consulta">
        <form:option value="" label="Escolher a Consulta"/>

        <form:options
                items="${consultas}"
                itemValue="id"
                itemLabel="nome"
        />
    </form:select>
</div>