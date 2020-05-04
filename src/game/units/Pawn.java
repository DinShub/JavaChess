package game.units;

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
	
	
	
}