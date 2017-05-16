package vier;

import java.util.Scanner;

/*
 * TO DO:
 * I	check all directions for win
 * II	turn board 90°
 * III	original mode: 7 x 6 (rows, cols)
 */
public class Board {

	static int rows = 6;
	static int cols = 7;
	static final char empty = '_', red = 'X', yellow = 'O';
	static char[][] matrix = new char[rows][cols];
	static boolean run = true;

	public static void main(String[] args) {
		
		// field init
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				matrix[i][j] = empty;

		// run game
		boolean player = true;
		Scanner scr = new Scanner(System.in);
		
		while (run) {
			
			Print.out();
			
			int chosenCol = -1;
			
			if (player) {
				
				while (chosenCol < 0 || chosenCol >= cols) {
					System.out.printf("*** Spieler 1 *** - welche Spalte (0 - %d)? ", cols - 1);
					chosenCol = scr.nextInt();
				}
				
				if ( !(Turn.set(red, chosenCol)) )
					continue;
			}
			
			else {
				while (chosenCol < 0 || chosenCol >= cols) {
					System.out.printf("*** Spieler 2 *** - welche Spalte (A - %d)? ", cols - 1);
					chosenCol = scr.nextInt();
				}
				
				if ( !(Turn.set(yellow, chosenCol)) )
					continue;
			}
			player = !player;				// toggle player
		}
		scr.close();
	}
	
}
