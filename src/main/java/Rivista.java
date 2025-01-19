public class Rivista extends ElementoCartaceo {

    private String periodicita;

    public Rivista(String isbn, String titolo , int annoPubblicazione, int numeroPagine, String periodicita){
        super(isbn,titolo,annoPubblicazione,numeroPagine);
        this.periodicita=periodicita;
    }

    @Override
    public String toString(){
        return super.toString() + "Periodicita: " + periodicita;
    }

}
