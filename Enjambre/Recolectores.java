import java.util.Random;
public class Recolectores extends Agentes{
    Random rand = new Random();
    public Recolectores(){
        Recurso = false;
        Amenaza = 1;
        Obstaculo=false;
        EspaciosAmenaza = 10;
        Movimiento = "Derecha";
        PosicionX= rand.nextInt(50+1);//Donde aparezcan
        PosicionY= rand.nextInt(50+1);
        PosicionXrecurso=-1;//Ubicación default fuera del 50x50
        PosicionYrecurso=-1;
        PosicionXbase=0;//Donde se encuentre la base
        PosicionYbase=0;
        PosicionXAmenaza=-1;
        PosicionYAmenaza=-1;
        posicion=0;
        siguiendo=-1;
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

public int getsiguiendo(){
    return siguiendo;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////


public int DetectarCercanias(int x,int y){
        int comparacion = x-PosicionX;
        if (comparacion==0 || comparacion==1||comparacion==-1)//Esta en el mismo bloque una a la derecha o a la izquierda
        {
            comparacion = y-PosicionY;
            if (comparacion==0 || comparacion==1||comparacion==-1){
                return posicion;
            }
        }
        return -1;
    }

    public void DetectarRecurso(int x,int y){
        Recurso=true;
        PosicionXrecurso=x;
        PosicionYrecurso=y;
    }

    public void AmenazaNoDetectada(){
        Amenaza=1;
        EspaciosAmenaza=10;
    }

    public void DetectarAmenaza(int x,int y){
        Amenaza=2;
        PosicionXAmenaza=x;
        PosicionYAmenaza=y;
    }

    public void DetectarObstaculo(int x, int y){
        int comparacion = x-PosicionX;
        if (comparacion==0){
            comparacion = y-PosicionY;
            switch(comparacion){
                case 0:
                    Movimiento="Izquierda";
                case 1:
                    Movimiento="Izquierda";
                case -1:
                    Movimiento="Derecha";
            }
            Obstaculo=true;
        }
        else{
            if (y-PosicionY==0){//Confirmación por los perpediculares
            switch(comparacion){
                case 0:
                    Movimiento="Abajo";
                case 1:
                    Movimiento="Arriba";
                case -1:
                    Movimiento="Abajo";
            }
            Obstaculo=true;
        }
            
        }
    }
    public void DetectarAgente(boolean rec, int Amen, int esp, String mov, int posXrec, int posYrec,int amenX, int amenY,int sig, int cod){
        if (rec==true){
            if (Recurso==true & sig!=posicion){//Para que no se empicen a seguir entre ellos
                siguiendo=cod;
                Movimiento=mov;
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

    public void Base(){
        Recurso = false;
        Amenaza = 1;
        EspaciosAmenaza = 10;
        Movimiento = "Derecha";
        PosicionXrecurso=-1;//Ubicación default fuera del 50x50
        PosicionYrecurso=-1;
        PosicionXAmenaza=-1;
        PosicionYAmenaza=-1;
        siguiendo=-1;
    }

    public void MoverAgente(){
        boolean ciclo=true;
        if (Amenaza==1 || Obstaculo==true){//No se ah encontrado una amenaza
            if (Recurso==false || Obstaculo==true){//no a encontrado recurso
                if (PosicionXrecurso==-1 || Obstaculo==true){//No le han pasado la hubicación de algún recurso
                    Obstaculo=false;
                    switch (Movimiento){
                        case "Izquierda":
                            if (PosicionX>0){
                                PosicionX=PosicionX-1;
                                break;
                            }
                        case "Derecha":
                            if (PosicionX<50){
                                PosicionX=PosicionX+1;
                                break;
                            }
                        case "Arriba":
                            if (PosicionY>0){ 
                                PosicionY=PosicionY-1;
                                break;
                            }
                        case "Abajo":
                            if (PosicionY<50){
                                PosicionY=PosicionY+1;
                                break;
                            }
                        }
                    while (ciclo){//En caso de que de un numero que lo vaya a sacar de pantalla
                        switch (rand.nextInt(5+1)){//Se estipula el proximo movimiento
                            case 1:
                                if (PosicionX>0){
                                    Movimiento="Izquierda";
                                    ciclo=false;
                                    break;
                                }
                            case 2:
                                if (PosicionX<50){
                                    Movimiento="Derecha";
                                    ciclo=false;
                                    break;
                                }
                            case 3:
                                if (PosicionY>0){ 
                                    Movimiento="Arriba";
                                    ciclo=false;
                                    break;
                                }
                            case 4:
                                if (PosicionY<50){
                                    Movimiento="Abajo";
                                    ciclo=false;
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
                    //En caso de que este buscando un recurso pero este ya no esta
                    if (PosicionXrecurso==PosicionX & PosicionYrecurso==PosicionY & Recurso==false){
                        PosicionXrecurso=-1;
                        PosicionYrecurso=-1;
                    }
                }
            }
            else{
                if (PosicionXbase<PosicionX){
                    PosicionX=PosicionX-1;
                }
                if (PosicionXbase==PosicionX){
                    if (PosicionYbase<PosicionY){
                        PosicionY=PosicionY-1;
                    }
                }
            }
        }
        else{//En caso de amenaza
            int comparacion = PosicionXAmenaza-PosicionX;
            if (comparacion > 1){
                    PosicionX=PosicionX-1;
                    Movimiento="Izquierda";
            }
            if (comparacion < 1){
                    PosicionX=PosicionX+1;
                    Movimiento="Derecha";
            }
            comparacion = PosicionYAmenaza-PosicionY;
            if (comparacion > 1){
                    PosicionY=PosicionY-1;
                    Movimiento="Arriba";
            }
            if (comparacion < 1){
                    PosicionY=PosicionY+1;
                    Movimiento="Abajo";
            }
            EspaciosAmenaza=EspaciosAmenaza-1;
        }
    }
}
