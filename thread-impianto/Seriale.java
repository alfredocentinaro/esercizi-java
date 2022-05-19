
package iisteramo.schedediretethread;

/**
 *
 * @author alfredo centinaro
 */
public class Seriale 
{
    int progressivo;

    public Seriale(int progressivo) 
    {
        this.progressivo = progressivo;
    }
    
    synchronized public int incrementa()
    {
       return this.progressivo++;
    }      

    synchronized public int getProgressivo() {
        return progressivo;
    }

    synchronized public void setProgressivo(int progressivo) {
        this.progressivo = progressivo;
    }
    
}
