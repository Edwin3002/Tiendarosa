package com.u.Tiendarosa;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tiendarosa.ProductoDAO;
import com.DTO.Tiendarosa.ProductoVO;

@RestController
public class ProductoController {

	
	
	
	@RequestMapping("/listaproductos")
	public ArrayList<ProductoVO> listaDeProductos(){
		ProductoDAO dao = new ProductoDAO();
		
		return dao.listaDeProductos();
	}
	
	
	
	
	
	
	@RequestMapping("/buscarproductoID")
	public ArrayList<ProductoVO> buscarProducto(String id_usuario){ 
		ProductoDAO dao = new ProductoDAO();
		return dao.buscarProducto(Long.parseLong(id_usuario));
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/crearproducto")
	public boolean crearProducto(String id_usuario, String nombre, String nitprove, int precio, int iva, int venta){
		ProductoDAO dao = new ProductoDAO();
		ProductoVO producto = new ProductoVO();
	
		producto.setId_usuario(Long.parseLong(id_usuario));
		producto.setNombre(nombre);
		producto.setNitprove(nitprove);
		producto.setPrecio(precio);
		producto.setIva(iva);
		producto.setVenta(venta);
		
		
		return dao.crearProducto(producto);
	}
	
	
	
	
	
	
	@RequestMapping("/borrarproducto")
	public boolean borrarProducto(String id_usuario) {
		ProductoDAO dao = new ProductoDAO();
		return dao.borrarProducto(Long.parseLong(id_usuario));
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/actualizarproducto")
	public boolean actualizarProducto(String id_usuario, String nombre, String nitprove, int precio, int iva, int venta) {
		ProductoDAO dao = new ProductoDAO();
		ProductoVO producto = new ProductoVO();
			
		producto.setId_usuario(Long.parseLong(id_usuario));
		producto.setNombre(nombre);
		producto.setNitprove(nitprove);
		producto.setPrecio(precio);
		producto.setIva(iva);
		producto.setVenta(venta);
			
		return dao.actualizarProducto(producto);
	}
	
}

