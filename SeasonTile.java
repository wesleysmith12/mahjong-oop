import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SeasonTile extends PictureTile {  
	
	private String filePath = "";
	
	public SeasonTile(String name)  {   
		super(name);  	
		
		filePath = "images/" + name + ".png";
		image = new ImageIcon(this.getClass().getResource(filePath));
		
		setToolTipText(toString());
		
	} 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		image.paintIcon(this, g, 40, 20);
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Season Tiles");

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
	
}