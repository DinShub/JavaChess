package game;

import java.util.ArrayList;
import java.util.List;

import game.units.*;
import gui.GameWindow;

public class MainGame  {
	static GameBoard gb = new GameBoard();
	static Player white = new Player("White", game.Color.WHITE);
	static Player black = new Player("Black", game.Color.BLACK);
	static GameWindow gw;
	static boolean bUnitSelected = false;
	static Unit selectedUnit = null;
	
	public static void main(String[] args) {
		
		
		
		initGameBoard();
		initGameWindow();
	}
	
	public static void initGameBoard() {
		//Pawns
		gb.setUnit(0, 1, new Pawn(white, gb.getCell(0,1), gb));
		gb.setUnit(1, 1, new Pawn(white, gb.getCell(1,1), gb));
		gb.setUnit(2, 1, new Pawn(white, gb.getCell(2,1), gb));
		gb.setUnit(3, 1, new Pawn(white, gb.getCell(3,1), gb));
		gb.setUnit(4, 1, new Pawn(white, gb.getCell(4,1), gb));
		gb.setUnit(5, 1, new Pawn(white, gb.getCell(5,1), gb));
		gb.setUnit(6, 1, new Pawn(white, gb.getCell(6,1), gb));
		gb.setUnit(7, 1, new Pawn(white, gb.getCell(7,1), gb));
		gb.setUnit(0, 6, new Pawn(black, gb.getCell(0,6), gb));
		gb.setUnit(1, 6, new Pawn(black, gb.getCell(1,6), gb));
		gb.setUnit(2, 6, new Pawn(black, gb.getCell(2,6), gb));
		gb.setUnit(3, 6, new Pawn(black, gb.getCell(3,6), gb));
		gb.setUnit(4, 6, new Pawn(black, gb.getCell(4,6), gb));
		gb.setUnit(5, 6, new Pawn(black, gb.getCell(5,6), gb));
		gb.setUnit(6, 6, new Pawn(black, gb.getCell(6,6), gb));
		gb.setUnit(7, 6, new Pawn(black, gb.getCell(7,6), gb));
		
		//rooks
		gb.setUnit(0, 0, new Rook(white, gb.getCell(0,0), gb));
		gb.setUnit(7, 0, new Rook(white, gb.getCell(7,0), gb));
		gb.setUnit(0, 7, new Rook(black, gb.getCell(0,7), gb));
		gb.setUnit(7, 7, new Rook(black, gb.getCell(7,7), gb));
		
		//knights
		gb.setUnit(1, 0, new Knight(white, gb.getCell(1,0), gb));
		gb.setUnit(6, 0, new Knight(white, gb.getCell(6,0), gb));
		gb.setUnit(1, 7, new Knight(black, gb.getCell(1,7), gb));
		gb.setUnit(6, 7, new Knight(black, gb.getCell(6,7), gb));
		
		//bishops
		gb.setUnit(2, 0, new Bishop(white, gb.getCell(2,0), gb));
		gb.setUnit(5, 0, new Bishop(white, gb.getCell(5,0), gb));
		gb.setUnit(2, 7, new Bishop(black, gb.getCell(2,7), gb));
		gb.setUnit(5, 7, new Bishop(black, gb.getCell(5,7), gb));
		
		//kings
		gb.setUnit(4, 0, new King(white, gb.getCell(4, 5), gb));
		gb.setUnit(4, 7, new King(black, gb.getCell(4, 7), gb));
		
		//queens
		gb.setUnit(3, 0, new Queen(white, gb.getCell(3, 5), gb));
		gb.setUnit(3, 7, new Queen(black, gb.getCell(3, 7), gb));
		
	}
	
	public static void initGameWindow() {
		gw = new GameWindow(1024, 720, gb);
	}
	
	public static void mouseClicked(int x, int y) {
		if(!gb.getCell(x, y).isEmpty()) {
			if(bUnitSelected) {
				selectedUnit.setSelected(false);
				gb.clearSelected();
			}
			selectedUnit = gb.getCell(x,y).getUnit();
			selectedUnit.setSelected(true);
			bUnitSelected = true;
			List<Cell> moves = validateMoves(selectedUnit.possibleMoves());
			for(Cell cell : moves) {
				cell.setSelected(true);
			}
		}
		else {
			bUnitSelected = false;
			selectedUnit = null;
			gb.clearSelected();
		}
		gw.paintAgain();
	}
	
	private static List<Cell> validateMoves(List<int[]> moves) {
		List<Cell> newList = new ArrayList<Cell>();
		switch(selectedUnit.getType()) {
		case PAWN:
		for(int[] coords : moves) {
			Cell cell = gb.getCell(coords[0], coords[1]);
			Color c = selectedUnit.getOwner().getColor();
			if(selectedUnit.getCell().getLocation().getX() == cell.getLocation().getX()) {
				if(cell.isEmpty())
					newList.add(cell);
			}
			else {
				if(!cell.isEmpty()) {
					if(cell.getUnit().getOwner().getColor() != c)
						newList.add(cell);
				}
			}
		}break;
		default:	for(int[] coords : moves) {
			if(legitCoords(coords)) {
				Cell cell = gb.getCell(coords[0], coords[1]);
				Color c = selectedUnit.getOwner().getColor();
				if(cell.isEmpty())
					newList.add(cell);
				else if(cell.getUnit().getOwner().getColor() != c)
					newList.add(cell);
			}
		}
		}
		return newList;
	}
	
	private static boolean legitCoords(int[] coords) {
		if(coords[0] > 7 || coords[0] < 0)
			return false;
		if(coords[1] > 7 || coords[1] < 0)
			return false;
		return true;
	}
	
}
