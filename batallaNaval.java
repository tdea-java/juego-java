/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rtz
 */

import javax.swing.JOptionPane;
import java.util.*;


public class batallaNaval {

    //menu del juego
    public static void main(String []args){
      menuUsuario();
    }

    //Crea los tableros
    public static int [][] tableros(int tablero[][], int indice){

        switch (indice){
            case 0:
                for(int i = 0; i<6; i++){
                    for(int j = 0; j<6; j++){
                        if( (i<=4 && j==0) || (i==0 && (j==2||j== 3))   || (i==2 && (j==2||j==3||j==4)) || (j==5 && i>=4)
                                ){
                            tablero[i][j]=1;
                        }
                    }
                }
                break;
            case 1:
                for(int i = 0; i<6; i++){
                    for(int j = 0; j<6; j++){
                        if((j<5 && i==5) || (i==2 && (j>=0 && j <2)) || (i==0 && (j>=1 && j <= 2)) || (j==4 && (i>0 && i<4))){
                            tablero[i][j]=1;
                        }
                    }
                }
                break;
            case 2:
                for(int i = 0; i<6; i++){
                    for(int j = 0; j<6; j++){
                        if((i<5 && j==2) || (j==0 && (i>0 && i<4)) || (i==0 && (j>=4 && j <= 5)) || (i==5 && (j>=0 && j<=1))){
                            tablero[i][j]=1;
                        }
                    }
                }
                break;
            case 3:
                for(int i = 0; i<6; i++){
                    for(int j = 0; j<6; j++){
                        if((i>0 && j==5) || (i==4 && (j>0 && j <4)) || (i==1 && (j>=2 && j <= 3)) || (j==0 && (i>=2 && i<=3))){
                            tablero[i][j]=1;
                        }
                    }
                }
                break;
        }

        return tablero;
    }

    //generar tableros visibles para el usuario
    public static String[][] tableroVisible(){

      String tablero[][] = new String[6][6];

      for(int i=0; i < tablero.length; i++){
         for(int j=0; j < tablero[i].length; j++){
            tablero[i][j] = "-";
         }
      }

      return tablero;
    }

    //Inicia el juego
    public static void jugar(){

        //Tableros con la informacion de los barcos de cada jugador
        int tablero1 [][]= new int [6][6],tablero2 [][]= new int [6][6];
        Random random = new Random();
        int random1 = random.nextInt(4);
        int random2 = random.nextInt(4);

        if(random1 == random2){
          random2 = random.nextInt(4);
        }
        tablero1 = tableros(tablero1,random1);
        tablero2 = tableros(tablero2,random2);

        //Tableros visibles para el jugador
        String[][] tableroVPlayer1 = tableroVisible();
        String[][] tableroVPlayer2 = tableroVisible();

        //contador de puntos jugador1
        int contPlayer1 = 0;
        int contBarcoPlayer1 = cantPuntosBarcosPlayer(tablero1);

        //contador de puntos jugador2
        int contPlayer2 = 0;
        int contBarcoPlayer2 = cantPuntosBarcosPlayer(tablero2);

        //coordenadas del jugador
        int coorX = 0;
        int coorY = 0;
        String CoorXY;

        //variables globales para los dos jugadores
         boolean turnoPlayer = true;
         int turnoJuego = 1;

        while((contPlayer1<contBarcoPlayer1) && (contPlayer2<contBarcoPlayer2)){


            if(turnoPlayer){
               CoorXY = JOptionPane.showInputDialog(
                "Turno del jugador #1 \n" +
                "Capitán!! Coordenadas para atacar."
               );
            } else{
                CoorXY = JOptionPane.showInputDialog(
                "Turno del jugador #2 \n" +
                "Capitán!! Coordenadas para atacar."
               );
            }

            String[] cXY = CoorXY.split(",");
            coorX = Integer.parseInt(cXY[0]);
            coorY = Integer.parseInt(cXY[1]);

            System.out.print("\nTurno de la partida #" + turnoJuego + " \t |  ");

            if(turnoPlayer){
               System.out.print("ATAQUE JUGADOR #1 \n"
                + "--------------------------- \n");

               if(!tableroVPlayer2[coorX][coorY].equals("-")){
                    System.out.print("Capitan!! pon mas cuidado, estamos atacando en el mismo punto.\n");
               } else{
                  if(tablero2[coorX][coorY] == 1){
                      tableroVPlayer2[coorX][coorY] = "O";
                      contPlayer1++;
                  } else {
                     tableroVPlayer2[coorX][coorY] = "X";
                     }
                  }

            } else {
                System.out.print("ATAQUE JUGADOR #2 \n"
                  + "----------------- \n");

               if(!tableroVPlayer1[coorX][coorY].equals("-")){
                   System.out.print("Capitan!! pon mas cuidado, estamos atacando en el mismo punto.\n");
               } else{
                  if(tablero1[coorX][coorY] == 1){
                      tableroVPlayer1[coorX][coorY] = "O";
                      contPlayer2++;
                  } else {
                     tableroVPlayer1[coorX][coorY] = "X";
                     }
                 }


            }

          System.out.println("Tablero JUGADOR #1");
          if(turnoPlayer){
             mensajes(tablero2,coorX,coorY);
          }

          System.out.print("y/x\t0\t1\t2\t3\t4\t5\n");
          for(int i = 0; i < tableroVPlayer1.length; i++){
            System.out.print( i +"\t");
              for(int j = 0; j < tableroVPlayer1[i].length; j++){

                  System.out.print(tableroVPlayer1[i][j] + "\t");
              }
              System.out.println();
          }

          System.out.println();

          System.out.println("Tablero JUGADOR #2");

          if(!turnoPlayer){
             mensajes(tablero1,coorX,coorY);
          }
          System.out.print("y/x\t0\t1\t2\t3\t4\t5\n");
          for(int i = 0; i < tableroVPlayer2.length; i++){
            System.out.print( i +"\t");
              for(int j = 0; j < tableroVPlayer2[i].length; j++){
                  System.out.print(tableroVPlayer2[i][j] + "\t");
              }
              System.out.println();

          }

      turnoPlayer = !turnoPlayer;
      turnoJuego++;

    }
    if(contPlayer1>contPlayer2){
        System.out.println(
          "ENHORABUENA \n"
          + "-------------- \n"
          + "El ganador es el jugador 1");
    }else{
         System.out.println("ENHORABUENA \n"
          + "-------------- \n"
          + "El ganador es el jugador 2");
    }

  }

