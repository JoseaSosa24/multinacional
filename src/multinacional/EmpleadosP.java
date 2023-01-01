
package multinacional;

import javax.swing.JOptionPane;
;


public class EmpleadosP 
{
    int k = 0;

    public Persona RegistrarEmpleado(Pila pila, Validacion objVal) {
        String info;
        Persona p = null;

        if (!pila.IsFull()) {
            int ident = 0, telefono = 0, celular = 0;
            String nombre = "", apellido = "", direccion = "";
            info = "Digite el ID del empleado #" + (k + 1);
            ident = objVal.ValidarEntero(info, ident);
            info = "Digite el Nombre del empleado #" + (k + 1);
            nombre = objVal.ValidarTexto(info, nombre);
            info = "Digite el Apellido del empleado #" + (k + 1);
            apellido = objVal.ValidarTexto(info, apellido);
            info = "Digite la Dirección del empleado #" + (k + 1);
            direccion = objVal.ValidarTexto(info, direccion);
            info = "Digite el Fijo del Empleado #" + (k + 1);
            telefono = objVal.ValidarEntero(info, telefono);
            info = "Digite el Celular del Empleado #" + (k + 1);
            celular = objVal.ValidarEntero(info, celular);
            p = new Persona(ident, nombre, apellido, direccion, telefono, celular);
            k++;
        } else {
            JOptionPane.showMessageDialog(null, "****¡PILA LLENA!****", "PILA LLENA", JOptionPane.ERROR_MESSAGE);

        }

        return p;
    }
    
    
    public void IngresandoVendedores(Pila objp,Pila objpaux, Multinacional obj, Validacion objVal)
    {
        Persona p;
        int op=0;
        if (!objp.IsFull()) 
        {
               while (!objp.IsEmpty()) 
               {
                 objpaux.Push(objp.Pop());
                }

                   op = JOptionPane.showConfirmDialog(null, "¿Desea ingresar datos del vendedor?", "REGISTRO DE VENDEDORES", JOptionPane.YES_NO_OPTION);
                       while (op == JOptionPane.YES_NO_OPTION) 
                       {
                            p = RegistrarEmpleado(objpaux, objVal);
                                objpaux.Push(p);
                                op = JOptionPane.showConfirmDialog(null, "¿Desea ingresar un nuevo vendedor?", "REGISTRO DE VENDEDORES", JOptionPane.YES_NO_OPTION);
                        }
                           while (!objpaux.IsEmpty()) 
                           {
                             objp.Push(objpaux.Pop());
                           }
            } else {
                    JOptionPane.showMessageDialog(null, "***¡PILA LLENA!***, ***NO PUEDE INGRESAR MÁS VENDEDORES*** ", "PILA LLENA", JOptionPane.ERROR_MESSAGE);
                   }
    }//FININGRESANDOEMPLEADOS
    
    public String ImprimirPila(Pila objp,Pila objpaux)
    {
    
       String cadena = "";
       Persona p2;

        while (!objp.IsEmpty()) 
        {
          p2 = objp.Pop();
          cadena = cadena + "[ " + p2.toString() + " ]\n\n";
          objpaux.Push(p2);

        }
          DevolverAuxPila(objp, objpaux);//
          return cadena; 
    }//FIN IMpirmirPila
    
    public void DevolverAuxPila(Pila objp, Pila objpaux)
    {
        while (!objpaux.IsEmpty()) 
        {
            objp.Push(objpaux.Pop());
    
        }

    }//FIN Devolver
    
   public void EliminarDato(Pila objp, Pila objpa,int datoelimi)
    {//By: Jose
        Persona d;
        int sw=0;
        
            while(objp.IsEmpty() == false)
                {
                  d=(Persona)objp.Pop();
                 if(d.getIdent()==datoelimi)
                 {
                     
                     sw=1;
                 }else
                 {
                     objpa.Push(d);
                 }//fin si
                }// fin mientras
                          
            if(sw==1)
            {
                JOptionPane.showMessageDialog(null,"El dato se eliminó de la PILA.");
            }else
            {
                 JOptionPane.showMessageDialog(null,"El dato se encontró en la PILA. ");
            }//fin si
       
        
            DevolverAuxPila(objp,objpa); 
    }//fin ELIMINAR dato
    
    
}//FIN CLASE
