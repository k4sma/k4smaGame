package k4smaGame;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class GameObject implements Comparable<GameObject>
{
	public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public Vector3 pos = new Vector3();
	public Image img;
	public String name = "";
	
	public GameObject(Vector3 position, String imgPath)
	{
		objects.add(this);
		
		pos = position;
		
		loadImage(imgPath);
	}
	
	public GameObject(Vector3 position)
	{
		objects.add(this);
		
		pos = position;
		img = null;
	}
	
	private void loadImage(String path)
	{
		ImageIcon ii = new ImageIcon(path);
		img = ii.getImage();
	}
	
	public void update()
	{
		if(this.pos.x < -1920)
		{
			objects.remove(this);
		}
	}

	@Override
	public int compareTo(GameObject g)
	{
		return this.pos.z - g.pos.z;
	}
}
