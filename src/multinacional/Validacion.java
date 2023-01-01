package multinacional;
import javax.swing.JOptionPane;

public class Validacion 
{
    /*Instrucciones para validar:
    Se debe asignar al atributo  de cualquier clase al que desea asignarle un valor el objeto que instancia esta clase y el metodo a acceder, si es entero se accede a ValidarEntero, si es real,
    se accede al metodo ValidarReal y si es String, se accede al metodo ValidarTexto y como parametros se le asigna el texto que debe salir en el recuadro de ingreso de datos
    y seguido del mismo atributo al que deseamos modificar de valor.
    
    Ej --> cantProdutos = objVal.ValidarEntero(text, cantProductos);
    Ej --> nombre = objVal.ValidarTexto(cadena, nombre);
    Ej --> salario = objVal.ValidarReal(info, salario);
    Si alguna cosa me preguntan.
    */
    
    public int ValidarEntero(String info, int entero)
    {
        if (entero >= 0)
        {
            do
            {
                try
                {
                    entero = Integer.parseInt(JOptionPane.showInputDialog(info));
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,
                    "Dato ingresado no es válido.",
                    "*** ERROR ***",
                    JOptionPane.ERROR_MESSAGE);
                    entero = -1;
                }
            }while(entero < 0);
        }
        return entero;
    }    
    
    public String ValidarTexto(String info, String texto)
    {   do
        {
            try
            {
                texto = JOptionPane.showInputDialog(info);
                if(texto.equals(""))
                {
                    ValidarTexto(info,texto);
                }
            }
            catch (Exception e)
            {
                System.out.println("Error " + e);
                texto = "";
            }
        }while(texto.equals(""));
        return texto;
    }

    public double ValidarReal(String info,double real)
    {
        do
        {
            try
            {
                real = Double.parseDouble(JOptionPane.showInputDialog(info));
            }
            catch (Exception e)
            {
                System.out.println("Error " + e);
                real = -1.1;
            }
        }while(real < 0);
        return real;
    }
    
}
