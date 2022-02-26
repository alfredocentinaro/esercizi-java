package iisteramo.file;

/**
 *
 * @author alfredo centinaro
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test 
{
    String nomeFile;

    public String getNomeFile() {
        return nomeFile;
    }

    public void setNomeFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }
    
    public void leggi() throws FileNotFoundException, IOException, ParseException
    {
        BufferedReader in
            = new BufferedReader(new FileReader(this.nomeFile));
        String linea = in.readLine();
        String lineaSplit[];
        
        while (linea != null)
        {
            lineaSplit = linea.split(";");
            String nome = lineaSplit[0];
            String cognome = lineaSplit[1];
            Date   dn = new SimpleDateFormat("dd/MM/yyyy").parse(lineaSplit[2]);
            Double peso = Double.valueOf(lineaSplit[3]);
            char sesso = lineaSplit[4].charAt(0);
            int altezza = Integer.valueOf(lineaSplit[5]);
            
            Alunno al = new Alunno(nome,cognome, dn, peso, sesso, altezza);
            
            System.out.println("-----------------------------");
            System.out.println(al.toRecord());
            
            linea = in.readLine();
        }
        
    }        
    
    public void scrivi(String _record)
    {

        try 
        {
            FileWriter file = new FileWriter(this.nomeFile, true);  //true = append
            BufferedWriter output = new BufferedWriter(file);
            System.out.println("Sto scrivendo... ");
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
    
    public static void main (String[] args) throws ParseException 
    {
        Alunno a1 = new Alunno("Alfredo", "Centinaro", new Date("02/01/1982"), 75.0, 'M', 173);
        Alunno a2 = new Alunno("Mario", "Rossi", new Date("07/07/1977"), 81.0, 'M', 170);
        Alunno a3 = new Alunno("Serena", "Bianchi", new Date("07/07/1990"), 50.0, 'F', 170);  
        
        Test t = new Test();
        t.setNomeFile("prova.txt");
        t.scrivi(a1.toRecord());
        t.scrivi(a2.toRecord());
        t.scrivi(a3.toRecord());
        
         
        try
        {
          System.out.println("Sto leggendo... ");
          t.leggi( );
        }
        catch(FileNotFoundException e){System.out.println("File non esistente");}
        catch(IOException e){System.out.println("Qualcosa è andato storto nella lettura");}  
    }
    
}
