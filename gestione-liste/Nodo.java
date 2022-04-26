package liste;

/**
 *
 * @author alfredo centinaro
 */
public class Nodo 
{
    
    protected Persona info;
    protected Nodo    next;

    //costruttori
    public Nodo() 
    {
        this.info = null;
        this.next = null;
    }

    public Nodo(Persona p) 
    {
        this.info = p;
        this.next = null;
    }

    public Nodo(Nodo n) 
    {
        this.info = n.getInfo();
        this.next = null;
    }
    
    public Persona getInfo() {
        return info;
    }

    public void setInfo(Persona info) {
        this.info = info;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.info.toString();
    }

}
