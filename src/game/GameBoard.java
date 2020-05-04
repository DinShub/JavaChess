package game;

public class GameBoard {
	
	/* Game board will be built by a 2d array 8x8 of cell class
	 * 	TODO: Cell class
	 */
	
	private Cell[] cBoard;
	
	public GameBoard() {
		cBoard = new Cell[8*8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				cBoard[i + j*8] = new Cell(i,j);
			}
		}
	}
	
	public Cell[] getBoard() {	return this.cBoard;	}
	public Cell getCell(int x, int y) 	{	return this.cBoard[x + y*8]; }
	
	public void setUnit(int x, int y, Unit unit) {
		this.cBoard[x + y*8].setUnit(unit);
		this.cBoard[x + y*8].setEmpty(false);
<<<<<<< HEAD
=======
	}
	
	public void clearSelected() {
		for(Cell cell : cBoard)
			cell.setSelected(false);
>>>>>>> d907888... Added moves for Pawn and Knight.
	}
}
