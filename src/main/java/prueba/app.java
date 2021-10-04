package prueba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import com.DAO.Tiendarosa.*;

public class app {
	
	public static void main(String[] args) {
		Connection con;
		Conexion co = new Conexion();
		try {
			con = co.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * FROM usuarios");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				System.out.println("ID: " + rs.getInt("id_usuario") + "\n"
								+ "USER: " + rs.getString("usuario") + "\n"
								+ "CLAVE: " + rs.getString("clave") + "\n");
			}
		}catch (Exception e) {
			System.out.println("No se encontro info");
		}
	}
}
