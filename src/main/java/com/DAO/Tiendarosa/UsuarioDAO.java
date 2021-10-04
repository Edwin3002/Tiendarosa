package com.DAO.Tiendarosa;

import java.beans.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import com.DAO.Tiendarosa.Conexion;
import com.DTO.Tiendarosa.UsuarioVO;

public class UsuarioDAO {
	
	public ArrayList<UsuarioVO>listaDeUsuarios(){
		ArrayList<UsuarioVO> misUsuarios = new ArrayList<UsuarioVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				UsuarioVO Usuario = new UsuarioVO();
				Usuario.setId_usuario(res.getLong("id_usuario"));
				
				
				Usuario.setUsuario(res.getString("usuario"));
				Usuario.setClave(res.getString("clave"));
				Usuario.setNombre(res.getString("nombre"));
				Usuario.setCorreo(res.getString("correo"));
				misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misUsuarios;
	}	
	
	
	
	
	
	
	public ArrayList<UsuarioVO> buscarUsuario(long id_usuario){
		ArrayList<UsuarioVO> misUsuarios = new ArrayList<UsuarioVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				UsuarioVO Usuario = new UsuarioVO();
				
				Usuario.setId_usuario(res.getLong("id_usuario"));
				Usuario.setUsuario(res.getString("usuario"));
				Usuario.setClave(res.getString("clave"));
				Usuario.setNombre(res.getString("nombre"));
				Usuario.setCorreo(res.getString("correo"));
				misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misUsuarios;
	}
	
	public boolean existeUsuario(long id_usuario) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo verificar si existe el usuario");
		}
		
		return existe;
	}

	public boolean crearUsuario(UsuarioVO Usuario) {
		boolean swCrear = false;
		if(!existeUsuario(Usuario.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO usuarios (id_usuario, usuario, clave, nombre, correo) VALUES ("+
						Usuario.getId_usuario()+",'"+ Usuario.getUsuario()+"','"+Usuario.getClave()+"','"+ Usuario.getNombre()+"','"+Usuario.getCorreo()+"');";
				((java.sql.Statement)consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
				}catch(SQLException e) {
					System.out.println("No se pudo crear usuario");
				}
		}else {
			System.out.println("El usuario ya existe");
		}
		return swCrear;
	}
	
	public boolean borrarUsuario(long id_usuario) {
		boolean swCrear = false;
		if(existeUsuario(id_usuario)) {
			Conexion conex = new Conexion();
					try {
						Statement consulta = (Statement) conex.getConnection().createStatement();
						String SQL = "DELETE FROM usuarios WHERE id_usuario = "+id_usuario; 
						/*((java.sql.Statement))*/ consulta.executeUpdate(SQL);
						/*((java.sql.Statement))*/consulta.close();
						conex.desconectar();
						swCrear = true;
						}catch(SQLException e) {
							System.out.println("No se pudo eliminar usuario");
						}
				}else {
					System.out.println("El usuario no existe");
				}
				return swCrear;
			}
	
	public boolean actualizarUsuario(UsuarioVO Usuario) {
		boolean swActualizar = false;
		if(existeUsuario(Usuario.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="UPDATE usuarios SET usuario='"+Usuario.getUsuario()+"',"+
				"clave='"+Usuario.getClave()+"',"+
						"nombre='"+Usuario.getNombre()+"',"+
								"correo='"+Usuario.getCorreo()+"' WHERE id_usuario="+Usuario.getId_usuario();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				
				conex.desconectar();
				swActualizar = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo actualizar el usuario");
			}
		}else {
			System.out.println("El usuario no existe");
		}
		return swActualizar;
	}
}
