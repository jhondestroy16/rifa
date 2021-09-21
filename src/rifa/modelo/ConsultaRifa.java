package rifa.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaRifa extends Conexion {

    public boolean guardar(Rifa pro) {
        PreparedStatement ps = null;
        Connection con = GetConexion();

        String sql = "INSERT INTO RifaPersona (Numero, Nombre, "
                + "Apellido, Direccion, Telefono, Pago) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getNumero());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getApellido());
            ps.setString(4, pro.getDireccion());
            ps.setString(5, pro.getTelefono());
            ps.setString(6, pro.getPago());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("El numero ya existe, eliga otro");
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException | NumberFormatException e) {
                System.out.println(e);
            }
        }
    }

    public boolean modificar(Rifa pro) {
        PreparedStatement ps = null;
        Connection conn = GetConexion();

        String sql = "UPDATE RifaPersona SET Nombre=?, Apellido=?, "
                + "Direccion=?, Telefono=?, Pago=? WHERE Numero=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getApellido());
            ps.setString(3, pro.getDireccion());
            ps.setString(4, pro.getTelefono());
            ps.setString(5, pro.getPago());
            ps.setInt(6, pro.getNumero());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al modificar el dato");
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException | NumberFormatException e) {
                System.out.println(e);
            }
        }
    }

    public boolean eliminar(Rifa pro) {
        PreparedStatement ps = null;
        Connection conn = GetConexion();

        String sql = "DELETE FROM RifaPersona WHERE Numero=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pro.getNumero());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al ELIMINAR el dato de la rifa" + e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException | NumberFormatException e) {
                System.out.println(e);
            }
        }
    }

    public boolean buscar(Rifa pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = GetConexion();

        String sql = "SELECT * FROM RifaPersona WHERE Numero=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pro.getNumero());
            ps.execute();
            rs = ps.executeQuery();

            if (rs.next()) {
                pro.setNumero(Integer.parseInt(rs.getString("Numero")));
                pro.setNombre(rs.getString("Nombre"));
                pro.setApellido(rs.getString("Apellido"));
                pro.setDireccion(rs.getString("Direccion"));
                pro.setTelefono(rs.getString("Telefono"));
                pro.setPago(rs.getString("Pago"));
                return true;
            }

            return false;
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException | NumberFormatException e) {
                System.out.println(e);
            }
        }
    }
}
