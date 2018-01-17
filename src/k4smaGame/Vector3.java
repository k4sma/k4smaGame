package k4smaGame;

//a simple class to store a 3-dimensional vector

public class Vector3
{
	public int x, y, z;
	
	public Vector3()
	{
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Vector3(int xx, int yy, int zz)
	{
		x = xx;
		y = yy;
		z = zz;
	}
	
	public Vector3(int depth)
	{
		z = depth;
	}
	
	public void add(int xy)
	{
		this.x += xy;
		this.y += xy;
	}
	
	public void add(int xx, int yy)
	{
		this.x += xx;
		this.y += yy;
	}
	
	//returns the unit-vector of the given vector like
	public Vector3 unit()
	{
		float sq = (float) Math.sqrt((this.x * this.x) + (this.y * this.y));
		return new Vector3((int)(this.x / sq), (int)(this.y / sq), this.z);
	}
}
