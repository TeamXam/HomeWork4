/**
 * Java 1. Home work 4. TicTacToe
 *
 * @author ToBapuW
 * @version dated August 23, 2018
 */
import java.util.Random;
import java.util.Scanner;

 class TicTacToe {

     final int size = 5;
     final char DOT_pole = '.';
     final char DOT_X = 'x';
     final char DOT_O = 'o';
     char[][] map = new char[size][size];
     Scanner sc = new Scanner(System.in);
     Random rnd = new Random();

     public static void main(String[] args) {
         new TicTacToe();
     }

     TicTacToe() {
         initMap();
         while (true) {
             humanTurn();
             if (checkWin(DOT_X)) {
                 System.out.println("You win");
                 break;
             }
             if (isMapFull()) {
                 System.out.println("The map is full");
                 break;
             }
             aiTurn();
             printMap();
             if (checkWin(DOT_O)) {
                 System.out.println("You suck");
                 break;
             }
             if (isMapFull()) {
                 System.out.println("The map is Ffull");
                 break;
             }
         }
         System.out.println("GAME OVER.");
         printMap();
     }

     void initMap() {
         for (int i = 0; i < size; i++)
             for (int j = 0; j < size; j++)
                 map[i][j] = DOT_pole;
     }

     void printMap() {
         for (int i = 0; i < size; i++) {
             for (int j = 0; j < size; j++)
                 System.out.print(map[i][j] + " ");
             System.out.println();
         }
         System.out.println();
     }

     void humanTurn() {
         int x, y;
         do {
             System.out.println("Enter X and Y (1..5):");
             x = sc.nextInt() - 1;
             y = sc.nextInt() - 1;
         } while (!isCellValid(x, y));
         map[y][x] = DOT_X;
     }

     void aiTurn() {
         int x, y;
         do {
             x = rnd.nextInt(size);
             y = rnd.nextInt(size);
         } while (!isCellValid(x, y));
         map[y][x] = DOT_O;
     }

     boolean checkWin(char dot) {
         // check horizontals
         if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
         if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
         if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;
         // check verticals
         if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
         if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
         if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true;
         // check diagonals
         if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
         if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;
         return false;
     }

     boolean isMapFull() {
         for (int i = 0; i < size; i++)
             for (int j = 0; j < size; j++)
                 if (map[i][j] == DOT_pole)
                     return false;
         return true;
     }

     boolean isCellValid(int x, int y) {
         if (x < 0 || y < 0 || x >= size || y >= size)
             return false;
         return map[y][x] == DOT_pole; // by DSerov
     }
 }