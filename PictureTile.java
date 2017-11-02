import javax.swing.ImageIcon;

abstract public class PictureTile extends Tile {  
	private String name;
	protected ImageIcon image;
	public PictureTile(String name)  {   
		this.name = name;  	
	}
	public String toString()  {   
		return name;  
	} 
	
}