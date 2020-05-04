package game;

public class Player {
	
	private String sName;
	private Color cColor;
	
	public Player(String _name, Color _color) {
		this.sName = _name;
		this.cColor = _color;
	}
	
	public String getName() { return this.sName;}
	public Color getColor() { return this.cColor;}
	
	public void setName(String _name) { this.sName = _name;}
}
