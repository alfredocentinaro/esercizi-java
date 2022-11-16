import java.time.*;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

enum Tipologia {PRIVATO, AZIENDALE}

public class SIM
{
    // ATTRIBUTI

    private String    numero;
    private String    compagnia;
    private double    credito;
    private Tipologia tipoContratto;
    private ArrayList<Telefonata> telefonateRicevute;
    private ArrayList<Telefonata> telefonateInviate;

    // COSTRUTTORI

    public SIM()
    {
        telefonateRicevute = new ArrayList<Telefonata>();
        telefonateInviate = new ArrayList<Telefonata>();
    }

    public SIM(String numero, String compagnia, double credito, Tipologia tipoContratto) {
        this();
        this.numero = numero;
        this.compagnia = compagnia;
        this.credito = credito;
        this.tipoContratto = tipoContratto;
    }

    // METODI DI ACCESSO

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCompagnia() {
        return compagnia;
    }

    public void setCompagnia(String compagnia) {
        this.compagnia = compagnia;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public Tipologia getTipoContratto() {
        return tipoContratto;
    }

    public void setTipoContratto(Tipologia tipoContratto) {
        this.tipoContratto = tipoContratto;
    }

    public ArrayList<Telefonata> getTelefonateRicevute() {
        return telefonateRicevute;
    }

    public void setTelefonateRicevute(ArrayList<Telefonata> telefonateRicevute) {
        this.telefonateRicevute = telefonateRicevute;
    }

    public ArrayList<Telefonata> getTelefonateInviate() {
        return telefonateInviate;
    }

    public void setTelefonateInviate(ArrayList<Telefonata> telefonateInviate) {
        this.telefonateInviate = telefonateInviate;
    }


    //METODI ACCESSORI
    public void inserisciTelefonataRicevuta(Telefonata _t)
    {
        this.telefonateRicevute.add(_t);
    }

    public void inserisciTelefonataInviata(Telefonata _t)
    {
        this.telefonateInviate.add(_t);
    }

    //cerca un numero di telefono tra le chiamate e restituisce l'indice della posizione
    //se non trova nulla non posso tornare un indice ovviamente e torno un valore -1
    public int cercaTelefonataRicevuta(Telefonata _t)
    {
        for(int i = 0; i < telefonateRicevute.size(); i++ )
        {
            if (this.telefonateRicevute.get(i).getNumeroChiamante() == _t.getNumeroChiamante())
                return i;
        }
        return -1;
    }

    //cerca un numero di telefono tra le chiamate e restituisce l'indice della posizione
    //se non trova nulla non posso tornare un indice ovviamente e torno un valore -1
    public int cercaTelefonataInviata(Telefonata _t)
    {
        for(int i= 0; i < telefonateInviate.size(); i++ )
        {
            if (this.telefonateInviate.get(i).getNumeroChiamante() == _t.getNumeroChiamante())
                return i;
        }
        return -1;
    }

    //cerca un numero di telefono tra le chiamate e restituisce l'indice della posizione
    //se non trova nulla non posso tornare un indice ovviamente e torno un valore -1
    public int cercaTelefonataRicevuta(String _t)
    {
        for(int i = 0; i < telefonateRicevute.size(); i++ )
        {
            if (this.telefonateRicevute.get(i).getNumeroChiamante() == _t)
                return i;
        }
        return -1;
    }

    //cerca un numero di telefono tra le chiamate e restituisce l'indice della posizione
    //se non trova nulla non posso tornare un indice ovviamente e torno un valore -1
    public int cercaTelefonataInviata(String _t)
    {
        for(int i= 0; i < telefonateInviate.size(); i++ )
        {
            if (this.telefonateInviate.get(i).getNumeroChiamante() == _t)
                return i;
        }
        return -1;
    }




    //cerca un numero di telefono tra le chiamate e restituisce l'indice della posizione
    public void cancellaelefonataRicevuta(Telefonata _t)
    {
        for(int i = 0; i < telefonateRicevute.size(); i++ )
        {
            if (this.telefonateRicevute.get(i).getNumeroChiamante() == _t.getNumeroChiamante())
            {
                this.telefonateRicevute.remove(i);
            }

        }
    }

    //cerca un numero di telefono tra le chiamate e lo elimina con l'indice della posizione
    public void cancellaTelefonataInviata(Telefonata _t)
    {
        for(int i= 0; i < telefonateInviate.size(); i++ )
        {
            if (this.telefonateInviate.get(i).getNumeroChiamante() == _t.getNumeroChiamante())
            {
                this.telefonateRicevute.remove(i);
            }
        }
    }

    //cerca un numero di telefono tra le chiamate e restituisce l'indice della posizione
    public void cancellaelefonataRicevuta(String _t)
    {
        for(int i = 0; i < telefonateRicevute.size(); i++ )
        {
            if (this.telefonateRicevute.get(i).getNumeroChiamante() == _t)
            {
                this.telefonateRicevute.remove(i);
            }

        }
    }

    //cerca un numero di telefono tra le chiamate e lo elimina con l'indice della posizione
    public void cancellaTelefonataInviata(String _t)
    {
        for(int i= 0; i < telefonateInviate.size(); i++ )
        {
            if (this.telefonateInviate.get(i).getNumeroChiamante() == _t)
            {
                this.telefonateRicevute.remove(i);
            }
        }
    }

    public void svuotaElenchi()
    {
        for(int i= 0; i < this.telefonateInviate.size(); i++ )
        {
            this.telefonateInviate.remove(i);
        }

        for(int i = 0; i < this.telefonateRicevute.size(); i++ )
        {
            this.telefonateRicevute.remove(i);
        }
    }

    public void totaleChiamate()
    {
        long durataTot = 0;
        long durataTotTelefonateInviate = 0;
        long durataTotTelefonateRicevute= 0;
        for(int i= 0; i < this.telefonateInviate.size(); i++ )
        {
            durataTotTelefonateInviate += this.telefonateInviate.get(i).getDurata().toSecondOfDay();
        }

        for(int i = 0; i < this.telefonateRicevute.size(); i++ )
        {
            durataTotTelefonateRicevute += this.telefonateRicevute.get(i).getDurata().toSecondOfDay();
        }

        durataTot = durataTotTelefonateInviate + durataTotTelefonateRicevute;

        long giorni = TimeUnit.SECONDS.toDays(durataTot);
        long ore = TimeUnit.SECONDS.toHours(durataTot) - TimeUnit.DAYS.toHours(giorni);
        long minuti = TimeUnit.SECONDS.toMinutes(durataTot) - TimeUnit.HOURS.toMinutes(ore) - TimeUnit.DAYS.toMinutes(giorni);
        long secondi= durataTot - TimeUnit.MINUTES.toSeconds(minuti) -TimeUnit.HOURS.toSeconds(ore) - TimeUnit.DAYS.toSeconds(giorni);

        System.out.println("Durata totale delle chiamate: " + giorni + "g " + ore + "h " + minuti + "m " + secondi + "s");
        //analogamente si possono stampare per durataTotTelefonateInviate e durataTotTelefonateRicevute

    }

    public void stampaChiamate()
    {
        for(int i= 0; i < this.telefonateInviate.size(); i++ )
        {
            this.telefonateInviate.get(i).stampaDettagli();
        }

        for(int i= 0; i < this.telefonateRicevute.size(); i++ )
        {
            this.telefonateRicevute.get(i).stampaDettagli();
        }

    }
}
