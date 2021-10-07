package prueba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import com.DAO.Tiendarosa.*;

public class app4 {
	
	public static void main(String[] args) {
		Connection con;
		Conexion co = new Conexion();
		try {
			con = co.getConnection();
			PreparedStatement ps = con.prepareStatement("Select * FROM productos");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				System.out.println("Id: " + rs.getInt("id_usuario") + "\n"
								+ "Nombre: " + rs.getString("nombre") + "\n"
								+ "Nitprove: " + rs.getString("nitprove") + "\n"
								+ "Precio: " + rs.getString("precio") + "\n"
								+ "Iva: " + rs.getInt("iva") + "\n"
								+ "Venta: " + rs.getInt("venta") + "\n");
			}
		}catch (Exception e) {
			System.out.println("No se encontro info");
		}
	}
}

