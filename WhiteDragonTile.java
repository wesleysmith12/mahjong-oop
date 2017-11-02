import java.awt.Color;
import java.awt.Graphics;

public class WhiteDragonTile extends Tile {  
	public WhiteDragonTile(){
		//super();
		setToolTipText(toString());
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		//top
		g.fillRect(31, 11, 15, 7);
		g.fillRect(60, 11, 15, 7);
		g.fillRect(89, 11, 15, 7);
		//right
		g.fillRect(103, 24, 7, 15);
		g.fillRect(103, 54, 7, 15);
		//bottom
		g.fillRect(96, 83, 15, 7);
		g.fillRect(65, 83, 15, 7);
		g.fillRect(37, 83, 12, 7);
		//left
		g.fillRect(31, 32, 7, 15);
		g.fillRect(31, 61, 7, 15);
		g.setColor(Color.BLACK);
		g.drawRect(30, 10, 80, 80);
		g.drawRect(37, 17, 66, 66);
	}
	public String toString()  {   
		return "White Dragon";  
	} 
}