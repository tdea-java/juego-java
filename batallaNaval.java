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
import java.util.Scanner;

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

        //Tableros con la información de los barcos de cada jugador
        int tablero1 [][]= new int [6][6],tablero2 [][]= new int [6][6];
        tablero1 = tableros(tablero1,2);
        tablero2 = tableros(tablero2,3);

        //Tableros visibles para el jugador
        String[][] tableroVPlayer1 = tableroVisible();
        String[][] tableroVPlayer2 = tableroVisible();

        //contador de puntos jugador1
        int contPlayer1 = 0;
        int contBarcoPlayer1 = cantPuntosBarcosPlayer(tablero1);

        //contador de puntos jugador2
        int contPlayer2 = 0;
        int contBarcoPlayer2 = cantPuntosBarcosPlayer(tablero2);
        boolean turnoPlayer1 = true;

        //coordenadas al jugar
        int coorX = 0;
        int coorY = 0;

        while((contPlayer1 <= contBarcoPlayer1) || (contPlayer2 <= contBarcoPlayer2)){
            coorX = Integer.parseInt(JOptionPane.showInputDialog("Digitar coordenada en X"));
            coorY = Integer.parseInt(JOptionPane.showInputDialog("Digitar coordenada en Y"));

            if(turnoPlayer1){
               System.out.print("Turno del jugador 1 \n");
                  for(int i = 0; i < 6; i++){
                      for(int j = 0; j < 6; j++){
                          if(tablero2[coorX][coorY] == 1){
                              tableroVPlayer2[coorX][coorY] = "O";
                          } else{
                              tableroVPlayer2[coorX][coorY] = "X";
                          }
                      }
                      System.out.println();

                  }
            contPlayer1++;
            } else{
                System.out.print("Turno del jugador 2 \n");
                      for(int i = 0; i < 6; i++){
                          for(int j = 0; j < 6; j++){
                              if(tablero1[coorX][coorY] == 1){
                                  tableroVPlayer1[coorX][coorY] = "O";
                              } else{
                                  tableroVPlayer1[coorX][coorY] = "X";
                              }
                          }
                          System.out.println();

                      }
                contPlayer2++;
            }

          System.out.println("tablero visible player 1");
          for(int i = 0; i < tableroVPlayer1.length; i++){
              for(int j = 0; j < tableroVPlayer1[i].length; j++){
                  System.out.print(tableroVPlayer1[i][j] + "\t");
              }
              System.out.println();

          }

           System.out.println("tablero visible player 2");
          for(int i = 0; i < tableroVPlayer2.length; i++){
              for(int j = 0; j < tableroVPlayer2[i].length; j++){
                  System.out.print(tableroVPlayer2[i][j] + "\t");
              }
              System.out.println();

          }

        System.out.println("tablero2");
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                System.out.print("|"+tablero2[i][j]+"|");
            }
            System.out.println("");
            System.out.println("----------------");
        }

        System.out.println("tablero1");
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                System.out.print("|"+tablero1[i][j]+"|");
            }
            System.out.println();
            System.out.println("----------------");
        }

      turnoPlayer1 = !turnoPlayer1;

    }



        //ciclos visibles
        System.out.println("tablero visible player 1");

          for(int i = 0; i < tableroVPlayer1.length; i++){
              for(int j = 0; j < tableroVPlayer1[i].length; j++){
                  System.out.print(tableroVPlayer1[i][j] + "\t");
              }
              System.out.println();

          }


        System.out.println("cantidad de barcos que tiene el jugador 1: " + contBarcoPlayer1 + "\n");
        System.out.println("cantidad de barcos que tiene el jugador 2: " + contBarcoPlayer2);
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
      System.out.print("manual de usuario, digitar 1 para volver al menu");
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
         " BIENVENIDOS AL JUEGO BATALLA NAVAL V.1 \n" +
          "######################################### \n" +
         "1. Instrucciones del juego\n" +
         "2. Como funciona \n" +
         "3. Empezar juego \n" +
         "4. Salir"
        ));

        switch(optionUser){
          case 1:
            instruccionesJuego();
           break;
          case 2:
            comoFunciona();
           break;
          case 3:
            jugar();
           break;
        }
    }
}
