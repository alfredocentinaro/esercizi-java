package liste;

/**
 *
 * @author alfredo centinaro
 */
public class Main {
    
    public static void main(String[] args) 
    {
        Lista lis = new Lista();
        
        lis.aggiungiInCoda(new Persona("Alfredo", "Centinaro", "paizza Garibaldi 4", 1982));
        lis.aggiungiInCoda(new Persona("Mario", "Rossi", "paizza Verdi 10", 1980));
        lis.aggiungiInCoda(new Persona("Luigi", "Pallavicini", "paizza Covour 21", 1992));
        lis.aggiungiInCoda(new Persona("Ludovico", "Betoven", "via Mozart 1", 1770));       
        lis.aggiungiInCoda(new Persona("Leonardo", "Da Vinci", "via firenze 11", 1452));
        
        System.out.println("------------------------------------------------------------------------");            
        System.out.println("Lista: ");
        System.out.print(lis.toString());
        
        System.out.println("------------------------------------------------------------------------");            
        System.out.println("Lunghezza lista: " + lis.lunghezza());
        
        System.out.println("Anno medio: " + lis.annoDiNascitaMedio());        
    
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------");  
        
        lis.aggiungiInTesta(new Persona("Dante", "Alighieri", "via dei Guelfi 29", 1200));
        
        System.out.println("Lista Aggiunto in testa: ");
        System.out.print(lis.toString());
        
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------"); 
        System.out.println("Elimina per nome/cognome: ");
        
        lis.eliminaPerNomeCognome("Mario", "Rossi");
        
        System.out.print(lis.toString());    
        
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------"); 
        System.out.println("Aggiungi in posizione 1 (parto da 0): ");
        
        lis.aggiungiInPosizione(new Persona("Cristoforo", "Colombo", "via Vespucci 11", 1450),1);
        
        System.out.print(lis.toString());      
        
        
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------"); 
        System.out.println("Elimina in testa: ");
        
        lis.eliminaInTesta();
        
        System.out.print(lis.toString()); 
        
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------"); 
        System.out.println("Elimina in posizione 2: ");
        
        lis.eliminaInPosizione(2);
        
        System.out.print(lis.toString());       
        
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------"); 
        System.out.println("Aggiungi in posizione casuale: ");
        
        lis.aggiungiInPosizioneCasuale(new Persona("Alessandro", "Manzoni", "via Napoleone 12", 1745));
        
        System.out.print(lis.toString());         
        
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------"); 
        System.out.println("Sposta in posizione precedente il 4: ");    
        System.out.print("PRIMA: \n" + lis.toString());
        lis.spostaNodoAlPrecedente(4);
        System.out.print("DOPO: \n" + lis.toString());
        
        
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------"); 
        System.out.println("Sposta in posizione successiva il 4: ");    
        System.out.print("PRIMA: \n" + lis.toString());
        lis.spostaNodoAlSuccessivo(3);
        System.out.print("DOPO: \n" + lis.toString());        
    
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------"); 
        System.out.println("Riordino casuale: ");    
        System.out.print("PRIMA: \n" + lis.toString());
        lis.riordinoCasuale();
        System.out.print("DOPO: \n" + lis.toString());  
        
        System.out.println(""); 
        System.out.println("------------------------------------------------------------------------"); 
        System.out.println("Riordino per data: ");    
        System.out.print("PRIMA: \n" + lis.toString());
        lis.ordinaPerDataNascita();
        System.out.print("DOPO: \n" + lis.toString());         
    }
}
