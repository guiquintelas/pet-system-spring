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
    <label>Com banho</label>
    <form:checkbox path="comBanho" cssClass="form-control" />
</div>