$(document).ready(function(){

	$("#listarU").click(function(){
        $.get("http://localhost:8080/listaclientes",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<br><div class=conten><table>";
                salida = salida + "<tr><th colspan='5'>TABLA DE CLIENTES</th></tr><td>CEDULA</td><td>NOMBRE</td><td>CORREO</td><td>DIRECCION</td><td>TELEFONO</td></tr>";
                for(let i=0;i<longitud;i++){
                    salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].id_usuario+"</td>";
                   
					salida = salida + "<td>"+data[i].nombre+"</td>";
					salida = salida + "<td>"+data[i].correo+"</td>";
					salida = salida + "<td>"+data[i].direccion+"</td>";
                    salida = salida + "<td>"+data[i].telefono+"</td>";
					salida = salida + "</tr></div>";
                }
                salida = salida +"</table>";
                $("#mensaje").html(salida);
            }
        });
    });
		

    $("#buscarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/buscarclienteID",{id_usuario: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id").val(data[0].id_usuario);

				$("#nombre").val(data[0].nombre); 
				$("#correo").val(data[0].correo);
				$("#direccion").val(data[0].direccion);
                $("#telefono").val(data[0].telefono);  

                   
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  Cliente no encontrado</div>");
            }                  
        });
    });


	$("#agregarU").click(function(){
        let elid = $("#id").val();
        let ladireccion = $("#direccion").val();
        let eltelefono = $("#telefono").val();
		let elnombre = $("#nombre").val();
		let elcorreo = $("#correo").val();
		
        $.post("http://localhost:8080/crearcliente",{id_usuario: elid, direccion: ladireccion, telefono: eltelefono, nombre: elnombre, correo: elcorreo},function(data, status){
            if(data==true){
				
                $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  El cliente fue actualizado</div>");
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo crear, ya existe</div>");
        
    
			}
        });
    });
    
    
     $("#actualizarU").click(function(){
        let elid = $("#id").val();
        let ladireccion = $("#direccion").val();	
        let eltelefono = $("#telefono").val();
		let elnombre = $("#nombre").val();
		let elcorreo = $("#correo").val();

        $.post("http://localhost:8080/actualizarcliente",{id_usuario: elid, direccion: ladireccion, telefono: eltelefono, nombre: elnombre, correo: elcorreo},function(data, status){
            if(data==true){
                $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  El cliente fue actualizado</div>");
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo actualizar, no existe</div>");
            }
        });
    });

    $("#eliminarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/borrarcliente",{id_usuario: elid},function(data, status){
            if(data==true){
                $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  El cliente fue eliminado</div>");
            }else{
                $("#mensaje").html("<div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo borrar, no existe</div>");
            }
        });
    });
});
