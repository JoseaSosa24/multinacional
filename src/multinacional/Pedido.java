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
public class Pedido {
    private int id;    
    private String ref;
    private int canPed;

    public Pedido(int id, String ref, int canPed) {
        this.id = id;
        this.ref = ref;
        this.canPed = canPed;
    }

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getRef() {
        return ref;
    }

    public int getCanPed() {
        return canPed;
    }

    @Override
    public String toString() {
        return "PEDIDO {" + "id: " + id + ", Referencia:" + ref + ", Cantidad pedida: " + canPed + '}';
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setCanPed(int canPed) {
        this.canPed = canPed;
    }


  
}
