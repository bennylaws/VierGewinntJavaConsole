package vier;

/**
 * 
 * @author ben
 * 
 *	This class checks for valid positions, sets chips, checks whether
 *	someone has won and turns the board by 90° (not implemented yet)
 */

public class Turn {

	static boolean set(char color, int col) {
		
		int countRow = 0;

		if (checkCol(col)) {

			// if col allowed, put chip to [lowest avail. row][col]
			while (countRow < Board.rows && Board.matrix[countRow][col] == Board.empty)
				countRow++;

			countRow--;
		
		Board.matrix[countRow][col] = color;
		
		}
		
		else
			return false;

		// check for win after setting chip
		if (checkWin(color)) {
			Board.run = false;
			Print.out();
			
			// game over
			if (color == Board.red)
				System.out.printf("********** Spieler 1 [X] hat gewonnen :-) **********\n\n");
			else
				System.out.printf("********** Spieler 2 [O] hat gewonnen :-) **********\n\n");
		}

		return true;

	}

	// check if [row][col] has space for chip
	static boolean checkCol(int col) {

		if (Board.matrix[0][col] == Board.empty)
			return true;

		return false;
	}

	// call after every single turn && after every 90° board turn
	static boolean checkWin(char color) {

		int tmpRow = 0;
		int tmpCol = 0;
		int count = 0;

		for (int i = 0; i < Board.rows; i++) {
			for (int j = 0; j < Board.cols; j++) {

				// put checks for all directions and BOTH colors here!
				// for normal version (no ultra - no 90° turns) only for one
				// color

				// check to right
				tmpRow = i;
				tmpCol = j;
				count = 0;

				if (tmpCol < Board.cols - 4 && Board.matrix[tmpRow][tmpCol] == color) {

					while (tmpCol < Board.cols && Board.matrix[tmpRow][tmpCol] == color) {
						tmpCol++;
						count++;

						if (count >= 4)
							return true;
					}
				}

				// check to bottom-right
				tmpRow = i;
				tmpCol = j;
				count = 0;

				if (tmpCol < Board.cols - 4 && tmpRow < Board.rows - 4 && Board.matrix[tmpRow][tmpCol] == color) {

					while (tmpCol < Board.cols && tmpRow < Board.rows && Board.matrix[tmpRow][tmpCol] == color) {
						tmpCol++;
						tmpRow++;
						count++;

						if (count >= 4)
							return true;
					}
				}

				// check to bottom
				tmpRow = i;
				tmpCol = j;
				count = 0;

				if (tmpRow < Board.rows - 4 && Board.matrix[tmpRow][tmpCol] == color) {

					while (tmpRow < Board.rows && Board.matrix[tmpRow][tmpCol] == color) {
						tmpRow++;
						count++;

						if (count >= 4)
							return true;
					}
				}

				// check to bottom-left
				tmpRow = i;
				tmpCol = j;
				count = 0;

				if (tmpCol > 3 && tmpRow < Board.rows - 4 && Board.matrix[tmpRow][tmpCol] == color) {

					while (tmpCol >= 0 && tmpRow < Board.rows && Board.matrix[tmpRow][tmpCol] == color) {
						tmpCol--;
						tmpRow++;
						count++;

						if (count >= 4)
							return true;
					}
				}

				// check to left
				tmpRow = i;
				tmpCol = j;
				count = 0;

				if (tmpCol > 3 && Board.matrix[tmpRow][tmpCol] == color) {

					while (tmpCol >= 0 && Board.matrix[tmpRow][tmpCol] == color) {
						tmpCol--;
						count++;

						if (count >= 4)
							return true;
					}
				}

				// check to top-left
				tmpRow = i;
				tmpCol = j;
				count = 0;

				if (tmpCol > 3 && tmpRow > 3 && Board.matrix[tmpRow][tmpCol] == color) {

					while (tmpCol >= 0 && tmpRow >= 0 && Board.matrix[tmpRow][tmpCol] == color) {
						tmpCol--;
						tmpRow--;
						count++;

						if (count >= 4)
							return true;
					}
				}

				// check to top
				tmpRow = i;
				tmpCol = j;
				count = 0;

				if (tmpRow > 3 && Board.matrix[tmpRow][tmpCol] == color) {

					while (tmpRow >= 0 && Board.matrix[tmpRow][tmpCol] == color) {
						tmpRow--;
						count++;

						if (count >= 4)
							return true;
					}
				}

				// check to top-right
				tmpRow = i;
				tmpCol = j;
				count = 0;

				if (tmpCol < Board.cols - 4 && tmpRow > 3 && Board.matrix[tmpRow][tmpCol] == color) {

					while (tmpCol < Board.cols && tmpRow >= 0 && Board.matrix[tmpRow][tmpCol] == color) {
						tmpCol++;
						tmpRow--;
						count++;

						if (count >= 4)
							return true;
					}
				}
			}
		}
		return false;
	}
}
