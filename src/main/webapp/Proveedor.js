$(document).ready(function(){

	$("#listarU").click(function(){
        $.get("http://localhost:8080/listaproveedores",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<table border='1'>";
                salida = salida + "<tr><th>NIT</th><th>NOMBRE</th><th>CIUDAD</th><th>DIRECCION</th><th>TELEFONO</th></tr>";
                for(let i=0;i<longitud;i++){
                    salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].id_usuario+"</td>";
                   
					salida = salida + "<td>"+data[i].nombre+"</td>";
					salida = salida + "<td>"+data[i].ciudad+"</td>";
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
        $.post("http://localhost:8080/buscarproveedorID",{id_usuario: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id").val(data[0].id_usuario);
				$("#nombre").val(data[0].nombre); 
				$("#ciudad").val(data[0].ciudad); 
                $("#direccion").val(data[0].direccion);
                $("#telefono").val(data[0].telefono);
				                   
            }else{
                $("#mensaje").html("<b style='color:red;'>proveedor NO ENCONTRADO !!!</b>");
            }                  
        });
    });


	$("#agregarU").click(function(){
        let elid = $("#id").val();
		let elnombre = $("#nombre").val();
		let laciudad = $("#ciudad").val();
        let ladireccion = $("#direccion").val();
        let eltelefono = $("#telefono").val();
		
		
        $.post("http://localhost:8080/crearproveedor",{id_usuario: elid, nombre: elnombre, ciudad: laciudad, direccion: ladireccion, telefono: eltelefono,},function(data, status){
            if(data==true){
                $("#mensaje").html(" El proveedor fue creado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se puedo crear, ya existe!!!</b>");
            }
        });
    });
    
    
     $("#actualizarU").click(function(){
        let elid = $("#id").val();
		let elnombre = $("#nombre").val();
		let laciudad = $("#ciudad").val();
        let ladireccion = $("#direccion").val();
        let eltelefono = $("#telefono").val();

        $.post("http://localhost:8080/actualizarproveedor",{id_usuario: elid, nombre: elnombre, ciudad: laciudad, direccion: ladireccion, telefono: eltelefono,},function(data, status){
            if(data==true){
                $("#mensaje").html(" El proveedor fue actualizado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo actualizar, NO existe!!!</b>");
            }
        });
    });

    $("#eliminarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/borrarproveedor",{id_usuario: elid},function(data, status){
            if(data==true){
                $("#mensaje").html(" El proveedor fue eliminado .");
            }else{
                $("#mensaje").html("<b style='color:red;'>No se pudo eliminar, NO existe!!!</b>");
            }
        });
    });
});
