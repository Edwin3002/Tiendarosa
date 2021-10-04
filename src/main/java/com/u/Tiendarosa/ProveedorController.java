package com.u.Tiendarosa;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tiendarosa.ProveedorDAO;
import com.DTO.Tiendarosa.ProveedorVO;

@RestController
public class ProveedorController {

	
	
	
	@RequestMapping("/listaproveedores")
	public ArrayList<ProveedorVO> listaDeProveedores(){
		ProveedorDAO dao = new ProveedorDAO();
		
		return dao.listaDeProveedores();
	}
	
	
	
	
	
	
	@RequestMapping("/buscarproveedorID")
	public ArrayList<ProveedorVO> buscarProveedor(String id_usuario){ 
		ProveedorDAO dao = new ProveedorDAO();
		return dao.buscarProveedor(Long.parseLong(id_usuario));
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/crearproveedor")
	public boolean crearProveedor(String id_usuario, String nombre, String ciudad, String direccion, String telefono){
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO Proveedor = new ProveedorVO();
	
		Proveedor.setId_usuario(Long.parseLong(id_usuario));
		Proveedor.setNombre(nombre);
		Proveedor.setCiudad(ciudad);
		Proveedor.setDireccion(direccion);
		Proveedor.setTelefono(telefono);
		
		
		
		return dao.crearProveedor(Proveedor);
	}
	
	
	
	
	
	
	@RequestMapping("/borrarproveedor")
	public boolean borrarProveedor(String id_usuario) {
		ProveedorDAO dao = new ProveedorDAO();
		return dao.borrarProveedor(Long.parseLong(id_usuario));
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/actualizarproveedor")
	public boolean actualizarProveedor(String id_usuario, String nombre, String ciudad, String direccion, String telefono) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO Proveedor = new ProveedorVO();
			
		Proveedor.setId_usuario(Long.parseLong(id_usuario));
		Proveedor.setNombre(nombre);
		Proveedor.setCiudad(ciudad);
		Proveedor.setDireccion(direccion);
		Proveedor.setTelefono(telefono);
			
		return dao.actualizarProveedor(Proveedor);
	}
	
}
