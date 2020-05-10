package game.units;

import java.util.ArrayList;
import java.util.List;

import game.Cell;
import game.GameBoard;
import game.Player;
import game.Unit;
import game.Units;

public class Queen extends Unit {

	public Queen(Player _owner, Cell _cell, GameBoard _gB) {
		super(_owner, _cell, _gB);
		// TODO Auto-generated constructor stub
		
		this.Type = Units.QUEEN;
		
		switch(this.sOwner.getColor()) {
		case WHITE: this.img = "Images/queen_white.png"; break;
		case BLACK: this.img = "Images/queen_black.png"; break;
		}
	}
	
	public List<Cell> possibleMoves() {
		List<Cell> moves = new ArrayList<Cell>();
		for(int i = 1; i <= 7; i++) {
			if(this.x+i <= 7 && this.y+i <= 7) {
				if(!gB.getCell(this.x +i, this.y + i).isEmpty()) {
					if(gB.getCell(this.x + i, this.y + i).getUnit().getOwner().getColor() != this.sOwner.getColor())
						moves.add(gB.getCell(this.x + i, this.y + i));
					break;
				}
				moves.add(gB.getCell(x+i, y+i));
			}
		}
		for(int i = 1; i <= 7; i++) {
			if(this.x-i >= 0 && this.y-i >= 0) {
				if(!gB.getCell(this.x -i, this.y - i).isEmpty()) {
					if(gB.getCell(this.x - i, this.y - i).getUnit().getOwner().getColor() != this.sOwner.getColor())
						moves.add(gB.getCell(this.x - i, this.y - i));
					break;
				}
				moves.add(gB.getCell(x-i, y-i));
			}
		}
		for(int i = 1; i <= 7; i++) {
			if(this.x+i <= 7 && this.y-i >= 0) {
				if(!gB.getCell(this.x +i, this.y - i).isEmpty()) {
					if(gB.getCell(this.x + i, this.y - i).getUnit().getOwner().getColor() != this.sOwner.getColor())
						moves.add(gB.getCell(this.x - i, this.y + i));
					break;
				}
				moves.add(gB.getCell(this.x+i, this.y-i));
			}
		}
		for(int i = 1; i <= 7; i++) {
			if(this.x-i >= 0 && this.y+i <= 7) {
				if(!gB.getCell(this.x -i, this.y + i).isEmpty()) {
					if(gB.getCell(this.x - i, this.y + i).getUnit().getOwner().getColor() != this.sOwner.getColor())
						moves.add(gB.getCell(this.x - i, this.y + i));
					break;
				}
				moves.add(gB.getCell(this.x-i, this.y+i));
			}
		}
		for(int i = this.y+1; i <= 7; i++) {
			if(!gB.getCell(this.x, i).isEmpty()) {
				if(gB.getCell(this.x, i).getUnit().getOwner().getColor() != this.sOwner.getColor())
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
