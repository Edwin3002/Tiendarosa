package com.u.Tiendarosa;

 import java.io.BufferedReader;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Arrays;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;
 import org.springframework.web.multipart.MultipartFile;
 import com.DAO.Tiendarosa.ArchivoDAO;
 import com.DTO.Tiendarosa.ArchivoVO;
 @RestController
 public class ArchivoController {
 @RequestMapping("/cargarArchivo")
 public String cargarArchivo(MultipartFile archivoCSV) {
	 File archivoNew;
	 String salida="";
	 FileReader fuente = null;
	 String linea="";
	 ArrayList<ArchivoVO> listado= new ArrayList<ArchivoVO>();
	 try {
		 archivoNew = deMultiPartAFile(archivoCSV);
		 fuente = new FileReader(archivoNew.getName());
		 BufferedReader archivo = new BufferedReader(fuente);
		 do {
			 linea = archivo.readLine();
			 if (linea!=null) {
				 String tmpLinea = linea.replace("\"","'");
				 ArrayList<String> miLista = new
						 ArrayList<String>(Arrays.asList(tmpLinea.split(",")));
				 ArchivoVO producto = new ArchivoVO();
				 producto.setId_usuario(Long.parseLong(miLista.get(0)));    
				 producto.setNombre(miLista.get(1).replace("'",""));
				 producto.setNitprove(miLista.get(2).replace("'",""));
				 producto.setPrecio(Integer.parseInt(miLista.get(3).replace("'","")));
				 producto.setIva(Integer.parseInt(miLista.get(4).replace("'","")));
				 producto.setVenta(Integer.parseInt(miLista.get(5).replace("'","")));
				 listado.add(producto);
			 }
		 }while (linea!=null);
		 archivo.close();
		 fuente.close();
		 boolean secreo= false;
		 for(ArchivoVO registro:listado) {
			 ArchivoDAO dao = new ArchivoDAO();
			 secreo = dao.registrarProducto2(registro);
			 salida = salida + "**"+secreo+"**" + registro.getId_usuario() + "---" +
					 registro.getNombre() + " ---"+
					 registro.getNitprove() + "---"+
					 registro.getPrecio() + "---" +
					 registro.getIva() + " ---"+
					 registro.getVenta() + "<br>";
		 }
		 salida = salida + " RTA: " + (secreo?"Ok":"No se pudo insertar el listado");
	 }catch(FileNotFoundException e) {
		 System.out.println(e.getMessage());
	 }catch(IOException e2) {
		 System.out.println(e2.getMessage());
	 }
	 return salida;
 	}

  	private File deMultiPartAFile(MultipartFile archivo) {
  		File convFile = new File(archivo.getOriginalFilename());
  		FileOutputStream salida;
  		try {
  			salida = new FileOutputStream(convFile);
  			salida.write(archivo.getBytes());
  			salida.close();
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return convFile;
  	}
 
 /**
 * recibe la peticion para el listado de clientes
 * @return
 */
  	@RequestMapping("/listaProductos")
  	public ArrayList<ArchivoVO> listaDeProductos2(){
  		ArchivoDAO dao = new ArchivoDAO();
  		ArrayList<ArchivoVO> listado = dao.listaDeProductos2();
  		return listado; 
  	}
 /*
 * Peticion para buscar un cliente por su ID
 * @param id
 * @return
 */
 } 