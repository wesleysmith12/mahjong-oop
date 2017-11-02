import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*abstract */public class Tile extends JPanel{
	
	private int x;
	private int y;
	private int z;
	private boolean painted;
	private int zOrder;
	
	public Tile(){
		setPreferredSize(new Dimension(121,121));
		setSize(121,121);
		setOpaque(false);
		painted = true;
		this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		//this.add(jboard);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(!painted)
			return;
		
		int x1[] = {10,20,20,10,10};
		int y1[] = {10,0,100,110,10};
		int x2[] = {0,10,10,0,0};
		int y2[] = {20,10,110,120,35};
		int x3[] = {20,120,110,10,20};
		int y3[] = {100,100,110,110,100};
		int x4[] = {10,110,100,0,10};
		int y4[] = {110,110,120,120,110};
		
		Color myColor = Color.decode("#efe1c4");
		Color shade = Color.decode("#47a342");
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint grad = new GradientPaint(0, 20,
				shade,
				10, 110, Color.GREEN);
		GradientPaint grad2 = new GradientPaint(110, 110,
				shade,
				0, 120, Color.GREEN);
		
		g.setColor(myColor);
		g.fillRect(20, 0, 100, 100);
		
		g.fillPolygon(x1, y1, 5);
		g.fillPolygon(x3, y3, 5);
		
		g2.setPaint(grad);
		g.fillPolygon(x2, y2, 5);
		g2.setPaint(grad2);
		g.fillPolygon(x4, y4, 5);
		g.setColor(Color.BLACK);
		
		// draw outlines
		g.drawRect(20, 0, 100, 100);
		g.drawPolygon(x1, y1, 5);
		g.drawPolygon(x3, y3, 5);
		g.drawPolygon(x2, y2, 5);
		g.drawPolygon(x4, y4, 5); 	
	}
	public boolean matches(Tile other)  {   
		// this prevents a tile matching with itself
		if (this == other)    
			return false;
		if (other == null)    
			return false;
		return getClass() == other.getClass();  
	} 
	
	public int getTileX(Tile tile){
		return tile.x;
	}
	public int getTileY(Tile tile){
		return tile.y;
	}
	public int getTileZ(Tile tile){
		return tile.z;
	}
	
	public void setTileX(int x){
		this.x = x;
	}
	public void setTileY(int y){
		this.y = y;
	}
	public void setTileZ(int z){
		this.z = z;
	}
	
	// z-order functions
	public void setZOrder(){
		zOrder = getParent().getComponentZOrder(this);
	}
	
	public int getZOrder()
    {
        return zOrder;
    }
	
	public void resetZOrder()
    {
        getParent().setComponentZOrder(this, zOrder);
    }
	
	
	public boolean getPainted(){
		return painted;
	}
	
	public void setPainted(boolean painted){
		this.painted = painted;
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");

		frame.add(new Tile());
		//temp fix
		//frame.setSize(500,500);
		frame.pack();
		
		frame.setVisible(true);
	}
	
}