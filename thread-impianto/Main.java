package iisteramo.schedediretethread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfredo centinaro
 */
public class Main 
{

    public static void main(String[] args) 
    {
        //TO DO chiederlo da tastiera?
        Seriale s = new Seriale(100);
        
        Macchinario m1 = new Macchinario("M001",s);
        Macchinario m2 = new Macchinario("M002",s);
        Macchinario m3 = new Macchinario("M003",s);

        Impianto imp = new Impianto(m1,m2,m3);
        imp.start();
        
    }
}
