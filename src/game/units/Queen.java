package game.units;

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

}
