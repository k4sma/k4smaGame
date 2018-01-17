package k4smaGame;

import java.awt.EventQueue;

import javax.swing.JFrame;

//this class is the window
//the board class is the JPanel in the window -> everythings rendered on that

public class Application extends JFrame
{
	private static final long serialVersionUID = 1L;
	public static Board brd;

	public Application()
	{
		initUI();
	}
	
	//initialize the UI
	private void initUI()
	{
		brd = new Board();
		add(brd);
		
		setSize(1920, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setTitle("Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	//creates itself to create a window
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				Application ex = new Application();
				ex.setVisible(true);
			}
		});
	}
}
