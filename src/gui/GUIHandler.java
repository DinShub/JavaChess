package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GUIHandler {
	
	private int height;
	private int width;
	private JFrame window;
	
	public GUIHandler(int _width, int _height) {
		this.height = _height;
		this.width = _width;
		this.window = new Window("Chess", this.width, this.height);
	}
	
	
	
}
