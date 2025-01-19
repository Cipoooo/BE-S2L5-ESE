import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Archivio archivio = new Archivio();
    System.out.println();

    while(true){
        System.out.println();
        System.out.println("Clicca un numero per avviare l' operazione correlata ad esso.");
        System.out.println();
        System.out.println("1: Crea un libro");
        System.out.println("2: Crea una Rivista");
        System.out.println("3: Ricerca un elemento tramite il suo ISBN");
        System.out.println("4: Rimuovi un elemento tramite il suo ISBN");
        System.out.println("5: Ricerca un elemento tramite il suo anno di produzione");
        System.out.println("6: Ricerca un elemento tramite il suo autore");
        System.out.println("7: Aggiorna/Modifica un elemento");
        System.out.println("8: Vedi tutte le Statistiche del catalogo");
        System.out.println("0: Esci");
        System.out.println();

        int scelta = scanner.nextInt();

        switch (scelta){
            case 1:
                scanner.nextLine();
                System.out.println("Inserisci ISBN: ");
                String isbnLibro = scanner.nextLine();
                System.out.println("Inserisci il titolo del libro: ");
                String titoloLibro = scanner.nextLine();
                System.out.println("Inserisci L' anno di produzione del libro: ");
                int annoProduzioneLibro = scanner.nextInt();
                System.out.println("Inserisci il numero di pagine del libro: ");
                int numeroPagineLibro = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci L' autore del libro: ");
                String autoreLibro = scanner.nextLine();
                System.out.println("Inserisci il genere del libro: ");
                String genereLibro = scanner.nextLine();
                try{
                    Libri libro = new Libri(isbnLibro, titoloLibro,annoProduzioneLibro,numeroPagineLibro,autoreLibro,genereLibro);
                    archivio.aggiungereElemento(libro);
                    System.out.println("Libro creato e posizionato nell' archivio");
                }catch (Exception e){
                    System.out.print(e.getMessage());
                }
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Inserisci ISBN: ");
                String isbnRivista = scanner.nextLine();
                System.out.println("Inserisci il titolo della rivista: ");
                String titoloRivista = scanner.nextLine();
                System.out.println("Inserisci L' anno di produzione della rivista: ");
                int annoProduzioneRivista = scanner.nextInt();
                System.out.println("Inserisci il numero di pagine della rivista: ");
                int numeroPagineRivista = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci ogni quanto esce la rivista: ");
                String periodicitaRivista = scanner.nextLine();
                try{
                    Rivista rivista = new Rivista(isbnRivista, titoloRivista,annoProduzioneRivista,numeroPagineRivista,periodicitaRivista);
                    archivio.aggiungereElemento(rivista);
                    System.out.println("Rivista creata e posizionata nell' archivio");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                scanner.nextLine();
                System.out.println("Inserisci l' ISBN da ricercare: ");
                String isbnRicerca = scanner.nextLine();
                try{
                    ElementoCartaceo elementoTrovato = archivio.ricercaElementoPerIsbn(isbnRicerca);
                    System.out.println("Elemento trovato: " + elementoTrovato);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                scanner.nextLine();
                System.out.println("Inserisci l' ISBN dell' elemento da rimuovere:");
                String isbnRimozione = scanner.nextLine();
                try{
                    ElementoCartaceo elemtoRimosso = archivio.ricercaElementoPerIsbn(isbnRimozione);
                    archivio.getCatalogo().remove(elemtoRimosso);
                    System.out.println("Elemento rimosso con successo...");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                scanner.nextLine();
                System.out.println("Inserisci l' anno di produzione dell' elemento da cercare: ");
                int annoProduzioneRicerca = scanner.nextInt();
                try{
                    ElementoCartaceo elemetoAnno = (ElementoCartaceo) archivio.ricercaPerAnno(annoProduzioneRicerca);
                    System.out.println("Elemento trovato: " + elemetoAnno);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 6:
                scanner.nextLine();
                System.out.println("Inserisci l' autore dell' elemento da cercare: ");
                String autoreRicerca = scanner.nextLine();
                try{
                    ElementoCartaceo elementoAutore = (ElementoCartaceo) archivio.ricercaPerAutore(autoreRicerca);
                    System.out.println("Elemento trovato: " + elementoAutore);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 7:
                scanner.nextLine();
                System.out.println("Inserisci l' ISBN dell' elemento da modificare:");
                String isbnModifica = scanner.nextLine();
                try{
                    ElementoCartaceo elementoMod = (ElementoCartaceo) archivio.aggiornaElemento(isbnModifica);
                    System.out.println("L' elemento è stato modificato: " + elementoMod);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            case 8:
                scanner.nextLine();
                archivio.stats();
                break;
            case 0:
                System.out.println("Scanner chiuso...");
                scanner.close();
                return;
            default:
                System.out.println("Qualcosa è andato storto,riprova");
                break;
        }
    }

    }
}