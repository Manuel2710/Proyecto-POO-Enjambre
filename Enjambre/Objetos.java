public abstract class Objetos {
    public int Vida;//Cantidad de veces que se puede interactuar con el
    public int PosicionX1;//Posición del cubo de la izquierda superior
    public int PosicionY1;
    public int PosicionX2;//Posición del cubo de la derecha superior
    public int PosicionY2;
    public int PosicionX3;//Posición del cubo de la izquierda inferior
    public int PosicionY3;
    public int PosicionX4;//Posición del cubo de la derecha inferior
    public int PosicionY4;

        
        public abstract void PerderVida();
        public abstract void VolverAparecer();
        public abstract int getPosicionX1();
        public abstract int getPosicionY1();
        public abstract int getPosicionX2();
        public abstract int getPosicionY2();
        public abstract int getPosicionX3();
        public abstract int getPosicionY3();
        public abstract int getPosicionX4();
        public abstract int getPosicionY4();
}
