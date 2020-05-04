package game;

public class Player {
	
	private String sName;
	private Color cColor;
	private boolean bCanCastle = true;
	
	public Player(String _name, Color _color) {
		this.sName = _name;
		this.cColor = _color;
	}
	
	public String getName() { return this.sName;}
	public Color getColor() { return this.cColor;}
	public boolean canCastle()	{	return this.bCanCastle;	}
	
	public void setName(String _name) { this.sName = _name;}
	public void setCanCastle(boolean flag)	{	this.bCanCastle = flag;	}
}
