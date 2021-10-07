$(document).ready(function(){

	$("#listarU").click(function(){
        $.get("http://localhost:8080/listausuarios",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<br><table border='1' class='table table-striped'>";
                salida = salida + "<tr><th>CEDU</th><th>NOMBRE</th><th>CORREO</th><th>USUARIO</th><th>CLAVE</th></tr>";
                for(let i=0;i<longitud;i++){
                    salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].id_usuario+"</td>";
                    
					salida = salida + "<td>"+data[i].nombre+"</td>";
					salida = salida + "<td>"+data[i].correo+"</td>";
					salida = salida + "<td>"+data[i].usuario+"</td>";
                    salida = salida + "<td>"+data[i].clave+"</td>";
                    salida = salida + "</tr>";
                }
                salida = salida +"</table>";
                $("#mensaje").html(salida);
            }
        });
    });
		

    $("#buscarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/buscarusuarioID",{id_usuario: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id").val(data[0].id_usuario);
                
				$("#nombre").val(data[0].nombre); 
				$("#correo").val(data[0].correo);
				$("#usuario").val(data[0].usuario);
                $("#clave").val(data[0].clave);                    
            }else{
                $("#mensaje").html("<br><div class='alert alert-danger' role='alert'>El cliente No encontrado </div>");
            }                  
        });
    });


    $("#agregarU").click(function(){
        let elid = $("#id").val();
        
		let elnombre = $("#nombre").val();
		let elcorreo = $("#correo").val();
		let elusuario = $("#usuario").val();
        let laclave = $("#clave").val();
        $.post("http://localhost:8080/crearusuario",{id_usuario: elid, nombre: elnombre, correo: elcorreo, usuario: elusuario, clave: laclave},function(data, status){
            if(data==true){
                $("#mensaje").html("<br><div class='alert alert-primary' role='alert'>El usuario fue creado </div>");
            }else{
                $("#mensaje").html("<br><div class='alert alert-danger' role='alert'>No se puede crear, ya existe</div>");
            }
        });
    });
    
    
     $("#actualizarU").click(function(){
        let elid = $("#id").val();
        
		let elnombre = $("#nombre").val();
		let elcorreo = $("#correo").val();
		let elusuario = $("#usuario").val();
        let laclave = $("#clave").val();
        $.post("http://localhost:8080/actualizarusuario",{id_usuario: elid, nombre: elnombre, correo: elcorreo, usuario: elusuario, clave: laclave},function(data, status){
            if(data==true){
                $("#mensaje").html("<br><div class='alert alert-primary' role='alert'>El usuario fue actualizado </div>");
            }else{
                $("#mensaje").html("<br><div class='alert alert-danger' role='alert'>No se pudo actualizar, no existe </div>");
            }
        });
    });
/*@RequestMapping("/borrarusuario")
	public boolean borrarUsuario(String id_usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.borrarUsuario(Long.parseLong(id_usuario));
	}*/

    $("#eliminarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/borrarusuario",{id_usuario: elid},function(data, status){
            if(data==true){
                $("#mensaje").html("<br><div class='alert alert-primary' role='alert'>El usuario fue eliminado </div>");
            }else{
                $("#mensaje").html("<br><div class='alert alert-danger' role='alert'>No se pudo borrar, no existe </div>");
            }
        });
    });
});