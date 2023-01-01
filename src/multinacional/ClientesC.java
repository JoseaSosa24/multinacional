
package multinacional;

import javax.swing.JOptionPane;



public class ClientesC 
{
    int c=0;
    public Persona RegistrarCliente(Cola cola, Validacion objVal) {
        String info = "";
        Persona p = null;

        if (!cola.IsFull()) {
            int ident = 0, telefono = 0, celular = 0;
            String nombre = "", apellido = "", direccion = "";
            info = "Digite el ID del Cliente #" + (c + 1);
            ident = objVal.ValidarEntero(info, ident);
            info = "Digite el Nombre del Cliente #" + (c + 1);
            nombre = objVal.ValidarTexto(info, nombre);
            info = "Digite el Apellido del Cliente #" + (c + 1);
            apellido = objVal.ValidarTexto(info, apellido);
            info = "Digite la Dirección del Cliente #" + (c + 1);
            direccion = objVal.ValidarTexto(info, direccion);
            info = "Digite el Fijo del Cliente #" + (c + 1);
            telefono = objVal.ValidarEntero(info, telefono);
            info = "Digite el Celular del Cliente #" + (c + 1);
            celular = objVal.ValidarEntero(info, celular);
            p = new Persona(ident, nombre, apellido, direccion, telefono, celular);
            c++;
        } else {
            JOptionPane.showMessageDialog(null, "******¡COLA LLENA!******\n    ¡NO PUEDE INGRESAR MÁS DATOS!", "***COLA LLENA***", JOptionPane.WARNING_MESSAGE);

        }

        return p;
    }//FIN REGISTRAR CLIENTES

    
    int i=0;
    public void RegistraCli(Multinacional obja, Validacion objVal,int tampila ,Cola vec[],Pila objp,Pila objpaux,EmpleadosP objEmple) {

        Persona p1;
        Persona d = null;
        int k = 0;
        for (int n = 0; n < tampila; n++) 
        {
            if (vec[n].IsFull()) 
            {
                k++;
            }
        }
        if (k == tampila) 
        {
            JOptionPane.showMessageDialog(null, "Todos los vendedores se encuentran ocupados\n"
                    + "        Debe esperar que atiendan clientes", "OCUPADOS", JOptionPane.WARNING_MESSAGE);
        } else if (objp.IsEmpty() && objpaux.IsEmpty()) {
            JOptionPane.showMessageDialog(null, "*********NO HAY VENDEDORES EN EL SISTEMA**********\n           Debe ingresarlos previamente", "SIN VENDEDORES", JOptionPane.WARNING_MESSAGE);
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Desea ingresar datos del cliente?", "REGISTRO DE CLIENTES", JOptionPane.YES_NO_OPTION);
            if (opc == JOptionPane.YES_OPTION) {

                if (!objp.IsEmpty()) {
                    d = objp.Pop();
                    objpaux.Push(d);
                }
                if (d != null && !vec[i].IsFull()) {

                    while (!vec[i].IsFull() && opc == JOptionPane.YES_OPTION) {

                        p1 = RegistrarCliente(vec[i], objVal);
                        vec[i].Push(p1);
                        JOptionPane.showMessageDialog(null, "****Éste cliente será atendido por el vendedor: " + d.getNombre() + "****, el cual se encuentra en el Piso #" + (i + 1));
                        opc = JOptionPane.showConfirmDialog(null, "¿Desea ingresar un nuevo cliente?", "REGISTRO DE CLIENTES", JOptionPane.YES_NO_OPTION);
                    }
                }

                if (vec[i].IsFull()) {
                    JOptionPane.showMessageDialog(null, "El piso # " + (i + 1) + " ya se encuentra lleno de clientes, se lo debe asignar a otro vendedor , vamos para el piso #" + (i + 2), "SUBIENDO DE PISO", JOptionPane.WARNING_MESSAGE);
                    if (objp.IsEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay vendedores disponibles en pisos superiores \n deben ingresar nuevos vendedores o atender turnos","SIN ATENCIÓN",JOptionPane.WARNING_MESSAGE);
                    } else {
                        i++;
                        RegistraCli(obja,  objVal, tampila , vec, objp, objpaux,objEmple);
                    }
                }
            }
        }
          objEmple.DevolverAuxPila(objp, objpaux);//DevolvemosAuxiliar
        /*while (!objpaux.IsEmpty()) {//devolviendo a la original personalizadamente
            objp.Push(objpaux.Pop());
        }*/
    }//FINREGISTRARCLIEN
    
    
    
    
    
