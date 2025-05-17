public class Pelicula {
    private String titulo;
    private String autor;
    private String codigo;
    private int year;

    public Pelicula(String titulo, String autor, String codigo, int year) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.year = year;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCodigo() { return codigo; }
    public int getYear() { return year; }

    public void setTitulo(String titulo) { titulo = this.titulo; }
    public void setAutor(String autor) { autor = this.autor; }
    public void setCodigo(String codigo) { codigo = this.codigo; }
    public void setYear(int year) { year = this.year; }

    public String toString() {
        return "\n" + titulo + " - " + autor + " - " + codigo + " - " + year;
    }
    
    public String toFileString() {
        return titulo + ";" + autor + ";" + codigo + ";" + year;
    }
}
