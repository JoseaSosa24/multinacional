/*
----------------
      Nodo 
----------------
-Dato: objeto
- izq: Nodo
- der: Nodo
----------------
Nodo()
Nodo(d)
DestructorNodo()
----------------

*/

package multinacional;

 import java.util.logging.Level;
import java.util.logging.Logger;

public class nodo  
{
   
    //atributos propios de la clase
    private Object dato;
    private nodo izq, der;

//constructor vacio
    public nodo()
    {}
    //fin método Nodo

    /*constructor que recibe el dato 
    y crea el nodo con su información
     y coloca las ligas en null*/
    public nodo(Object d)
    {
        dato=d;
        izq=null;
        der=null;
    }//fin método Nodo

    //destructor ojo, este metodo finaliza se  genera
    
    @Override
    public void finalize()
    {   try {
        super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(nodo.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public nodo getIzq() {
        return izq;
    }

    public void setIzq(nodo izq) {
        this.izq = izq;
    }

    public nodo getDer() {
        return der;
    }

    public void setDer(nodo der) {
        this.der = der;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
    
    
   
}//fin clase nodo


    

