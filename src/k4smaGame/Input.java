package k4smaGame;

import java.awt.event.KeyEvent;

public class Input
{
	private static int x = 0;
	private static int y = 0;
	public static boolean jump;
	
	public static int getHorizontal()
	{
		return x;
	}
	
	public static int getVertical()
	{
		return y;
	}
	
	public static void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A)
		{
			x = -1;
		}
		if(key == KeyEvent.VK_D)
		{
			x = 1;
		}
		if(key == KeyEvent.VK_W)
		{
			y = -1;
		}
		if(key == KeyEvent.VK_S)
		{
			y = 1;
		}
		
		//JUMP
		if(key == KeyEvent.VK_SPACE)
		{
			jump = true;
		}
	}
	
	public static void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_A)
		{
			x = 0;
		}
		if(key == KeyEvent.VK_D)
		{
			x = 0;
		}
		if(key == KeyEvent.VK_W)
		{
			y = 0;
		}
		if(key == KeyEvent.VK_S)
		{
			y = 0;
		}
	}
}
