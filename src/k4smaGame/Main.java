package k4smaGame;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main extends JFrame
{
	public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	private static final long serialVersionUID = 1L;

	public Main()
	{
		initUI();
	}
	
	private void initUI()
	{
		add(new Board());
		
		setSize(WIDTH/2, HEIGHT/2);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setTitle("Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				Main ex = new Main();
				ex.setVisible(true);
			}
		});
	}
}
