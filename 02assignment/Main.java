import core.*;
import solvers.*;

public class Main{

public static void main(String[] args){

//	BruteForce force = new BruteForce();
//	force.solve();
	
//	Backtracking bt = new Backtracking();
//	bt.solve();
	int dim = 8;
	
	Heuristic heuristic = new Heuristic(dim);
	heuristic.solve();
	
	Chessboard board = new Chessboard(8);
//	board.set(true, 3, 0);
//	board.set(true, 3, 7);
	board.set(true, 3, 3);
//	board.set(true, 0, 3);
//	board.set(true, 7, 3);
	board.set(true, 1, 1);
	board.set(true, 5, 5);
	board.set(true, 5, 1);
	board.set(true, 0, 6);
	board.set(true, 0, 0);
	board.printBoard();
	
	Queen queen = new Queen(3, 3);
	queen.checkPosition(board);


}

}