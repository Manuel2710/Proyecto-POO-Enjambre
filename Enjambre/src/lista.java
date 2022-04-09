/*import javax.swing.JOptionPane;

public class lista {
    protected Nodo inicio,fin;

    public lista()
    {
        inicio=null;
        fin=null;
    }

    public boolean Vacio()
    {
        if(inicio==null)
            return true;
        else
            return false;
    }

    public void insertar(Agentes agente){
        Nodo actual;
        if (Vacio())
        {
            actual=new Nodo(agente,null);
            inicio=actual;
            fin=actual;
        }
        else{
            actual=new Nodo(agente, null);
            fin.setSiguiente(actual);
            fin=actual;
        }

    }
    public void ejecutar(){
        if (Vacio()){
            JOptionPane.showMessageDialog((null), "vacio");
            return;
        }
        else{
            Nodo temporal;
            temporal=inicio;
            while(temporal!=null)
            {
                //JOptionPane.showMessageDialog(null, temporal.getDato().toString());
                temporal.getDato().DetectarRecurso();
                temporal.getDato().DetectarAgente();
                temporal.getDato().DetectarAmenaza();
                temporal.getDato().AtacarRecurso();
                temporal.getDato().MoverAgente();
                temporal=temporal.getSiguiente();
            }
        }
    }
}
*/