
class Juego{

	public static void main(String args[]) {

  int[][] player1 = generarTableros();
  int[][] player2 = generarTableros();


  System.out.print("Resultado jugador1 \n");
  for(int i=0; i < player1.length; i++){
    for(int j=0; j < player1[i].length; j++){
        System.out.print(player1[i][j] + "\t");
      }
      System.out.println();
  }

   System.out.print("Resultado jugador2 \n");
  for(int i=0; i < player2.length; i++){
    for(int j=0; j < player2[i].length; j++){
        System.out.print(player2[i][j] + "\t");
      }
      System.out.println();
  }

	}

	public static int[][] generarTableros(){
		int[][][] tableros = {
		{
      { 0 ,0 ,0, 0, 0, 0},
      { 0 ,0 ,0, 0, 0, 0},
      { 0 ,0 ,0, 0, 0, 0},
      { 0 ,0 ,0, 0, 0, 0},
      { 0 ,0 ,0, 0, 0, 0},
      { 0 ,0 ,0, 0, 0, 0}
		},
		{
      { 1 ,0 ,0, 0, 0, 0},
      { 1 ,0 ,0, 0, 0, 0},
      { 1 ,0 ,0, 0, 0, 0},
      { 1 ,0 ,0, 0, 0, 0},
      { 1 ,0 ,0, 0, 0, 0},
      { 1 ,0 ,0, 0, 0, 0}
		},
    {
      { 2, 0 ,0, 0, 0, 0},
      { 2, 0 ,0, 0, 0, 0},
      { 2, 0 ,0, 0, 0, 0},
      { 2, 0 ,0, 0, 0, 0},
      { 2, 0 ,0, 0, 0, 0},
      { 2, 0 ,0, 0, 0, 0}
    }
		};

    //seleccionar solo uno de los tableros para un jugador
    int[][] tableroJugador = new int[6][6];
    int tableroRandom = (int)(Math.random()*3); // va de 0-2 de los tableros generados

     for(int i=tableroRandom; i <= tableroRandom; i++){
        for(int j=0; j < tableros[i].length; j++){
          for(int k=0; k < tableros[i][j].length; k++){
             tableroJugador[j][k] = tableros[i][j][k];
          }
          System.out.println();
        }
    }
    return tableroJugador;
  }
}
