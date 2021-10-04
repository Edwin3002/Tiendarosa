package com.DAO.Tiendarosa;

import java.beans.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import com.DAO.Tiendarosa.Conexion;
import com.DTO.Tiendarosa.ProveedorVO;

public class ProveedorDAO {
	
	public ArrayList<ProveedorVO>listaDeProveedores(){
		ArrayList<ProveedorVO> misProveedores = new ArrayList<ProveedorVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				ProveedorVO Proveedor = new ProveedorVO();
				Proveedor.setId_usuario(res.getLong("id_usuario"));
				Proveedor.setNombre(res.getString("nombre"));
				Proveedor.setCiudad(res.getString("ciudad"));
				Proveedor.setDireccion(res.getString("direccion"));
				Proveedor.setTelefono(res.getString("telefono"));
				
				misProveedores.add(Proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misProveedores;
}	
	
	
	
	
	
	
	public ArrayList<ProveedorVO> buscarProveedor(long id_usuario){
		ArrayList<ProveedorVO> misProveedores = new ArrayList<ProveedorVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				ProveedorVO Proveedor = new ProveedorVO();
				
				Proveedor.setId_usuario(res.getLong("id_usuario"));
				Proveedor.setNombre(res.getString("nombre"));
				Proveedor.setCiudad(res.getString("ciudad"));
				Proveedor.setDireccion(res.getString("direccion"));
				Proveedor.setTelefono(res.getString("telefono"));
				
				misProveedores.add(Proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misProveedores;
	}
	
	public boolean existeProveedor(long id_usuario) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo verificar si existe el Proveedor");
		}
		
		return existe;
	}

	public boolean crearProveedor(ProveedorVO Proveedor) {
		boolean swCrear = false;
		if(!existeProveedor(Proveedor.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO proveedores (id_usuario, nombre, ciudad, direccion, telefono) VALUES ("+
						Proveedor.getId_usuario()+",'"+ Proveedor.getNombre()+"','"+Proveedor.getCiudad()+"','"+ Proveedor.getDireccion()+"','"+Proveedor.getTelefono()+"');";
				((java.sql.Statement)consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
				}catch(SQLException e) {
					System.out.println("No se pudo crear proveedor");
				}
		}else {
			System.out.println("El proveedor ya existe");
		}
		return swCrear;
	}
	
	public boolean borrarProveedor(long id_usuario) {
		boolean swCrear = false;
		if(existeProveedor(id_usuario)) {
			Conexion conex = new Conexion();
					try {
						Statement consulta = (Statement) conex.getConnection().createStatement();
						String SQL = "DELETE FROM proveedores WHERE id_usuario = "+id_usuario; 
						/*((java.sql.Statement))*/ consulta.executeUpdate(SQL);
						/*((java.sql.Statement))*/consulta.close();
						conex.desconectar();
						swCrear = true;
						}catch(SQLException e) {
							System.out.println("No se pudo eliminar proveedor");
						}
				}else {
					System.out.println("El proveedor no existe");
				}
				return swCrear;
			}
	
	public boolean actualizarProveedor(ProveedorVO Proveedor) {
		boolean swActualizar = false;
		if(existeProveedor(Proveedor.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="UPDATE proveedores SET nombre='"+Proveedor.getNombre()+"',"+
				"ciudad='"+Proveedor.getCiudad()+"',"+
						"direccion='"+Proveedor.getDireccion()+"',"+
								"telefono='"+Proveedor.getTelefono()+"' WHERE id_usuario="+Proveedor.getId_usuario();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				
				conex.desconectar();
				swActualizar = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo actualizar el proveedor");
			}
		}else {
			System.out.println("El proveedor no existe");
		}
		return swActualizar;
	}
}
	
	

