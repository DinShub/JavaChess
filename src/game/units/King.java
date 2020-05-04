package game.units;

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
	
	

}
