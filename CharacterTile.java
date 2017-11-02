import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CharacterTile extends Tile {  
	protected char symbol;
	
	public CharacterTile(char symbol)  {
		this.symbol = symbol;  	
		setToolTipText(toString());
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Font	f = g.getFont().deriveFont(20F);
		g.setFont(f);	
		String temp = "";
		temp += symbol;
		g.setColor(Color.red);
		g.drawString(temp,100,20);
		//g.drawString("\u4e00", 10, 55);
		int a = Character.getNumericValue(symbol);
		//System.out.println("a: " + a);
		
		g.setColor(Color.black);
		
		if(a < 10 && a > 0){
			g.setColor(Color.red);
			f = g.getFont().deriveFont(40F);
			g.setFont(f);
			g.drawString("\u842c", 50, 85);
			g.setColor(Color.black);
			switch(symbol){
				case '1':
					g.drawString("\u4e00",50,45);
					break;
				case'2':
					g.drawString("\u4e8c",50,45);
					break;
				case '3':
					g.drawString("\u4e09",50,45);
					break;
				case'4':
					g.drawString("\u56db",50,45);
					break;
				case '5':
					g.drawString("\u4e94",50,45);
					break;
				case'6':
					g.drawString("\u516d",50,45);
					break;
				case '7':
					g.drawString("\u4e03",50,45);
					break;
				case'8':
					g.drawString("\u516b",50,45);
					break;
				case '9':
					g.drawString("\u4e5d",50,45);
					break;
			}
		}else{
			
			f = g.getFont().deriveFont(80F);
			g.setFont(f);
			
			switch(symbol){
				case'N':
					g.drawString("\u5317",30,80);
					break;
				case'E':
					g.drawString("\u6771",30,80);
					break;
				case'W':
					g.drawString("\u897f",30,80);
					break;
				case'S':
					g.drawString("\u5357",30,80);
					break;
				case'C':
					g.setColor(Color.red);
					g.drawString("\u4E2D",30,80);
					break;
				case'F':
					g.setColor(Color.green);
					g.drawString("\u767c",30,80);
					break;
			
			}
		}
		
	}
	public boolean matches(Tile other)  {   	
		return super.matches(other) && symbol == ((CharacterTile)other).symbol;  
	}
	public String toString()  {   
		switch (symbol)   {    
			case 'C': return "Red Dragon";    	
			case 'F': return "Green Dragon";    
			case 'N': return "North Wind";    
			case 'E': return "East Wind";    
			case 'W': return "West Wind";    
			case 'S': return "South Wind";    
			default : return "Character " + symbol;   
		}  
	} 
	
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		//scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile height));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
	
}