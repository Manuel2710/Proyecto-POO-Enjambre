public abstract class Agentes {
    public boolean Recurso;//Si posee recurso
    public int Amenaza;//Si a detectado amenaza
    public boolean Obstaculo;//Si tiene un obstaculo a la par
    public int EspaciosAmenaza;//Espacio a moverse en caso de amenaza
    public String Movimiento;//Siguiente movimiento a realizar
    public int PosicionX;//Posición en los ejes x,y 
    public int PosicionY;
    public int PosicionXrecurso;//Posición de recurso encontrado
    public int PosicionYrecurso;
    public int PosicionXbase;//Posición de la base
    public int PosicionYbase;
    public int PosicionXAmenaza;//Posición de amenaza encontrada
    public int PosicionYAmenaza;
    public int posicion;//Lugar en la lista de objetos
    public int siguiendo;//Agente siguiendo
    
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
    
    public abstract int DetectarCercanias(int x,int y);//Objetos,agentes,atacantes funciona con X y Y
    public abstract void DetectarRecurso(int x,int y);
    public abstract void DetectarObstaculo(int x, int y,int x4, int y4);
    public abstract void Base();
    public abstract void AmenazaNoDetectada();
    public abstract void DetectarAmenaza(int x, int y);
    public abstract void DetectarAgente(boolean rec, int Amen, int esp, String mov, int posXrec, int posYrec,int amenX, int amenY,int sig, int cod);
    public abstract void MoverAgente();
}
