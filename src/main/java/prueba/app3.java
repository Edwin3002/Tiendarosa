package prueba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import com.DAO.Tiendarosa.*;

public class app3 {
	
	public static void main(String[] args) {
		Connection con;
		Conexion co = new Conexion();
		try {
			con = co.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * FROM proveedores");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				System.out.println("Nit: " + rs.getInt("id_usuario") + "\n"
								+ "Nombre: " + rs.getString("nombre") + "\n"
								+ "Ciudad: " + rs.getString("ciudad") + "\n"
								+ "Direccion: " + rs.getString("direccion") + "\n"
								+ "Telefono: " + rs.getString("telefono") + "\n");
			}
		}catch (Exception e) {
			System.out.println("No se encontro info");
		}
	}
}
