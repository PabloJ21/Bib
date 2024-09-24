import java.time.LocalDate;

public class Bibliotecario {
    private String nombre;
    private String cedula;
    private String correo;
    private String telefono;
    private double salario;
    private int añosAntiguedad;

    public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salario,
            int añosAntiguedad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.añosAntiguedad = añosAntiguedad;
    }

    public double calcularSalarioConBonificacion(double totalPrestamos) {
        double salarioBase = salario + (totalPrestamos * 0.2);
        double bonificacion = salarioBase * (0.02 * añosAntiguedad);
        return salarioBase + bonificacion;
    }

    public void entregarPrestamo(Prestamo prestamo) {
        prestamo.setFechaEntrega(LocalDate.now());
        double costo = prestamo.calcularCosto();
        for (Libro libro : prestamo.getLibros()) {
            libro.actualizarUnidades(1); // Devuelve las unidades al libro
        }
        System.out.println("El costo del préstamo es: " + costo);
    }

    // Getters - Setters//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAñosAntiguedad() {
        return añosAntiguedad;
    }

    public void setAñosAntiguedad(int añosAntiguedad) {
        this.añosAntiguedad = añosAntiguedad;
    }

    @Override
    public String toString() {
        return "Bibliotecario [nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", correo=" + correo + ", salario=" + salario + "]";
    }

}
