
package multinacional;

import javax.swing.JOptionPane;


public class Cola {
           //atributos propios y privados
    private int max;
    private  int Final,Front;
    private Persona cola[];
    
    //constructores
    public Cola()
    {}
    public Cola(int n)
    {
        max=n;
        cola=new Persona[max];
        Front=Final=-1;
    }
    
    public boolean IsFull()
    {
        if (Final==max-1)
        {
            //JOptionPane.showMessageDialog(null,"*****Cola LLena DESBORDAMIENTO DE COLA*****");//OPCIONAL
            return true;
        }
        else
        {
           return false;
        }//fin si
    }//fin de is full - colallena
    
    public boolean IsEmpty()
    {
         if (Front==-1&&Final==-1)
        {
            //JOptionPane.showMessageDialog(null,"*****Cola Vacia SUBDESBORDAMIENTO DE COLA*****");//OPCIONAL
            return true;
        }
        else
        {
           return false;
        }//fin si
        
    }//fin de is empty - colavacia
    
    public void Push(Persona d)
    {
        if(IsFull()==false)
        {
            Final=Final+1;
            cola[Final]=d;
            if(Final==0)
            {
                Front=0;
            }//fin si
        }//fin si
    }//fin de push - encolar
    
    public Persona Pop()
    {
        Persona d=null;
        if (IsEmpty()==false)
        {
            d=cola[Front];
            if(Front==Final)
            {
                Front=-1;
                Final=-1;
            }
            else
            {
                Front=Front+1;
            }
        }
        return d;
    }//fin de pop - encolar
}
