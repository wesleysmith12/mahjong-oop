import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class MahJong extends JFrame{
	
	MahJongBoard game;
	/*Fireworks reward;
	boolean sound = true;*/
	boolean started;
	
	public MahJong(){
		
		started = false;
		setTitle("Mah Jong"); 
		setSize(1522,822); 
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() 
				{ public void windowClosing(WindowEvent e)
					{ exit(); }
				});
		
//		game = new MahJongBoard(-1);
//		add(game);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Game");
		menu.setMnemonic('G');
		menuBar.add(menu);
		
		JMenu menu2 = new JMenu("Sound");
		menu.setMnemonic('S');
		menuBar.add(menu2);
		
		JMenu menu3 = new JMenu("Move");
		menu.setMnemonic('M');
		menuBar.add(menu3);
		
		JMenu menu4 = new JMenu("Help");
		menu.setMnemonic('H');
		menuBar.add(menu4);
		
		JMenuItem play = new JMenuItem("Play", 'P');
		menu.add(play);
		play.addActionListener(new ActionListener() 
				{ public void actionPerformed(ActionEvent e)
					{ playGame(); }
				});

		JMenuItem restart = new JMenuItem("Restart", 'R');
		menu.add(restart);
		restart.addActionListener(new ActionListener() 
				{ public void actionPerformed(ActionEvent e)
					{ game.restartGame(); }
				});
		
		JMenuItem numbered = new JMenuItem("Numbered", 'N');
		menu.add(numbered);
		numbered.addActionListener(new ActionListener() 
				{ public void actionPerformed(ActionEvent e)
					{ numbered(); }
				});
		
		JMenuItem onOff = new JMenuItem("On Off", 'O');
		menu2.add(onOff);
		onOff.addActionListener(new ActionListener() 
				{ public void actionPerformed(ActionEvent e)
					{ onOff(); }
				});
		
		JMenuItem undo = new JMenuItem("Undo", 'U');
		menu3.add(undo);
		undo.addActionListener(new ActionListener() 
				{ public void actionPerformed(ActionEvent e)
					{ undo(); }
				});
		
		JMenuItem operation = new JMenuItem("Operation");
		menu4.add(operation);
		operation.addActionListener(new ActionListener() 
				{ public void actionPerformed(ActionEvent e)
					{ operation(); }
				});
		
		JMenuItem gameRules = new JMenuItem("Game Rules");
		menu4.add(gameRules);
		gameRules.addActionListener(new ActionListener() 
				{ public void actionPerformed(ActionEvent e)
					{ gameRules(); }
				});
		
		setVisible(true);
	}
	public void playGame(){
		if(!started){
			long r = System.currentTimeMillis()%100000;
			game = new MahJongBoard(r);
			add(game);
			setTitle("Mah Jong " + r);
			setVisible(true);
			return;
		}
		
		if (JOptionPane.showConfirmDialog(this,
			       "Do you want to start a new game?", "Start New Game",        
			       JOptionPane.YES_NO_OPTION,        
			       JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) 
		{
			long r = System.currentTimeMillis()%100000;
			game = new MahJongBoard(r);
			add(game);
			setTitle("Mah Jong " + r);
			setVisible(true);
		}
	}
	public void restart(){
		game.restartGame();
		setVisible(true);
	}
	public void numbered(){
		long num = 0;
		String	 gameNumber = JOptionPane.showInputDialog("Enter the game number");
		try{
			num = Long.parseLong(gameNumber);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this,"A number must be entered");
			return;
		}
		
		num = num%10000;
		System.out.println("Number: " + num);
	    game = new MahJongBoard(num);
	    add(game);
	    setTitle("Mah Jong" + gameNumber);
	    setVisible(true);
		
	}
	
	public void onOff(){
			game.setSound(!game.getSound());
	}
	
	public void undo(){
		game.undoMove();
	}
	
	public void operation(){}
	
	public void gameRules(){}
	
	public void exit() {
		if (JOptionPane.showConfirmDialog(this,
		       "Do you want to end this program?", "End Program",        
		       JOptionPane.YES_NO_OPTION,        
		       JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) 
		{
			System.exit(0);
		}
	}
	
/*	public void startReward(){
		
		
		reward = new Fireworks(game);
		reward.setSound(sound);
		reward.fire();
	}
	
	public void stopReward(){
		if(reward == null)
			return;
		reward.stop();
		reward = null;
	}*/
	
	public static void main(String[] args)
	{
		new MahJong();
	}
	
	
}
