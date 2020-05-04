package game.units;

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

}
