import java.util.ArrayList;
import java.util.Scanner;

public class Videoteca {
    Scanner sc = new Scanner(System.in);
    GestorVideoteca gestor = new GestorVideoteca();

    public Videoteca() {}

    public void menuPrincipal() {
        int opcion;

        do {
            System.out.println("\nBienvenido a la biblioteca");
            System.out.println("1. Añadir nueva pelicula");
            System.out.println("2. Buscar pelicula por codigo");
            System.out.println("3. Buscar peliclas por director");
            System.out.println("4. Buscar peliculas por titulo.");
            System.out.println("5. Mostrar todas las peliculas");
            System.out.println("6. Salir");
            System.out.println("-->");
            
            while (!sc.hasNextInt()) {
                System.out.println("Introduce una opcion valida");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> añadirPelicula();
                case 2 -> buscarPeliculaCodigo();
                case 3 -> buscarPeliculaDirector();
                case 4 -> buscarPeliculaTitulo();
                case 5 -> mostrarTotalPeliculas();
                case 6 -> System.out.println("Saliendo del programa...");
            }
        } while (opcion != 6);
    }

    public void añadirPelicula() {
        ArrayList<Pelicula> peliculas = gestor.cargarPeliculas();

        System.out.println("\nIntroduce el Titulo de la pelicula: ");
        String titulo = sc.nextLine().trim();
        sc.nextLine();
        System.out.println("Introduce el nombre del Director de la pelicula");
        String autor = sc.nextLine().trim();
        System.out.println("Introduce el Codigo de la pelicula: ");
        String codigo = sc.nextLine().trim();
        System.out.println("Introduce el Año de estreno de la pelicula: ");
        String yearStr = sc.nextLine().trim();
        
        if (titulo.isEmpty() || autor.isEmpty() || codigo.isEmpty() || yearStr.isEmpty()) {
            System.out.println("Todos los campos son obligatorios para crear una pelicula");
            return;
        }

        for (Pelicula pelicula : peliculas) {
                if (pelicula.getCodigo().equalsIgnoreCase(codigo)) {
                    System.out.println("No puedo haber codigos duplicados");
                    return;
                }
            }

        try {
            int year = Integer.parseInt(yearStr);
            Pelicula nuevPelicula = new Pelicula(titulo, autor, codigo, year);
            gestor.añadirPelicula(nuevPelicula);
        } catch (NumberFormatException e) {
            System.err.println("Error a la hora de cambiar el año a numero: " + e.getMessage());
        }
        System.out.println("Pelicula añadida con exito");
    }   

    public void buscarPeliculaCodigo() {
        ArrayList<Pelicula> peliculas = gestor.cargarPeliculas();

        System.out.println("\nIntroduce el Codigo de la pelicula a buscar: ");
        String codigo = sc.nextLine().trim();
        sc.nextLine();

        Pelicula pelicula = gestor.buscarPeliculaCodigo(peliculas, codigo);
        if (pelicula != null) {
            System.out.println(pelicula);
        } else {
            System.out.println("No se encontro ninguna pelicula");
        }

    }

    public void buscarPeliculaDirector() {
        ArrayList<Pelicula> peliculas = gestor.cargarPeliculas();

        System.out.println("\nIntroduce el Director de las peliculas a buscar: ");
        String director = sc.nextLine().trim();
        sc.nextLine();

        ArrayList<Pelicula> resultado = gestor.buscarPeliculaDirector(peliculas, director);
        if (resultado.isEmpty()) {
            System.out.println("No hay peliculas de ese director");
        }else {
            System.out.println("Peliculas de " + director + ": ");
            for (Pelicula pelicula : resultado) {
                System.out.println(pelicula);
            }
        }
    }

    public void buscarPeliculaTitulo() {
        ArrayList<Pelicula> peliculas = gestor.cargarPeliculas();
        
        System.out.println("\nIntroduce el Titulo de la pelicula a buscar: ");
        String titulo = sc.nextLine().trim();
        sc.nextLine();

        gestor.buscarPeliculaTitulo(peliculas, titulo);


    }

    public void mostrarTotalPeliculas() {
        ArrayList<Pelicula> peliculas = gestor.cargarPeliculas();
        if (peliculas.isEmpty()) {
            System.out.println("No hay peliculas registradas");
        }

        System.out.println("\nPeliculas guardadas: ");
        System.out.println("-----------------------");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    
    
    }

}
