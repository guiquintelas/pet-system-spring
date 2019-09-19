<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <!------ Include the above in your HEAD tag ---------->
    <title>Login</title>

    <style>
        .login-form {
            width: 340px;
            margin: 150px auto;
            padding: 20px;
            border: 1px solid rgba(1,1,1,0.1);
            border-radius: 15px;
            box-shadow: 0 2px 4px -1px rgba(0,0,0,.2),0 4px 5px 0 rgba(0,0,0,.14),0 1px 10px 0 rgba(0,0,0,.12)
        }
    </style>
</head>
<body>
    <div class="login-form">
        <form action="/login" method="post">
            <h2 class="text-center" style="margin-bottom: 30px">Login</h2>

            <c:if test="${loginError}">
                <div class="alert alert-danger" role="alert">
                    Email ou senha incorretos!
                </div>
            </c:if>

            <div class="form-group">
                <input type="text" name="email" class="form-control" placeholder="Email" required="required">
            </div>

            <div class="form-group">
                <input type="password" name="senha" class="form-control" placeholder="Senha" required="required">
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Log in</button>
            </div>
        </form>
    </div>
</body>
</html>