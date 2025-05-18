import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorVideoteca {
    private static final String RUTA = "Videoteca\\src\\peliculas.txt";

    public ArrayList<Pelicula> cargarPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    peliculas.add(new Pelicula(partes[0], partes[1], partes[2], Integer.parseInt(partes[3])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
        return peliculas;
    }

    public void añadirPelicula(Pelicula pelicula) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA, true))) {
            writer.write(pelicula.toFileString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar la pelicula: " + e.getMessage());
        }
    }

    public Pelicula buscarPeliculaCodigo(ArrayList<Pelicula> peliculas, String codigo) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getCodigo().equalsIgnoreCase(codigo)) {
                return pelicula;
            }
        }
        return null;
    }

}
