package multinacional;

import javax.swing.JOptionPane;

public class Multinacional {

    //static int i = 0, tampila = 0, tamcola = 0, op, opped, z = 0;
    //static Pila objp, objpaux;
    //static Cola vec[];
    //static Cola objcaux;
    //static listadoble objlispe;
    //static listadoble objlispe1;
    //static listadoble objlispr;
    //static Archivos objArchivos;

    public static void main(String[] args) {
        

        //Instanciando
        Multinacional obj = new Multinacional();
        Archivos objArchivos = new Archivos();
        EmpleadosP objEmple=new EmpleadosP();
        ClientesC objClie=new ClientesC();
       
        Validacion objVal = new Validacion();
        String info = "";
        //Cola objcaux;
        listadoble objlis=new listadoble();
        listadoble objlispr = new listadoble();
        listadoble objlispe = new listadoble();
        listadoble objlispe1 = new listadoble();
        
        //AUXILIARES
        int i = 0, tampila = 0, tamcola = 0, op, opped=0, z = 0;
        
        info = "Digite el número de pisos del edificio:";
        tampila = objVal.ValidarEntero(info, tampila);
        info = "Digite el número de clientes por piso";
        tamcola = objVal.ValidarEntero(info, tamcola);
        Pila objp = new Pila(tampila);
        Pila objpaux = new Pila(tampila);
        Cola vec[] = new Cola[tamcola];
        obj.cargarProductos(objArchivos, objlispr);

        for (int k = 0; k < tampila; k++) {
            vec[k] = new Cola(tamcola);
        }

        Cola objcaux = new Cola(tamcola);
        do {
            op = obj.menu(objVal);//MENÚ PRINCIPAL
            switch (op) //CASOS PRINCIPALES
            {
                case 1:
                    int opc1 = 0;
                    while (opc1 != 5) //MIENTRAS DE VENDEDORES
                    {
                        info = "MENU VENDEDORES:\n"
                                + "1. Ingresar Vendedores\n"
                                + "2. Mostrar Vendedores\n"
                                + "3. Despedir vendedor\n"
                                + "4. Asignar Clientes por Orden de Llegada\n"
                                + "5. Salir";
                        opc1 = objVal.ValidarEntero(info, opc1);
                        switch (opc1) //CASOS DE VENDEDORES
                        {
                            case 1:objEmple.IngresandoVendedores(objp, objpaux, obj, objVal);
                                /*Persona p;
                                            if (!objp.IsFull()) {
                                                while (!objp.IsEmpty()) {
                                                    objpaux.Push(objp.Pop());
                                                }

                                                op = JOptionPane.showConfirmDialog(null, "¿Desea ingresar datos del vendedor?", "REGISTRO DE VENDEDORES", JOptionPane.YES_NO_OPTION);
                                                while (op == JOptionPane.YES_NO_OPTION) {
                                                    p = obj.RegistrarEmpleado(objpaux, objVal);
                                                    objpaux.Push(p);
                                                    op = JOptionPane.showConfirmDialog(null, "¿Desea ingresar un nuevo vendedor?", "REGISTRO DE VENDEDORES", JOptionPane.YES_NO_OPTION);
                                                }
                                                while (!objpaux.IsEmpty()) {
                                                    objp.Push(objpaux.Pop());
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "***¡PILA LLENA!***, ***NO PUEDE INGRESAR MÁS VENDEDORES*** ", "PILA LLENA", JOptionPane.ERROR_MESSAGE);
                                            }*/
                            
                                break;

                            case 2:if(!objp.IsEmpty())
                                {
                                  JOptionPane.showMessageDialog(null, "****LOS DATOS DE LOS VENDEDORES SON: \n" + objEmple.ImprimirPila(objp, objpaux));
                                }else{JOptionPane.showMessageDialog(null, "*******¡NO HAY VENDEDORES PARA MOSTRAR!*******\n                            ¡Debe ingresarlos!","NO HAY CLIENTES",JOptionPane.ERROR_MESSAGE);}
                                break;
                            
                            case 3:int datoeli=Integer.parseInt(JOptionPane.showInputDialog("INGRESE IDETIFICACIÓN A DESPEDIR"));
                                    objEmple.EliminarDato(objp, objpaux, datoeli);
                                break;

                            case 4:
                                    i = 0;
                                    objClie.RegistraCli(obj, objVal, tampila, vec, objp, objpaux, objEmple);
                                
                                break;

                            case 5:
                                JOptionPane.showMessageDialog(null, "*Saliendo de Vendedores*");
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "¡Ingrese una opción válida¡", "***ERROR***", JOptionPane.ERROR_MESSAGE);
                                break;
                        }//FIN CASO VENDEDORES
                    }//FIN MIENTRAS VENDEDORES

                    break;

                case 2:
                    int opc2 = 0;
                    while (opc2 != 5) //MIENTRAS DE CLIENTES
                    {
                        info = "MENU CLIENTES:\n"
                                + "1. Ingresar Clientes de acuerdo al vendedor\n"
                                + "2. Asignar vendedor en orden de llegada\n"
                                + "3. Listar clientes\n"
                                + "4. Hacer pedido\n"
                                + "5. Salir";
                        opc2 = objVal.ValidarEntero(info, opc2);
                        switch (opc2) //CASOS CLIENTES
                        {
                            case 1:
                                objClie.RegistraClixven(obj, objVal, objp, objpaux, vec, objEmple);//INGRESA LOS CLIENTES DE ACUERDO AL VENDEDOR
                                break;

                            case 2:
                                i = 0;
                                objClie.RegistraCli(obj, objVal, tampila, vec, objp, objpaux, objEmple);//Asignar vendedor en orden de llegada
                                break;

                            case 3:
                                if (vec[i].IsEmpty()) {
                                    JOptionPane.showMessageDialog(null, "***********¡NO HAY CLIENTES PARA MOSTRAR!***********\n          ¡Ya se atendieron o debe Ingresarlos!","NO HAY CLIENTES",JOptionPane.ERROR_MESSAGE);
                                } else {
                                    for (int j = 0; j < tampila; j++) {
                                        if (!vec[j].IsEmpty())//AGRGADO,  PARA VERIFICAR SI EN TODOS LOS PISO HAY VENDEDORES ATENDIENDO O SI HAY CLIENTES INGRESADOS
                                        {
                                        JOptionPane.showMessageDialog(null, "Los clientes del piso # " + (j + 1) + " Son: \n" + objClie.ImprimirCola(vec[j], objcaux));//lamo a imprimir cola
                                        }else
                                        {
                                            JOptionPane.showMessageDialog(null,    "*******¡NO HAY CLIENTES PARA MOSTRAR EN EL PISO #"+(j+1)+"!*******"+"\n PORQUE NO HAY CLIENTES REGISTRADOS EN ESTE PISO O NO HAY VENDEDORES PARA ASIGNAR ","SIN SERVICIO",JOptionPane.ERROR_MESSAGE); 
                                        }
                                    }//fin para
                                }

                                break;

                            case 4:
                                if (objlispr.Estavacia()) {
                                    JOptionPane.showMessageDialog(null, "No hay productos disponibles, debe agregarlos previamente", "**ERROR**", JOptionPane.ERROR_MESSAGE);

                                } else {
                                    JOptionPane.showMessageDialog(null, "******Lista Actualizada de productos:******\n" + objlispr.ImprimirDesdeCabeza(), "PRODUCTOS DISPONIBLES", JOptionPane.INFORMATION_MESSAGE);
                                    obj.IngresarPedido(obj,z,tampila,opped, objVal , vec,objlispe1,objlispr,objlispe,objClie,objcaux, objArchivos);
                                }
                                break;

                            case 5:
                                JOptionPane.showMessageDialog(null, "Saliendo  de Clientes");
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opción válida", "**ERROR**", JOptionPane.ERROR_MESSAGE);
                                break;
                        }

                    }

                    break;

                case 3:
                    int opc3 = 0;
                    while (opc3 != 5) //MIENTRAS DE PRODUCTOS
                    {
                        info = "***MENÚ PRODUCTOS***:\n"
                                + "1. Ingresar Productos\n"
                                + "2. Mostrar Productos\n"
                                + "3. Listar Pedidos\n"
                                +" 4. Mostrar toda la información del producto con más existencia\n"
                                + "5. Salir";
                        
                        opc3 = objVal.ValidarEntero(info, opc3);//VALIDACIONES
                        switch (opc3) //CASOS DE PRODUCTOS
                        {
                            case 1:
                                 objlispr.IngrsandoProducto(obj, objVal, objArchivos, objlispr);//Todo lo de abajo se encuentra acá, en la clas elistadoble 
                                                /*Producto pr;
                                                int val = JOptionPane.YES_OPTION;
                                                while (val == JOptionPane.YES_OPTION) {
                                                    pr = obj.RegistrarProducto(objVal);
                                                    objlispr.AgregarDato(pr);
                                                    val = JOptionPane.showConfirmDialog(null, "¿Desea ingresar un nuevo producto: ?", "REGISTRO DE PRODUCTOS", JOptionPane.YES_NO_OPTION);
                                                }
                                                obj.actualizaProductos(objArchivos, objlispr);*/

                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "*************LA LISTA DE PRODUCTOS ES:***********\n" + objlispr.ImprimirDesdeCabeza(), "LISTA PRODUCTOS", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            case 3:
                                objlispe.MostrarPedidos(objArchivos);
                                
                                /*JOptionPane.showMessageDialog(null, "*********La lista de pedidos actuales es:********\n" + objlispe.ImprimirDesdeCabeza(), "PEDIDOS ACTUALES", JOptionPane.INFORMATION_MESSAGE);
                                    int cn = 1;
                                    Pedido pedi;
                                    nodo pe = objlispe.recorrer(cn);
                                    objArchivos.resetearTxt("pedidos.txt");
                                    objArchivos.cerrarArchivoParaEscritura();//Estas dos lineas en caso que desee limpiar el txt antes de llevarle los datos, si deseo un histórico las comento
                                        while (pe != null) 
                                        {
                                            String cad = objlispe.ImprimirDesdeCabeza();
                                            objArchivos.abrirArchivoParaEscritura("pedidos.txt");
                                            pedi = (Pedido) pe.getDato();
                                            objArchivos.escribirUnaLineaYAlfrente("" + pedi);
                                            objArchivos.cerrarArchivoParaEscritura();
                                            cn++;
                                            pe = objlispe.recorrer(cn);
                                        }

                                        JOptionPane.showMessageDialog(null, "Se guardó el archivo actual de pedidos en disco");*/
                                break;
                            case 4:JOptionPane.showMessageDialog(null, "EL PRODUCTO CON MÁS CANTIDAD CON MÁS EXISTENCIA ES: \n"+objlispr.ProductoconmasExistencia());
                                break;

                            case 5:
                                JOptionPane.showMessageDialog(null, "Saliendo de Productos");
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opción válida", "**ERROR**", JOptionPane.ERROR_MESSAGE);
                                break;
                        }//FIN CASO

                    }//FIN MIENTRAS PRODUCTOS

                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "******Programa terminado*******\n *****¡GRACIAS POR PREFERIRNOS!****");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "¡Ingrese una opción válida!","ERROR",JOptionPane.ERROR_MESSAGE);
                    break;

            }
        } while (op !=4);
    }
    
    
    

    public void IngresarPedido(Multinacional obj,int z,int tampila,int opped, Validacion objVal ,Cola vec[],listadoble objlispe1,listadoble objlispr,listadoble objlispe,ClientesC objClie,Cola objcaux,Archivos objArchivos) 
    {
        int c = objClie.CantCli(tampila, vec, objcaux);
        Persona p = vec[z].Pop();
        if (c > 0 && p != null) 
        {
            opped = JOptionPane.showConfirmDialog(null, "¿Desea ingresar pedido del Cliente: " + p.getIdent() + "\nNombre: " + p.getNombre() + "\nApellido: " + p.getApellido() + " ?", "REGISTRO DE PEDIDOS", JOptionPane.YES_NO_OPTION);
            if (opped == JOptionPane.NO_OPTION) 
            {
                JOptionPane.showMessageDialog(null, "El cliente no registró ningun pedido\n ¡Hasta Pronto!");
            }
            while (p != null && z < tampila && opped == JOptionPane.YES_OPTION) {

                Pedido ped = RegistrarPedido(p.getIdent(), objVal);
                objlispe1.AgregarDato(ped); //
                JOptionPane.showMessageDialog(null, "***Item(PEDIDO) agregado***");
                opped = JOptionPane.showConfirmDialog(null, "¿Desea ingresar un nuevo item para el cliente " + p.getNombre() + " " + p.getApellido() + " ?", "REGISTRO DE PEDIDOS", JOptionPane.YES_NO_OPTION);
            }//FINMIENTRAS

            if (opped == JOptionPane.NO_OPTION) 
            {
                objClie.AtenderCliente(obj, objlispe1, objlispr, objlispe, objArchivos);//
                opped = JOptionPane.showConfirmDialog(null, "¿Desea ingresar pedido del cliente del turno siguiente?", "REGISTRO DE PEDIDOS", JOptionPane.YES_NO_OPTION);
                if (opped == JOptionPane.YES_OPTION && vec[z].IsEmpty()) 
                {
                    z++;
                    if (z == tampila) 
                    {
                        z = 0;
                    }
                        IngresarPedido(obj,z,tampila,opped, objVal , vec,objlispe1,objlispr,objlispe,objClie,objcaux, objArchivos);
                } else if (opped == JOptionPane.YES_OPTION) 
                {
                    IngresarPedido(obj,z,tampila,opped, objVal , vec,objlispe1,objlispr,objlispe,objClie,objcaux, objArchivos);
                }
            }
        } else if (c > 0 && z < tampila) 
        {
            z++;//
            IngresarPedido(obj,z,tampila,opped, objVal , vec,objlispe1,objlispr,objlispe,objClie,objcaux, objArchivos);
        } else 
        {
            JOptionPane.showMessageDialog(null, "¡NO HAY CLIENTES PARA ATENDER!");
        }
    }

    

    public int menu(Validacion objVal) 
    {
        int opc = 1;
        String info = "****MENÚ PRINCIPAL****\n"
                + "1. VENDEDORES\n"
                + "2. CLIENTES\n"
                + "3. PRODUCTOS\n"
                + "4. SALIR\n";
        opc = objVal.ValidarEntero(info, opc);

        return opc;
    }//finmenu

   

    public Producto RegistrarProducto(Validacion objVal) 
    {
        String info = "", ref = "", desc = "";
        int canIni = 0;
        double costo = 0, precio = 0;
        Producto pro = null;
        info = "Digite la referencia del producto";
        ref = objVal.ValidarTexto(info, ref);
        info = "Digite la descripción del producto";
        desc = objVal.ValidarTexto(info, desc);
        info = "Digite la cantidad inicial del producto";
        canIni = objVal.ValidarEntero(info, canIni);
        info = "Digite el costo de producción del producto";
        costo = objVal.ValidarReal(info, costo);
        info = "Digite el precio de venta del producto";
        precio = objVal.ValidarReal(info, precio);
        int canAct = canIni;

        pro = new Producto(ref, desc, canIni, canAct, costo, precio);

        return pro;
    }//FIN REGISTRAR PRODUCTO

    public Pedido RegistrarPedido(int idped, Validacion objVal) 
    {
        String ref = "";
        int canPed = 0;
        Pedido pe = null;
        String info = "Digite la referencia del producto que desea: ";
        ref = objVal.ValidarTexto(info, ref);
        info = "Digite la cantidad que desea solicitar: ";
        canPed = objVal.ValidarEntero(info, canPed);
        pe = new Pedido(idped, ref, canPed);
        return pe;
    }

    public void actualizaProductos(Archivos objArchivos,listadoble objlispr) 
    {
        try {
            int cn1 = 1;
            Producto pro1;
            nodo n1 = objlispr.recorrer(cn1);
            pro1 = (Producto) n1.getDato();
            String cad2 = "";
            objArchivos.resetearTxt("productos.txt");
            objArchivos.cerrarArchivoParaEscritura();//Estas dos lineas en caso que desee limpiar el txt antes de llevarle los datos, si deseo un histórico las comento
            while (n1 != null) {
                n1 = objlispr.recorrer(cn1);
                objArchivos.abrirArchivoParaEscritura("productos.txt");
                pro1 = (Producto) n1.getDato();
                cad2 = pro1.ImpPro();
                objArchivos.escribirUnaLineaYAlfrente("" + cad2);
                objArchivos.cerrarArchivoParaEscritura();
                cn1++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "*****SE ACTUALIZÓ El ARCHIVO DE PRODUCTOS*****");
        }

    }

    public void cargarProductos(Archivos objArchivos,listadoble objlispr) 
    {
        try {
            String r;
            String de;
            int ci;
            int ca;
            double co;
            double pre;
            String lin[];
            lin = new String[5];
            objArchivos.abrirArchivoParaLectura("productos.txt");

            lin = objArchivos.leerUnaLineaDelArchivo();
            while (lin != null) 
            {
                r = lin[0];
                de = lin[1];
                ci = Integer.parseInt(lin[2]);
                ca = Integer.parseInt(lin[3]);
                co = Double.parseDouble(lin[4]);
                pre = Double.parseDouble(lin[5]);

                Producto pro = null;
                pro = new Producto(r, de, ci, ca, co, pre);
                objlispr.AgregarDato(pro);
                lin = null;
                lin = objArchivos.leerUnaLineaDelArchivo();
            }//FIN MIENTRAS
            objArchivos.cerrarArchivoParaLectura();

        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "****Se cargaron los productos a la lista****");
        }
    }//FIN CARGAR PRODUCTOS

}//fin CLASE MUTINACIONAL
