package solvers;

import java.util.ArrayList;
import java.util.Collections;

import core.*;

public class Heuristic extends BasicQueenSolver {
	private int dim;
	public Chessboard board;
	private ArrayList<Queen> queens;

	public Heuristic(Chessboard board) {
		this.dim = board.getDim();
		this.board = board;
		this.queens = new ArrayList<Queen>();
	}

	public Chessboard queensToBoard(ArrayList<Queen> queens, int dim) {
		// this.board = new Chessboard(dim);

		for (int i = 0; i < queens.size(); i++) {
			setQueen(queens.get(i), this.board);
		}
		return this.board;
	}

	public void setQueen(Queen queen, Chessboard board) {
		board.set(true, queen.getX(), queen.getY());
	}

	// public void removeQueen(Queen queen, Chessboard board) {
	// board.set(false, queen.getX(), queen.getY());
	// }

	public Queen leastThreats(int x, int y) {
		ArrayList<Queen> row = new ArrayList<Queen>();
		ArrayList<Queen> candidates = new ArrayList<Queen>();
		for (int i = 0; i < dim; i++) {
			row.add(new Queen(this.board, i, y));
		}

		Collections.sort(row);
		int best = row.get(0).getThreats();

		while (row.isEmpty() == false && row.get(0).getThreats() == best) {
			candidates.add(row.get(0));
			row.remove(0);
		}

		Collections.shuffle(candidates);

		Queen replacement = candidates.get(0);
		candidates.remove(0);

		while (replacement.getX() == x) {
			if (!candidates.isEmpty()) {
				replacement = candidates.get(0);
				candidates.remove(0);
			} else {
				replacement = row.get(0);
				row.remove(0);
			}

		}
		// System.out.println("putting " + replacement);

		return replacement;
	}

	@Override
	public void solve() {
		System.out.println("Solving...");
		int prev = -1;

		for (int i = 0; i < dim; i++) {
			Queen queen = leastThreats(i, i);
			board.set(true, queen.getX(), queen.getY());
			queens.add(queen);
		}

		while (!checkChessboard(board)) {

			Collections.sort(queens);

			Queen mostConflicted = queens.get(dim - 1);
			if (mostConflicted.getY() == prev) {
				Collections.shuffle(queens);
				mostConflicted = queens.get(dim - 1);
			}

			Queen replacement = leastThreats(mostConflicted.getX(),
					mostConflicted.getY());

			board.set(false, mostConflicted.getX(), mostConflicted.getY());
			board.set(true, replacement.getX(), replacement.getY());

			queens.remove(dim - 1);
			queens.add(replacement);

			for (Queen q : queens) {
				q.update(board);
			}
			prev = replacement.getY();
		}
		System.out.println("Found solution:");
		System.out.println(board);
//		System.out.println(queens);

	}

}
