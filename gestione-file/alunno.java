package iisteramo.file;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alfredo centinaro
 */
public class Alunno 
{
    String  nome;
    String  cognome;
    Date    nascita;
    double  peso;
    char    sesso;
    int     altezza;

    public Alunno() {
    }

    public Alunno(String nome, String cognome, Date nascita, double peso, char sesso, int altezza) {
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
        this.peso = peso;
        this.sesso = sesso;
        this.altezza = altezza;
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

    public Date getNascita() {
        return nascita;
    }

    public void setNascita(Date nascita) {
        this.nascita = nascita;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }
     
    public String toRecord()
    {
        return this.nome        + ";" + 
                this.cognome    + ";" +
                new SimpleDateFormat("dd/MM/yyyy").format(this.nascita)  + ";" + 
                this.peso       + ";" +
                this.sesso      + ";" +
                this.altezza    +
                ";";
    }        
}
