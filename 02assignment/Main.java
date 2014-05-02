import solvers.Heuristic;
import core.Chessboard;

public class Main {

	public static void main(String[] args) {

		// BruteForce force = new BruteForce();
		// force.solve();

		// Backtracking bt = new Backtracking();
		// bt.solve();
		int dim = 50;

		Chessboard board = new Chessboard(dim);		
		Heuristic heuristic = new Heuristic(board);
		heuristic.solve();
		
	}

}