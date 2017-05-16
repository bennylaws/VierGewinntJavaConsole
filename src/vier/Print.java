package vier;

public class Print {

	static void out() {

		for (int i = 0; i < 50; i++)
			System.out.println();
		
		System.out.println("Aktuelle Belegung:\n");

		// column names
		System.out.print(" ");
		
		for (int c = 0; c < Board.cols; c++)

			System.out.print(" " + c + " ");

		System.out.println();

		for (int i = 0; i < Board.rows; i++) {

			System.out.print("|");

			for (int j = 0; j < Board.cols; j++) {

				if (Board.matrix[i][j] == Board.yellow)
					System.out.print(" " + Board.yellow + " ");

				else if (Board.matrix[i][j] == Board.red)
					System.out.print(" " + Board.red + " ");

				else
					System.out.print(" " + Board.empty + " ");

			}
			System.out.println("|");
		}

		System.out.println("\n");
	}

}
