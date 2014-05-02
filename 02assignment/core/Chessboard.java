package core;

public class Chessboard {

	public int dim = 0; // array dimension [row][column]
	public boolean[][] field = new boolean[10][10]; // n x n matrix for the
													// board
	public int nQueens = 0; // number of queens on a field

	/*
	 * Chessboard is created. dimension is set, a field in a size of dim is set
	 * up with false in each "square".
	 */
	public Chessboard(int dimension) {
		this.dim = dimension;
		this.field = new boolean[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				// System.out.printf("In field %d , %d", i,j);
				// System.out.printf(" i %d\n", i);
				this.field[i][j] = false;
			}
		}
	}

	/*
	 * Wrote createField at first to check some stuff out. Basically, the same
	 * as a Chessboard constructor.
	 */
	public void createField(int dimension) {
		dim = dimension;
		field = new boolean[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				// System.out.printf("In field %d , %d", i,j);
				// System.out.printf(" i %d\n", i);
				field[i][j] = false;
			}
		}
	}

	/*
	 * printBoard prints a board. Output of each cell depends on it's value. I
	 * like it better as a toString method.
	 */
	public void printBoard() {
		// it prints my board... but it's not String toString();

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				// System.out.printf("i = %d, j = %d", i,j);
				if (get(i, j) == false) {
					System.out.printf("[ ]");
				} else if (get(i, j) == true) {
					System.out.printf("[X]");
				}
				if (j == dim - 1) {
					System.out.printf("\n");
				}
			}
		}

		System.out.println();
		// System.out.printf("\nNumber of Queens on board: %d\n", this.nQueens);

	}

	/*
	 * A toString method being asked to be written in a task. Same principle as
	 * my printBoard, with one difference: it sticks a field into a string and
	 * can be used like that.
	 */
	public String toString() {
		// yepp, that's a toString() if you like. I don't like it.
		String string = new String();

		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				// System.out.printf("i = %d, j = %d", i,j);

				if (get(i, j) == false) {
					string = string + "[ ]";
					// System.out.printf( "[ ]");
				} else if (get(i, j) == true) {
					string = string + "[X]";
					// System.out.printf("[X]");
				}
				if (j == dim - 1) {
					string = string + "\n";
					// System.out.printf("\n");
				}
			}
		}
		string = string + "\nNumber of Queens on board: " + nQueens;
		return string;
	}

	/*
	 * just gets the value of an explicit "square"
	 */
	public boolean get(int x, int y) {
		boolean get = false;
		if (field[x][y] == false) {
			get = false;
		} else if (field[x][y] == true) {
			get = true;
		} else {
			System.out.println("Oops, something went wrong!");
		}
		return get;
	}

	/*
	 * sets "square" value to value
	 */
	public void set(boolean value, int x, int y) {

		if (value == true) {
			field[x][y] = value;
			// System.out.printf("Queen set on field %d , %d\n", x, y);
			nQueens++;
		} else if (value == false) {
			if (field[x][y] == false) {
				field[x][y] = value;
				// System.out.printf("No queen on field %d , %d\n", x, y);
			} else if (field[x][y] == true)
				field[x][y] = value;
			nQueens--;
			// System.out.printf("Queen removed from field %d , %d\n", x, y);
		}
	}

	/*
	 * copies a board square by square. previously used board.clone() which
	 * didn't work
	 */
	public Chessboard copy() {
		Chessboard copy = new Chessboard(dim);
		copy.dim = dim;
		copy.nQueens = nQueens;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				copy.set(this.get(i, j), i, j);
			}
		}
		return copy;
	}

	public int getDim() {
		return this.dim;
	}
}