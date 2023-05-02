package iis.alessandrini.tabellefx;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alunno
{
    private int         id;
    private String      nome;
    private String      cognome;
    private String      classe;
    private LocalDate   nascita;
    private String      indirizzo;

    private Sesso       sesso;

    public Alunno(int id, String nome, String cognome, String classe, LocalDate nascita, String indirizzo, Sesso sesso)
    {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.classe = classe;
        this.nascita = nascita;
        this.indirizzo = indirizzo;
        this.sesso = sesso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public String toStringCSV()
    {
        return this.id + ";" +
                this.nome + ";" +
                this.cognome + ";" +
                this.classe + ";" +
                this.nascita.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";" +
                this.indirizzo + ";" +
                this.sesso ;
    }
}
