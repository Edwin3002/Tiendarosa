$(document).ready(function(){

	$("#listarU").click(function(){
        $.get("http://localhost:8080/listausuarios",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<br><table>";
                salida = salida + "<tr><th colspan='5'>TABLA DE USUARIOS</th></tr><tr><td>CEDULA</td><td>NOMBRE</td><td>CORREO</td><td>USUARIO</td><td>CLAVE</td></tr>";
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
                              $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  Usuario no encontrado</div>");
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
                $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  El usuario fue actualizado</div>");
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo crear, ya existe</div>");
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
                $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  El usuario fue actualizado</div>");
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo actualizar, no existe</div>");
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
                 $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  El usuario fue eliminado</div>");
            }else{
                $("#mensaje").html("<div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo borrar, no existe</div>");
            }
        });
    });
});