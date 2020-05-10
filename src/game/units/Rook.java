package game.units;

import java.util.ArrayList;
import java.util.List;

import game.Cell;
import game.GameBoard;
import game.Player;
import game.Unit;
import game.Units;

public class Rook extends Unit {

	public Rook(Player _owner, Cell _cell, GameBoard _gB) {
		super(_owner, _cell, _gB);
		// TODO Auto-generated constructor stub
		
		this.Type = Units.ROOK;
		
		switch(this.sOwner.getColor()) {
		case WHITE: this.img = "Images/rook_white.png"; break;
		case BLACK: this.img = "Images/rook_black.png"; break;
		}
	}
	
	public List<Cell> possibleMoves() {
		List<Cell> moves = new ArrayList<Cell>();
		
		for(int i = this.y+1; i <= 7; i++) {
			if(!gB.getCell(x, i).isEmpty()) {
				if(gB.getCell(x, y).getUnit().getOwner().getColor() != this.sOwner.getColor())
					moves.add(gB.getCell(this.x, i));
				break;
			}
			moves.add(gB.getCell(this.x, i));
		}
		for(int i = this.y-1; i >= 0; i--) {
			if(!gB.getCell(this.x, i).isEmpty()) {
				if(gB.getCell(this.x, i).getUnit().getOwner().getColor() != this.sOwner.getColor())
					moves.add(gB.getCell(this.x, i));
				break;
			}
			moves.add(gB.getCell(this.x, i));
		}
		for(int i = this.x+1; i <= 7; i++) {
			if(!gB.getCell(i, this.y).isEmpty()) {
				if(gB.getCell(i, this.y).getUnit().getOwner().getColor() != this.sOwner.getColor())
					moves.add(gB.getCell(i, this.y));
				break;
			}
			moves.add(gB.getCell(i, this.y));
		}
		for(int i = this.x-1; i >= 0; i--) {
			if(!gB.getCell(i, this.y).isEmpty()) {
				if(gB.getCell(i, this.y).getUnit().getOwner().getColor() != this.sOwner.getColor())
					moves.add(gB.getCell(i, this.y));
				break;
			}
			moves.add(gB.getCell(i, this.y));
		}
		
		
		
		return moves;
	}
	
}
