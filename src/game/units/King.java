package game.units;

import java.util.ArrayList;
import java.util.List;

import game.Cell;
import game.GameBoard;
import game.Player;
import game.Unit;
import game.Units;

public class King extends Unit {

	public King(Player _owner, Cell _cell, GameBoard _gB) {
		super(_owner, _cell, _gB);
		// TODO Auto-generated constructor stub
		
		this.Type = Units.KING;
		
		switch(this.sOwner.getColor()) {
		case WHITE: this.img = "Images/king_white.png"; break;
		case BLACK: this.img = "Images/king_black.png"; break;
		}
	}
	
	public List<Cell> possibleMoves() {
		List<Cell> moves = new ArrayList<Cell>();
		
		if(validateMove(x+1,y)) moves.add(gB.getCell(x+1, y));
		if(validateMove(x-1,y)) moves.add(gB.getCell(x-1, y));
		if(validateMove(x,y+1)) moves.add(gB.getCell(x, y+1));
		if(validateMove(x,y-1)) moves.add(gB.getCell(x, y-1));
		if(validateMove(x+1,y+1)) moves.add(gB.getCell(x+1, y+1));
		if(validateMove(x-1,y+1)) moves.add(gB.getCell(x-1, y+1));
		if(validateMove(x-1,y-1)) moves.add(gB.getCell(x-1, y-1));
		if(validateMove(x+1,y-1)) moves.add(gB.getCell(x+1, y-1));
		
		return moves;
	}
	
	private boolean validateMove(int x, int y) {
		if(x >= 0 && x <= 7 && y >= 0 && y <= 7) {
			if(gB.getCell(x, y).isEmpty()) {
				if(!checkCheck(x, y))
					return true;
			}
			else if(gB.getCell(x, y).getUnit().getOwner().getColor() != this.sOwner.getColor())
				if(!checkCheck(x,y))
					return true;
		}
		return false;
	}
	
	private boolean checkCheck(int x, int y) {
		//Check if a bishop/Queen threatens it
		//go in a diagonal in all 4 ways until we hit a unit
		//if the unit color is different and it is a bishop/Queen then we return true
		//Check if a rook/Queen threatens it
		//go in a straight in all 4 ways until we hit a unit
		//if the unit color is different and it is a rook/Queen then we return true
		for(int i = 0; i <= 7; i++) {
			if(x+i <= 7 && y+i <= 7) {
				if(!gB.getCell(x+i, y+i).isEmpty())
					if(gB.getCell(x+i, y+i).getUnit().getOwner().getColor() != this.sOwner.getColor() && (gB.getCell(x+i, y+i).getUnit().getType() == Units.BISHOP
							|| gB.getCell(x+i,y+i).getUnit().getType() == Units.QUEEN))
						return true;
					else
						break;
			}
		}
		for(int i = 0; i <= 7; i++) {
			if(x-i >= 0 && y+i <= 7) {
				if(!gB.getCell(x-i, y+i).isEmpty())
					if(gB.getCell(x-i, y+i).getUnit().getOwner().getColor() != this.sOwner.getColor() && (gB.getCell(x-i, y+i).getUnit().getType() == Units.BISHOP
							|| gB.getCell(x-i,y+i).getUnit().getType() == Units.QUEEN))
						return true;
					else
						break;
			}
		}
		for(int i = 0; i <= 7; i++) {
			if(x+i <= 7 && y-i >= 0) {
				if(!gB.getCell(x+i, y-i).isEmpty())
					if(gB.getCell(x+i, y-i).getUnit().getOwner().getColor() != this.sOwner.getColor() && (gB.getCell(x+i, y-i).getUnit().getType() == Units.BISHOP
							|| gB.getCell(x+i,y-i).getUnit().getType() == Units.QUEEN))
						return true;
					else
						break;
			}
		}
		for(int i = 0; i <= 7; i++) {
			if(x-i >= 0 && y-i >= 0) {
				if(!gB.getCell(x-i, y-i).isEmpty())
					if(gB.getCell(x-i, y-i).getUnit().getOwner().getColor() != this.sOwner.getColor() && (gB.getCell(x-i, y-i).getUnit().getType() == Units.BISHOP
					|| gB.getCell(x-i,y-i).getUnit().getType() == Units.QUEEN))
						return true;
					else
						break;
			}
		}
		for(int i = 0; i <= 7; i++) {
			if(x + i <= 7) {
				if(!gB.getCell(x+i, y).isEmpty())
					if(gB.getCell(x+i, y).getUnit().getOwner().getColor() != this.sOwner.getColor() && (gB.getCell(x+i, y).getUnit().getType() == Units.ROOK
					|| gB.getCell(x+i, y).getUnit().getType() == Units.QUEEN))
						return true;
					else
						break;
			}
		}
		for(int i = 0; i <= 7; i++) {
			if(x - i >= 0) {
				if(!gB.getCell(x-i, y).isEmpty())
					if(gB.getCell(x-i, y).getUnit().getOwner().getColor() != this.sOwner.getColor() && (gB.getCell(x-i, y).getUnit().getType() == Units.ROOK
					|| gB.getCell(x-i, y).getUnit().getType() == Units.QUEEN))
						return true;
					else
						break;
			}
		}
		for(int i = 0; i <= 7; i++) {
			if(y + i <= 7) {
				if(!gB.getCell(x, y+i).isEmpty())
					if(gB.getCell(x, y+i).getUnit().getOwner().getColor() != this.sOwner.getColor() && (gB.getCell(x, y+i).getUnit().getType() == Units.ROOK
					|| gB.getCell(x, y+i).getUnit().getType() == Units.QUEEN))
						return true;
					else
						break;
			}
		}
		for(int i = 0; i <= 7; i++) {
			if(y - i >= 0) {
				if(!gB.getCell(x, y-i).isEmpty())
					if(gB.getCell(x, y-i).getUnit().getOwner().getColor() != this.sOwner.getColor() && (gB.getCell(x, y-i).getUnit().getType() == Units.ROOK
					|| gB.getCell(x, y-i).getUnit().getType() == Units.QUEEN))
						return true;
					else
						break;
			}
		}
		
		//Check if the cell is threatened by a pawn
		//We check based on the color the right diagonal cells if a pawn from a different color is situated
		switch(this.sOwner.getColor()) {
		case WHITE:if(x+1 <= 7 && y+1 <= 7 && !gB.getCell(x+1, y+1).isEmpty()) if(gB.getCell(x+1, y+1).getUnit().getOwner().getColor() == game.Color.BLACK && gB.getCell(x+1, y+1).getUnit().getType() == Units.PAWN)
			return true;
		if(x-1 >=0 && y+1 <= 7 && !gB.getCell(x-1, y+1).isEmpty()) if(gB.getCell(x-1, y+1).getUnit().getOwner().getColor() == game.Color.BLACK && gB.getCell(x-1, y+1).getUnit().getType() == Units.PAWN)
			return true;
		break;
		case BLACK:if(x+1 <= 7 && y-1 >= 0 && !gB.getCell(x+1, y-1).isEmpty()) if(gB.getCell(x+1, y-1).getUnit().getOwner().getColor() == game.Color.WHITE && gB.getCell(x+1, y-1).getUnit().getType() == Units.PAWN)
			return true;
		if(x-1 >= 0 && y-1 >= 0 && !gB.getCell(x-1, y-1).isEmpty()) if(gB.getCell(x-1, y-1).getUnit().getOwner().getColor() == game.Color.WHITE && gB.getCell(x-1, y-1).getUnit().getType() == Units.PAWN)
			return true;
		}
		
		return false;
	}
}
