package core;

public class Queen implements Comparable<Object> {
	int x; // the x coordinate
	int y; // the y coordinate
	int threats; // number of queens threatening the current one

	public Queen(int x, int y) {
		this.x = x;
		this.y = y;
		this.threats = 0;
	}

	public int getTreats() {
		return this.threats;
	}

	public void resetThreats() {
		this.threats = 0;
	}

	/*
	 * compares two queens on the basis of the number of threats
	 */
	@Override
	public int compareTo(Object queen) {

		if (!(queen instanceof Queen)) {
			throw new ClassCastException("Invalid object");
		}

		int n = ((Queen) queen).getTreats();

		if (this.getTreats() > n) {
			return 1;
		} else if (this.getTreats() < n) {
			return -1;
		} else {
			return 0;
		}
	}

	public int checkPosition(Chessboard board) {
		int x = this.x;
		int y = this.y;

		int dim = board.dim;

		// check the column
		for (int i = 0; i < dim; i++) {
			if (x != i) {
				if (board.get(x, i)) {
					System.out.println("Threat from " + x + " , " + i + " !");
					this.threats++;
				}
			}
		}
		// check the row
		for (int i = 0; i < dim; i++) {
			if (y != i) {
				if (board.get(i, y)) {
					System.out.println("Threat from " + i + " , " + y + " !");
					this.threats++;
				}
			}
		}

		// check diagonals
		// to lower right
		for (int i = x; i < dim; i++) {
			for (int j = y; j < dim; j++) {
				if (x != i && y != j) {
					if (board.get(i, j)) {
						System.out.println("Threat from " + i + " , " + j
								+ " !");
						this.threats++;
					}
				}
			}
		}
		// to lower left
		for (int i = x; i < dim; i++) {
			for (int j = y; j > 0; j--) {
				if (x != i && y != j) {
					if (board.get(i, j)) {
						System.out.println("Threat from " + i + " , " + j
								+ " !");
						this.threats++;
					}
				}
			}
		}
		// to upper right
		for (int i = x, j = y; i >= 0 && j < dim; i--, j++) {
			 if (i != x && j != y) {
			if (board.get(i, j)) {
				System.out.println("Threat from " + i + " , " + j + " !");
				this.threats++;
			}
			 }
		}
		// to upper left
		for (int i = x, j = y; i >= 0 && j >=0; i--, j--) {
			 if (i != x && j != y) {
			if (board.get(i, j)) {
				System.out.println("Threat from " + i + " , " + j + " !");
				this.threats++;
			}
			 }
		}
		System.out.println("Queen has " + this.threats + " threats!");

		return this.threats;
	}
}
