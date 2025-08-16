package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidadorArchivo {

    public void verificarNoVacio(String nombreArchivo) throws ArchivoVacioException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            if (reader.readLine() == null) {
                throw new ArchivoVacioException("El archivo está vacío: " + nombreArchivo);
            }
        }
    }
}
