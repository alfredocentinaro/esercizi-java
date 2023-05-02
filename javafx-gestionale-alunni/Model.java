package iis.alessandrini.tabellefx;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Model
{
    private URL nomeFile = AlunniApplication.class.getResource("dati.csv");
    private ArrayList<Alunno> alunni;
    private int id;

    public Model()
    {
        this.alunni = new ArrayList<Alunno>();
    }

    public int size()
    {
        return this.alunni.size();
    }

    public Alunno get(int i)
    {
        return this.alunni.get(i);
    }

    public void scrivi()
    {
        try
        {
            FileWriter file = new FileWriter(this.nomeFile.getPath(), false);  //true = append
            BufferedWriter output = new BufferedWriter(file);
            System.out.println("Sto scrivendo su "+this.nomeFile.getPath());
            for (int i=0; i < this.alunni.size(); i++)
            {
                output.write(this.alunni.get(i).toStringCSV());
                output.newLine();
            }

            //output.flush();
            output.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void scrivi(String _record)
    {

        try
        {
            FileWriter file = new FileWriter(this.nomeFile.getPath(), true);  //true = append
            BufferedWriter output = new BufferedWriter(file);
            System.out.println("Sto scrivendo su "+this.nomeFile.getPath());
            System.out.println(_record);
            output.write(_record);
            output.newLine();
            //output.flush();
            output.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
    public void leggi() throws FileNotFoundException, IOException, ParseException
    {
        BufferedReader in
                = new BufferedReader(new FileReader(this.nomeFile.getPath()));
        String linea = in.readLine();
        String lineaSplit[];

        while (linea != null)
        {
            lineaSplit = linea.split(";");  //carattere separatore

            int id          = Integer.valueOf(lineaSplit[0]);
            String nome     = lineaSplit[1];
            String cognome  = lineaSplit[2];
            String classe   = lineaSplit[3];
            LocalDate nato  = LocalDate.parse(lineaSplit[4],DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String indirizzo= lineaSplit[5];
            Sesso  sesso    = Sesso.valueOf(lineaSplit[6]);

            this.alunni.add(new Alunno(id, nome, cognome, classe, nato, indirizzo, sesso));

            /*
            * Prendo l'id massimo del file per staccare i lsuccessivo
            * Non è esattamente realistico: i gestionali hanno file/tabelle delle sequenze indici progressivi a parte
            * e ricominciano sempre da quelli, anche se con buchi
            * */
            if (id > this.id)
                this.id = id;

            //System.out.println("-----------------------------"); //scommenta solo per DEBUG
            //System.out.println(al.toRecord());  //scommenta solo per DEBUG

            linea = in.readLine(); //leggi prossima linea
        }
    }

    /*
    * Restiusice il prossimo numero di sequenza valido
    **/
    public int seq()
    {
        return this.id + 1;
    }

    public void add(Alunno a)
    {
        //aggiungo all'array list
        a.setId(this.seq()) ;
        this.alunni.add(a);
        //System.out.println(this.alunni.toString());

        //scrivo su file
        this.scrivi(a.toStringCSV());
    }

    public void remove(Alunno a)
    {
        if(this.alunni.remove(a))
        {
            //cancello da file ovvero riscrivo tutto il vettore

            try
            {
                FileWriter file = new FileWriter(this.nomeFile.getPath(), false);  //true = append
                BufferedWriter output = new BufferedWriter(file);
                System.out.println("Sto scrivendo su "+this.nomeFile.getPath());
                for (int i=0; i < this.alunni.size(); i++)
                {
                    output.write(this.alunni.get(i).toStringCSV());
                    output.newLine();
                }

                //output.flush();
                output.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
