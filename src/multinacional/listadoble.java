/*
-------------------------
       ListaDoble
-------------------------
cabeza: Nodo
fin: Nodo
-------------------------
+ ListaDoble()
+ EstaVacia()
+ AgregarDato(dato)
+ ImprimirdesdeCabeza()
+ InsertarCab()
+ EliminarCab()
+ InsertarUlt()
+ EliminarUlt()
+ InsertarAntes()
+ InsertarDespues()
+ Eliminar()
….….
------------------------*/
package multinacional;

import javax.swing.JOptionPane;


public class listadoble {

    //atributos propios y privados
    private nodo cabeza, fin;

    nodo q;

//constructor de condiciones iniciales
    public listadoble() {
        cabeza = null;
        fin = null;
    }//fin método listaDoble

    public boolean Estavacia() {
        return getCabeza() == null; //"LISTA VACIA!!!“   //opcional
    }//fin esta vacia

    public nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(nodo cabeza) {
        this.cabeza = cabeza;
    }

    public nodo getFin() {
        return fin;
    }

    public void setFin(nodo fin) {
        this.fin = fin;
    }

    public void AgregarDato(Object info) {
        q = new nodo(info);
        if (Estavacia() == true) {
            setCabeza(q);
            setFin(q);
        } else {
            getFin().setDer(q);
            q.setIzq(getFin());
            setFin(q);
        }

    }//fin de agregar dato*/

        public boolean Buscar(String dato) { 
        boolean resp=false;
        q = cabeza;
        Producto p = (Producto) q.getDato();
        String re = p.getRef();    
        while (q != null && !re.equals(dato)) {
            q = q.getDer();
            if(q==null){
                resp=false;
            }else{
            p = (Producto) q.getDato();
            re = p.getRef();
            }            
        }//fin del mientras
        if(q != null){
            resp=true;
        }        
        return resp;

    }//fin del metodo buscar
    
