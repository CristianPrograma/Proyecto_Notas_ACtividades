package proyecto1.pkg0;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {

    Connection con;
    Statement st;

    public conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sian.0.0.5", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public void modificar(String sql) {
        try {

            st.executeUpdate(sql);
        } catch (Exception ex) {
            Logger.getLogger(inicio_prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet consultar(String sql) {
        ResultSet rs = null;
        try {

            rs = st.executeQuery(sql);
        } catch (Exception ex) {
            Logger.getLogger(inicio_prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
