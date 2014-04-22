public class Backtracking extends BasicQueenSolver {
	public static final int dim = 8;
	public static int solutions;

	@Override
	public void solve() {
		solutions = 0;
		for (int i = 0; i < dim; i++){
			Chessboard board = new Chessboard(dim);
			board.set(true, 0, i);
			backTracking(1, dim, board);
		}
		System.out.println( solutions + " solutions found.");
	}
	
	public void backTracking(int n, int dim, Chessboard board) {
//		System.out.println("n is " + n);
		if (n == dim){
			board.printBoard();
			solutions++;
			return;
		}
		
		for (int i = 0; i < dim; i++){
			Chessboard copy = board.copy();
			copy.set(true, n, i);
			if (i > 0){
				copy.set(false, n, i-1);
			}
//			System.out.println("n " + n + " i " + i);
//			copy.printBoard();
			if (checkChessboard(copy) == true){
				backTracking(n+1, dim, copy);
			}
		}
	}

}

