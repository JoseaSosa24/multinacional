/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multinacional;

/**
 *
 * @author soporte.sistemas
 */
public class Producto {   
    private String ref;
    private String desc;
    private int canIni;
    private int canAct;
     private double costo;
    private double precio;

    public Producto(String ref, String desc, int canIni, int canAct, double costo, double precio) {
        this.ref = ref;
        this.desc = desc;
        this.canIni = canIni;
        this.canAct = canAct;
        this.costo = costo;
        this.precio = precio;
    }

    public String getRef() {
        return ref;
    }

    public String getDesc() {
        return desc;
    }

    public int getCanIni() {
        return canIni;
    }

    public int getCanAct() {
        return canAct;
    }

    public double getCosto() {
        return costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCanIni(int canIni) {
        this.canIni = canIni;
    }

    public void setCanAct(int canAct) {
        this.canAct = canAct;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "PRODUCTO {" + "Referencia: " + ref + ", Descripción: " + desc + ", Cantidad Inicial: " + canIni + ", Cantidad Actual: " + canAct + ",  Posible Costo: " + costo + ", Precio: " + precio + '}';
    }
    public String ImpPro(){
        return ref + "," + desc + "," + canIni + "," + canAct + "," + costo + "," + precio;
    }


   
}
