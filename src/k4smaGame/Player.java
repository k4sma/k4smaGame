package k4smaGame;

public class Player extends GameObject
{
	public Vector3 col = new Vector3();
	
	private int jump = 70;
	private int gravity = 20;
	
	private Vector3 vel = new Vector3();

	public Player(Vector3 position, String imgPath)
	{
		super(position, imgPath);
	
		name = "player";
		col.x = img.getWidth(null);
		col.y = img.getHeight(null);
	}

	public void update()
	{
		super.update();;
		
		if(Input.jump)
		{
			vel.y = jump;
			Input.jump = false;
		}
		
		pos.y -= vel.y;
		pos.y += gravity;
		
		vel.y *= 0.9;
		
		if(pos.y <= -100 || pos.y >= 970)
		{
			Application.brd.endGame();
		}
	}
}
