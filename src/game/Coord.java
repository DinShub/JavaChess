package game;

public class Coord {
	
	private int col;
	private int row;
	
	public Coord(int _col, int _row) {
		this.col = _col;
		this.row = _row;
	}
	
	
	public char getCol() {
		switch(this.col) {
		case 0: return 'A'; 
		case 1: return 'B';
		case 2: return 'C';
		case 3: return 'D';
		case 4: return 'E'; 
		case 5: return 'F'; 
		case 6: return 'G'; 
		case 7: return 'H'; 
		default: return '0';
		}
	}
	
	public int getRow() { return this.row +1; }
	
	public int getX() { return this.col; }
	public int getY() { return this.row; }
	
	public String getCoord() { return getCol() + "" + this.getRow(); }
}
