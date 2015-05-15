<html>
<head>
<link rel="stylesheet" href="css/wro.css"/>
</head>
<body>
<#if RequestParameters['error']??>
	<div class="alert alert-danger">
		Ha habido un inconveniente con su acceso. Por favor, int&eacute;ntelo de nuevo.
	</div>
</#if>
	<div class="container">
		<form role="form" action="login" method="post">
		  <div class="form-group">
		    <label for="username">Usuario:</label>
		    <input type="text" class="form-control" id="username" name="username"/>
		  </div>
		  <div class="form-group">
		    <label for="password">Contraseña:</label>
		    <input type="password" class="form-control" id="password" name="password"/>
		  </div>
		  <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		  <button type="submit" class="btn btn-primary">Entrar</button>
		</form>
	</div>
	<script src="js/wro.js" type="text/javascript"></script>
</body>
</html>