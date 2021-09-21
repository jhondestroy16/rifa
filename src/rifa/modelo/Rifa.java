package rifa.modelo;

public class Rifa {

    private int numero;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Telefono;
    private String pago;
    private String fecha;

    public Rifa() {
    }

    public Rifa(int numero, String Nombre, String Apellido, String Direccion, String Telefono, String pago, String fecha) {
        this.numero = numero;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.pago = pago;
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
