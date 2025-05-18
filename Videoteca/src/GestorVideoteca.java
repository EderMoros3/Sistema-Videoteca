import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestorVideoteca {
    private static final String RUTA = "Videoteca\\src\\peliculas.txt";
    public void añadirPelicula(Pelicula pelicula) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA, true))) {
            writer.write(pelicula.toFileString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar la pelicula: " + e.getMessage());
        }
    }
}
