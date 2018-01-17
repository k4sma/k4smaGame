package k4smaGame;

//the player class
//only one object is will be created
//the falling and jumping is simulated with a simple phyiscs simulation you can read in update

public class Player extends GameObject
{
	//the collider of the player, used in Pipe to calculate collision
	public Vector3 col = new Vector3();
	
	//the physical force that is applied on the y-velocity of the player
	private int jump = 70;
	//the gravitational force that is applied to the player
	private int gravity = 20;
	
	//the velocity of the player also stored in a 3-dimensional vectors
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
		super.update();
		
		if(Input.jump)
		{
			vel.y = jump;
			Input.jump = false;
		}
		
		//all kind of physics simulation
		pos.y -= vel.y;
		pos.y += gravity;
		
		vel.y *= 0.9;
		
		if(pos.y <= -100 || pos.y >= 970)
		{
			Application.brd.endGame();
		}
	}
}
