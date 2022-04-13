public abstract class Agentes {
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
    public int posicion=0;
    public int siguiendo=0;
    
    public abstract boolean getRecurso();
    public abstract int getAmenaza();
    public abstract int getEspaciosAmenaza();
    public abstract String getMovimiento();
    public abstract int getPosicionX();
    public abstract int getPosicionY();
    public abstract int getPosicionXrecurso();
    public abstract void setPosicionYrecurso(int n);
    public abstract void setPosicionXrecurso(int n);
    public abstract int getPosicionYrecurso();
    public abstract void setposicion(int n);
    public abstract void setsiguiendo(int cod);

    public abstract int DetectarRecurso(int x,int y);
    public abstract int DetectarAgente(int x,int y);
    public abstract int DetectarAmenaza(int x,int y);
    public abstract void AtacarRecurso();
    public abstract void MoverAgente();
}
