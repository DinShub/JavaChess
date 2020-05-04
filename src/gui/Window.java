package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window extends JFrame implements ActionListener {
	private int width;
	private int height;
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private State currState;
	
	enum State{
		MAIN,
		OPTIONS,
		GAME
	}
	
	public Window(String _title, int _width, int _height) {
		this.width = _width;
		this.height = _height;
		
		this.currState = State.MAIN;
		
		new JFrame();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(_title);
		this.setSize(this.width, this.height);
		this.setLayout(this.gbl);
		
		drawMain();
	}
	
	public void updateMenu() {
		switch(currState) {
		case MAIN: drawMain(); break;
		//case GAME: drawGame(); break;
		case OPTIONS: drawOptions(); break;
		}
	}
	
	private JButton createButton(String _title, int _x, int _y, int _width, int _height) {
		JButton b = new JButton(_title);
		this.gbc.ipadx = _width;
		this.gbc.ipady = _height;
		this.gbc.gridx = _x;
		this.gbc.gridy = _y;
		this.add(b, this.gbc);
		return b;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Play"))
			this.currState = State.GAME;
		else if(e.getActionCommand().equals("Options")) {
			this.currState = State.OPTIONS;
			drawOptions();
		}
	}
	
	private void drawMain() {
		//this.removeAll();
		//this.setLayout(gbl);
		JButton play = createButton("Play", 0,0,70,50);
		JButton options = createButton("Options", 0,1,50,50);
		options.addActionListener(this);
		this.setVisible(true);
	}
	
	private void drawOptions() {
		this.removeAll();
		
		JTextArea width_text = new JTextArea(Integer.toString(this.width), 1, 4);
		JTextArea height_text = new JTextArea(Integer.toString(this.height), 1, 4);
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}
}
