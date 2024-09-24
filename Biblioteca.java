import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
   private String nombre;
   private String ubicacion;
   private int cantidadLibros;
   private List<Bibliotecario> bibliotecarios;
   private List<Estudiante> estudiantes;
   private List<Libro> libros;
   private List<Prestamo> prestamos;

   public Biblioteca(String nombre, String ubicacion) {
      this.nombre = nombre;
      this.ubicacion = ubicacion;
      this.cantidadLibros = 0;
      this.bibliotecarios = new ArrayList<>();
      this.estudiantes = new ArrayList<>();
      this.libros = new ArrayList<>();
      this.prestamos = new ArrayList<>();
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getUbicacion() {
      return ubicacion;
   }

   public void setUbicacion(String ubicacion) {
      this.ubicacion = ubicacion;
   }

   public int getCantidadLibros() {
      return cantidadLibros;
   }

   public void setCantidadLibros(int cantidadLibros) {
      this.cantidadLibros = cantidadLibros;
   }

   public void crearBibliotecario(String nombre, String cedula, String telefono, String correo, double salario, int añosAntiguedad) {
      Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, telefono, correo, salario, añosAntiguedad);
      bibliotecarios.add(bibliotecario);
   }

   public void crearEstudiante(String nombre, String cedula, String telefono, String correo) {
      Estudiante estudiante = new Estudiante(nombre, cedula, telefono, correo);
      estudiantes.add(estudiante);
   }

   public void crearLibro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, int unidadesDisponibles) {
      Libro libro = new Libro(codigo, isbn, autor, titulo, editorial, fecha, unidadesDisponibles);
      libros.add(libro);
   }

   public Libro consultarLibroPorCodigo(String codigo) {
      for (Libro libro : libros) {
         if (libro.getCodigo().equals(codigo)) {
            return libro;
         }
      }
      return null;
   }

   public void crearPrestamo(String codigo, Estudiante estudiante, Bibliotecario bibliotecario) {
      Prestamo prestamo = new Prestamo(codigo, estudiante, bibliotecario);
      prestamos.add(prestamo);
   }

   public Prestamo consultarPrestamoPorCodigo(String codigo) {
      for (Prestamo prestamo : prestamos) {
         if (prestamo.getCodigo().equals(codigo)) {
            return prestamo;
         }
      }
      return null;
   }

   public void mostrarCantidadPrestamosPorEmpleado() {
      for (Bibliotecario bibliotecario : bibliotecarios) {
         int count = 0;
         for (Prestamo prestamo : prestamos) {
            if (prestamo.getBibliotecario().equals(bibliotecario)) {
               count++;
            }
         }
         System.out.println(bibliotecario.getNombre() + " ha realizado " + count + " préstamos.");
      }
   }

   public double calcularTotalDineroRecaudado() {
      double total = 0;
      for (Prestamo prestamo : prestamos) {
         total += prestamo.getCosto();
      }
      return total;
   }

   public static void main(String[] args) {
      // Ejemplo de creación de una biblioteca
      Biblioteca biblioteca = new Biblioteca("Biblioteca CRAI", "Armenia Quindío");
      System.out.println("Nombre de la biblioteca: " + biblioteca.getNombre());
      System.out.println("Ubicación: " + biblioteca.getUbicacion());
      System.out.println("Cantidad de libros: " + biblioteca.getCantidadLibros());

      // Crear bibliotecarios
      biblioteca.crearBibliotecario("Juan Pérez", "1090274138", "3244587908", "juanp.20@gmail.com", 1000000.0, 5);

      // Crear estudiantes
      biblioteca.crearEstudiante("Ana Gómez", "1090285639", "3289012027", "anaG.17@gmail.com");

      // Crear libros
      biblioteca.crearLibro("001", "00001", "Edgar Allan Poe", "El cuervo", "New-York Mirror", "29 de enero de 1845", 10);
      biblioteca.crearLibro("002", "00002", "Edgar Allan Poe", "Annabel Lee", "Sartain's Union Magazine", "9 de octubre de 1849", 5);

      // Consultar libro por código
      Libro libroConsultado = biblioteca.consultarLibroPorCodigo("002");
      if (libroConsultado != null) {
         System.out.println("Libro encontrado: " + libroConsultado.getTitulo());
      } else {
         System.out.println("Libro no encontrado.");
      }

      // Crear préstamo
      Estudiante estudiante = biblioteca.estudiantes.get(0); // Obtener el primer estudiante
      Bibliotecario bibliotecario = biblioteca.bibliotecarios.get(0); // Obtener el primer bibliotecario
      biblioteca.crearPrestamo("P001", estudiante, bibliotecario);

      // Consultar préstamo por código
      Prestamo prestamoConsultado = biblioteca.consultarPrestamoPorCodigo("P001");
      if (prestamoConsultado != null) {
         System.out.println("Préstamo encontrado: " + prestamoConsultado.getCodigo());
      } else {
         System.out.println("Préstamo no encontrado.");
      }

      // Mostrar cantidad de préstamos por empleado
      biblioteca.mostrarCantidadPrestamosPorEmpleado();

      // Calcular total de dinero recaudado
      double totalDineroRecaudado = biblioteca
            .calcularTotalDineroRecaudado();
      System.out.println("Total de dinero recaudado: " + totalDineroRecaudado);
   }
}
