
package multinacional;

import java.io.*;
import javax.swing.JOptionPane;
//import javax.swing.DefaultListModel;
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
public class Archivos {
    File objFile;
    FileReader objFileReader;
    BufferedReader objBufferedReader;
    FileWriter objFileWriter;
    PrintWriter objPrintWriter;
    
   
    public String abrirArchivoParaLectura(String rutaYnombre){
        String mensaje="ok";
        try{
            objFile= new File(rutaYnombre);
            objFileReader= new FileReader(objFile);
            objBufferedReader = new BufferedReader(objFileReader);
        }
        catch(Exception objException){
            mensaje=objException.getMessage();          
        }
        return mensaje;
    }
    public String cerrarArchivoParaLectura(){
        String mensaje="ok";
        try{
           
           objBufferedReader.close();
        }
        catch(Exception objException){
            mensaje=objException.getMessage();          
        }
        return mensaje;
    }    
        public String abrirArchivoParaEscritura(String rutaYnombre){
        String mensaje="ok";
        try{
            objFile= new File(rutaYnombre);
            objFileWriter= new FileWriter(objFile,true);
            objPrintWriter = new PrintWriter(objFileWriter);
        }
        catch(Exception objException){
            mensaje=objException.getMessage();          
        }
        return mensaje;
    }
    public String cerrarArchivoParaEscritura(){
        String mensaje="ok";
        try{
            
            objPrintWriter.close();
        }
        catch(Exception objException){
            mensaje=objException.getMessage();          
        }
        return mensaje;
    }

    
        public String[] leerUnaLineaDelArchivo(){
        String linea="",mensaje="ok";
        String vec[];
        vec=new String[5];
        try{
            linea=objBufferedReader.readLine();
            vec=linea.split(",");
        }
        catch(Exception objException){
            mensaje=objException.getMessage();          
        }
        return vec;
    }
    public String escribirUnaLineaYAlfrente(String linea){
        String mensaje="ok";
        try{            
            objPrintWriter.print(linea);
            objPrintWriter.println(); 
        }
        catch(Exception objException){
            mensaje=objException.getMessage();          
        }
        return mensaje;
    }    
       public void resetearTxt(String rutaYnombre){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaYnombre));
            bw.write("");
            bw.close();
        }
        catch(Exception objException){
            JOptionPane.showMessageDialog(null, "Error al reiniciar archivo");
        }
        
    }

    
 }