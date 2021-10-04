 package com.u.Tiendarosa;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tiendarosa.UsuarioDAO;
import com.DTO.Tiendarosa.UsuarioVO;

@RestController
public class UsuarioController {

	
	
	
	@RequestMapping("/listausuarios")
	public ArrayList<UsuarioVO> listaDeUsuarios(){
		UsuarioDAO dao = new UsuarioDAO();
		
		return dao.listaDeUsuarios();
	}
	
	
	
	
	
	
	@RequestMapping("/buscarusuarioID")
	public ArrayList<UsuarioVO> buscarUsuario(String id_usuario){ 
		UsuarioDAO dao = new UsuarioDAO();
		return dao.buscarUsuario(Long.parseLong(id_usuario));
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/crearusuario")
	public boolean crearUsuario(String id_usuario, String usuario, String clave, String nombre, String correo){
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO Usuario = new UsuarioVO();
	
		Usuario.setId_usuario(Long.parseLong(id_usuario));
		Usuario.setUsuario(usuario);
		Usuario.setClave(clave);
		Usuario.setNombre(nombre);
		Usuario.setCorreo(correo);
		
		
		return dao.crearUsuario(Usuario);
	}
	
	
	
	
	
	
	@RequestMapping("/borrarusuario")
	public boolean borrarUsuario(String id_usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.borrarUsuario(Long.parseLong(id_usuario));
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/actualizarusuario")
	public boolean actualizarUsuario(String id_usuario, String usuario, String clave, String nombre, String correo) {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO Usuario = new UsuarioVO();
			
		Usuario.setId_usuario(Long.parseLong(id_usuario));
		Usuario.setUsuario(usuario);
		Usuario.setClave(clave);
		Usuario.setNombre(nombre);
		Usuario.setCorreo(correo);
			
		return dao.actualizarUsuario(Usuario);
	}
	
}
