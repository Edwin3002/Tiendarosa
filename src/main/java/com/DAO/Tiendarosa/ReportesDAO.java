package com.DAO.Tiendarosa;

import java.beans.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import com.DAO.Tiendarosa.Conexion;
import com.DTO.Tiendarosa.UsuarioVO;

public class ReportesDAO {
	
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
	
		
}
