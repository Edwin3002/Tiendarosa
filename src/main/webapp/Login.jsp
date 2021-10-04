<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>Iniciar sesión</title>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="login.js"></script>
<link rel="stylesheet" type="text/css" href="estiloLogin.css">
</head>
<body>
	<div id="contenedor">
        
		<form name="formularioLogin">
	            <img src="PROYECTO.png" width="350px"><br><br>
				<label>Usuario:</label>
				<input Id="usuario" type="text" class="campo" placeholder="Usuario" value="" required><br><br>
				<label>Clave:</label>
				<input Id="clave" type="password" class="campo" placeholder="Clave" value="" required	><br><br>
				<input type="button" class="boton" value="Enviar" id="btn_Enviaru"><br><br>
					
		</form>
	</div>
	<br>
    <br>
    <!-- permite mostrar los datos del JSON -->
    <div id="salida">
    
   </div>
</body>
</html>