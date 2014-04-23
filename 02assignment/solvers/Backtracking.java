package solvers;
import core.Chessboard;

public class Backtracking extends BasicQueenSolver {
	public static final int dim = 8;
	public static int solutions;
/** Backtracking
 * uses a recursive method to check every possible solution.
 */
	/* solve() overrides a method form BasicQueenSolver.
	 * this starts a backtracking algorithm from row 1. Not from row 0,
	 * as it also sets  the first queen in row 0.
	 * The for loop goes on and starts a backtracking algorithm for
	 * each possible queen position from row zero.
	 * As soon as it's ran through the number of found solutions 
	 * will be printed.
	 */
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
	
	/* backTracking
	 * gets a current line, dimension of a chessboard and chessboard itself.
	 * It makes a copy of a board, sets another queen in a row it gets first
	 * and calls itself again with a row n+1, same dimension and a copy of
	 * a board. It goes on until the row count reaches dimension.
	 */
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

