package solvers;
import core.Chessboard;

public class BruteForce extends BasicQueenSolver{
	
	public static final int dim = 8;
	public BruteForce() {
	}

	@Override
	public void solve() {
		int solutions = 0;
		for (int a = 0; a < dim; a++){
			for (int b = 0; b < dim; b++){
				for (int c = 0; c < dim; c++){
					for (int d = 0; d < dim; d++){
						for (int e = 0; e < dim; e++){
							for (int f = 0; f < dim; f++){
								for (int g = 0; g < dim; g++){
									for (int h = 0; h < dim; h++){
										Chessboard board = new Chessboard(dim);
										board.set(true, 0, a);
										board.set(true, 1, b);
										board.set(true, 2, c);
										board.set(true, 3, d);
										board.set(true, 4, e);
										board.set(true, 5, f);
										board.set(true, 6, g);
										board.set(true, 7, h);
										if (checkChessboard(board) == true){
											board.printBoard();
											System.out.println();
											solutions++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(solutions + " solutions found.");
	}

}
