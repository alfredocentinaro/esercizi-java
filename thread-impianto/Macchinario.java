package iisteramo.schedediretethread;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfredo centinaro
 */
public class Macchinario extends Thread
{
    private String  idMacchina;
    private int     qtaProdotta; //max 100
    private boolean produci;
    
    public static Seriale serialeScheda;

    public Macchinario(String idMacchina, Seriale sc) 
    {
        this.idMacchina     = idMacchina;
        this.qtaProdotta    = 0;
        this.produci        = true;
        this.serialeScheda  = sc;
    }
    
    public Macchinario(String idMacchina, int qtaProdotta) 
    {
        this.idMacchina = idMacchina;
        this.qtaProdotta = qtaProdotta;
        this.produci        = true;
    }

    public boolean isProduci() {
        return produci;
    }

    public void setProduci(boolean produci) {
        this.produci = produci;
    }

    public String getIdMacchina() {
        return idMacchina;
    }

    public void setIdMacchina(String idMacchina) {
        this.idMacchina = idMacchina;
    }

    public int getQtaProdotta() {
        return qtaProdotta;
    }

    public void setQtaProdotta(int qtaProdotta) {
        this.qtaProdotta = qtaProdotta;
    }
   
    
    public void produciScheda()
    {
        //tempo variabile tra 2 e 5 secondi
        Random rand = new Random();
        int tempoProduzione = 1000 *(rand.nextInt(6)+2);
        try 
        {
            Thread.sleep(rand.nextInt(tempoProduzione));
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(Macchinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int serialeStampato= Macchinario.serialeScheda.incrementa();
        this.qtaProdotta++;
        
        System.out.println("Scheda: "+this.idMacchina + " - "+ serialeStampato);
    }        

    @Override
    public void run()
    {
        while (this.qtaProdotta < 100 && this.produci == true)
        {
            this.produciScheda();
        }    
    }
}
