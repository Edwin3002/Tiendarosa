package prueba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import com.DAO.Tiendarosa.*;

public class app2 {
	
	public static void main(String[] args) {
		Connection con;
		Conexion co = new Conexion();
		try {
			con = co.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * FROM clientes");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				System.out.println("ID: " + rs.getInt("id_usuario") + "\n"
								+ "Direccion: " + rs.getString("direccion") + "\n"
								+ "Telefono: " + rs.getString("telefono") + "\n"
								+ "NOMBRE: " + rs.getString("nombre") + "\n"
								+ "CORREO: " + rs.getString("correo") + "\n");
			}
		}catch (Exception e) {
			System.out.println("No se encontro info");
		}
	}
}
