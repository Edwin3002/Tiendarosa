package com.DAO.Tiendarosa;

import java.beans.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import com.DAO.Tiendarosa.Conexion;
import com.DTO.Tiendarosa.ClienteVO;

public class ClienteDAO {
	
	public ArrayList<ClienteVO>listaDeClientes(){
		ArrayList<ClienteVO> misClientes = new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				ClienteVO Cliente = new ClienteVO();
				Cliente.setId_usuario(res.getLong("id_usuario"));
				
				
				Cliente.setDireccion(res.getString("direccion"));
				Cliente.setTelefono(res.getString("telefono"));
				Cliente.setNombre(res.getString("nombre"));
				Cliente.setCorreo(res.getString("correo"));
				misClientes.add(Cliente);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misClientes;
}	
	
	
	
	
	
	
	public ArrayList<ClienteVO> buscarCliente(long id_usuario){
		ArrayList<ClienteVO> misClientes = new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				ClienteVO Cliente = new ClienteVO();
				
				Cliente.setId_usuario(res.getLong("id_usuario"));
				Cliente.setDireccion(res.getString("direccion"));
				Cliente.setTelefono(res.getString("telefono"));
				Cliente.setNombre(res.getString("nombre"));
				Cliente.setCorreo(res.getString("correo"));
				misClientes.add(Cliente);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misClientes;
	}
	
	public boolean existeCliente(long id_usuario) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo verificar si existe el cliente");
		}
		
		return existe;
	}

	public boolean crearCliente(ClienteVO Cliente) {
		boolean swCrear = false;
		if(!existeCliente(Cliente.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO clientes (id_usuario, direccion, telefono, nombre, correo) VALUES ("+
						Cliente.getId_usuario()+",'"+ Cliente.getDireccion()+"','"+Cliente.getTelefono()+"','"+ Cliente.getNombre()+"','"+Cliente.getCorreo()+"');";
				((java.sql.Statement)consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
				}catch(SQLException e) {
					System.out.println("No se pudo crear cliente");
				}
		}else {
			System.out.println("El cliente ya existe");
		}
		return swCrear;
	}
	
	public boolean borrarCliente(long id_usuario) {
		boolean swCrear = false;
		if(existeCliente(id_usuario)) {
			Conexion conex = new Conexion();
					try {
						Statement consulta = (Statement) conex.getConnection().createStatement();
						String SQL = "DELETE FROM clientes WHERE id_usuario = "+id_usuario; 
						/*((java.sql.Statement))*/ consulta.executeUpdate(SQL);
						/*((java.sql.Statement))*/consulta.close();
						conex.desconectar();
						swCrear = true;
						}catch(SQLException e) {
							System.out.println("No se pudo eliminar cliente");
						}
				}else {
					System.out.println("El cliente no existe");
				}
				return swCrear;
			}
	
	public boolean actualizarCliente(ClienteVO Cliente) {
		boolean swActualizar = false;
		if(existeCliente(Cliente.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="UPDATE clientes SET direccion='"+Cliente.getDireccion()+"',"+
				"telefono='"+Cliente.getTelefono()+"',"+
						"nombre='"+Cliente.getNombre()+"',"+
								"correo='"+Cliente.getCorreo()+"' WHERE id_usuario="+Cliente.getId_usuario();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				
				conex.desconectar();
				swActualizar = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo actualizar el cliente");
			}
		}else {
			System.out.println("El cliente no existe");
		}
		return swActualizar;
	}
}
	
	
