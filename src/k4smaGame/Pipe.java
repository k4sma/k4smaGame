package k4smaGame;

public class Pipe extends GameObject
{
	private Vector3 vel = new Vector3();
	private Vector3 col = new Vector3();

	public Pipe(Vector3 position, String imgPath, int xVel)
	{
		super(position, imgPath);
		
		vel.x = xVel;
		col.x = img.getWidth(null);
		col.y = img.getHeight(null);
	}
	
	public void update()
	{
		super.update();
		
		pos.x -= vel.x;
		
		//Collision
		Player player = PipeController.player;
		if(player.pos.x + player.col.x >= pos.x && player.pos.x <= pos.x + col.x)
		{
			if(player.pos.y + player.col.y >= pos.y && player.pos.y <= pos.y + col.y)
			{
				Application.brd.endGame();
				//GameObject.objects.remove(player);
			}
		}
	}

}
