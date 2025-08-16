import modelo.GestorDeArchivo;
import modelo.ValidadorArchivo;
import modelo.ArchivoVacioException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorDeArchivo gestor = new GestorDeArchivo();
        ValidadorArchivo validador = new ValidadorArchivo();

        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = sc.nextLine();

        System.out.println("Ingrese el contenido que desea guardar en el archivo:");
        String contenido = sc.nextLine();

        try {
            gestor.guardar(nombreArchivo, contenido);
            System.out.println("Archivo guardado correctamente.");

            String datos = gestor.leer(nombreArchivo);
            System.out.println("Contenido del archivo:\n" + datos);

            validador.verificarNoVacio(nombreArchivo);
            System.out.println("El archivo no está vacío.");

        } catch (ArchivoVacioException ave) {
            System.out.println("Error: " + ave.getMessage());
        } catch (IOException ioe) {
            System.out.println("Error de E/S: " + ioe.getMessage());
        }
    }
}
