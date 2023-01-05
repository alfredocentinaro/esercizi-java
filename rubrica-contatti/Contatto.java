enum Tipo  {NessunaEtichetta, Cellulare, Lavoro, Principale};

public class Contatto
{
    // ATTRIBUTI
    private String nome;
    private String cognome;
    private String telefono;
    private Tipo tipotelfono;

    // COSTRUTTORI
    public Contatto(){}

    public Contatto(String nome, String cognome, String telefono, Tipo tipotelfono)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.tipotelfono = tipotelfono;
    }

    public Contatto(Contatto c)
    {
        this.nome = c.getNome();
        this.cognome = c.getCognome();
        this.telefono = c.getTelefono();
        this.tipotelfono = c.getTipotelfono();
    }


    // METODI DI ACCESSO
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Tipo getTipotelfono() {
        return tipotelfono;
    }

    public void setTipotelfono(Tipo tipotelfono) {
        this.tipotelfono = tipotelfono;
    }


    // METODI ACCESSORI
    void stampaInfo()
    {
        System.out.println("|---------------------------------------|");
        System.out.println("|               CONTATTO                |");
        System.out.println("|---------------------------------------|");
        System.out.println("| Nome            : " + String.format("%-20s", this.nome) + "|");
        System.out.println("| Cognome         : " + String.format("%-20s", this.cognome) + "|");
        System.out.println("| Telefono        : " + String.format("%-20s", this.telefono) + "|");
        System.out.println("| Tipo            : " + String.format("%-20s", this.tipotelfono) + "|");
        System.out.println("|---------------------------------------|");
    }
}
