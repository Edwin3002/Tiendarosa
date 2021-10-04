$(document).ready(function(){

	$("#listarU").click(function(){
        $.get("http://localhost:8080/listaclientes",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<table border='1'>";
                salida = salida + "<tr><th>CEDU</th><th>NOMBRE</th><th>CORREO</th><th>DIRECCION</th><th>TELEFONO</th></tr>";
                for(let i=0;i<longitud;i++){
                    salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].id_usuario+"</td>";
                   
					salida = salida + "<td>"+data[i].nombre+"</td>";
					salida = salida + "<td>"+data[i].correo+"</td>";
					salida = salida + "<td>"+data[i].direccion+"</td>";
                    salida = salida + "<td>"+data[i].telefono+"</td>";
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
                $("#direccion").val(data[0].direccion);
                $("#telefono").val(data[0].telefono);
				$("#nombre").val(data[0].nombre); 
				$("#correo").val(data[0].correo);                    
            }else{
                $("#mensaje").html("<b style='color:red;'>cliente NO ENCONTRADO !!!</b>");
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
                $("#mensaje").html(" El cliente fue creado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se puedo crear, ya existe!!!</b>");
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
                $("#mensaje").html(" El cliente fue actualizado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo actualizar, NO existe!!!</b>");
            }
        });
    });

    $("#eliminarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/borrarcliente",{id_usuario: elid},function(data, status){
            if(data==true){
                $("#mensaje").html(" El cliente fue eliminado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo eliminar, NO existe!!!</b>");
            }
        });
    });
});
