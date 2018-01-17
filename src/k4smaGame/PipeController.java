package k4smaGame;

//this class simply controlls the spawning process of pipes (where, how fast, ...)

public class PipeController
{
	public static Player player;
	
	private long time;
	//how often
	private long delay = 1500l;
	//for the gap in between 2 pipes
	private int gap = 60;
	//the horizontal speed of the pipes
	private int level = 12;
	
	public PipeController()
	{
		for(int i = 0; i < GameObject.objects.size(); i++)
		{
			if(GameObject.objects.get(i).name == "player")
			{
				player = (Player) GameObject.objects.get(i);
				break;
			}
		}
	}

	public void update()
	{	
		if(System.currentTimeMillis() - time >= delay)
		{
			spawnPipes();
			
			time = System.currentTimeMillis();
		}
		
		//System.out.println(player.pos.y);
	}
	
	//spawns 2 pipes
	private void spawnPipes()
	{
		int rand = (int) (Math.random() * 600) + 50;
		
		new Pipe(new Vector3(1920, -gap -rand, 5), "../k4smaGame/src/pics/pipe.png", level);
		new Pipe(new Vector3(1920, 1080 + gap - rand, 5), "../k4smaGame/src/pics/pipe.png", level);
		new ScorePoint(1920, level);
		//level++;
	}
	
}
