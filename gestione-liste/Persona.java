package liste;

/**
 *
 * @author alfredo centinaro
 */
class Persona {

    // Attributi
    private String  nome;
    private String  cognome;
    private String  indirizzo;
    private int     annonascita;
    private char    sesso;        

    // Costruttori
    public Persona() 
    {
        this.nome = "";
        this.cognome = "";
        this.indirizzo = "";
        this.annonascita = 1970; 
        this.sesso = 'M';
    }

    public Persona(String nome, String cognome, String indirizzo, int annonascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.annonascita = annonascita;
        this.sesso = 'M';
    }
    
    public Persona(String nome, String cognome, String indirizzo, int annonascita, char sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.annonascita = annonascita;
        this.sesso = sesso;
    } 

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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getAnnonascita() {
        return annonascita;
    }

    public void setAnnonascita(int annonascita) {
        this.annonascita = annonascita;
    }

    @Override
    public String toString() {
        return "Persona{" + "nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + ", annonascita=" + annonascita + '}';
    }


}
