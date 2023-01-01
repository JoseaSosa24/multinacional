
package multinacional;

import javax.swing.JOptionPane;


public class Pila {
          //atributos propios y privados
    private int max;
    private int top;
    private Persona pila[];
    
    //constructores
    public Pila()
    {}
    public Pila(int n)
    {
        max=n;
        pila=new Persona[max];
        top=-1;
    }
    
    public boolean IsFull()
    {
        if (top==max-1)
        {
            //JOptionPane.showMessageDialog(null,"*****Pila LLena DESBORDAMIENTO DE PILA*****");//OPCIONAL
            return true;
        }
        else
        {
           return false;
        }//fin si
    }//fin de is full - pilallena
    
    public boolean IsEmpty()
    {
        if (top==-1)
        {
            //JOptionPane.showMessageDialog(null,"*****Pila Vacia SUBDESBORDAMIENTO DE PILA*****");//OPCIONAL
            return true;
        }
        else
        {
           return false;
        }//fin sireturn ;
    }//fi de is empty - pilavacia
    
    public void Push(Persona d)
    {
        if(IsFull()==false)
        {
            top=top + 1;
            pila[top]=d;
        }
        //opcional avisarle al usuario "pila LLENA..Desbordamiento de pila"
    }//fin de push - apilar
    
    public Persona Pop()
    {
        Persona d=null;
        if(IsEmpty()==false)
        {
            d=pila[top];
            pila[top]=null;//opcional
            top=top - 1;
        }    
        return d;
        //opcional avisarle al usuario "pila VACIA..sUBDesbordamiento de pila"
    }//fin  de pop - desapilar
    
    public int getTop(){
        return top;
    }
    
}
