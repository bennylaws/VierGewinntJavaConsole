package vier;

import java.util.Scanner;

/*
 * TO DO:
 * I	[done] check all directions for win
 * II	[done] original mode: 7 x 6 (rows, cols)
 * III	check if board is full && no winner -> draw
 * IV	make board quadratic &&
 * V	turn board 90° and check for win or draw
 * VI 	Single Player Mode, simple AI ?
 */
public class Board {

	static int rows = 6;
	static int cols = 7;
	static final char empty = '_', red = 'X', yellow = 'O';
	static char[][] matrix = new char[rows][cols];
	static boolean run = true;

	public static void main(String[] args) {
		
		// field empty init
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				matrix[i][j] = empty;

		// run game
		boolean player = true;		// for quick toggeling player 1 / 2
		Scanner scr = new Scanner(System.in);
		
		while (run) {
			
			Print.out();
			
			int chosenCol = -1;
			
			if (player) {
				
				while (chosenCol < 0 || chosenCol >= cols) {
					System.out.printf("*** Spieler 1 [X] *** - welche Spalte (0 - %d)? ", cols - 1);
					chosenCol = scr.nextInt();
				}
				
				if ( !(Turn.set(red, chosenCol)) )
					continue;
			}
			
			else {
				while (chosenCol < 0 || chosenCol >= cols) {
					System.out.printf("*** Spieler 2 [O] *** - welche Spalte (A - %d)? ", cols - 1);
					chosenCol = scr.nextInt();
				}
				
				if ( !(Turn.set(yellow, chosenCol)) )
					continue;
			}
			player = !player;		// toggle player
		}
		scr.close();
	}
	
}
