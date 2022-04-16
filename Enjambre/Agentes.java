public abstract class Agentes {
    public boolean Recurso;
    public int Amenaza;
    public String obstaculo; 
    public int EspaciosAmenaza;
    public String Movimiento;
    public int PosicionX=0;
    public int PosicionY= 0;
    public int PosicionXrecurso=0;
    public int PosicionYrecurso= 0;
    public int PosicionXbase=0;
    public int PosicionYbase=0;
    public int PosicionXAmenaza=0;
    public int PosicionYAmenaza=0;
    public int posicion=0;
    public int siguiendo=0;
    
    public abstract boolean getRecurso();
    public abstract int getAmenaza();
    public abstract int getEspaciosAmenaza();
    public abstract String getMovimiento();
    public abstract int getPosicionX();
    public abstract int getPosicionY();
    public abstract int getPosicionXrecurso();
    public abstract int getPosicionYrecurso();
    public abstract int getPosicionXAmenaza();
    public abstract int getPosicionYAmenaza();
    public abstract void setposicion(int n);
    public abstract int getsiguiendo();
    
    public abstract int DetectarCercanias(int x,int y);//Obajetos,agentes,atacantes funciona con X y Y
    public abstract void DetectarRecurso(int x,int y);
    public abstract void DetectarObstaculo(int x, int y);
    public abstract void Base();
    public abstract void AmenazaNoDetectada();
    public abstract void DetectarAmenaza();
    public abstract void DetectarAgente(boolean rec, int Amen, int esp, String mov, int posXrec, int posYrec, int cod, int amenX,int sig, int amenY);
    public abstract void MoverAgente();
}
