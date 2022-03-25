package Enjambre;
public abstract class Agentes {
    public int Tamaño;
    public boolean Recurso;
    public int Amenaza;
    public int EspaciosAmenaza;
    public String Movimiento;
    public int PosicionX=0;
    public int PosicionY= 0;
    public int PosicionXrecurso=0;
    public int PosicionYrecurso= 0;
    public int PosicionXbase=0;
    public int PosicionYbase= 0;
    
    public abstract void DetectarRecurso();
    public abstract void DetectarAgente();
    public abstract void DetectarAmenaza();
    public abstract void AtacarRecurso();
    public abstract void MoverAgente();
}
