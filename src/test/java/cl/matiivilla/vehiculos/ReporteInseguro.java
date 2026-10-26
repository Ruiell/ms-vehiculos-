package cl.matiivilla.vehiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReporteInseguro {
    private static final String DB_PASSWORD = "admin123";

    public String buscarPorPatente(String patente) {
        String sql = "SELECT * FROM vehiculo WHERE patente = '" + patente + "'";
        
        try (Connection con = DriverManager.getConnection("jdbc:h2:mem:test", "sa", DB_PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            return rs.next() ? rs.getString("modelo") : null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
