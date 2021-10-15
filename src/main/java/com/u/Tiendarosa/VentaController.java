package com.u.Tiendarosa;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tiendarosa.VentaDAO;
import com.DTO.Tiendarosa.VentaVO;

@RestController
public class VentaController {

	
	
	
	@RequestMapping("/listaventas")
	public ArrayList<VentaVO> listaDeVentas(){
		VentaDAO dao = new VentaDAO();
		
		return dao.listaDeVentas();
	}
	
	
	
	
	
	
	@RequestMapping("/buscarventaID")
	public ArrayList<VentaVO> buscarVenta(String id_usuario){ 
		VentaDAO dao = new VentaDAO();
		return dao.buscarVenta(Long.parseLong(id_usuario));
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/crearventa")
	public boolean crearVenta(String id_usuario, String nombre,int totaliva){
		VentaDAO dao = new VentaDAO();
		VentaVO venta = new VentaVO();
	
		venta.setId_usuario(Long.parseLong(id_usuario));
		venta.setNombre(nombre);
		venta.setTotaliva(totaliva);
		
		
		return dao.crearVenta(venta);
	}
	
	
	
	
	
	

	
	
	
	
	
	
	

	
}

