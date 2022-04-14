import java.util.Random;
public class Recolectores extends Agentes{
    Random rand = new Random();
    public Recolectores(){
        this.Recurso = false;
        this.Amenaza = 1;
        this.obstaculo=" ";
        this.EspaciosAmenaza = 10;
        this.Movimiento = "Derecha";
        this.PosicionX= rand.nextInt(50+1);//Donde aparezcan
        this.PosicionY= rand.nextInt(50+1);
        this.PosicionXrecurso=60;//Ubicación default fuera del 50x50
        this.PosicionYrecurso=60;
        this.PosicionXbase=0;//Donde se encuentre la base
        this.PosicionYbase=0;
        this.PosicionXAmenaza=0;
        this.PosicionYAmenaza=0;
        this.posicion=0;
        this.siguiendo=0;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////
public boolean getRecurso(){
    return Recurso;
}
public int getAmenaza(){
    return Amenaza;
}
public int getEspaciosAmenaza(){
    return EspaciosAmenaza;
}
public String getMovimiento(){
    return Movimiento;
}
public int getPosicionX(){
    return PosicionX;
}
public int getPosicionY(){
    return PosicionY;
}
public int getPosicionXrecurso(){
    return PosicionXrecurso;
}
public int getPosicionYrecurso(){
    return PosicionYrecurso;
}
public int getPosicionXAmenaza(){
    return PosicionXAmenaza;
}
public int getPosicionYAmenaza(){
    return PosicionYAmenaza;
}

public void setposicion(int n){
    posicion=n;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    public int DetectarCercanias(int x,int y){
        int comparacion = x-PosicionX;
        if (comparacion==0 || comparacion==1||comparacion==-1)//Esta en el mismo bloque una a la derecha o a la izquierda
        {
            return posicion;
        }
        else
        {
            comparacion = y-PosicionY;
            if (comparacion==0 || comparacion==1||comparacion==-1){
                return posicion;
            }
            else{
                return -1;
            }
        }
    }

    public void DetectarRecurso(int x,int y){
        Recurso=true;
        PosicionXrecurso=x;
        PosicionYrecurso=y;
    }

    public void AmenazaNoDetectada(){
        Amenaza=1;
    }

    public void DetectarAmenaza(){
        Amenaza=2;
    }

    public void DetectarObstaculo(int x, int y){
        int comparacion = x-PosicionX;
        switch(comparacion){
            case 0:
                obstaculo="Izquierda";
            case 1:
                obstaculo="Izquierda";
            case -1:
                obstaculo="Derecha";
        }
        comparacion = y-PosicionY;
        switch(comparacion){
            case 0:
                obstaculo="Abajo";
            case 1:
                obstaculo="Arriba";
            case -1:
                obstaculo="Abajo";
        }
    }

    public void DetectarAgente(boolean rec, int Amen, int esp, String mov, int posXrec, int posYrec,int amenX, int amenY, int cod){
        if (rec==true){
            if (Recurso==true){
                siguiendo=cod;
            }
             else{
                 PosicionXrecurso=posXrec;
                 PosicionYrecurso=posYrec;
            }
        }
        if (Amen==2){//huyendo
            Amenaza=2;
            EspaciosAmenaza=esp;
            PosicionXAmenaza=amenX;//En caso de encontrarse con otro defensor pasarle el dato
            PosicionYAmenaza=amenY;
            Movimiento=mov;
        }
        if (Amen==3){//atacando
            Amenaza=2;
            PosicionXAmenaza=amenX;
            PosicionYAmenaza=amenY;
            switch (mov){
                case "Izquierda":
                    Movimiento="Derecha";
                case "Derecha":
                    Movimiento="Izquierda";
                case "Arriba":
                    Movimiento="Abajo";
                case "Abajo":
                    Movimiento="Arriba";
            }
        }
    }

    public void MoverAgente(){
        if (Amenaza==1){//No se ah encontrado una amenaza
            if (Recurso==false){//no a encontrado recurso
                if (PosicionXrecurso==60){//No le han pasado la hubicación de algún recurso
                    while (true){//Evita que se salgan de pantalla
                        switch (rand.nextInt(4+1)){
                            case 1:
                                if (PosicionX>0){
                                PosicionX=PosicionX-1;
                                Movimiento="Izquierda";
                                break;
                                }
                            case 2:
                                if (PosicionX<50){
                                PosicionX=PosicionX+1;
                                Movimiento="Derecha";
                                break;
                                }
                            case 3:
                                if (PosicionY>0){ 
                                PosicionY=PosicionY-1;
                                Movimiento="Arriba";
                                break;
                                }
                            case 4:
                                if (PosicionY<50){
                                PosicionY=PosicionY+1;
                                Movimiento="Abajo";
                                break;
                                }
                        }
                    }
                }
                else
                {
                    if (PosicionXrecurso>PosicionX){
                        PosicionX=PosicionX+1;
                    }
                    if (PosicionXrecurso<PosicionX){
                        PosicionX=PosicionX-1;
                    }
                    if (PosicionXrecurso==PosicionX){
                        if (PosicionYrecurso>PosicionY){
                            PosicionY=PosicionY+1;
                        }
                        if (PosicionYrecurso<PosicionY){
                            PosicionY=PosicionY-1;
                        }
                    }
                }
            }
            else{
                if (PosicionXbase>PosicionX){
                    PosicionX=PosicionX+1;
                }
                if (PosicionXbase<PosicionX){
                    PosicionX=PosicionX-1;
                }
                if (PosicionXbase==PosicionX){
                    if (PosicionYbase>PosicionY){
                        PosicionY=PosicionY+1;
                    }
                    if (PosicionYbase<PosicionY){
                        PosicionY=PosicionY-1;
                    }
                }
            }
        }
        else{//En caso de amenaza
            switch (Movimiento){
                case "Izquierda":
                    PosicionX=PosicionX-1;
                case "Derecha":
                    PosicionX=PosicionX+1;
                case "Arriba":
                    PosicionY=PosicionY-1;
                case "Abajo":
                    PosicionY=PosicionY+1;
            }
            EspaciosAmenaza=EspaciosAmenaza-1;
        }
        //posiciones amenazas,recursos, agentes
    }
}
