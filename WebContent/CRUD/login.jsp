<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/stilo.css" />
</head>
<body>
	<form action="ServletLogar" >
		<div class="container">
			<div class="row vertical-offset-100">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Acesso ao sistema</h3>
						</div>
						<div class="panel-body">
							<form accept-charset="UTF-8" role="form">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="E-mail" name="email"
											type="text">
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Senha"
											name="password" type="password" value="">
									</div>
									<div class="checkbox">
										<label> <input name="remember" type="checkbox"
											value="Remember Me"> Remember Me
										</label>
									</div>
									<input class="btn btn-lg btn-success btn-block" name"acessar" type="submit"
										value="Login">
									<input class="btn btn-lg btn-success btn-block" type="reset"
										value="Limpar">
									
									<c:choose>
										<c:when test = "${mensagem!= null}">
											${mensagem}
										</c:when>
										<c:otherwise>
										<br>
											Entre com usuario/senha
										</c:otherwise>
									</c:choose>	
										
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</body>
</html>