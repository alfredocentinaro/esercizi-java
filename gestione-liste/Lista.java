package liste;

import java.util.Random;

/**
 *
 * @author alfredo centinaro
 */
public class Lista 
{

    private Nodo testa;
    
    public Lista() 
    {
        this.testa = null;
    }
    
    Nodo ultimo()
    {
        Nodo iteratore = this.testa;
        
        if (this.testa == null)
            return null;
        
        while (iteratore.getNext() != null)
        {
            iteratore = iteratore.getNext();
        }    
        return iteratore;
    }      
    
    int lunghezza()
    {
        Nodo iteratore = this.testa;
        int contatore = 0;
        
        if (this.testa == null)
            return 0;
        
        while (iteratore != null)
        {
            contatore++;
            iteratore = iteratore.getNext();
        }      
        
        return contatore;
    }   
    
    Nodo posizione(int _posizione)
    {
        int posizione = 0;        
        Nodo tmp = this.testa; //individua il nodo cercato
        
        while(tmp != null)
        {
            if (posizione == _posizione)
            {
                return tmp;
            }    
            
            tmp = tmp.getNext();
            posizione++;
        }    
        
        return null; //non dovrebbe mai presentarsi!
    }        
    
   
    public void aggiungiInCoda(Nodo n)
    {
        if (this.testa == null)
        {
            this.testa = n;
            return;
        }  
        
        Nodo ultimo = this.ultimo();
        //System.out.println(ultimo.toString());
        ultimo.setNext(n);
        //System.out.println(n.toString());        
    }        
    
    public void aggiungiInCoda(Persona p)
    {
        Nodo n = new Nodo(p);
        
        this.aggiungiInCoda(n);
    } 
    
    public void aggiungiInTesta(Nodo n)
    {
        Nodo tmp = testa;
        this.testa = n;
        this.testa.setNext(tmp);
    }
    
    public void aggiungiInTesta(Persona p)
    {
        Nodo n = new Nodo(p);
        aggiungiInTesta(n);
    }    

    public String toString()
    {
        String stampa = "";
        Nodo tmp = this.testa;

        while(tmp != null)
        {
            stampa += tmp.toString() + "\n"; 
            tmp = tmp.getNext();
        }    
        
        return stampa;
    }   
    
    public void eliminaPerNomeCognome(String _nome, String _cognome)
    {
        Nodo tmp = this.testa; //individua il nodo cercato
        Nodo precedente = null; //tiene traccia del nodo prima di quello cercato 
        
        while(tmp != null)
        {
            if (tmp.info.getNome() == _nome && tmp.info.getCognome() == _cognome)
            {
                //trovato il nodo, "cucio" il precedente, annullo il trovato
                precedente.setNext(tmp.getNext());
                tmp = null;    
                return; //forzo uscita finita l'eliminazione
            }    
            
            precedente = tmp;
            tmp = tmp.getNext();
        }     
    }   
    
    public void eliminaInTesta()
    {
        this.testa = this.testa.getNext();
    }        
    
    public void eliminaInPosizione(int _posizione)
    {
        int posizione = 0;        
        Nodo tmp = this.testa; //individua il nodo cercato
        Nodo precedente = null; //tiene traccia del nodo prima di quello cercato 
        
        if (_posizione == 0)
        {    
            this.eliminaInTesta();
            return;
        }        
        
        while(tmp != null)
        {
            if (posizione == _posizione)
            {
                //trovato il nodo, "cucio" il precedente, annullo il trovato
                // se non è l'ultimo
                if (tmp.getNext() != null)
                    precedente.setNext(tmp.getNext());
                //annullo il nodo trovato
                tmp = null;    
                return; //forzo uscita finita l'eliminazione
            }    
            
            precedente = tmp;
            tmp = tmp.getNext();
            posizione++;
        }     
    }         
    
    
    public void aggiungiInPosizione(Nodo n, int _posizione)
    {
        int posizione = 0;
        Nodo tmp = this.testa;
        Nodo precedente = null; //tiene traccia del nodo prima di quello cercato         

        if (_posizione == 0)
        {    
            this.aggiungiInTesta(n);
            return;
        }
        
        while(tmp != null)
        {
            if (posizione == _posizione)
            {
                precedente.setNext(n);
                n.setNext(tmp);
                return;
            }    
            
            precedente = tmp;            
            tmp = tmp.getNext();
            posizione++;
        }     
    }     
    
