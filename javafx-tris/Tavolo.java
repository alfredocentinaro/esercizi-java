package iis.tris;

import java.util.ArrayList;

public class Tavolo
{
    private ArrayList<Casella> tavolo;
    private int ultimaCarta;
    private Turno turno;

    public Tavolo()
    {
        this.tavolo = new ArrayList<>();
        this.turno = Turno.Giocatore_O;
        this.ultimaCarta = -1;
    }

    public int getUltimaCarta() {
        return ultimaCarta;
    }

    public void setUltimaCarta(int ultimaCarta) {
        this.ultimaCarta = ultimaCarta;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Casella get(int i)
    {
        return this.tavolo.get(i);
    }

    public void inserisci(Casella c)
    {
        this.tavolo.add(c);
    }

    /*
    *   La caselle sono disposte come segue
    *    0  1  2
    *    3  4  5
    *    6  7  8
    */
    public boolean controllaVincitore()
    {
        //Controllo le righe
        if(tavolo.get(0).getScelta() == tavolo.get(1).getScelta() &&
                tavolo.get(0).getScelta() == tavolo.get(2).getScelta() &&
                tavolo.get(0).getScelta() != Scelta.Vuota)
            return true;

        if(tavolo.get(3).getScelta() == tavolo.get(4).getScelta() &&
                tavolo.get(3).getScelta() == tavolo.get(5).getScelta()&&
                tavolo.get(3).getScelta() != Scelta.Vuota)

            return true;

        if(tavolo.get(6).getScelta() == tavolo.get(7).getScelta() &&
                tavolo.get(6).getScelta() == tavolo.get(8).getScelta() &&
                tavolo.get(6).getScelta() != Scelta.Vuota)
            return true;

        //Controllo le colonne
        if(tavolo.get(0).getScelta() == tavolo.get(3).getScelta() &&
                tavolo.get(0).getScelta() == tavolo.get(6).getScelta()&&
                tavolo.get(0).getScelta() != Scelta.Vuota)
            return true;

        if(tavolo.get(1).getScelta() == tavolo.get(4).getScelta() &&
                tavolo.get(1).getScelta() == tavolo.get(7).getScelta()&&
                tavolo.get(1).getScelta() != Scelta.Vuota)
            return true;

        if(tavolo.get(2).getScelta() == tavolo.get(5).getScelta() &&
                tavolo.get(2).getScelta() == tavolo.get(8).getScelta()&&
                tavolo.get(2).getScelta() != Scelta.Vuota)
            return true;

        //Controllo le diagonali
        if(tavolo.get(2).getScelta() == tavolo.get(4).getScelta() &&
                tavolo.get(2).getScelta() == tavolo.get(6).getScelta()&&
                tavolo.get(2).getScelta() != Scelta.Vuota)
            return true;

        if(tavolo.get(0).getScelta() == tavolo.get(4).getScelta() &&
                tavolo.get(0).getScelta() == tavolo.get(8).getScelta()&&
                tavolo.get(0).getScelta() != Scelta.Vuota)
            return true;

        return false;
    }

    public Scelta vincitore()
    {
        //Controllo le righe
        if(tavolo.get(0).getScelta() == tavolo.get(1).getScelta() &&
                tavolo.get(0).getScelta() == tavolo.get(2).getScelta())
            return tavolo.get(0).getScelta();

        if(tavolo.get(3).getScelta() == tavolo.get(4).getScelta() &&
                tavolo.get(3).getScelta() == tavolo.get(5).getScelta())
            return tavolo.get(3).getScelta();

        if(tavolo.get(6).getScelta() == tavolo.get(7).getScelta() &&
                tavolo.get(6).getScelta() == tavolo.get(8).getScelta())
            return tavolo.get(6).getScelta();

        //Controllo le colonne
        if(tavolo.get(0).getScelta() == tavolo.get(3).getScelta() &&
                tavolo.get(0).getScelta() == tavolo.get(6).getScelta())
            return tavolo.get(0).getScelta();

        if(tavolo.get(1).getScelta() == tavolo.get(4).getScelta() &&
                tavolo.get(1).getScelta() == tavolo.get(7).getScelta())
            return tavolo.get(1).getScelta();

        if(tavolo.get(2).getScelta() == tavolo.get(5).getScelta() &&
                tavolo.get(2).getScelta() == tavolo.get(8).getScelta())
            return tavolo.get(2).getScelta();

        //Controllo le diagonali
        if(tavolo.get(2).getScelta() == tavolo.get(4).getScelta() &&
                tavolo.get(2).getScelta() == tavolo.get(6).getScelta())
            return tavolo.get(2).getScelta();

        if(tavolo.get(0).getScelta() == tavolo.get(4).getScelta() &&
                tavolo.get(0).getScelta() == tavolo.get(8).getScelta())
            return tavolo.get(0).getScelta();

        return Scelta.Vuota;
    }

    public void nuovaPartita()
    {
        for(int i=0; i < this.tavolo.size(); i++)
        {
            tavolo.get(i).setScelta(Scelta.Vuota);
        }
    }

    public void annullaUltima()
    {
        if (this.ultimaCarta != -1)
        {
            this.tavolo.get(ultimaCarta).setScelta(Scelta.Vuota);
        }
    }
}
