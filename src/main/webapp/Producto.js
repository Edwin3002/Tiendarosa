$(document).ready(function(){

	$("#listarU").click(function(){
        $.get("http://localhost:8080/listaproductos",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<br><table>";
                salida = salida + "<tr><th colspan='6'>TABLA DE PRODUCTOS</th></tr><tr><td>ID</td><td>NOMBRE</td><td>NITPROVE</td><td>PRECIO</td><td>IVA</td><td>VENTA</td></tr>";
                for(let i=0;i<longitud;i++){
                    salida = salida + "<tr>";
                    salida = salida + "<td>"+data[i].id_usuario+"</td>";
                   
					salida = salida + "<td>"+data[i].nombre+"</td>";
					salida = salida + "<td>"+data[i].nitprove+"</td>";
					salida = salida + "<td>"+data[i].precio+"</td>";
                    salida = salida + "<td>"+data[i].iva+"</td>";
					salida = salida + "<td>"+data[i].venta+"</td>";
					salida = salida + "</tr>";
                }
                salida = salida +"</table>";
                $("#mensaje").html(salida);
            }
        });
    });
		

    $("#buscarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/buscarproductoID",{id_usuario: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#id").val(data[0].id_usuario);
                $("#nombre").val(data[0].nombre);
                $("#nitprove").val(data[0].nitprove);
				$("#precio").val(data[0].precio); 
				$("#iva").val(data[0].iva);    
				$("#venta").val(data[0].venta);                  
            }else{
               $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  producto no encontrado</div>");
            }                  
        });
    });


	$("#agregarU").click(function(){
        let elid = $("#id").val();
		let elnombre = $("#nombre").val();
        let elnitprove = $("#nitprove").val();
        let elprecio = $("#precio").val();
		
		let eliva = $("#iva").val();
		let laventa = $("#venta").val();
		
        $.post("http://localhost:8080/crearproducto",{id_usuario: elid, nombre: elnombre, nitprove: elnitprove, precio: elprecio, iva: eliva, venta: laventa},function(data, status){
            if(data==true){
               $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  El producto fue creado</div>");
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo crear, ya existe</div>");
         }
        });
    });
    
    
     $("#actualizarU").click(function(){
        let elid = $("#id").val();
		let elnombre = $("#nombre").val();
        let elnitprove = $("#nitprove").val();
        let elprecio = $("#precio").val();
		
		let eliva = $("#iva").val();
		let laventa = $("#venta").val();

        $.post("http://localhost:8080/actualizarproducto",{id_usuario: elid, nombre: elnombre, nitprove: elnitprove, precio: elprecio, iva: eliva, venta: laventa},function(data, status){
            if(data==true){
                $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  El producto fue actualizado</div>");
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo actualizar, no existe</div>");
            }
        });
    });

    $("#eliminarU").click(function(){
        let elid = $("#id").val();
        $.post("http://localhost:8080/borrarproducto",{id_usuario: elid},function(data, status){
            if(data==true){
                $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  El producto fue eliminado</div>");
            }else{
                $("#mensaje").html("<div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo borrar, no existe</div>");
            }
        });
    });
});
/**
 * 
 */ 