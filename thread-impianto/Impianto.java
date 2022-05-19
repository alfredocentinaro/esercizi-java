package iisteramo.schedediretethread;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfredo centinaro
 */
public class Impianto extends Thread
{
    Macchinario m1;
    Macchinario m2;
    Macchinario m3;

    public Impianto(Macchinario m1, Macchinario m2, Macchinario m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }
    
    @Override
    public void run()
    {
        //avvio da tastiera
        while(true)
        {
            System.out.print("Premi invio per iniziare la produzione. Ripremilo per fermarla");
            try {
                char tastiera = (char) System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(Impianto.class.getName()).log(Level.SEVERE, null, ex);
            }            
            m1.start();
            m2.start();
            m3.start();
            break;
        }    
        

        //interruzione da tastiera
        while(true)
        {
            try {
                char tastiera = (char) System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(Impianto.class.getName()).log(Level.SEVERE, null, ex);
            }
            m1.setProduci(false);
            m2.setProduci(false);
            m3.setProduci(false);
            
            try 
            {
                m1.join();
                m2.join();
                m3.join();

            } catch (InterruptedException ex) 
            {
                Logger.getLogger(Schedediretethread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.interrupt();         
            break;
        }   
        
        //stampa qta prodotta sia che sia stoppato che conclusione normale
        int qta = m1.getQtaProdotta() + m2.getQtaProdotta() + m3.getQtaProdotta();
        System.out.println("\n Quantità prodotta: " + qta);         
    }
}
