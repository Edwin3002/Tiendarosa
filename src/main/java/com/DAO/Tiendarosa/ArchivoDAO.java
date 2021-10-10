package com.DAO.Tiendarosa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.DTO.Tiendarosa.ArchivoVO;
public class ArchivoDAO{
	public boolean registrarProducto2(ArchivoVO producto) {
		boolean creado=false;
		if(!existeProducto2(producto.getId_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = conex.getConnection().createStatement();
				String sql = "INSERT INTO productos (id_usuario, nombre, nitprove, precio, iva, venta) VALUES "+
						"("+producto.getId_usuario()+",'"+producto.getNombre()+"','"+producto.getNitprove()+"',"
						+ "'"+producto.getPrecio()+"','"+producto.getIva()+"','"+producto.getVenta()+"');";
				consulta.executeUpdate(sql);
				consulta.close();
				conex.desconectar();
				creado = true;
			}catch(SQLException e) {
				System.out.println("No se pudo crear el prodcuto.");
			}
		}else {
			System.out.println("El producto ya exite.");
		}
		return creado;
	}
	public boolean existeProducto2(Long id_usuario) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos WHERE id_usuario = ?");
			consulta.setLong(1, id_usuario);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return existe;
	}
	public ArrayList<ArchivoVO> listaDeProductos2(){					
		ArrayList<ArchivoVO> misProductos = new ArrayList<ArchivoVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos");
			ResultSet res = consulta.executeQuery();
			while(res.next()){

				ArchivoVO producto = new ArchivoVO();
				producto.setId_usuario(res.getLong("id_usuario"));
				producto.setNombre(res.getString("nombre"));
				producto.setNitprove(res.getString("nitprove"));
				producto.setPrecio(res.getInt("precio"));
				producto.setIva(res.getInt("iva"));
				producto.setVenta(res.getInt("venta"));
				misProductos.add(producto);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		}catch(Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misProductos;
	}
	}