    public void RegistraClixven(Multinacional obj, Validacion objVal,Pila objp,Pila objpaux,Cola vec[],EmpleadosP objEmple) {
        Persona p1;
        Persona d = null;
        if (objp.IsEmpty()) {
            JOptionPane.showMessageDialog(null, "¡NO HAY VENDEDORES EN EL SISTEMA!\n     Debe ingresarlos previamente", "SIN VENDEDORES", JOptionPane.WARNING_MESSAGE);
        } else {
            String info = "";
            info = "Ingrese el ID del vendedor al cual le desea asignar el cliente";
            int ven = 0;
            ven = objVal.ValidarEntero(info, ven);
            int ban = 0;
            int l = 0;
            while (!objp.IsEmpty() && ban == 0) {
                d = objp.Pop();
                objpaux.Push(d);
                l++;
                if (ven == d.getIdent()) {
                    ban = 1;
                }//finsi
            }//finmientras

            if (ven == d.getIdent()) {
                int opcv = JOptionPane.showConfirmDialog(null, "¿Desea ingresar datos del cliente?", "REGISTRO DE CLIENTES", JOptionPane.YES_NO_OPTION);
                if (opcv == JOptionPane.YES_OPTION) {

                    while (!vec[l - 1].IsFull() && opcv == JOptionPane.YES_OPTION) {

                        p1 = RegistrarCliente(vec[l - 1], objVal);
                        vec[l - 1].Push(p1);
                        JOptionPane.showMessageDialog(null, "Éste cliente será atendido por el vendedor: " + d.getNombre() + " que se encuentra en el piso # " + (l));
                        opcv = JOptionPane.showConfirmDialog(null, "¿Desea ingresar un nuevo cliente para este vendedor?", "REGISTRO DE CLIENTES", JOptionPane.YES_NO_OPTION);
                    }//fin mientras

                }//FIN MIENTRAS
            } else {
                JOptionPane.showMessageDialog(null, "****El vendedor no se encuentra registrado, favor verifique vendedores***", "NO SE ENCUENTRA", JOptionPane.WARNING_MESSAGE);
            }
            if (vec[l - 1].IsFull()) {
                JOptionPane.showMessageDialog(null, "El piso # " + (l) + " ya se encuentra lleno de clientes\n"
                        + "Debe asignar clientes a otros vendedores", "PISO #" + (l) + "LLENO", JOptionPane.WARNING_MESSAGE);
            }//fin si de pisos
        }
            objEmple.DevolverAuxPila(objp, objpaux);
        /*while (!objpaux.IsEmpty()) {
            objp.Push(objpaux.Pop());
        }*/
    }//FIN METODO
    
    
     public void DevolverAuxCola(Cola objc, Cola objcaux) 
     {

        while (!objcaux.IsEmpty()) {
            objc.Push(objcaux.Pop());
        }
    }//FIN METODOD
     
     
     public String ImprimirCola(Cola objc, Cola objcaux) {
        String cadena = "";
        Persona p4;

        while (!objc.IsEmpty()) 
        {
            p4 = objc.Pop();
            objcaux.Push(p4);
            cadena = cadena + "[ " + p4.toString2() + " ]\n\n";
        }//FIN MIENTRAS objc, no este vacia
        
            DevolverAuxCola(objc,objcaux);
        return cadena;
    }
    
     
     public int CantCli(int tampila,Cola vec[],Cola objcaux) {
        int x = 0, c = 0;
        Persona p;
        while (x < tampila) 
        {
            while (!vec[x].IsEmpty()) 
            {
                p = vec[x].Pop();
                objcaux.Push(p);
                if (p != null) 
                {
                    c = c + 1;
                }//finsi
            }//fin mientras
            DevolverAuxCola(vec[x], objcaux);
            x++;
        }
        return c;
    }

     
     public void AtenderCliente(Multinacional obj,listadoble objlispe1,listadoble objlispr,listadoble objlispe,Archivos objArchivos) {

        String cadena = "";
        int id = 0;
        Pedido pe;
        double pre = 0, sub = 0, total = 0;
        while (!objlispe1.Estavacia()) {
            nodo n1 = objlispe1.getCabeza();
            pe = (Pedido) n1.getDato();
            String ref = pe.getRef();
            id = pe.getId();
            
            int cant = pe.getCanPed();
            boolean resp = objlispr.Buscar(ref);
            if (resp == true) {
                int res = objlispr.BuscarRef(ref, cant);
                pre = objlispr.consulta_precio(ref);
                if (res == 0) {
                    sub = 0;
                    cadena = cadena + "[Item: " + ref + " sin existencia " + " valor: " + sub + "]\n";
                    pe.setCanPed(res);
                    objlispe.AgregarDato(pe);
                } else if (res == cant) {
                    sub = pre * cant;
                    cadena = cadena + "[Item: " + ref + " Completo, cantidad: " + cant + " valor: " + sub + "]\n";
                    pe.setCanPed(res);
                    objlispe.AgregarDato(pe);
                } else {
                    sub = pre * res;
                    cadena = cadena + "[Item: " + ref + " Parcial, cantidad: " + res + " valor: " + sub + "]\n";
                    pe.setCanPed(res);
                    objlispe.AgregarDato(pe);
                }
                total = total + sub;
                objlispe1.EliminarCabeza();
            } else {
                JOptionPane.showMessageDialog(null, "La referencia: " + ref + " No existe en el inventario\nPor lo tanto no será incluida en la factura");
                objlispe1.EliminarCabeza();
            }
        }

        cadena = cadena + "[Total a pagar: " + total + " ]\nId-Cliente: " + id;
        JOptionPane.showMessageDialog(null, "Detalle Factura:\n" + cadena);
        obj.actualizaProductos(objArchivos,objlispr);
    }
    

     
}//FIN CLASE
