$(document).ready(function(){

 $("#buscarC").click(function(){
        let elid = $("#idC").val();
        $.post("http://localhost:8080/buscarclienteID",{id_usuario: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#idC").val(data[0].id_usuario);

				$("#nombreC").val(data[0].nombre); 
                   
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  Cliente no encontrado</div>");
            }                  
        });
    });



	$("#listarC").click(function(){
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
					salida = salida + "</tr>";
                }
                salida = salida +"</table>";
                $("#mensaje").html(salida);
            }
        });
    });






$("#buscarP").click(function(){
        let elid = $("#codigoP").val();
        $.post("http://localhost:8080/buscarproductoID",{id_usuario: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#codigoP").val(data[0].id_usuario);
                $("#nombreP").val(data[0].nombre);
				$("#precioP").val(data[0].precio); 
				}else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  producto no encontrado</div>");
            }                  
        });
    });

$("#agregarV").click(function(){
        let elid = $("#idC").val();
		let elnombre = $("#nombreC").val();
		let eltotaliva= $("#totalivaP").val();
		
        $.post("http://localhost:8080/crearventa",{id_usuario: elid, nombre: elnombre,totaliva: eltotaliva},function(data, status){
            if(data==true){
               $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  La venta fue creada</div>");
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo crear, ya existe</div>");
         }
        });
    });

$("#agregarV").click(function(){
        let elid = $("#idC").val();
		let elnombre = $("#nombreC").val();
		let eltotaliva= $("#totalivaP2").val();
		
        $.post("http://localhost:8080/crearventa",{id_usuario: elid, nombre: elnombre,totaliva: eltotaliva},function(data, status){
            if(data==true){
               $("#mensaje").html("<br><div class='alertv'><i class='fas fa-check-circle'></i>  La venta fue creada</div>");
            }else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  No se pudo crear, ya existe</div>");
         }
        });
    });








$("#listarP").click(function(){
        $.get("http://localhost:8080/listaproductos",function(data, status){
            if(status=="success"){
                let longitud = data.length;
                let salida ="<br><table>";
                salida = salida + "<tr><th colspan='6'>TABLA DE PRODUCTOS</th></tr><tr><td>CODIGO</td><td>NOMBRE</td><td>NIT PROVEEDOR</td><td>PRECIO</td><td>IVA</td><td>VENTA</td></tr>";
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


//**************************2*************************************


$("#buscarP").click(function(){
        let elid = $("#codigoP2").val();
        $.post("http://localhost:8080/buscarproductoID",{id_usuario: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#codigoP2").val(data[0].id_usuario);
                $("#nombreP2").val(data[0].nombre);
				$("#precioP2").val(data[0].precio); 
				}else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  producto 2 no encontrado</div>");
            }                  
        });
    });

//**************************3*************************************


$("#buscarP").click(function(){
        let elid = $("#codigoP3").val();
        $.post("http://localhost:8080/buscarproductoID",{id_usuario: elid},function(data, status){
            let longitud = data.length;
            if(longitud>0){
                $("#codigoP3").val(data[0].id_usuario);
                $("#nombreP3").val(data[0].nombre);
				$("#precioP3").val(data[0].precio); 
				}else{
                $("#mensaje").html("<br><div class='alertf'><i class='fas fa-exclamation-triangle'></i>  producto 3 no encontrado</div>");
            }                  
        });
    });
});
