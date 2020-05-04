package game.units;

import java.util.ArrayList;
import java.util.List;

import game.Cell;
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
	
	public List<int[]> possibleMoves() {
		List<int[]> moves = new ArrayList<int[]>();
		
		moves.add(new int[] {x+2, y+1});
		moves.add(new int[] {x-2, y+1});
		moves.add(new int[] {x+2, y-1});
		moves.add(new int[] {x-2, y-1});
		moves.add(new int[] {x+1, y+2});
		moves.add(new int[] {x-1, y+2});
		moves.add(new int[] {x+1, y-2});
		moves.add(new int[] {x-1, y-2});
		
		return moves;
	}
	
}
