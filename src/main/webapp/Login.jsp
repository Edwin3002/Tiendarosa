<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>Iniciar sesión</title>
<script src="https://kit.fontawesome.com/38890b9b7f.js" crossorigin="anonymous"></script>	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="login.js"></script>
<link rel="stylesheet" type="text/css" href="estiloLogin.css">
</head>
<body>
	<div class="c2">
        <div class="contene">
            <form action="">
                <i class="far fa-user"></i>
                <h1>Login in</h1>
                <p>Tienda series <span>X</span></p>
                <input id="usuario" type="text" placeholder="Usuario"><br>

                <input id="clave" type="password" placeholder="Contraseña"><br>
                <input type="button" class="boton" value="Iniciar sesion" id="btn_Enviaru"><br>
            </form>
        </div>
    </div>
    <br>
    <br>
    <!-- permite mostrar los datos del JSON -->
    <div id="salida">
</body>
</html>