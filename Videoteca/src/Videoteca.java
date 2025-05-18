import java.util.ArrayList;
import java.util.Scanner;

public class Videoteca {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Pelicula> peliculas;

    public Videoteca() {
        peliculas = new ArrayList<>();
    }

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
            opcion = sc.nextInt();

            if (!sc.hasNextInt()) {
                System.out.println("Introduce una opcion valida");
                return;
            }

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
        System.out.println("\nIntroduce el Titulo de la pelicula: ");
        String titulo = sc.nextLine();
        sc.nextLine();
        System.out.println("Introduce el nombre del Director de la pelicula");
        String autor = sc.nextLine();
        System.out.println("Introduce el Codigo de la pelicula: ");
        String codigo = sc.nextLine();
        System.out.println("Introduce el Año de estreno de la pelicula: ");
        String yearStr = sc.nextLine();
    
    
    
    
    }   

    public void buscarPeliculaCodigo() {
        System.out.println("\nIntroduce el Codigo de la pelicula a buscar: ");
        String codigo = sc.nextLine();
        sc.nextLine();


    }

    public void buscarPeliculaDirector() {
        System.out.println("\nIntroduce el Director de las peliculas a buscar: ");
        String director = sc.nextLine();
        sc.nextLine();


    }

    public void buscarPeliculaTitulo() {
        System.out.println("\nIntroduce el Titulo de la pelicula a buscar: ");
        String titulo = sc.nextLine();
        sc.nextLine();


    }

    public void mostrarTotalPeliculas() {
        System.out.println("\nPeliculas guardadas: ");
        System.out.println("-----------------------");
    
    
    }

}
