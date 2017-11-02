import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

public class BambooTile extends RankTile {
	
	Bamboo[] bamboo;
	
	public BambooTile(int rank)  {   
		super(rank);  
		bamboo = new Bamboo[44];
		
		
		bamboo[0] = new Bamboo(65,15,Color.BLUE);
		bamboo[1] = new Bamboo(65,50,Color.GREEN);
		
		bamboo[2] = new Bamboo(65,15,Color.BLUE);
		bamboo[3] = new Bamboo(45,50,Color.GREEN);
		bamboo[4] = new Bamboo(85,50,Color.GREEN);
		
		bamboo[5] = new Bamboo(45,15,Color.BLUE);
		bamboo[6] = new Bamboo(85,15,Color.GREEN);
		bamboo[7] = new Bamboo(45,50,Color.BLUE);
		bamboo[8] = new Bamboo(85,50,Color.GREEN);
		
		bamboo[9] = new Bamboo(35,15,Color.GREEN);
		bamboo[10] = new Bamboo(95,15,Color.BLUE);
		bamboo[11] = new Bamboo(35,50,Color.BLUE);
		bamboo[12] = new Bamboo(95,50,Color.GREEN);
		bamboo[13] = new Bamboo(65,35,Color.RED);
		
		bamboo[14] = new Bamboo(35,15,Color.GREEN);
		bamboo[15] = new Bamboo(65,15,Color.GREEN);
		bamboo[16] = new Bamboo(95,15,Color.GREEN);
		bamboo[17] = new Bamboo(35,50,Color.BLUE);
		bamboo[18] = new Bamboo(65,50,Color.BLUE);
		bamboo[19] = new Bamboo(95,50,Color.BLUE);
		
		bamboo[20] = new Bamboo(35,34,Color.GREEN);
		bamboo[21] = new Bamboo(65,34,Color.BLUE);
		bamboo[22] = new Bamboo(95,34,Color.GREEN);
		bamboo[23] = new Bamboo(35,66,Color.GREEN);
		bamboo[24] = new Bamboo(65,66,Color.BLUE);
		bamboo[25] = new Bamboo(95,66,Color.GREEN);
		bamboo[26] = new Bamboo(65,2,Color.RED);
		
		bamboo[27] = new Bamboo(35,2,Color.GREEN);
		bamboo[28] = new Bamboo(65,2,Color.GREEN);
		bamboo[29] = new Bamboo(95,2,Color.GREEN);
		bamboo[30] = new Bamboo(50,34,Color.RED);
		bamboo[31] = new Bamboo(80,34,Color.RED);
		bamboo[32] = new Bamboo(35,66,Color.BLUE);
		bamboo[33] = new Bamboo(65,66,Color.BLUE);
		bamboo[34] = new Bamboo(95,66,Color.BLUE);
		
		bamboo[35] = new Bamboo(35,2,Color.RED);
		bamboo[36] = new Bamboo(65,2,Color.BLUE);
		bamboo[37] = new Bamboo(95,2,Color.GREEN);
		bamboo[38] = new Bamboo(35,34,Color.RED);
		bamboo[39] = new Bamboo(65,34,Color.BLUE);
		bamboo[40] = new Bamboo(95,34,Color.GREEN);
		bamboo[41] = new Bamboo(35,66,Color.RED);
		bamboo[42] = new Bamboo(65,66,Color.BLUE);
		bamboo[43] = new Bamboo(95,66,Color.GREEN);
		
		setToolTipText(toString());
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		switch(rank){
		case 2:
			bamboo[0].draw(g);
			bamboo[1].draw(g);
			break;
		case 3: 
			bamboo[2].draw(g);
			bamboo[3].draw(g);
			bamboo[4].draw(g);
			break;
		case 4: 
			bamboo[5].draw(g);
			bamboo[6].draw(g);
			bamboo[7].draw(g);
			bamboo[8].draw(g);
			break;
		case 5:
			bamboo[9].draw(g);
			bamboo[10].draw(g);
			bamboo[11].draw(g);
			bamboo[12].draw(g);
			bamboo[13].draw(g);
			break;
		case 6:
			bamboo[14].draw(g);
			bamboo[15].draw(g);
			bamboo[16].draw(g);
			bamboo[17].draw(g);
			bamboo[18].draw(g);
			bamboo[19].draw(g);
			break;
		case 7:
			bamboo[20].draw(g);
			bamboo[21].draw(g);
			bamboo[22].draw(g);
			bamboo[23].draw(g);
			bamboo[24].draw(g);
			bamboo[25].draw(g);
			bamboo[26].draw(g);
			break;
		case 8:
			bamboo[27].draw(g);
			bamboo[28].draw(g);
			bamboo[29].draw(g);
			bamboo[30].draw(g);
			bamboo[31].draw(g);
			bamboo[32].draw(g);
			bamboo[33].draw(g);
			bamboo[34].draw(g);
			break;
		case 9:
			bamboo[35].draw(g);
			bamboo[36].draw(g);
			bamboo[37].draw(g);
			bamboo[38].draw(g);
			bamboo[39].draw(g);
			bamboo[40].draw(g);
			bamboo[41].draw(g);
			bamboo[42].draw(g);
			bamboo[43].draw(g);
			break;
		}
	}
	
	public String toString()  {   
		return "Bamboo " + rank;  
	} 
	public class Bamboo {
		private int x;
		private int y;
		private Color color;
		public Bamboo(int x, int y, Color color){
			this.x = x;
			this.y = y;
			this.color = color;
		}
		public void draw(Graphics g){
			g.setColor(color);
			g.fillArc(x, y, 13, 12, 0, 180);
			g.fillArc(x, y+13, 13, 12, 0, 180);
			g.fillArc(x, y+26, 13, 12, 0, 180);
			g.fillRect(x+4, y+5, 6, 25);
			g.setColor(Color.WHITE);
			g.fillRect(x+7, y+3, 1, 10);
			g.fillRect(x+7, y+20, 1, 10);
			/*g.fillArc(25, 25, 13, 12, 0, 180);
			g.fillArc(25, 38, 13, 12, 0, 180);
			g.fillArc(25, 51, 13, 12, 0, 180);
			g.fillRect(29, 30, 6, 25);
			g.setColor(Color.WHITE);
			g.fillRect(32, 28, 1, 10);
			g.fillRect(32, 45, 1, 10);*/
		}
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}