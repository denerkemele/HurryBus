 <%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<html>
<!-- <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 
  -->


<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	
	
<!-- <script type="text/javascript">
		$(document).ready(function() {
			$("#cadastrar").click(function() {
				$.ajax({
					url : "http://localhost:8080/HurryBus/rest/usuarios",
					contentType : "application/json; charset=utf-8",
					type : "post",
					dataType : "json",
					data : JSON.stringify({
						nome : $('#nome').val(),//
	// 					id : $('#senha').val(),
						
				}),
				success : function(data) {
					console.log(data);
				}
			});
		});
	});
</script> -->

<script type="text/javascript">
/* 	$(document)
			.ready(
					function() {
						$(".fb-login-button")
								.click(function(event) {
											event.preventDefault(); */
											
								function teste(){			
											$.ajax({
														type : 'POST',
														url : 'http://localhost:8080/HurryBus/rest/usuarios'+'/login',
														contentType : 'application/json; charset=utf-8',
														data : JSON.stringify({
															nome : localStorage.nome
																	,
															senha : localStorage.id
														}),
														dataType : 'json',
														cache : false,
														async : false,
														crossDomain : true,
														jsonp : true,
														jsonpCallback : "callback",
													
														success : AjaxSucceeded,

														error : AjaxFailed


													});
											}
/* 
										});
					}); */

	function AjaxSucceeded(result) {
		
		alert("Usuario Cadastrado");
		
		window.location.href = "http://localhost:8080/HurryBus/CRUD/index.jsp";
	
	}
	function AjaxFailed(result) {
		alert("Erro de Acesso");
		if (result) {
			var successUrl = "http://localhost:8080/HurryBus/CRUD/login.jsp"; // might be a good idea to return this URL in the successful AJAX call
			window.location.href = successUrl;
		}

		

	}


</script>
 <div id="fb-root"></div>




<script>
/* function teste(result){
	
	alert ("nome:" );
	
	
} */

function refresh(){

	 setTimeout('location.reload();', 1000);
}

//////////////////////////////////////

  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
  
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      //testAPI();
         /* var iduser = response.id;
         var name = response.name;
         $("#nome").append(response.name);
         $("#userid").append(response.id); */
         //refresh();
        // teste();
         basicAPIRequest();
         //refresh();
         //teste();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  function checkLoginState() {
	  
	  system.out.println("entrou");
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '626698044148646',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.2' // use version 2.2
  });


  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };


//////////////////////////////////////




 /*  window.fbAsyncInit = function() {
    FB.init({
      appId      : '626698044148646',
      xfbml      : true,
      version    : 'v2.0'
    });
  };
 */
 
 

 (function(d, s, id) {
   var js, fjs = d.getElementsByTagName(s)[0];
   if (d.getElementById(id)) return;
   js = d.createElement(s); js.id = id;
   js.src = "//connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v2.6&appId=626698044148646";
   fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));

 var nome;

function basicAPIRequest() {
    FB.api('/me', 
        {fields: "id,about,age_range,picture,bio,birthday,context,email,first_name,gender,hometown,link,location,middle_name,name,timezone,website,work"}, 
        function(response) {
          console.log('API response', response);
          //console.log(response);
         // $("#fb-profile-picture").append('<img src="' + response.picture.data.url + '"> ');
         /*  $("#nome").append(response.name);
          $("#userid").append(response.id);
          
          var iduser = response.id;
         
          var nome = response.name; */
          
          localStorage . setItem ('nome' ,response.name);
          localStorage . setItem ('id' ,response.id);

          teste();
          /* var replaced = name.replace(/ /g, ''); */
         
          /* $.post( "ServletLogar", { email: "teste", password: "teste" });
          window.location = 'http://localhost:8080/HurryBus/CRUD/ServletLogar'; */
          
          
          //refresh();
      /*    window.location = 'http://localhost:8080/HurryBus/CRUD/ServletLogar?email='+ replaced +'&password='+ iduser;  */
          
        //  window.location =  $.post("{MyAppContextRoot}"/ServletLogar,{ email: "teste", password: "teste" });
         // window.location = 'http://localhost:8080/HurryBus/CRUD/ServletLogar?email='+ replaced +'&password='+ iduser; 
         /*   $.post("ServletLogar", { nome: "leo"}, function(data) {    
        	   $("#resposta").html(data);   
			});   */
           
           
       	
           /* $.post( "ServletLogar", { email: "teste", password: "teste" },
  		function(data){
   	   alert(data);
   	
   	
   	load( 'localhost:8080/HurryBus/CRUD/ServletLogar' );
   	   
      }	   
           ); 
			
			$.post("{MyAppContextRoot}"/ServletLogar,{ email: "teste", password: "teste" },
	        		function(data){
	        	   alert(data);   
	           }	   
	           );
           
           
           $(document).ready(function() {                        
               $('#submit').click(function(event) {  
                   var username= response.name;
                $.get('ServletLogar',{user:username},function(responseText) { 
                       $('#welcometext').text(responseText);         
                   });
               });
           });*/

           /*   $.post("ServletLogar", { email : name, password : iduser },
                   function (data) {
                       $("#resposta").html(data);
                   }
                   , "html"); */
           
            	//'http://localhost:12962/Account/FacebookLogin/' + email + '/' + name; 
            //http://localhost:8080/HurryBus/CRUD/ServletLogar
            //'http://localhost:8080/HurryBus/CRUD/ServletLogar?email='+ email +'&password='+ name; 
            
         // document.getElementById("ramo").value = name;
          
       }
    );
  }
jQuery(document).ready(function(){
  jQuery("#fb").click(function(){
    
	  refresh();
	  /* if(typeof(FB) == "undefined") {
        alert("Facebook SDK not yet loaded please wait.") 
      }
    FB.getLoginStatus(function(response) {
      if (response.status === 'connected') {
        console.log('Logged in.');
        basicAPIRequest();

      }
      else {
        FB.login();
      }*/
    });      
  });

//});





</script>
<input id="abc" type="submit" onclick="checkLoginState" value="teste"/>
<!-- -->
<!-- 	<div id="fb-root"></div>
		<fb:login-button scope="public_profile,email" onlogin="checkLoginState() ";">
</fb:login-button> 

<div class="fb-login-button" data-max-rows="1" data-size="xlarge" data-show-faces="false" data-auto-logout-link="false"></div>
<div id='login'>
<img src="http://clapme.com.br/fb_login_bg.jpg" />
</div> -->

<div class="fb-login-button"  data-max-rows="1" data-size="xlarge"   data-show-faces="true" data-auto-logout-link="true"></div>


<form name="servlet" action="ServletLogar" method="get">
		aqui<div id="nome" name="nome"></div>

		aqui<div id="userid" name="userid"></div>
		
		
		
	<input id="ramo" name="nome2" placeholder="Nome2" "type="text"> 
	
		<input type="submit"  scope="public_profile,email" onlogin="checkLoginState()"  />
 </form>	
		
		
	
		
		
<!-- fb-profile-picture: <div id="fb-profile-picture"></div>
name: <div id="name"></div>
user-id: <div id="user-id"></div>
work: <div id="work"></div>
birthday: <div id="birthday"></div>
education: <div id="education"></div> 

<p>1) Click login</p>
<div  class="fb-login-button" data-scope="email,user_birthday,user_hometown,user_location,user_website,user_work_history,user_about_me
" data-max-rows="1" data-size="medium" data-show-faces="false" data-auto-logout-link="false"></div>

<p>2) Click load data</p>
<button id='load'>Load data</button>-->
</html>