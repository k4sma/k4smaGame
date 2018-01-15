package k4smaGame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageObject extends Object
{
	private Image img;

	public ImageObject(Vector3 position, String imgPath)
	{
		super(position);
		
		loadImage(imgPath);
	}
	
	private void loadImage(String path)
	{
		ImageIcon ii = new ImageIcon(path);
		img = ii.getImage();
	}
}
