package game;

public class Cell {
	
	/*	Cell class is the basic tile in the game board
	 * 	Attributes:
	 * 	bIsEmpty	- true if no units on the board, false otherwise
	 * 	uUnit 		- hold reference to the unit on the cell from type Unit
	 * 	sName		- holds class Coord which tells the basic chess nomination of the cell EX: 8A
	 * 	
	 */
	
	private boolean bIsEmpty = true;
	private Unit uUnit = null;
	private Coord sName;
	private Color sColor;
	
	
	public Cell(int _x, int _y) {
		this.sName = new Coord(_x, _y);
		setColor();
	}
	
	//Getters and Setters
	public boolean isEmpty()	{	return bIsEmpty;	}
	public Unit getUnit()		{	return this.uUnit;	}
	public Coord getLocation()	{	return this.sName;	}
	public String getCoord()	{	return this.sName.getCoord();}
	public Color getColor()	{	return this.sColor;	}
	
	public void setEmpty(boolean _flag)		{	this.bIsEmpty = _flag;	}
	public void setUnit(Unit _unit)			{	this.uUnit = _unit;		}
	public void setColor(game.Color c) 		{	this.sColor = c;		}
	
	private void setColor()	{
		if(this.sName.getX() % 2 == this.sName.getY() % 2)
			this.sColor = Color.BLACK;
		else
			this.sColor = Color.WHITE;
	}
}
