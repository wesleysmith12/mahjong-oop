import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class MahJongBoard extends JPanel implements MouseListener{

	Tile[] specialCaseTiles = new Tile[3];
	Tile[][][] MahJongModel = new Tile[8][12][5]; //rows cols layers
	private	Stack<Tile>	undoStack = new Stack<Tile>();
	//array to add and randomize tiles
	ArrayList dealTiles = new ArrayList();
	Tile t;
	Tile temp = null;
	ImageIcon image;
	Dimension screenSize;
	private Border normal;
	private Border selected;
	PlayClip clip;
	boolean volume;
	
	public MahJongBoard(long gameNumber){

		volume = true;
		clip = new PlayClip("audio/stone-scraping.wav");
		selected = BorderFactory.createLineBorder(Color.RED, 3);
		normal = BorderFactory.createEmptyBorder(); 
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLayout(null);
//		setPreferredSize(new Dimension((int)screenSize.getWidth(),(int)screenSize.getHeight()));
		
		setPreferredSize(new Dimension(1520,820));

		
		//t = new BambooTile(3);
		/*t.setLocation(0,0);
		add(t);*/
		
		//background image

		
		image = new ImageIcon(this.getClass().getResource("images/dragon_bg.png"));
		image = new ImageIcon(image.getImage().getScaledInstance(-1, ((int)screenSize.getHeight()), Image.SCALE_SMOOTH));	// ImageIcon resize
		
		for(int i = 0; i < 4; i++){
			// character tiles
			dealTiles.add( new CharacterTile('1') );
			dealTiles.add( new CharacterTile('2') );
			dealTiles.add( new CharacterTile('3') );
			dealTiles.add( new CharacterTile('4') );
			dealTiles.add( new CharacterTile('5') );
			dealTiles.add( new CharacterTile('6') );
			dealTiles.add( new CharacterTile('7') );
			dealTiles.add( new CharacterTile('8') );
			dealTiles.add( new CharacterTile('9') );
			dealTiles.add( new CharacterTile('N') );
			dealTiles.add( new CharacterTile('E') );
			dealTiles.add( new CharacterTile('W') );
			dealTiles.add( new CharacterTile('S') );
			
			// circle tiles
			dealTiles.add( new CircleTile(1) );
			dealTiles.add( new CircleTile(2) );
			dealTiles.add( new CircleTile(3) );
			dealTiles.add( new CircleTile(4) );
			dealTiles.add( new CircleTile(5) );
			dealTiles.add( new CircleTile(6) );
			dealTiles.add( new CircleTile(7) );
			dealTiles.add( new CircleTile(8) );
			dealTiles.add( new CircleTile(9) );
			
			// bamboo tiles
			dealTiles.add( new BambooTile(2) );
			dealTiles.add( new BambooTile(3) );
			dealTiles.add( new BambooTile(4) );
			dealTiles.add( new BambooTile(5) );
			dealTiles.add( new BambooTile(6) );
			dealTiles.add( new BambooTile(7) );
			dealTiles.add( new BambooTile(8) );
			dealTiles.add( new BambooTile(9) );
			
			// bamboo1 or sparrow tile
			dealTiles.add( new Bamboo1Tile() );
			
			// dragon tiles
			dealTiles.add( new WhiteDragonTile() );
			dealTiles.add( new CharacterTile('C') );
			dealTiles.add( new CharacterTile('F') );
		}	
		
		// season tiles
		dealTiles.add( new SeasonTile("Spring") );
		dealTiles.add( new SeasonTile("Summer") );
		dealTiles.add( new SeasonTile("Fall") );
		dealTiles.add( new SeasonTile("Winter") );
		
		// flower tiles
		dealTiles.add( new FlowerTile("Chrysanthemum") );
		dealTiles.add( new FlowerTile("Orchid") );
		dealTiles.add( new FlowerTile("Plum") );
		dealTiles.add( new FlowerTile("Bamboo") );
		
		//add seed
		Random rand = new Random();
		
		rand.setSeed(gameNumber);
		
		// shuffle array
		Collections.shuffle(dealTiles, rand);
		
		// draw from array
		/*t = (Tile) dealTiles.remove(dealTiles.size() - 1);
		
		// assign tiles to data structure
		*/
		
		// fill array
		for(int i = 0; i < 3; i++){
			t = (Tile) dealTiles.remove(dealTiles.size() - 1);
			specialCaseTiles[i] = t;
		}
		
		// far left tile
		specialCaseTiles[0].setLocation(0,350);
		add(specialCaseTiles[0]);
		specialCaseTiles[0].setTileX(100);
		specialCaseTiles[0].addMouseListener(this);
		
		// 4 layer
		t = (Tile) dealTiles.remove(dealTiles.size() - 1);
		MahJongModel[0][0][0] = t;
		t.setLocation(720,280);
		add(t);
		t.addMouseListener(this);
		t.setTileX(0);
		t.setTileY(0);
		t.setTileZ(0);
		
		// 3 layer
		for (int i = 0; i < 2; i++){
			for (int z = 0; z < 2; z++){
				t = (Tile) dealTiles.remove(dealTiles.size() - 1);
				MahJongModel[4-i][6-z][1] = t;			//r c z
				t.setTileX(6+i);
				t.setTileY(6-z);
				t.setTileZ(1);
				t.setLocation((6+z)*100+60,(4-i)*100-60);
				add(t);
				t.addMouseListener(this);
				
				t.setTileX(6-z);
				t.setTileY(6-i);
				t.setTileZ(1);
			}
		}
		
		// 2 layer BEING OVERLAPPED
		for (int i = 0; i < 4; i++){
			for (int z = 0; z < 4; z++){
				t = (Tile) dealTiles.remove(dealTiles.size() - 1);
				MahJongModel[5-i][7-z][2] = t;
				t.setLocation((5+z)*100+40,(5-i)*100-40);
				add(t);
				t.addMouseListener(this);
				
				t.setTileX(7-z);
				t.setTileY(5-i);
				t.setTileZ(2);
			}
		}
		
		
		// 1 layer
		for (int i = 0; i < 6; i++){
			for (int z = 0; z < 6; z++){
				t = (Tile) dealTiles.remove(dealTiles.size() - 1);
				MahJongModel[6-i][8-z][3] = t;
				t.setLocation((4+z)*100+20,(6-i)*100-20);
				add(t);
				t.addMouseListener(this);
				
				t.setTileX(8-z);
				t.setTileY(6-i);
				t.setTileZ(3);
			}
		}
		
		// 0 layer
		for (int i = 0; i < 8; i++){
			for (int z = 0; z < 12; z++){
				if(i == 1 && z == 0){continue;}
				if(i == 1 && z == 1){continue;}
				if(i == 2 && z == 0){continue;}
				
				if(i == 5 && z == 0){continue;}
				if(i == 6 && z == 0){continue;}
				if(i == 6 && z == 1){continue;}
				
				if(i == 1 && z == 10){continue;}
				if(i == 1 && z == 11){continue;}
				if(i == 2 && z == 11){continue;}
				
				if(i == 6 && z == 10){continue;}
				if(i == 6 && z == 11){continue;}
				if(i == 5 && z == 11){continue;}
				t = (Tile) dealTiles.remove(dealTiles.size() - 1);
				MahJongModel[7-i][11-z][4] = t;
				t.setLocation((z)*100+100,(7-i)*100);
				add(t);
				t.addMouseListener(this);
				
				t.setTileX(11-z);
				t.setTileY(7-i);
				t.setTileZ(4);
			}
		}
		
		// rightmost tiles
		specialCaseTiles[1].setLocation(1300,350);
		add(specialCaseTiles[1]);
		specialCaseTiles[1].setTileX(200);
		specialCaseTiles[1].setTileZ(10);
		specialCaseTiles[1].addMouseListener(this);
		
		specialCaseTiles[2].setLocation(1400,350);
		specialCaseTiles[2].setTileY(300);
		add(specialCaseTiles[2]);
		specialCaseTiles[2].setTileZ(10);
		specialCaseTiles[2].addMouseListener(this);
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.YELLOW);
		image.paintIcon(this, g, (int) (screenSize.getWidth()-image.getIconWidth())/2, 0);
		
		// test circle
		/*g.setColor(Color.RED);
		g.fillOval(5, 50, 50, 50);*/

	}
	
	public void test(){
		System.out.println("You can access this method from another class");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {

		// get first tile
		if(temp == null){
			if(isTileOpen((Tile) e.getSource())){
				temp = (Tile) e.getSource();
				System.out.println("new temp tile " + temp.toString());
				temp.setBorder(selected);
			}
				
			return;
		}
		
		// get second tile 
		Tile tile = (Tile) e.getSource();
		if(isTileOpen(tile)){
			// compare tiles
			System.out.println("Comparing " + tile.toString());
			
			if(temp.matches(tile)){
				
				validate();
				tile.setZOrder();
				temp.setZOrder();
				remove(tile);
				remove(temp);
				repaint();
				tile.setPainted(false);
				temp.setPainted(false);
				undoStack.push(tile);
				undoStack.push(temp);
				
				if(volume)
					clip.play();		
			}
				//reset temp
			temp.setBorder(normal);
			System.out.println("temp is null");
			temp = null;
			//tile.setBorder(normal);
			
		}
		
	}
	
	public void restartGame(){
		while(!undoStack.empty()){
			undoMove();
		}
	}
	
	public void undoMove(){
		if(!undoStack.empty()){
			Tile a = undoStack.pop();
			Tile b = undoStack.pop();
			a.setPainted(true);
			b.setPainted(true);
			add(a, a.getZOrder());
			add(b, b.getZOrder());
			repaint();
			System.out.println(a.toString());
			System.out.println(b.toString());
			a.resetZOrder();
			b.resetZOrder();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	
	public boolean isTileOpen(Tile tile){
		//System.out.println(tile.getTileX(tile)+1);
		int x = tile.getTileX(tile);
		int y = tile.getTileY(tile);
		int z = tile.getTileZ(tile);
		
		// top tile is always open
		if(z == 0)
			return true;
		
		// is index out of bounds
		if( x-1 < 0 || x+1 > 11){
			
			if( x == 100 ){
				return true;
			}
			// this needs to compare the tiles on the right of it too
			if( x == 200){
				if(!specialCaseTiles[2].getPainted() || 
						!(MahJongModel[4][0][4].getPainted() && MahJongModel[3][0][4].getPainted())){
					return true;
				}else {
					return false;
				}
				// work around until the righmost tile is in window
					/*if(specialCaseTiles[2].getPainted()){
						return true;
					}else {
						return false;
					}*/
			}
			if( x == 300 ){
				return true;
			}
			
			//check to make sure that special case tiles are not on the right or left
			if(x==11 && y == 3 && (specialCaseTiles[0].getPainted() && MahJongModel[3][10][4].getPainted())){
				return false;
			}
			if(x==11 && y == 4 && (specialCaseTiles[0].getPainted() && MahJongModel[4][10][4].getPainted())){
				return false;
			}
			
			if(x==0 && y == 4 && (specialCaseTiles[1].getPainted() && MahJongModel[4][1][4].getPainted())){
				return false;
			}
			if(x==0 && y == 3 && (specialCaseTiles[1].getPainted() && MahJongModel[4][1][4].getPainted())){
				return false;
			}
				return true;
		}
		
		if(z == 1){
			if(MahJongModel[0][0][0].getPainted() == true)
				return false;
			else
				return true;
		}
		boolean a = false;
		boolean b = false;
		boolean c = false;
		if(MahJongModel[y][x][z-1] == null || !MahJongModel[y][x][z-1].getPainted()){
			a = true;
		}
		if(MahJongModel[y][x+1][z] == null || !MahJongModel[y][x+1][z].getPainted()){
			b = true;
		}
		if(MahJongModel[y][x-1][z] == null || !MahJongModel[y][x-1][z].getPainted()){
			c = true;
		}
		
		return a && ( b || c );
		

	}
	public void setSound(boolean b){
		if(b)
			volume = true;
		else
			volume = false;
	}
	public boolean getSound(){
		return volume;
	}
	
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();
		/*JScrollPane scroll = new JScrollPane(frame);
		frame.add(scroll, 0, 0);
		scroll.setPreferredSize(new Dimension(1500,1500));*/

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.setSize(500, 500);
		
		frame.setTitle("Mah Jong Board");

		//frame.add(new Bamboo1Tile());
		frame.add(new MahJongBoard(System.currentTimeMillis()));

		frame.pack();
		frame.setVisible(true);
	}
	
}


// WHY DID  I HAVE TO UP CAST THIS TO TILE?
// I did setPreferedSize but assignment said I need a setSize
// i don't understand z order
// is my sizing okay?
// do I need to be casting to tile?