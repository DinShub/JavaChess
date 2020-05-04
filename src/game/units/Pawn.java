package game.units;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import game.Cell;
import game.Color;
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
	
<<<<<<< HEAD
	public Cell[] possibleMoves() {
		Cell[] moves;
		if(bFirstMove)
			moves = new Cell[2];
		else
			moves = new Cell[1];
		switch(sOwner.getColor()) {
		case WHITE: if(bFirstMove) {
			moves[0] = gB.getCell(x, y+1);
			moves[1] = gB.getCell(x, y+2);
		}
		else
			moves[0] = gB.getCell(x, y+1);
		break;
		case BLACK: if(bFirstMove) {
			moves[0] = gB.getCell(x, y-1);
			moves[1] = gB.getCell(x, y-2);
		}
		else
			moves[0] = gB.getCell(x, y-1);
		break;
			
		}
		return moves;
	}
=======
	public List<int[]> possibleMoves() {
		List<int[]> moves = new ArrayList<int[]>();
		switch(this.sOwner.getColor()) {
		case WHITE: if(bFirstMove)	moves.add(new int[] {x, y+2});
		moves.add(new int[] {x, y+1});
		moves.add(new int[] {x+1, y+1});
		moves.add(new int[] {x-1, y+1});
		break;
		case BLACK:if(bFirstMove)	moves.add(new int[] {x, y-2});
		moves.add(new int[] {x, y-1});
		moves.add(new int[] {x+1, y-1});
		moves.add(new int[] {x-1, y-1}); 
		break;
		}
		
		return moves;
	}
	
	
>>>>>>> d907888... Added moves for Pawn and Knight.
	
}
