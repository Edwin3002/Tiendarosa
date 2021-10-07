$(document).ready(function(){

	$("#listarU").click(function(){
        $.get("http://localhost:8080/listaproveedores",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<br><table border='1' class='table table-striped'>";
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
                $("#mensaje").html("<br><div class='alert alert-danger' role='alert'>El cliente No encontrado </div>");
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
                $("#mensaje").html("<br><div class='alert alert-primary' role='alert'>El proveedor fue creado </div>");
            }else{
                $("#mensaje").html("<br><div class='alert alert-danger' role='alert'>No se puede crear, ya existe</div>");
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
               $("#mensaje").html("<br><div class='alert alert-primary' role='alert'>El proveedor fue actualizado </div>");
            }else{
                $("#mensaje").html("<br><div class='alert alert-danger' role='alert'>No se pudo actualizar, no existe </div>");
            }
        });
    });

    $("#eliminarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/borrarproveedor",{id_usuario: elid},function(data, status){
            if(data==true){
                $("#mensaje").html("<br><div class='alert alert-primary' role='alert'>El proveedor fue eliminado </div>");
            }else{
                $("#mensaje").html("<br><div class='alert alert-danger' role='alert'>No se pudo borrar, no existe </div>");
            }
        });
    });
});
