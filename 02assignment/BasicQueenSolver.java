public abstract class BasicQueenSolver {
/*
 * 
 */
	public BasicQueenSolver(){
	}
	
	public abstract void solve();
	
	public static boolean checkChessboard(Chessboard board){
//		check if in there is only one queen in every row, column and diagonal
//		System.out.println("Checking board...");
		int dim = board.getDim();
		int inRow = 0;
		int inColumn = 0;
		int inUpperDiagonal = 0;
		int inLowerDiagonal = 0;
		
		for (int i = 0; i < dim; i++){ // rows
			for (int j = 0; j < dim; j++){ // cols
				// checks if any row has more than two queens;
				if (board.get(i, j) == true){
					inRow++;
					if (inRow > 1){
//						System.out.println("In row "+ i + " there is more 
//											than one queen!");
//						System.out.println(inRow);
						return false;
					}
				}
				
				if (j == dim-1){ // reset queen number in a row on a new row
//					System.out.println("Reset row piece counter");
					inRow = 0;
				}
			}
		}
		
		for (int j = 0; j < dim; j++){ // cols
			for (int i = 0; i < dim; i++){ // rows
				// checks if any column has more than two queens;
				if (board.get(i, j) == true){
					inColumn++;
					if (inColumn > 1){
//						System.out.println("In column "+ j + " there is more
//											than one queen!");
//						System.out.println(inColumn);
						return false;
					}
				}
				
				if (i == dim-1){ 
					// reset queen number in a column on a new column
//					System.out.println("Reset column piece counter");
					inColumn = 0;
				}
			}
		}
		
		for (int k = 0; k < dim-1; k++){ // now check diagonals l-r.
			for (int i = 0; i+k < dim; i++){ // upper triangle
				int ik = i+k;
				if (board.get(i, i+k) == true){
					inUpperDiagonal++;
					if (inUpperDiagonal > 1){
//						System.out.println("There is more than one queen in 
//											upper diagonal on " +
//								i + " , " + ik);
//						System.out.println(inUpperDiagonal);
						return false;
					}
				}
				
				if (board.get(i+k, i) == true && k != 0){ // lower triangle
					inLowerDiagonal++;
					if (inLowerDiagonal > 1){
//						System.out.println("There is more than one queen in 
//											lower diagonal on " +
//								ik + " , " + i);
//						System.out.println(inLowerDiagonal);
						return false;
					}
				}
			}
//			System.out.println("Reset upper diagonal Counter.");
//			System.out.println("Reset lower diagonal Counter.");
			inUpperDiagonal = 0;
			inLowerDiagonal = 0;
		}
		
		for (int k = 0; k < dim-1; k++){ // now check diagonals r-l.
			for (int i = 0; i+k < dim; i++){ // upper triangle
				int ind = dim-1-(i+k);
//				System.out.println("In " +  i + " , " + ind);
				if (board.get(i, dim-1-(i+k)) == true){
					inUpperDiagonal++;
					if (inUpperDiagonal > 1){
//						System.out.println("There is more than one queen 
//								in upper diagonal on " +
//								i + " , " + ind);
//						System.out.println(inUpperDiagonal);
						return false;
					}
				}
				
				
				
				if (board.get(i+k, dim-1-i) == true &&  k != 0){ 
					// lower triangle
					inLowerDiagonal++;
					ind = dim-1-i;
					int ik = i+k;
					if (inLowerDiagonal > 1){
//						System.out.println("There is more than one queen 
//									in lower diagonal on " +
//								 + ik + " , " + ind);
//						System.out.println(inLowerDiagonal);
						return false;

					}
				}
			}
//			System.out.println("Reset upper diagonal Counter.");
//			System.out.println("Reset lower diagonal Counter.");
			inUpperDiagonal = 0;
			inLowerDiagonal = 0;
		}
		
		return true;
    }
}
