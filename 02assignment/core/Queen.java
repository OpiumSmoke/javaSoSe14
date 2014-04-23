package core;

public class Queen implements Comparable<Object>{
	int x; // the x coordinate
	int y; // the y coordinate
	int threats; // number of queens threatening the current one

	public Queen(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getTreats() {
		return this.threats;
	}
/*
 * compares two queens on the basis of the number of threats
 */
	@Override
	public int compareTo(Object queen) {
		
		if(!(queen instanceof Queen)){
            throw new ClassCastException("Invalid object");
        }
		
		int n = ((Queen) queen).getTreats();
		
		if (this.getTreats() > n) {
			return 1;
		} else if ( this.getTreats() < n) {
			return -1;
		} else {
			return 0;
		}
	}

}
