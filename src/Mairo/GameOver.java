package Mairo;

import java.util.ArrayList;

public class GameOver
{
	private static GameOver gameOver = new GameOver();
	private boolean isGameOver;
	Mairo mairo = Mairo.getInstance();
	
	private GameOver()
	{
		this.isGameOver = false;
		
	}
	
	public static GameOver getInstance()
	{
		return gameOver;
	}
	
	
	public void ifGameOver()
	{
		if(mairo.isDead() == true)
		{
			Thread.currentThread().suspend();
			setGameOver(true);
		}
	}

	public boolean isGameOver()
	{
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver)
	{
		this.isGameOver = isGameOver;
	}
	
	

}
