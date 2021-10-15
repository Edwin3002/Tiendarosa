package com.DAO.Tiendarosa;

import java.beans.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import com.DAO.Tiendarosa.Conexion;
import com.DTO.Tiendarosa.VentaVO;

public class VentaDAO {
	
	public ArrayList<VentaVO>listaDeVentas(){
		ArrayList<VentaVO> misVentas = new ArrayList<VentaVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				VentaVO venta = new VentaVO();
				venta.setId_usuario(res.getLong("id_usuario"));
				venta.setNombre(res.getString("nombre"));
				venta.setTotaliva(res.getInt("totaliva"));
				misVentas.add(venta);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misVentas;
}	
	
	
	
	
	
	
	public ArrayList<VentaVO> buscarVenta(long id_usuario){
		ArrayList<VentaVO> misVentas = new ArrayList<VentaVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				VentaVO venta = new VentaVO();
				
				venta.setId_usuario(res.getLong("id_usuario"));
				venta.setNombre(res.getString("nombre"));
				venta.setTotaliva(res.getInt("totaliva"));
				misVentas.add(venta);;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misVentas;
	}
	
	public boolean existeVenta(long id_usuario) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo verificar si existe la venta");
		}
		
		return existe;
	}

	public boolean crearVenta(VentaVO Venta) {
		boolean swCrear = false;
		if(!existeVenta(Venta.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO ventas (id_usuario,nombre,totaliva) VALUES ("+
						Venta.getId_usuario()+",'"+ Venta.getNombre()+"','"+Venta.getTotaliva()+"');";
				((java.sql.Statement)consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
				}catch(SQLException e) {
					System.out.println("No se pudo crear venta");
				}
		}else {
			System.out.println("la venta ya existe");
		}
		return swCrear;
	}
	
	public boolean borrarVenta(long id_usuario) {
		boolean swCrear = false;
		if(existeVenta(id_usuario)) {
			Conexion conex = new Conexion();
					try {
						Statement consulta = (Statement) conex.getConnection().createStatement();
						String SQL = "DELETE FROM ventas WHERE id_usuario = "+id_usuario; 
						/*((java.sql.Statement))*/ consulta.executeUpdate(SQL);
						/*((java.sql.Statement))*/consulta.close();
						conex.desconectar();
						swCrear = true;
						}catch(SQLException e) {
							System.out.println("No se pudo eliminar la venta");
						}
				}else {
					System.out.println("El venta no existe");
				}
				return swCrear;
			}
	
	public boolean actualizarVenta(VentaVO Venta) {
		boolean swActualizar = false;
		if(existeVenta(Venta.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="UPDATE ventas SET nombre='"+Venta.getNombre()+"',"+
				"totaliva='"+Venta.getTotaliva()+"' WHERE id_usuario="+Venta.getId_usuario();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				
				conex.desconectar();
				swActualizar = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo actualizar la venta");
			}
		}else {
			System.out.println("La venta no existe");
		}
		return swActualizar;
	}
}
	
	
