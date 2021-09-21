package rifa.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conn;
    public static final String Driver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/rifa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String user = "root";
    public static final String password = "toor";
    
    public Connection GetConexion() {

        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(Conexion.url, user, password);
            System.out.println("Conexion exitosa");

        } catch (SQLException e) {
            //System.err.println(e);
            System.err.println(">:V");
        } catch (ClassNotFoundException ex) {
            //System.out.println(ex);
            System.err.println(">:V");
        }
        return conn;
    }
}