    public void aggiungiInPosizione(Persona p, int _posizione)
    {
        Nodo n = new Nodo(p);
        aggiungiInPosizione(n,_posizione);
    }    
    
    public void aggiungiInPosizioneCasuale(Persona p)
    {
        Nodo n = new Nodo(p);
        Random r = new Random();
        int posizione = r.nextInt(0, this.lunghezza());
        aggiungiInPosizione(n, posizione);
    }       
    
    public int annoDiNascitaMedio()
    {
        int media = 0;
        int somma = 0;
        Nodo iteratore = this.testa;

        while(iteratore != null)
        {
            somma += iteratore.getInfo().getAnnonascita();
            iteratore = iteratore.getNext();
        }   
        
        media = (int)(somma / this.lunghezza());
        
        return media;
    }
    
    /**
     * sposta il nodo in _posizione alla _posizione -1
     * @param _posizione
     */
    public void spostaNodoAlPrecedente(int _posizione)
    {
        Nodo posizione = this.posizione(_posizione);
        Nodo precedente = this.posizione(_posizione - 1);
        Nodo pre_precedente = this.posizione(_posizione - 2);
        
        if (_posizione > 1)
        {
            pre_precedente.setNext(posizione);
            precedente.setNext(posizione.getNext());
            posizione.setNext(precedente);              
        }   
        
        if (_posizione == 1) //invertire testa con prim nodo
        {
            //scambio testa e secondo nodo!
            Nodo tmp = this.testa;
            this.testa = posizione;
            tmp.setNext(posizione.getNext());
            this.testa.setNext(tmp);
            System.out.println("Scambio in testa");
        }    

    }      
    
    public void spostaNodoAlSuccessivo(int _posizione)
    {
        Nodo posizione = this.posizione(_posizione);
        Nodo successivo = posizione.getNext();
        Nodo precedente = this.posizione(_posizione -1);
        
        precedente.setNext(successivo);
        posizione.setNext(successivo.getNext());
        successivo.setNext(posizione);
    }         
    
    /**
     * qui imbroglio, non sposto proprio il nodo 
     * ma i loro contenuti
     * TODO: prevedere la versione con taglia e cuci dei due nodi
     * @param da posizione 
     * @param a  posizione 
     */
    public void spostaNodo(int da, int a)
    {
        Nodo nodoDa = this.posizione(da);
        Nodo nodoA = this.posizione(a);
        Nodo nodoTMP;
        
        nodoTMP = new Nodo(nodoDa);
        nodoDa.setInfo(nodoA.getInfo());
        nodoA.setInfo(nodoTMP.getInfo());
        
    }     
    
    public void riordinoCasuale()
    {
        //creo una lista copia
        Nodo new_head;
        Nodo iteratore;
        int posizione = 0;
        boolean duplicato = true;
        
        Random r = new Random();
        int[] numeriCasuali = new int[100];
        for (int i =0; i < this.lunghezza(); i++)
        {
            while(duplicato)
            {
                posizione = r.nextInt(0, this.lunghezza());
                duplicato = false;
                for (int j =0; j < i; j++)
                    if (posizione == numeriCasuali[j] )
                        duplicato = true;
            }    
            duplicato = true;
            numeriCasuali[i]= posizione;

        }    
        
        //scelgo un elemento da mettere/copiare in testa
        //System.out.print(posizione);
        new_head = new Nodo(this.posizione(numeriCasuali[0]));
        iteratore = new_head;
        for (int i =1; i < this.lunghezza(); i++)
        {
            posizione = numeriCasuali[i];  
            //System.out.println(posizione);
            iteratore.setNext(new Nodo(this.posizione(numeriCasuali[i])));
            iteratore = iteratore.getNext();
        }    
  
        //sovrascrivo la lista originale con la copia
        this.testa = new_head;   
    }
    
    public void ordinaPerDataNascita()
    {
        Nodo iteratore1;
        Nodo iteratore2;
        
        for (int i = 0; i < (this.lunghezza()-1); i++)
        {
            iteratore1 = this.posizione(i);
            for (int j=i+1; j < (this.lunghezza()); j++)
            {
                iteratore2 = this.posizione(j);
                if (iteratore2.getInfo().getAnnonascita() < 
                        iteratore1.getInfo().getAnnonascita())
                {
                    this.spostaNodo(i, j);
                }    
             }
        }    
    }        
}
