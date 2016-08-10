package Mairo;

import java.awt.Rectangle;

public class Turtle implements Runnable
{
	private int turtleX;
	private int turtleY;
	private int turtleStartXY;
	private int turtleEndXY;
	private boolean isLeftMove, isRightMove, isUpMove, isDownMove;
	private boolean isDead;
	private int imageNum;
	private int imageNumTemp;
	
	Mairo mairo = Mairo.getInstance();
	
	public Turtle(int turtleX, int turtleY, int turtleStartX, int turtleEndX, boolean isLeftMove, boolean isRightMove, boolean isUpMove, boolean isDownMOve)
	{
		// TODO Auto-generated constructor stub
		this.turtleX = turtleX;
		this.turtleY = turtleY;
		this.turtleStartXY = turtleStartX;
		this.turtleEndXY = turtleEndX;
		this.isLeftMove = isLeftMove;
		this.isRightMove = isRightMove;
		this.isUpMove = isUpMove;
		this.isDownMove = isDownMOve;
	}
	
	public void run()
	{
		update();
	}
	
	public void update()
	{
		while(true)
		{
			try
			{
				Thread.sleep(30);
				leftMove();
				rightMove();
				upMove();
				downMove();
				ifCrash();

			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void ifLeftMove()
	{
		this.isRightMove = false;
		this.isLeftMove =true;
	}
	
	public void ifRightMove()
	{
		imageNumTemp++;
		if(imageNumTemp > 1)
		{
			imageNumTemp = 0;
		}else {
			imageNum = imageNumTemp;
		}
		this.isLeftMove = false;
		this.isRightMove = true;
	}
	
	public void ifUpMove()
	{
		this.isDownMove = false;
		this.isUpMove = true;
	}
	
	public void ifDownMove()
	{
		this.isUpMove = false;
		this.isDownMove = true;
	}
	
	public void leftMove()
	{
		if(isLeftMove == true)
		{
			if(this.turtleX <= this.turtleStartXY)
			{
				this.turtleX = this.turtleStartXY;
				ifRightMove();
			}else
			{
				this.turtleX -= 1;
			}
		}
	}
	
	public void rightMove()
	{
		if(isRightMove == true)
		{
			if(this.turtleX >= this.turtleEndXY)
			{
				this.turtleX = this.turtleEndXY;
				ifLeftMove();
			}else
			{
				this.turtleX += 1;
			}
		}
	}
	
	public void upMove()
	{
		if(isUpMove == true)
		{
			if(this.turtleY <= this.turtleStartXY)
			{
				this.turtleY = this.turtleStartXY;
				ifDownMove();
			}else
			{
				this.turtleY -= 1;
			}
		}
	}
	
	public void downMove()
	{
		if(isDownMove == true)
		{
			if(this.turtleY >= this.turtleEndXY)
			{
				this.turtleY = this.turtleEndXY;
				ifUpMove();
			}else 
			{
				this.turtleY += 1;
			}
		}
	}
	
	public void ifCrash()
	{
		Rectangle mairoRectangle = new Rectangle(mairo.getMairoX(), mairo.getMairoY(), 45, 45);
		Rectangle turtleRectangle = new Rectangle(this.turtleX, this.turtleY, 45, 45);
		if(turtleRectangle.intersects(mairoRectangle))
		{
			mairo.setDead(true);
		}
	}

	public int getTurtleX()
	{
		return turtleX;
	}

	public void setTurtleX(int turtleX)
	{
		this.turtleX = turtleX;
	}

	public int getTurtleY()
	{
		return turtleY;
	}

	public void setTurtleY(int turtleY)
	{
		this.turtleY = turtleY;
	}

	public boolean isDead()
	{
		return isDead;
	}

	public void setDead(boolean isDead)
	{
		this.isDead = isDead;
	}

	public int getTurtleStartXY()
	{
		return turtleStartXY;
	}

	public void setTurtleStartXY(int turtleStartXY)
	{
		this.turtleStartXY = turtleStartXY;
	}

	public int getTurtleEndXY()
	{
		return turtleEndXY;
	}

	public void setTurtleEndXY(int turtleEndXY)
	{
		this.turtleEndXY = turtleEndXY;
	}

	public int getImageNum()
	{
		return imageNum;
	}

	public void setImageNum(int imageNum)
	{
		this.imageNum = imageNum;
	}
	
	
}