    //Metodo para los mensajes
    public static void mensajes(int tablero[][], int x, int y){

      String[] msgFallos =
      {
      "Tripulacion: ¡¡¡Mira donde tiras!!!",
      "Tripulacion: Seguro me abuelita le hubiera dado",
      "Tripulacion: Casi estoy acostumbrado a que falles",
      "Tripulacion: Por poco, seguro que a la proxima le damos."
      };

      String[] msgBuenos =
      {
      "Tripulacion: Booyah!, de eso estamos hablando.",
      "Tripulacion: Justo en el blanco!",
      "Tripulacion: Bien, a eso me referia.",
      "Tripulacion: Ese es nuestro capitan."
      };

      Random random = new Random();
      int opc = random.nextInt(4);


      if(tablero[x][y] == 1){
         System.out.print(msgBuenos[opc]+ "\n");
      } else{
        System.out.print(msgFallos[opc]+ "\n");
      }

    }

    //Ver los puntos de vida de cada jugador segun la cantidad de barcos
    public static int cantPuntosBarcosPlayer(int tableroPlayer[][]) {
    int cantBarcoPlayer = 0;
       for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
              if(tableroPlayer[i][j] == 1){
                  cantBarcoPlayer++;
                }
            }
        }
       return cantBarcoPlayer;
    }

    //Instrucciones de juego
    public static void instruccionesJuego(){
      Scanner sc = new Scanner(System.in);
      System.out.println("MANUAL DE USUARIO \n"+
              "El objetivo del juego es destruir la flota de nuestro enemigo,\n"+
              "para esto debes ingresar las coordenadas de la forma x,y '0,5' \n"+
              "si aciertas destrozaras un parte de su barco, las flotas \n"+
              "estan constitudias por 4 barcos: \n"+
              "1. de 5 partes, *** El gran navio ***\n"+
              "1. de 3 partes, *** El constructor ***\n"+
              "2. de 2 partes, *** Los barredores ***\n"+
              "AL ATAQUE!!!");
     System.out.print("Escriba 1, para volver al menu: ");
      int opcion = sc.nextInt();

      if(opcion == 1){
        menuUsuario();
      }
    }

     //Como funciona
    public static void comoFunciona(){
      Scanner sc = new Scanner(System.in);
      System.out.print("Como funciona, digitar 1 para volver al menu");
      int opcion = sc.nextInt();

      if(opcion == 1){
        menuUsuario();
      }
    }

     //menu del usuario
    public static void menuUsuario(){
       int optionUser = 0;

        optionUser = Integer.parseInt(JOptionPane.showInputDialog(
         "######################################### \n" +
         "BIENVENIDOS AL JUEGO BATALLA NAVAL V.1\n" +
         "######################################### \n" +
         "1. Instrucciones del juego \n" +
         "2. Empezar juego \n" +
         "3. Salir \n"+
         "######################################### \n"
        ));

        switch(optionUser){
          case 1:
            instruccionesJuego();
           break;
          case 2:
            jugar();
           break;
          case 3:
            System.out.println("Gracias por jugar!");
            break;
          default:
            menuUsuario();
       }

    }

}