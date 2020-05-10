package game.units;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import game.Cell;
import game.Color;
import game.Coord;
import game.GameBoard;
import game.Player;
import game.Unit;
import game.Units;

public class Pawn extends Unit {
	
	private boolean bFirstMove;
	
	public Pawn(Player _owner, Cell _cell, GameBoard _gB) {
		super(_owner, _cell, _gB);
		this.Type = Units.PAWN;
		this.bFirstMove = true;
		switch(this.sOwner.getColor()) {
		case WHITE: this.img = "Images/pawn_white.png"; break;
		case BLACK: this.img = "Images/pawn_black.png"; break;
		}
	}
	
	public List<Cell> possibleMoves() {
		List<Cell> moves = new ArrayList<Cell>();
		switch(this.sOwner.getColor()) {
		case WHITE: if(bFirstMove)	if(validateMove(x, y+2)) moves.add(gB.getCell(x, y+2));
		if(validateMove(x, y+1)) moves.add(gB.getCell(x, y+1));
		if(validateMove(x+1, y+1)) moves.add(gB.getCell(x+1, y+1));
		if(validateMove(x-1, y+1)) moves.add(gB.getCell(x-1, y+1));
		break;
		case BLACK:if(bFirstMove)	if(validateMove(x, y-2)) moves.add(gB.getCell(x, y-2));
		if(validateMove(x, y-1)) moves.add(gB.getCell(x, y-1));
		if(validateMove(x+1, y-1)) moves.add(gB.getCell(x+1, y-1));
		if(validateMove(x-1, y-1)) moves.add(gB.getCell(x-1, y-1));
		break;
		}
		
		return moves;
	}
	
	private boolean validateMove(int x, int y) {
		if(x > 7 || x < 0)
			return false;
		if(y > 7 || y < 0)
			return false;
		if(x == this.x && (y == this.y +1 || y == this.y +2 || y == this.y-1 || y == this.y -2))
			if(!gB.getCell(x, y).isEmpty())
				return false;
		if(x == this.x+1 || x== this.x-1)
			if(gB.getCell(x, y).isEmpty())
				return false;
			else if(gB.getCell(x, y).getUnit().getOwner().getColor() == this.sOwner.getColor())
				return false;
		
		return true;
	}
	
}
