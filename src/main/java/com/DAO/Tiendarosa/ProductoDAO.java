package com.DAO.Tiendarosa;

import java.beans.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import com.DAO.Tiendarosa.Conexion;
import com.DTO.Tiendarosa.ProductoVO;

public class ProductoDAO {
	
	public ArrayList<ProductoVO>listaDeProductos(){
		ArrayList<ProductoVO> misProductos = new ArrayList<ProductoVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				ProductoVO Producto = new ProductoVO();
				Producto.setId_usuario(res.getLong("id_usuario"));
				Producto.setNombre(res.getString("nombre"));
				Producto.setNitprove(res.getString("nitprove"));
				Producto.setPrecio(res.getInt("precio"));
				Producto.setIva(res.getInt("iva"));
				Producto.setVenta(res.getInt("venta"));
				misProductos.add(Producto);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misProductos;
}	
	
	
	
	
	
	
	public ArrayList<ProductoVO> buscarProducto(long id_usuario){
		ArrayList<ProductoVO> misProductos = new ArrayList<ProductoVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			
			while(res.next()){
				ProductoVO Producto = new ProductoVO();
				
				Producto.setId_usuario(res.getLong("id_usuario"));
				Producto.setNombre(res.getString("nombre"));
				Producto.setNitprove(res.getString("nitprove"));
				Producto.setPrecio(res.getInt("precio"));
				Producto.setIva(res.getInt("iva"));
				Producto.setVenta(res.getInt("venta"));
				misProductos.add(Producto);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misProductos;
	}
	
	public boolean existeProducto(long id_usuario) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos WHERE id_usuario=?");
			
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo verificar si existe el producto");
		}
		
		return existe;
	}

	public boolean crearProducto(ProductoVO Producto) {
		boolean swCrear = false;
		if(!existeProducto(Producto.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "INSERT INTO productos (id_usuario, nombre, nitprove, precio, iva, venta) VALUES ("+
						Producto.getId_usuario()+",'"+ Producto.getNombre()+"','"+Producto.getNitprove()+"','"+ Producto.getPrecio()+"','"+ Producto.getIva()+"','"+Producto.getVenta()+"');";
				((java.sql.Statement)consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				swCrear = true;
				}catch(SQLException e) {
					System.out.println("No se pudo crear producto");
				}
		}else {
			System.out.println("El producto ya existe");
		}
		return swCrear;
	}
	
	public boolean borrarProducto(long id_usuario) {
		boolean swCrear = false;
		if(existeProducto(id_usuario)) {
			Conexion conex = new Conexion();
					try {
						Statement consulta = (Statement) conex.getConnection().createStatement();
						String SQL = "DELETE FROM productos WHERE id_usuario = "+id_usuario; 
						/*((java.sql.Statement))*/ consulta.executeUpdate(SQL);
						/*((java.sql.Statement))*/consulta.close();
						conex.desconectar();
						swCrear = true;
						}catch(SQLException e) {
							System.out.println("No se pudo eliminar producto");
						}
				}else {
					System.out.println("El producto no existe");
				}
				return swCrear;
			}
	
	public boolean actualizarProducto(ProductoVO Producto) {
		boolean swActualizar = false;
		if(existeProducto(Producto.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="UPDATE productos SET nombre='"+Producto.getNombre()+"',"+
				"nitprove='"+Producto.getNitprove()+"',"+
						"precio='"+Producto.getPrecio()+"',"+
							"iva='"+Producto.getIva()+"',"+
								"venta='"+Producto.getVenta()+"' WHERE id_usuario="+Producto.getId_usuario();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				
				conex.desconectar();
				swActualizar = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo actualizar el producto");
			}
		}else {
			System.out.println("El producto no existe");
		}
		return swActualizar;
	}
}
	
	
