package k4smaGame;

//this invisible GameObject is spawned in the gap between 2 pipes and is used for scoring

public class ScorePoint extends GameObject
{
	private Vector3 vel = new Vector3();
	
	private boolean archieved = false;
	
	public ScorePoint(int xx, int xVel)
	{
		super(new Vector3(xx, 0, 0));
		
		vel.x = -xVel;
	}
	
	public void update()
	{
		super.update();
		
		pos.x += vel.x;
		
		if(!archieved && PipeController.player.pos.x >= this.pos.x)
		{
			archieved = true;
			Board.score++;
			Board.updateScore();
		}
	}
}
