<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="org.json.JSONObject"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>

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

<title>Buscar Usuario</title>
</head>
<body>
Busca por id

<div class="container">
 <div class="panel-body">
	   <form>
	    	  <div class="form-group">
			    <label for="inputlg">Id</label>
			    <input class="form-control" id="id" name="id" type="text" >
			  </div>
			  <input type="submit" id="buscar" class="btn btn-default" value="Buscar"/>
	   </form>
	  </div>
</div>
</body>
</html>