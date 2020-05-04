package game.units;

import game.Cell;
import game.GameBoard;
import game.Player;
import game.Unit;
import game.Units;

public class Bishop extends Unit {

	public Bishop(Player _owner, Cell _cell, GameBoard _gB) {
		super(_owner, _cell, _gB);
		// TODO Auto-generated constructor stub
		
		this.Type = Units.BISHOP;
		
		switch(this.sOwner.getColor()) {
		case WHITE: this.img = "Images/bishop_white.png"; break;
		case BLACK: this.img = "Images/bishop_black.png"; break;
		}
	}

	

}
