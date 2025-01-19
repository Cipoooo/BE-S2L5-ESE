import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Archivio {

    private List<ElementoCartaceo> catalogo;

    public Archivio(){
        this.catalogo = new ArrayList<>();
        elementiPredefiniti();
    }

    private void elementiPredefiniti(){
        //Libri

        catalogo.add(new Libri("1","Signore degli anelli",1954,1200,"Tolkien","Fantasy"));
        catalogo.add(new Libri("2","Harry Potter e La Pietra Filosofale", 1997,304, "Rowling","Fantasy"));
        catalogo.add(new Libri("3","Harry Potter e La Camera dei Segreti",1998,272,"Rowling","fantasy"));
        catalogo.add(new Libri("4","Harry Potter e Il prigioniero di Azkaban",1999,300,"Rowling","fantasy"));
        catalogo.add(new Libri("5","Harry Potter e il Calice di Fuoco", 2000,330,"Rowling","Fantasy"));

        //Riviste

        catalogo.add(new Rivista("6","Magazine1",2020,210,"Settimanale"));
        catalogo.add(new Rivista("7","Magazine2",2021, 273,"Settimanale"));
        catalogo.add(new Rivista("8","MAgazine3",2014,179,"Mensile"));
        catalogo.add(new Rivista("9","MAgazine4",2018,364,"Semestrale"));
        catalogo.add(new Rivista("10","Magazine5",2024,138,"Settimanale"));
    }

    public void aggiungereElemento(ElementoCartaceo elemento)throws Exception{
        if (catalogo.stream().anyMatch(element -> element.isbn.equals(elemento.isbn))){
            throw new Exception("Elemento già presente, dato l' isbn: " + elemento.isbn);
        }
        catalogo.add(elemento);
    }

    public ElementoCartaceo ricercaElementoPerIsbn(String isbn)throws Exception{
        return catalogo.stream().filter(e -> e.isbn.equals(isbn)).findFirst().orElseThrow(()->new Exception("Non esiste un elemento con questo ISBN: "+ isbn));
    }

    public List<ElementoCartaceo> ricercaPerAnno(int annoP){
        return catalogo.stream().filter(e-> e.annoPubblicazione == annoP).collect(Collectors.toList());
    }

    public List<Libri> ricercaPerAutore(String autore){
        return catalogo.stream().filter(e->e instanceof Libri && ((Libri) e).autore.equals(autore)).map(e-> (Libri) e).collect(Collectors.toList());
    }

    public void aggiornaElemento(String isbn, ElementoCartaceo newElemento) throws Exception {
        ElementoCartaceo elementoEsistente = ricercaElementoPerIsbn(isbn);
        catalogo.remove(elementoEsistente);
        catalogo.add(newElemento);
    }

    public void stats(){
        long numLibri = catalogo.stream().filter(e -> e instanceof Libri).count();
        long numRiviste = catalogo.stream().filter(e -> e instanceof Rivista).count();
        ElementoCartaceo conMPagine = catalogo.stream().max(Comparator.comparingInt(e->e.numeroPagine)).orElse(null);
        double mediaPagineTot = catalogo.stream().mapToInt(e->e.numeroPagine).average().orElse(0.0);

        System.out.println("Ecco le statistiche del catalogo: ");
        System.out.println("Numero di libri: "+numLibri);
        System.out.println("Numero di Riviste: "+numRiviste);
        System.out.println("Elemento con il maggior numero di pagine: "+conMPagine);
        System.out.println("Media totale delle pagine: "+mediaPagineTot);
    }
    public List<ElementoCartaceo> getCatalogo(){
        return catalogo;
    }

    public Object aggiornaElemento(String isbnModifica) {
        return null;
    }
}
