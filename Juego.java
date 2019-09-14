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

public class batallaNaval {
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
    public static void main(String []args){

      //Menu de usuario y de uso
      int optionUser;

      do{

        optionUser = Integer.parseInt(JOptionPane.showInputDialog(
         "######################################### \n" +
         " JUEGO BATALLA NAVAL V.1 \n" +
         "1. Instrucciones del juego\n" +
         "2. Como funciona \n" +
         "3. Empezar juego \n" +
         "4. Salir"
        ));


      }while(opcionUser != 5)

        int tablero1 [][]= new int [6][6],tablero2 [][]= new int [6][6];
        tablero1 = tableros(tablero1,2);
        tablero2 = tableros(tablero2,3);

        System.out.println("tablero1");
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                System.out.print("|"+tablero1[i][j]+"|");
            }
            System.out.println();
            System.out.println("----------------");
        }
        System.out.println("tablero2");
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                System.out.print("|"+tablero2[i][j]+"|");
            }
            System.out.println("");
            System.out.println("----------------");
        }
    }
}
