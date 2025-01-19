public class Libri extends ElementoCartaceo{

    public  String autore;
    private String genere;

    public Libri(String isbn, String titolo , int annoPubblicazione, int numeroPagine, String autore, String genere){
        super(isbn,titolo,annoPubblicazione,numeroPagine);
        this.autore=autore;
        this.genere=genere;
    }
    @Override
    public String toString(){
        return super.toString() + "Autore: " + autore + "\n"  + "Genere: " + genere + "\n";
    }
}
