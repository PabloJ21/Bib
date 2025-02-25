public class Estudiante {
    private String nombre;
    private String telefono;
    private String correo;
    private String cedula;
    private int prestamosRealizados;

    public Estudiante(String nombre, String cedula, String telefono, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.prestamosRealizados = 0;
    }

    public void incrementarPrestamos() {
        this.prestamosRealizados++;
    }

    public int getPrestamosRealizados() {
        return prestamosRealizados;
    }

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

    public void setPrestamosRealizados(int prestamosRealizados) {
        this.prestamosRealizados = prestamosRealizados;
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + ", correo=" + correo + "]";
    }

}
