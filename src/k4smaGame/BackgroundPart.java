package k4smaGame;

public class BackgroundPart extends GameObject
{
	private Vector3 vel = new Vector3();	
	private String imgp;
	private boolean duplicated = false;

	public BackgroundPart(Vector3 position, String imgPath, int xVel)
	{
		super(position, imgPath);
		
		imgp = imgPath;
		vel.x = xVel;
	}
	
	public void update()
	{
		super.update();
		
		pos.x -= vel.x;
		
		if(pos.x <= 0 && !duplicated)
		{
			Vector3 newPos = new Vector3(pos.x + this.img.getWidth(null), pos.y, pos.z);
			
			BackgroundPart bg = new BackgroundPart(newPos, imgp, vel.x);
			
			duplicated = true;
		}
	}
}
