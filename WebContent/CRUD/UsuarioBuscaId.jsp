<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Busca por ID</title>


<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">


<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
        $("#buscar").click(function() {
               $.ajax({
            	  url: "http://localhost:8080/HurryBus/rest/usuarios/"+$('#id').val(),
               contentType: "application/json; charset=utf-8",
               type: "get",
               dataType:"json",
               success: function(data) {
                   console.log(data);
                   // gerar um html e guardar nesta vari�vel
                   var html = "";
                   // coloco os dados na variavel
                  
                   	html += "<strong>Id:</strong><br /> "+data.id;
                    html += "<strong>Nome:</strong><br /> "+data.nome;
                    html += "<strong>Senha:</strong><br /> "+data.senha;
                    html += "<strong>Email:</strong><br /> "+data.email;
                   //quebra de linha
                    html += "<br />";
               	   //coloca a vari�vel html na tela
                   $('body').html(html);
                   
               }
           });
       });       
   });
</script>

</head>
<body>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Busca por ID</div>

				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<form id="loginform" class="form-horizontal" role="form">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="id" name="id"
								type="text" class="form-control" value="" placeholder="ID">
						</div>

						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">

								<input type="submit" id="buscar" class="btn btn-success"
									value="Buscar" />

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">


								</div>
							</div>
						</div>
					</form>

				</div>

			</div>
		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>