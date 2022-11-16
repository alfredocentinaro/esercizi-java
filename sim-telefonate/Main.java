public class Main
{
    public static void main(String[] args)
    {
        Telefonata t = new Telefonata("0861410242",
                LocalDateTime.of(2022,11,12,23,00),
                LocalTime.of(2,15,24));
        t.stampaDettagli();

        //Creo una sim e ci carico 3 telefonate
        SIM s = new SIM("3493827841", "Iliad", 23.00, Tipologia.PRIVATO);

        //posso inserire una telefonata creando un oggetto telefonata
        s.inserisciTelefonataInviata(t);
        s.inserisciTelefonataInviata(new Telefonata("0861234567",
                LocalDateTime.of(2022,11,1,11,23),
                LocalTime.of(0,32,44)));
        s.inserisciTelefonataInviata(new Telefonata("085455667",
                LocalDateTime.of(2022,10,21,9,36),
                LocalTime.of(1,10,43)));

        //oppure inserendo una chiamata new direttamente nel parametro
        s.inserisciTelefonataRicevuta(new Telefonata("0861123456",
                LocalDateTime.of(2022,11,13,10,20),
                LocalTime.of(0,12,24)));

        s.totaleChiamate();


        s.stampaChiamate();
    }
}
