package k4smaGame;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

//IMPORTAND no actual GameObject is created, only objects of classes that inherit from GameObject

public class GameObject implements Comparable<GameObject>
{
	//an arraylist that contains all GameObjects created
	public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	//the position of the GameObject stored in a 3-dimensional Vector
	public Vector3 pos = new Vector3();
	//the image thats supposed to be rendered on the screen
	public Image img;
	//name of the GameObject (rarely used)
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
	
	//loads the image at the given path and gives it to the variable img
	private void loadImage(String path)
	{
		ImageIcon ii = new ImageIcon(path);
		img = ii.getImage();
	}
	
	//the INFAMOUS update method that is called every frame
	public void update()
	{
		//just deletes GameObjects that are far out of the screen
		if(this.pos.x < -1920)
		{
			objects.remove(this);
		}
	}

	//for the sorting step
	@Override
	public int compareTo(GameObject g)
	{
		return this.pos.z - g.pos.z;
	}
}
