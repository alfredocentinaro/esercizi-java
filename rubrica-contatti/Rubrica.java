import java.util.ArrayList;

public class Rubrica
{
    // ATTRIBUTI
    private String proprietario;
    private ArrayList<Contatto> lista;

    // COSTRUTTORI
    public Rubrica()
    {
        this.lista = new ArrayList<>(); //se non rispecifico il tipo Contatto usa polimorfismo in automatico
    }

    public Rubrica(String proprietario)
    {
        this();
        this.proprietario = proprietario;
    }


    // MEDOTI DI ACCESSO

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }


    // METODI ACCESSORI
    public void inserisciContatto(Contatto _c)
    {
        try
        {
            this.lista.add(_c);
        }
        catch(Exception e)
        {
            System.out.println("ERRORE DI INSERIMENTO");
        }

    }

    public Contatto cercaContattoPerNome(String _nome)
    {
        for (int i=0; i < lista.size(); i++)
        {
            if (lista.get(i).getNome() == _nome)
            {
                return lista.get(i);
            }
        }

        return null;
    }

    public int cercaPosizioneContattoPerNome(String _nome)
    {
        for (int i=0; i < lista.size(); i++)
        {
            if (lista.get(i).getNome() == _nome)
            {
                return i;
            }
        }

        return -1;
    }

    public void cancellaContatto(int _posizione)
    {
        try
        {
            this.lista.remove(_posizione);
        }
        catch(Exception e)
        {
            System.out.println("ERRORE DI CANCELLAZIONE");
        }
    }

    public void stampaContatti()
    {
        for (int i=0; i < lista.size(); i++)
        {
            lista.get(i).stampaInfo();
        }
    }
}
