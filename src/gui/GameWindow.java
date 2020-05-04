package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MenuItem;
import java.io.File;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.imageio.ImageIO;
import javax.swing.*;

import game.Cell;
import game.GameBoard;
import game.MainGame;
import game.Unit;

public class GameWindow extends JFrame implements ActionListener, MouseListener {
	
	private int height;
	private int width;
	private GameBoard gb;
	private Grid grid;
	private boolean bClickedUnit = false;
	
	public GameWindow(int _width, int _height, GameBoard _gb) {
		this.height = _height;
		this.width = _width;
		this.gb = _gb;
		new JFrame();
		this.setSize(this.width, this.height);
		this.setTitle("Chess");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid = new Grid(this);
		this.setContentPane(grid);

		this.addMouseListener(this);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public class Grid extends JPanel {
		GameWindow parent;
		
		public final int cellWidth = 75;
		public final int cellHeight = 75;
		public final int gridX = 200;
		public final int gridY = 50+(7*this.cellHeight);
		
		public Grid(GameWindow _parent) {
			this.parent = _parent;
		}
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, this.parent.width, this.parent.height);
			
			for(Cell cell : gb.getBoard()) {
				int rectX = gridX+(this.cellWidth*cell.getLocation().getX());
				int rectY = gridY-(this.cellHeight*cell.getLocation().getY());
				switch(cell.getColor()) {
				case WHITE: g.setColor(new Color(255, 204, 128));break;
				case BLACK: g.setColor(new Color(204, 102, 0));break;
				}
				g.fillRect(rectX, rectY, this.cellWidth, this.cellHeight);
				Image img;
				if(cell.getUnit() != null) {
					img = Toolkit.getDefaultToolkit().getImage(cell.getUnit().getImg());
					g.drawImage(img, rectX,rectY, this);
				}
				if(cell.isSelected()) {
					g.setColor(Color.GREEN);
					g.fillOval(rectX+this.cellWidth/4, rectY+this.cellHeight/4, this.cellWidth/2, this.cellHeight/2);
					System.out.println("Drew moves");
				}
				
			}
			
		}
		
	}
	
	private int[] translateCoordsToGrid(int screenX, int screenY) {
		int[] grid = new int[2];
		grid[0] = (screenX-7-200)/75;
		grid[1] = -1*((screenY-30-50)/75)+7;
		System.out.println(grid[0] + "," + grid[1]);
		return grid;
	}

	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		if((mouseX > grid.gridX+5 && mouseX <= grid.gridX + grid.cellWidth*8 +5) && (mouseY <= grid.gridY+grid.cellHeight + 30 && mouseY > grid.gridY - grid.cellHeight*7 + 30)) {
			int[] coords = translateCoordsToGrid(mouseX, mouseY);
			System.out.println(mouseX-7 + "," + (mouseY-75-30));
			Unit selected = null;
			if(!gb.getBoard()[coords[0] + coords[1]*8].isEmpty()) {
				selected = gb.getBoard()[coords[0] + coords[1]*8].getUnit();
				System.out.println(selected.getType());
			}
			MainGame.mouseClicked(coords[0], coords[1]);
		}
	}
	
	public void paintAgain() {
		this.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