    public int BuscarRef(String ref, int cant) {
        int canv = 0, canac, dif;
        try {
            q = cabeza;

            Producto p = (Producto) q.getDato();
            String re = p.getRef();

            while (q != null && !re.equals(ref)) {
                q = q.getDer();
                p = (Producto) q.getDato();
                re = p.getRef();
            }//fin del mientras

            if (q != null) {
                canac = p.getCanAct();
                if (canac == 0) {
                    return canac;
                } else {
                    dif = canac - cant;
                    if (dif < 0) {
                        int resp = JOptionPane.showConfirmDialog(null, "No tenemos las unidades completas para el item: " + ref + "\nTenemos: " + canac + " \n¿Desea solicitarlas?", "UNIDADES", JOptionPane.YES_NO_OPTION);
                        if (resp == JOptionPane.YES_OPTION) {
                            canv = canac;
                            canac = 0;
                            p.setCanAct(canac);
                            return canv;
                        } else {
                            return canv;
                        }
                    } else {
                        canac = canac - cant;
                        p.setCanAct(canac);
                        return cant;
                    }
                }

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }
        return canv;
    }//fin del metodo buscar

    public double consulta_precio(String ref) {
        double pre = 0;
        q = cabeza;
        Producto p = (Producto) q.getDato();
        String re = p.getRef();
        pre = p.getPrecio();

        while (q != null && !re.equals(ref)) {
            q = q.getDer();
            p = (Producto) q.getDato();
            re = p.getRef();
            pre = p.getPrecio();
        }//fin del mientras        

        return pre;
    }

    public String ImprimirDesdeCabeza() {
        String cadena = " ";

        if (Estavacia() == false) {
            q = getCabeza();
            while (q != null) {
                cadena = cadena + "[ " + q.toString() + " ]\n";
                q = q.getDer();
            }//fin mientras
        }//Fin si
        return cadena;
    }//Fin imprimir desde cabeza

    public String ImprimirDesdeUltimo() {
        nodo aux = fin;
        String cadena = " ";
        while (aux != null) {
            cadena = cadena + "[" + aux.getDato() + " ]\n";
            aux = aux.getIzq();
        }
        return cadena;
    }//Fin imprimir desde ultimo

    public void InsertarCabeza(Persona info) {
        if (Estavacia()) {
            nodo n = new nodo(info);
            cabeza = n;
            fin = cabeza;
        } else {
            nodo n = new nodo(info);
            n.setIzq(null);
            n.setDer(cabeza);
            cabeza.setIzq(n);
            cabeza = n;

        }
    }//Insertar en cabeza

    public Object EliminarCabeza() {
        Object obj = null;
        if (cabeza == fin) {
            obj = cabeza.getDato();
            cabeza = null;
            fin = null;

        } else {
            nodo aux = cabeza;
            cabeza = cabeza.getDer();
            cabeza.setIzq(null);
            obj = aux.getDato();
            aux = null;
        }
        return obj;
    }//Eliminar cabeza
    
    
    
    
    public Object EliminarCabezaP() {
        Object obj = null;
        if (cabeza == fin) {
            obj = cabeza.getDato();
            cabeza = null;
            fin = null;

        } else {
            nodo aux = cabeza;
            cabeza = cabeza.getDer();
            cabeza.setIzq(null);
            obj = aux.getDato();
            aux = null;
        }
        return obj;
        
    }//FIN ESPECIAL
        
    public void LiberarDato(int info )
{
    if(Estavacia()==false)
    {
        if (Buscars(info)==true)
        {
            if(q==cabeza)
            {
               
                JOptionPane.showMessageDialog(null, "LOS DATOS  ELIMINADOS SON: \n: "+EliminarCabeza());
            }else
            {
                if(q==fin)
                {
                    JOptionPane.showMessageDialog(null, "LOS DATOS  ELIMINADOS SON: \n: "+EliminarUltimo());
                }else
                {
                     
                    q.getIzq().setDer(q.getDer());
                    
                    q.getDer().setIzq(q.getIzq());
                   
                    q.finalize();
                    JOptionPane.showMessageDialog(null, "LOS DATOS  ELIMINADOS SON: \n: "+q.getDato());
                }//fin si
            }//fin si
           
        }else{JOptionPane.showMessageDialog(null, "¡EL DATO NO ESTA EN LA LISTA!");}//finsi
    }//fin si
}//Fin Liberar Dato

    public void InsertarFinal(Persona info) {
        if (Estavacia()) {
            InsertarCabeza(info);
        } else {
            nodo n = new nodo(info);
            n.setDer(null);
            n.setIzq(fin);
            fin.setDer(n);
            fin = n;
        }
    }

    public Object EliminarUltimo() {
        Object obj;
        if (cabeza == fin) {
            obj = cabeza.getDato();
            cabeza = null;
            fin = null;

        } else {
            nodo aux = fin;
            fin = fin.getIzq();
            fin.setDer(null);
            obj = aux.getDato();
            aux = null;
        }
        return obj;
    }//Eliminar cabeza  
    
    public nodo recorrer(int cn){
        nodo aux=cabeza;
        int con=1;
        while(con<cn){
            aux=aux.getDer();
            con++;
        }
        return aux;
    }

    
    //METODOS DE PRODUCTOS
    
    public void IngrsandoProducto(Multinacional obj,Validacion objVal,Archivos objArchivos,listadoble objlispr)
    {
        Producto pr;
           int val = JOptionPane.YES_OPTION;
           while (val == JOptionPane.YES_OPTION) 
           {
                pr = obj.RegistrarProducto(objVal);
                    AgregarDato(pr);
                val = JOptionPane.showConfirmDialog(null, "¿Desea ingresar un nuevo producto: ?", "REGISTRO DE PRODUCTOS", JOptionPane.YES_NO_OPTION);
           }
             obj.actualizaProductos(objArchivos, objlispr);

    }
    
    
    
    public void  MostrarPedidos(Archivos objArchivos)
    {
        JOptionPane.showMessageDialog(null, "*********La lista de pedidos actuales es:********\n" + ImprimirDesdeCabeza(), "PEDIDOS ACTUALES", JOptionPane.INFORMATION_MESSAGE);
        int cn = 1;
          Pedido pedi;
           nodo pe = recorrer(cn);
             objArchivos.resetearTxt("pedidos.txt");
             objArchivos.cerrarArchivoParaEscritura();//Estas dos lineas en caso que desee limpiar el txt antes de llevarle los datos, si deseo un histórico las comento
              while (pe != null) 
                {
                 String cad = ImprimirDesdeCabeza();
                 objArchivos.abrirArchivoParaEscritura("pedidos.txt");
                  pedi = (Pedido) pe.getDato();
                  objArchivos.escribirUnaLineaYAlfrente("" + pedi);
                  objArchivos.cerrarArchivoParaEscritura();
                  cn++;
                  pe = recorrer(cn);
                }

                 JOptionPane.showMessageDialog(null, "Se guardó el archivo actual de pedidos en disco");
    }
    
    
    
    
    
    
    public String ProductoconmasExistencia()
    {
        Producto p;
        String cadena="";
        if(!Estavacia())
        {
           
            int mayorcanti=0;
            q=cabeza;
            while(q!=null)
            {
                p=(Producto)q.getDato();
                if(p.getCanAct()>mayorcanti)
                {
                    mayorcanti=p.getCanAct();
                    cadena =q.toString();
                }//finsi
                q=q.getDer();
            }//fin mientras
        }
        return cadena;
    }
    
    
    
    //metodos especiales
    public boolean Buscars(int ID)
    {
       Persona d;
        q=cabeza;
        
        
        d=(Persona)q.getDato();
       
        
        //while((q!=null)&&(!d.getId().equals(datobus)))
        while(q!=null&&d.getIdent()==ID)
        {
            
            q=q.getDer();
            if(q!=null)
            d=(Persona)q.getDato();
           
        }//fin del mientras
        
         //return q != null;
         
         if(q==null)
         {
             return false;
         }else
         { 
             return true;
         }//finsi
        
    }//fin del metodo buscar
         
        
   
    
    
    //
    
    /*public void DespedirVendedor(String datobus)
    {
        if (!Estavacia())
        {
          Persona p;
          
            if(Buscar(datobus))
            {
                p=(Persona)q.getDato();
                LiberarDato(p);
            }
        }
        
    }*/
}//FIN LISTADOBLE

