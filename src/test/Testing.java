package test;

import game.*;
import game.units.Pawn;
import gui.GUIHandler;
import gui.GameWindow;

public class Testing {

	public static void main(String[] args) {
		
		Player white = new Player("White", Color.WHITE);
		GameBoard gB = new GameBoard();
		Unit test_base = new Pawn(white, gB.getBoard()[0], gB);
		System.out.println(test_base.getCell().getCoord());
		
		GameWindow gW = new GameWindow(1024,720, gB);
		
	}

}
