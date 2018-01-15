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
	private final int DELAY = 17;
	
	private static final long serialVersionUID = 1L;
	private static Timer timer;
	private static boolean running = true;
	private static boolean restart = false;
	
	PipeController pp;
	public static JLabel scoreLabel;
	public static int score = 0;
	
	public Board()
	{
		initBoard();
	}
	
	private void initBoard()
	{
		setLayout(null);
		
		scoreLabel = new JLabel("0", SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Open Sans", 1, 70));
		scoreLabel.setForeground(new Color(0, 153, 153));
		scoreLabel.setSize(300, 300);
		scoreLabel.setLocation(0, 0);
		
		addKeyListener(new TAdapter());
		setFocusable(true);
		add(scoreLabel);
		
		start();
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	private void start()
	{
		PipeController.player = new Player(new Vector3(150, 400, 5), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\player.png");
		new BackgroundPart(new Vector3(4), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 0.png", 12);
		new BackgroundPart(new Vector3(3), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 1.png", 6);
		new BackgroundPart(new Vector3(2), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 2.png", 3);
		new BackgroundPart(new Vector3(1), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 3.png", 2);
		new BackgroundPart(new Vector3(0), "D:\\EclipseWorkspace\\k4smaGame\\src\\pics\\bg_Layer 4.png", 1);
		System.out.println("helo");
		
		pp = new PipeController();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
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

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(running)
		{
			for(int i = 0; i < GameObject.objects.size(); i++)
			{
				GameObject.objects.get(i).update();
			}
			pp.update();
			
			repaint();
		} else if(Input.jump)
		{
			restartGame();
		}
	}
	
	public void endGame()
	{
		running = false;
	}
	
	public void restartGame()
	{
		GameObject.objects.clear();
		start();
		running = true;
		score = 0;
		updateScore();
	}
	
	public static void updateScore()
	{
		scoreLabel.setText(Integer.toString(score));
	}
	
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
