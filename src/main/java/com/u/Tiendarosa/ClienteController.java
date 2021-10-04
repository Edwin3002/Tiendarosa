 package com.u.Tiendarosa;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tiendarosa.ClienteDAO;
import com.DTO.Tiendarosa.ClienteVO;

@RestController
public class ClienteController {

	
	
	
	@RequestMapping("/listaclientes")
	public ArrayList<ClienteVO> listaDeClientes(){
		ClienteDAO dao = new ClienteDAO();
		
		return dao.listaDeClientes();
	}
	
	
	
	
	
	
	@RequestMapping("/buscarclienteID")
	public ArrayList<ClienteVO> buscarCliente(String id_usuario){ 
		ClienteDAO dao = new ClienteDAO();
		return dao.buscarCliente(Long.parseLong(id_usuario));
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/crearcliente")
	public boolean crearCliente(String id_usuario, String direccion, String telefono, String nombre, String correo){
		ClienteDAO dao = new ClienteDAO();
		ClienteVO Cliente = new ClienteVO();
	
		Cliente.setId_usuario(Long.parseLong(id_usuario));
		Cliente.setDireccion(direccion);
		Cliente.setTelefono(telefono);
		Cliente.setNombre(nombre);
		Cliente.setCorreo(correo);
		
		
		return dao.crearCliente(Cliente);
	}
	
	
	
	
	
	
	@RequestMapping("/borrarcliente")
	public boolean borrarCliente(String id_usuario) {
		ClienteDAO dao = new ClienteDAO();
		return dao.borrarCliente(Long.parseLong(id_usuario));
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/actualizarcliente")
	public boolean actualizarCliente(String id_usuario, String direccion, String telefono, String nombre, String correo) {
		ClienteDAO dao = new ClienteDAO();
		ClienteVO Cliente = new ClienteVO();
			
		Cliente.setId_usuario(Long.parseLong(id_usuario));
		Cliente.setDireccion(direccion);
		Cliente.setTelefono(telefono);
		Cliente.setNombre(nombre);
		Cliente.setCorreo(correo);
			
		return dao.actualizarCliente(Cliente);
	}
	
}
