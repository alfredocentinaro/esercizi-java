package iis.tris;

public class Casella
{
    private int     numero;

    private Scelta  scelta;

    public Casella(int numero, Scelta scelta)
    {
        this.numero = numero;
        this.scelta = scelta;
    }

    public Casella(int numero)
    {
        this.numero = numero;
        this.scelta = Scelta.Vuota;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Scelta getScelta() {
        return scelta;
    }

    public void setScelta(Scelta scelta) {
        this.scelta = scelta;
    }
}
