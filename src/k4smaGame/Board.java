package k4smaGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener
{
	//period between 2 images that are rendered in ms
	private final int DELAY = 17;
	//the font im using (monospace)
	private final String FONT = "Monospaced";
	
	private static final long serialVersionUID = 1L;
	//the timer object calls actionPerformed() every DELAY milliseconds
	private static Timer timer;
	//boolean that decides wether or not the GameObjects are updated
	private static boolean running = true;
	
	//controls the pipes and deletes them after use
	PipeController pp;
	//shows the score to the player
	public static JLabel scoreLabel;
	//indicates what to do when the player died
	public static JLabel restartLabel;
	//indicates what to do when game is started (replaces a start menu)
	public static JLabel startLabel;
	//the variable to keep track of the score
	public static int score = 0;
	
	public Board()
	{
		initBoard();
	}
	
	//creates all the labels and the timer object
	//also connects the key listener for keyboard input
	private void initBoard()
	{
		setLayout(null);
		
		scoreLabel = new JLabel("0", SwingConstants.CENTER);
		scoreLabel.setFont(new Font(FONT, 1, 70));
		scoreLabel.setForeground(new Color(0, 153, 153));
		scoreLabel.setSize(300, 300);
		scoreLabel.setLocation(0, 0);
		add(scoreLabel);
		
		restartLabel = new JLabel("Press Space to restart!", SwingConstants.CENTER);
		restartLabel.setFont(new Font(FONT, 1, 40));
		restartLabel.setForeground(new Color(0, 153, 153));
		restartLabel.setSize(700, 100);
		restartLabel.setLocation(getToolkit().getScreenSize().width / 2 - 350, getToolkit().getScreenSize().height / 2 - 50);
		restartLabel.setVisible(false);
		add(restartLabel);
		
		startLabel = new JLabel("Press Space to start the game!", SwingConstants.CENTER);
		startLabel.setFont(new Font(FONT, 1, 40));
		startLabel.setForeground(new Color(0, 153, 153));
		startLabel.setSize(800, 100);
		startLabel.setLocation(getToolkit().getScreenSize().width / 2 - 400, getToolkit().getScreenSize().height / 2 - 50);
		startLabel.setVisible(true);
		add(startLabel);
		
		addKeyListener(new TAdapter());
		setFocusable(true);
		
		start();
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	//the entry point, where GameObjects (or generally assets) are created
	private void start()
	{
		loadGameAssets();
		
		//set running to false, cause player has to press space to start the game
		running = false;
	}
	
	//used for the rendering process
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	//draws every GameObjects image to the screen at the GameObjects position
	//sorts them by their Z position (rendering order)
	private void doDrawing(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		ArrayList<GameObject> objects = GameObject.objects;
		
		Collections.sort(objects);
		
		System.out.println(objects.size());
		
		for(int i = 0; i < objects.size(); i++)
		{
			if(objects.get(i).img != null)
			{
				g2d.drawImage(objects.get(i).img, objects.get(i).pos.x, objects.get(i).pos.y, this);
			}
		}
	}
	
	//calls the "update" method of every GameObject while running
	//otherwise restarts if space is pressed
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(running)
		{
			for(int i = 0; i < GameObject.objects.size(); i++)
			{
				GameObject.objects.get(i).update();
			}
			//updates the PipeController which is not a GameObject
			pp.update();
			
			repaint();
		} else if(Input.jump)
		{
			restartGame();
		}
	}
	
	//when the player hits a pipe, the player has to press space to restart
	public void endGame()
	{
		running = false;
		restartLabel.setVisible(true);
	}
	
	//loads the needed GameObjects to the JPanel
	private void loadGameAssets()
	{
		PipeController.player = new Player(new Vector3(150, 400, 5), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\player2.png");
		new BackgroundPart(new Vector3(4), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 0.png", 12);
		new BackgroundPart(new Vector3(3), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 1.png", 6);
		new BackgroundPart(new Vector3(2), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 2.png", 3);
		new BackgroundPart(new Vector3(1), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 3.png", 2);
		new BackgroundPart(new Vector3(0), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 4.png", 1);
		
		pp = new PipeController();
	}
	
	public void restartGame()
	{
		GameObject.objects.clear();
		start();
		running = true;
		score = 0;
		updateScore();
		restartLabel.setVisible(false);
		startLabel.setVisible(false);
	}
	
	public static void updateScore()
	{
		scoreLabel.setText(Integer.toString(score));
	}
	
	//binds the keyboard input to my custom Input class
	private class TAdapter extends KeyAdapter
	{
		@Override
		public void keyReleased(KeyEvent e)
		{
			Input.keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e)
		{
			Input.keyPressed(e);
		}
	}
}
