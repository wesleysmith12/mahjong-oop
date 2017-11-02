import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

public class CircleTile extends RankTile {  
	
	Circle[] circle;
	Pancake pancake;
	
	public CircleTile(int rank)  {   
		super(rank);
		
		//pancake object
		pancake = new Pancake(33,12,Color.GREEN);
		
		//array of circle objects
		circle = new Circle[45];
		
		circle[0] = new Circle(55,15,Color.GREEN);
		circle[1] = new Circle(55,60,Color.RED);
		
		circle[2] = new Circle(30,10,Color.BLUE);
		circle[3] = new Circle(58,40,Color.RED);
		circle[4] = new Circle(90,72,Color.GREEN);
			
		circle[5] = new Circle(35,15,Color.BLUE);
		circle[6] = new Circle(85,15,Color.GREEN);
		circle[7] = new Circle(35,65,Color.GREEN);
		circle[8] = new Circle(85,65,Color.BLUE);
		
		circle[9] = new Circle(25,5,Color.BLUE);
		circle[10] = new Circle(95,5,Color.GREEN);
		circle[11] = new Circle(25,75,Color.GREEN);
		circle[12] = new Circle(95,75,Color.BLUE);
		
		circle[13] = new Circle(35,10,Color.GREEN);
		circle[14] = new Circle(85,10,Color.GREEN);
		circle[15] = new Circle(35,42,Color.RED);
		circle[16] = new Circle(85,42,Color.RED);
		circle[17] = new Circle(35,72,Color.RED);
		circle[18] = new Circle(85,72,Color.RED);
		
		circle[19] = new Circle(30,10,Color.GREEN);
		circle[20] = new Circle(60,16,Color.GREEN);
		circle[21] = new Circle(90,22,Color.GREEN);
		circle[22] = new Circle(35,50,Color.RED);
		circle[23] = new Circle(85,50,Color.RED);
		
		circle[24] = new Circle(40,5,Color.BLUE);
		circle[25] = new Circle(40,28,Color.BLUE);
		circle[26] = new Circle(40,52,Color.BLUE);
		circle[27] = new Circle(40,75,Color.BLUE);
		circle[28] = new Circle(80,5,Color.BLUE);
		circle[29] = new Circle(80,28,Color.BLUE);
		circle[30] = new Circle(80,52,Color.BLUE);
		circle[31] = new Circle(80,75,Color.BLUE);
		
		circle[32] = new Circle(30,10,Color.GREEN);
		circle[33] = new Circle(60,10,Color.GREEN);
		circle[34] = new Circle(90,10,Color.GREEN);
		circle[35] = new Circle(30,40,Color.RED);
		circle[36] = new Circle(60,40,Color.RED);
		circle[37] = new Circle(90,40,Color.RED);
		circle[38] = new Circle(30,70,Color.BLUE);
		circle[39] = new Circle(60,70,Color.BLUE);
		circle[40] = new Circle(90,70,Color.BLUE);
		
		/*circle[41] = new Circle(55,55,Color.GREEN);*/
		
		setToolTipText(toString());
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		switch(rank){
		case 1:
			pancake.draw(g);
			break;
		case 2:
			circle[0].draw(g);
			circle[1].draw(g);
			break;
		case 3: 
			circle[2].draw(g);
			circle[3].draw(g);
			circle[4].draw(g);
			break;
		case 4: 
			circle[5].draw(g);
			circle[6].draw(g);
			circle[7].draw(g);
			circle[8].draw(g);
			break;
		case 5: 
			circle[9].draw(g);
			circle[10].draw(g);
			circle[11].draw(g);
			circle[12].draw(g);
			circle[3].draw(g);
			break;
		case 6:
			circle[13].draw(g);
			circle[14].draw(g);
			circle[15].draw(g);
			circle[16].draw(g);
			circle[17].draw(g);
			circle[18].draw(g);
			break;
		case 7: 
			circle[17].draw(g);
			circle[18].draw(g);
			circle[19].draw(g);
			circle[20].draw(g);
			circle[21].draw(g);
			circle[22].draw(g);
			circle[23].draw(g);
			break;
		case 8:
			circle[24].draw(g);
			circle[25].draw(g);
			circle[26].draw(g);
			circle[27].draw(g);
			circle[28].draw(g);
			circle[29].draw(g);
			circle[30].draw(g);
			circle[31].draw(g);
			break;
		case 9:
			circle[32].draw(g);
			circle[33].draw(g);
			circle[34].draw(g);
			circle[35].draw(g);
			circle[36].draw(g);
			circle[37].draw(g);
			circle[38].draw(g);
			circle[39].draw(g);
			circle[40].draw(g);
			break;
		}
	}
	public String toString()  {   
		return "Circle " + rank;  
	} 
	
	public class Circle{
		protected int x;
		protected int y;
		protected Color color;
		
		public Circle(int x,int y, Color color){
			this.x = x;
			this.y = y;
			this.color = color;
		}
		
		public void draw(Graphics g){
			g.setColor(color);
			g.fillOval(x,y,20,20);
			g.setColor(Color.WHITE);
			g.drawLine(x+5, y+5, x+15, y+15);
			g.drawLine(x+15, y+5, x+5, y+15);
			/*g.setColor(Color.white);
			g.drawOval(x,y,20,20);*/
		}
	}
	public class Pancake extends Circle{
		public Pancake(int x, int y, Color color) {
			super(x, y, color);
		}

		public void draw(Graphics g){
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 75, 75);
			g.setColor(Color.BLACK);
			g.drawOval(x ,y ,75 ,75);
			g.setColor(Color.RED);
			g.fillOval(58, 37, 25, 25);
			g.setColor(Color.WHITE);	
			g.drawOval(58, 37, 25, 25);
			//g.setColor(Color.BLACK);
			//horizontal
			g.fillArc(35, 45, 10, 5, 270, 180);
			g.fillArc(93, 45, 10, 5, 270, 180);
			//vertical
			g.fillArc(65, 15, 10, 5, 270, 180);
			g.fillArc(65, 78, 10, 5, 270, 180);
			//
			g.fillArc(85, 25, 10, 5, 270, 180);
			g.fillArc(85, 68, 10, 5, 270, 180);
			//
			g.fillArc(42, 25, 10, 5, 270, 180);
			g.fillArc(42, 68, 10, 5, 270, 180);
			
			g.drawLine(x+33, y+33, x+43, y+43);
			g.drawLine(x+43, y+33, x+33, y+43);
			//
		}	
		
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
	
}