public abstract class ElementoCartaceo {

   public String isbn;
   public String titolo;
   public int annoPubblicazione;
   public int numeroPagine;

    public ElementoCartaceo(String isbn, String titolo , int annoPubblicazione, int numeroPagine){
        this.isbn=isbn;
        this.titolo=titolo;
        this.annoPubblicazione=annoPubblicazione;
        this.numeroPagine=numeroPagine;
    }

    public String toString(){
        return "\n" + "ISBN: " + isbn + "\n" + "Titolo: " + titolo + "\n"+ "Anno pubblicazione: " + annoPubblicazione + "\n" + "Numero di Pagine: " + numeroPagine + "\n";
    }

}
