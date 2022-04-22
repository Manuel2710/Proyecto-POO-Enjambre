import java.util.Random;
public class Recolectores extends Agentes{
    Random rand = new Random();
    public Recolectores(){
        Recurso = false;
        Amenaza = 1;
        Obstaculo=false;
        EspaciosAmenaza = 10;
        Movimiento = "Derecha";
        PosicionX= rand.nextInt(50+1);
        PosicionY= rand.nextInt(50+1);
        PosicionXrecurso=-1;
        PosicionYrecurso=-1;
        PosicionXbase=0;
        PosicionYbase=0;
        PosicionXAmenaza=-1;
        PosicionYAmenaza=-1;
        posicion=0;
        siguiendo=-1;
    }
//los get retornan un valor y lo establecen 
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

//Compara las coordenas recibidas con las del agentes
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
    //Establece que lleva recurso y registra la ubicación
    public void DetectarRecurso(int x,int y){
        Recurso=true;
        PosicionXrecurso=x;
        PosicionYrecurso=y;
    }
    //Restablece los atributos
    public void AmenazaNoDetectada(){
        if (EspaciosAmenaza==0){
            Amenaza=1;
            EspaciosAmenaza=10;
        }
    }
    //Cambia los atributos a huyendo de amenaza
    public void DetectarAmenaza(int x,int y){
        Amenaza=2;
        PosicionXAmenaza=x;
        PosicionYAmenaza=y;
    }
    //Compara la posición del agente con respecto al obstaculo para ver que movimiento hacer
    public void DetectarObstaculo(int x, int y, int x4, int y4){
        int comparacion = x-PosicionX;
        if(x-PosicionX==1 & y-PosicionY==1){
            return;
        }
        if (comparacion==0){
            comparacion = y-PosicionY;
            switch(comparacion){
                case 0:
                    Movimiento="Abajo";
                    break;
                case 1:
                    Movimiento="Arriba";
                    break;
                case -1:
                    Movimiento="Abajo";
                    break;
            }
            if (PosicionX==0 || PosicionX==1 & x4==1){
                Movimiento="Derecha";
            }
            if (PosicionX==49 || PosicionX==50 & x4==50){
                Movimiento="Izquierda";
            }
            Obstaculo=true;
        }
        else{
            if (y-PosicionY==0){//Confirmación por los perpediculares
            switch(comparacion){
                case 0:
                    Movimiento="Abajo";
                    break;
                case 1:
                    Movimiento="Arriba";
                    break;
                case -1:
                    Movimiento="Abajo";
                    break;
            }
            if (PosicionY==0 || PosicionY==1 & y4==1){
                Movimiento="Abajo";
            }
            if (PosicionY==49 || PosicionY==50 & y4==50){
                Movimiento="Arriba";
            }
            Obstaculo=true;
        }
            
        }
    }
    //Transfiere la información recibida a los atributos
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
    //Restablece los valores a los originales
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
    //Cambia los datos de x, y según el orden de prioridad
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
            if (comparacion > 1 & PosicionX>0){
                    PosicionX=PosicionX-1;
                    Movimiento="Izquierda";
            }
            if (comparacion < 1 & PosicionX<50){
                    PosicionX=PosicionX+1;
                    Movimiento="Derecha";
            }
            comparacion = PosicionYAmenaza-PosicionY;
            if (comparacion > 1 & PosicionY>0){
                    PosicionY=PosicionY-1;
                    Movimiento="Arriba";
            }
            if (comparacion < 1 & PosicionY<50){
                    PosicionY=PosicionY+1;
                    Movimiento="Abajo";
            }
            EspaciosAmenaza=EspaciosAmenaza-1;
        }
    }
}
