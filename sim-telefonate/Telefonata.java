import java.time.LocalDateTime;
import java.time.LocalTime;

public class Telefonata
{
    // ATTRIBUTI
    private String          numeroChiamante;
    private LocalDateTime   ricevuta;
    private LocalTime       durata;

    // COSTRUTTORI

    //Costruttore vuoto
    public Telefonata() {}

    public Telefonata(String numeroChiamante, LocalDateTime ricevuta, LocalTime durata)
    {
        this.numeroChiamante = numeroChiamante;
        this.ricevuta = ricevuta;
        this.durata = durata;
    }

    //Costruttore di copia
    public Telefonata(Telefonata _t)
    {
        this.numeroChiamante =_t.getNumeroChiamante();
        this.ricevuta = _t.getRicevuta();
        this.durata = _t.getDurata();
    }


    // METODI DI ACCESSO
    public String getNumeroChiamante() {
        return numeroChiamante;
    }

    public void setNumeroChiamante(String numeroChiamante) {
        this.numeroChiamante = numeroChiamante;
    }

    public LocalDateTime getRicevuta() {
        return ricevuta;
    }

    public void setRicevuta(LocalDateTime ricevuta) {
        this.ricevuta = ricevuta;
    }

    public LocalTime getDurata() {
        return durata;
    }

    public void setDurata(LocalTime durata) {
        this.durata = durata;
    }

    //METODI ACCESSORI
    public void stampaDettagli()
    {
        System.out.println("|-----------------------------------|");
        System.out.println("|             TELEFONATA            |");
        System.out.println("|-----------------------------------|");
        System.out.println("| Numero     : " + String.format("%-21s", this.numeroChiamante) + "|");
        System.out.println("| Ricevuta il: " + String.format("%-21s", this.ricevuta.toLocalDate()) + "|");
        System.out.println("| Alle ore   : " + String.format("%-21s", this.ricevuta.toLocalTime()) + "|");
        System.out.println("| Durata     : " + String.format("%-21s", this.durata) + "|");
        System.out.println("|-----------------------------------|");

    }
}
