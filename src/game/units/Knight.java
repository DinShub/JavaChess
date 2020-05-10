package game.units;

import java.util.ArrayList;
import java.util.List;

import game.Cell;
import game.Coord;
import game.GameBoard;
import game.Player;
import game.Unit;
import game.Units;

public class Knight extends Unit {

	public Knight(Player _owner, Cell _cell, GameBoard _gB) {
		super(_owner, _cell, _gB);
		// TODO Auto-generated constructor stub
		
		this.Type = Units.KNIGHT;
		
		switch(this.sOwner.getColor()) {
		case WHITE: this.img = "Images/knight_white.png"; break;
		case BLACK: this.img = "Images/knight_black.png"; break;
		}
	}
	
	public List<Cell> possibleMoves() {
		List<Cell> moves = new ArrayList<Cell>();
		
		if(validateMove(x+2, y+1))	moves.add(gB.getCell(x+2, y+1));
		if(validateMove(x-2, y+1))	moves.add(gB.getCell(x-2, y+1));
		if(validateMove(x+2, y-1))	moves.add(gB.getCell(x+2, y-1));
		if(validateMove(x-2, y-1))	moves.add(gB.getCell(x-2, y-1));
		if(validateMove(x+1, y+2))	moves.add(gB.getCell(x+1, y+2));
		if(validateMove(x-1, y+2))	moves.add(gB.getCell(x-1, y+2));
		if(validateMove(x+1, y-2))	moves.add(gB.getCell(x+1, y-2));
		if(validateMove(x-1, y-2))	moves.add(gB.getCell(x-1, y-2));
		
		return moves;
	}
	
	private boolean validateMove(int x, int y) {
		if(x > 7 || x < 0)
			return false;
		if(y > 7 || y < 0)
			return false;
		if(!gB.getCell(x, y).isEmpty())
			if(gB.getCell(x, y).getUnit().getOwner().getColor() == this.sOwner.getColor())
				return false;
		
		
		return true;
	}
	
}
