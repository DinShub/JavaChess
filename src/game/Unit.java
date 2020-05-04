package game;

public class Unit {
	
	/*	The abstract class for all the unit type
	 * 	Attributes:
	 * 	sOwner 		- Black or White player
	 * 	cLocation	- Cell to hold his location 
	 * 	sType 		- Type of the unit
	 */
	
	protected Player sOwner;
	protected Cell cCell;
	protected Units Type = null;
	protected GameBoard gB;
	protected String img;
	protected int x;
	protected int y;
	
	public Unit(Player _owner, Cell _cell, GameBoard _gB) {
		this.sOwner = _owner;
		this.cCell = _cell;
		this.x = this.cCell.getLocation().getX();
		this.y = this.cCell.getLocation().getY();
		this.gB = _gB;
	}
	
	//Getters and Setters
	public Player getOwner()	{	return this.sOwner;	}
	public Cell getCell()	{	return this.cCell;	}
	public Units getType()		{ 	return this.Type;	}
	public String getImg()		{ 	return this.img;	}
	
	public void setOwner(Player _owner)	{	this.sOwner = _owner;	}
	public void setCell(Cell _cell)	{	this.cCell = _cell;	}
	
	
	public Cell[] possibleMoves() {
		return null;
	}
	
}
