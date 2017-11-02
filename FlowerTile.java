import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class FlowerTile extends PictureTile {  

	private String filePath = "";
	
	public FlowerTile(String name)  {   
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
		frame.setTitle("Flower Tiles");

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.pack();
		frame.setVisible(true);
	}
	
}