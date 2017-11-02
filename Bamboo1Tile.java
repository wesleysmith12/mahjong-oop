import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Bamboo1Tile extends PictureTile {  
	
	private String filePath = "";
	
	public Bamboo1Tile()  {   
		super("Sparrow"); 
		
		filePath = "images/Sparrow.png";
		image = new ImageIcon(this.getClass().getResource(filePath));
		
		setToolTipText(toString());
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		image.paintIcon(this, g, 40, 20);
	}
	
	public String toString()  {   
		return "Bamboo 1";  
	} 
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo 1 Tile");

		frame.add(new Bamboo1Tile());

		frame.pack();
		frame.setVisible(true);
	}
	
}