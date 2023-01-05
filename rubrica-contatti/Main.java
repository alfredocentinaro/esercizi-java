public class Main
{
    public static void main(String[] args)
    {
        Rubrica rubricacasa = new Rubrica("Alfredo Centinaro");

        Contatto giovanni = new Contatto("Giovanni", "Rossi","0861626360",Tipo.Principale);
        ContattoAziendale rosa = new ContattoAziendale("Rosa",
                "Bianchi",
                "0861626360",
                Tipo.Lavoro,
                "LadriSPA2",
                "bianchi@ladrispa.it",
                Tipo.Lavoro);

        rubricacasa.inserisciContatto(giovanni);
        rubricacasa.inserisciContatto(rosa);

        rubricacasa.inserisciContatto(new Contatto("Alfredo", "Centinaro","3493827841",Tipo.Cellulare));
        rubricacasa.stampaContatti();

        System.out.println();
        System.out.println();

        Contatto risultato = rubricacasa.cercaContattoPerNome("Alfredo");
        if (risultato != null)
        {
            System.out.println("CONTATTO TROVATO, STAMPO");
            risultato.stampaInfo();
        }

        System.out.println();
        System.out.println("CANCELLO CONTATTO E STAMPO LA RUBRICA AGGIORNATA");
        int posizione = rubricacasa.cercaPosizioneContattoPerNome("Alfredo");
        rubricacasa.cancellaContatto(posizione);
        System.out.println("CANCELLAZIONE EFFETTUATA");
        rubricacasa.stampaContatti();


    }
}
