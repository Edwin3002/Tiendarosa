$(document).ready(function(){
    
    
                  $("#btn_Enviaru").click(function(){//El evento callback no tiene cuerpo solo se ejecuta en el momento
                      let elUsuario = document.getElementById("usuario").value;//cada control de la pagina tiene un Id
                      let laClave = document.getElementById("clave").value;        
                   
                     $.post("http://localhost:8080/loginusuario2",{ usuario: elUsuario, clave: laClave },
                    function(data, status){
	
					
		
						if (data.existe==true){
						alert("Bienvenido a la tienda " + elUsuario);
						window.location.href = "login2.html";
						
						
						}
						else{
						alert("No existe este usuario");
						window.location.href = "Login.jsp";
						
						/*if (elUsuario !=null & laClave !=null){
						alert("Faltan datos por llenar");
						window.location.href = "Login.jsp";
						}
						else {
						alert("Bienvenido a la tienda " + elUsuario);
						window.location.href = "login2.html"*/
						
						
						
					}
					});
				});
				function mostrarUno(item, index){
					let valores = Object.values(item);
					$("#usuario").val(valores[0]);
					$("#clave").val(valores[1]);
				}
				
			});
                        
                       /* if(status="success"){
                let longitud = data.length;
                let salida="<table class='w3-table-all w3-hoverable w3-card-2'>";
                salida=salida+"<tr><th>USUARIO</th></tr>";            
                for(let i=0;i<longitud;i++){
                    //alert(data[i].elusuario);
                    salida=salida+"<tr><td>"+data[i].usuario+"</td><td>";
                }
                salida=salida+"</table>";
                $("#salida").html(salida);
            }
                });
              });        
          });         */   

