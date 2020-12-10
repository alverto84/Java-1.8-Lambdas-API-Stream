import java.util.*;
import java.util.stream.Collectors;

class Pelicula
{
    private String titulo;
    private String director;
    private int estreno;
    
    public Pelicula(String titulo, String director, int estreno)
    {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }
    
    public String getTitulo()
    {
        return titulo;
    }
    
    public String getDirector()
    {
        return director;
    }
    
    public int getEstreno()
    {
        return estreno;
    }
    
    @Override
    public String toString()
    {
        return titulo + " (" + director + ", " + estreno + ")";
    }
}

public class EjercicioSeccion3Solucion
{    
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));
     
		// 1. Sublistado con películas del siglo XXI
		List<Pelicula> peliculasSigloXXI = peliculas.stream()
													.filter(p -> p.getEstreno() >= 2000)
													.collect(Collectors.toList());
		System.out.println("Películas del s. XXI:");
		peliculasSigloXXI.stream().forEach(System.out::println);
		
		// 2. Títulos de las películas de Steven Spielberg, separados por comas
		String titulosSpielberg = peliculas.stream()
										   .filter(p -> p.getDirector().equals("Steven Spielberg"))
										   .map(p -> p.getTitulo())
										   .collect(Collectors.joining(", ", "Películas de Spielberg:", ""));
		System.out.println(titulosSpielberg);
		
		// 3. Sublistado con nombres de películas ordenados alfabéticamente
		List<String> titulosPeliculas = peliculas.stream()
												 .map(p -> p.getTitulo())
												 .sorted((t1, t2) -> t1.compareTo(t2))
												 .collect(Collectors.toList());
		System.out.println("Títulos de películas por orden alfabético:");
		titulosPeliculas.stream().forEach(System.out::println);
		
		// 4. Año de estreno más reciente
		Optional<Integer> maxEstreno = peliculas.stream()
										  .map(p -> p.getEstreno())
										  .max((e1, e2) -> Integer.compare(e1, e2));
		if (maxEstreno.isPresent())
		{
			System.out.println("El año más reciente es " + maxEstreno.get());
		}
		else
		{
			System.out.println("No se ha podido obtener el año de estreno más reciente");
		}
    }
}
