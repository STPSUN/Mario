package Mairo;

import java.awt.Rectangle;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

public class Obstacle implements Runnable
{
	private int obstacleX;
	private int obstacleY;
	private int imageWide;
	private int imageHigh;
	Mairo mairo = Mairo.getInstance();

	public Obstacle(int obxtacleX, int obxtacleY, int imageWide, int imageHige)
	{
		// TODO Auto-generated constructor stub
		this.obstacleX = obxtacleX;
		this.obstacleY = obxtacleY;
		this.imageWide = imageWide;
		this.imageHigh = imageHige;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		update();
	}

	public void update()
	{
		while (true)
		{
			try
			{
				Thread.currentThread().sleep(30);
				canRight();
				canLeft();
				canUp();
				canDown();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void canRight()
	{
		if(((this.obstacleX > mairo.getMairoX()) && (obstacleX - mairo.getMairoX() <= imageWide)) 
				&& (((obstacleY > mairo.getMairoY()) && (obstacleY - mairo.getMairoY() <= imageHigh))
						|| ((mairo.getMairoY() > obstacleY) && (mairo.getMairoY() - obstacleY <= imageHigh))))
		{
			mairo.setCanRithtMove(false);
		}
	}
	
	public void canLeft()
	{
		if((mairo.getMairoX() > obstacleX && mairo.getMairoX() - obstacleX <= imageWide)
				&& (obstacleY > mairo.getMairoY() && obstacleY - mairo.getMairoY() <= imageHigh)
				|| (obstacleY < mairo.getMairoY() && mairo.getMairoY() - obstacleY <= imageHigh))
		{
			mairo.setCanLeftMove(false);
		}
	}
	
	public void canUp()
	{
		if((mairo.getMairoY() > obstacleY && mairo.getMairoY() - obstacleY <= imageHigh)
				&& (obstacleX > mairo.getMairoX() && obstacleX - mairo.getMairoX() <= imageWide)
				|| (mairo.getMairoX() > obstacleX && mairo.getMairoX() - obstacleX <= imageWide))
		{
			mairo.setCanUpMove(false);
		}
	}
	
	public void canDown()
	{
		if((obstacleY > mairo.getMairoY() && obstacleY - mairo.getMairoY() <= imageHigh)
				&& (obstacleX > mairo.getMairoX() && obstacleX - mairo.getMairoX() <= imageWide)
				|| (mairo.getMairoX() > obstacleX && mairo.getMairoX() - obstacleX <= imageWide))
		{
			mairo.setDownMove(false);
		}
	}


	public int getObstacleX()
	{
		return obstacleX;
	}

	public void setObstacleX(int obstacleX)
	{
		this.obstacleX = obstacleX;
	}

	public int getObstacleY()
	{
		return obstacleY;
	}

	public void setObstacleY(int obstacleY)
	{
		this.obstacleY = obstacleY;
	}

}
