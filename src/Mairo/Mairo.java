package Mairo;

public class Mairo implements Runnable
{
	private int mairoX;
	private int mairoY;
	private boolean isLeftMove, isRightMove, isUpMove, isDownMove;
	private boolean canRithtMove, canLeftMove, canUpMove, canDownMove;
	private boolean isDead, isStop, isMove;
	private int imageNum;
	private int imageNumTemp = 0;
	private int highTemp;

	private Mairo()
	{
		this.isLeftMove = false;
		this.isRightMove = false;
		this.isUpMove = false;
		this.isDownMove = false;
		this.isDead = false;
		this.canRithtMove = true;
		this.isMove = false;
		this.canLeftMove = true;
		this.canUpMove = true;
		this.canDownMove = true;
		this.mairoX = 30;
		this.mairoY = 480;
		this.imageNum = 0;

	}

	private static final Mairo mairo = new Mairo();

	public static Mairo getInstance()
	{
		return mairo;
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
				Thread.currentThread().sleep(10);
				leftMove();
				rightMove();
				upMove();
				ifDownMove();
				downMove();

			} catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public void ifRightMove()
	{
		if (this.canRithtMove == true)
		{
			imageNumTemp++;
			if (imageNumTemp > 9)
			{
				imageNumTemp = 0;
			}
			if (imageNumTemp % 2 == 0)
			{
				imageNum = imageNumTemp;
			}
			this.isLeftMove = false;
			this.isRightMove = true;

			highTemp = mairoY;
		}
	}

	public void ifLeftMove()
	{
		if (this.canLeftMove == true)
		{
			imageNumTemp++;
			if (imageNumTemp > 9)
			{
				imageNumTemp = 0;
			}
			if (imageNumTemp % 2 == 1)
			{
				imageNum = imageNumTemp;
			}
			this.isRightMove = false;
			this.isLeftMove = true;
		}
	}

	public void ifUpMove()
	{
		if (this.canUpMove == true)
		{
			this.isDownMove = false;
			this.isUpMove = true;
		}
	}

	public void ifDownMove()
	{
		/*if (this.canDownMove == true)
		{
			this.isUpMove = false;
			this.isDownMove = true;
		}*/
		if(isUpMove == false)
		{
			this.isDownMove = true;
		}
	}

	public void rightMove()
	{
		if (isRightMove == true)
		{
			this.mairoX += 1;
		} /*
			 * else if (isRightMove == true && isMove == true) { this.mairoX +=
			 * 1; } if(isStop == true) { isMove = true; }
			 */

	}

	public void leftMove()
	{
		if (isLeftMove == true)
		{
			this.mairoX -= 1;
		}
		/*
		 * if (isStop == true) { isMove = true; } if(isLeftMove == true &&
		 * isMove == true) { this.mairoX -= 1; }
		 */
	}

	public void upMove()
	{
		if (isUpMove == true)
		{
			/*if (mairoY - highTemp >= 30)
			{
				this.mairoY += 1;
			} else
			{
				this.mairoY -= 3;
			}*/
			this.mairoY -= 1;
		}
	}

	public void downMove()
	{
		if (isDownMove == true)
		{
			this.mairoY += 1;
		} /*
			 * else if(isDownMove == true && isStop == true) { this.mairoY += 1;
			 * }
			 */
	}

	public void keyUp()
	{
		this.isLeftMove = false;
		this.isRightMove = false;
		this.isUpMove = false;
		this.isDownMove = false;
		this.isStop = false;
		this.isMove = true;
		this.canRithtMove = true;
		this.canLeftMove = true;
		this.canUpMove = true;
		this.canDownMove = true;
		System.out.println("keyUp");
	}

	public int getMairoX()
	{
		if (this.mairoX <= 0)
		{
			this.mairoX = 0;
		} else if (this.mairoX >= 840)
		{
			this.mairoX = 840;
		}

		return mairoX;
	}

	public void setMairoX(int mairoX)
	{
		this.mairoX = mairoX;
	}

	public int getMairoY()
	{
		if (this.mairoY <= 40)
		{
			this.mairoY = 40;
		} else if (this.mairoY >= 480)
		{
			this.mairoY = 480;
		}

		return mairoY;
	}

	public void setMairoY(int mairoY)
	{
		this.mairoY = mairoY;
	}

	public boolean isLeftMove()
	{
		return isLeftMove;
	}

	public void setLeftMove(boolean isLeftMove)
	{
		this.isLeftMove = isLeftMove;
	}

	public boolean isRightMove()
	{
		return isRightMove;
	}

	public void setRightMove(boolean isRightMove)
	{
		this.isRightMove = isRightMove;
	}

	public boolean isUpMove()
	{
		return isUpMove;
	}

	public void setUpMove(boolean isUpMove)
	{
		this.isUpMove = isUpMove;
	}

	public boolean isDownMove()
	{
		return isDownMove;
	}

	public void setDownMove(boolean isDownMove)
	{
		this.isDownMove = isDownMove;
	}

	public boolean isDead()
	{
		return isDead;
	}

	public void setDead(boolean isDead)
	{
		this.isDead = isDead;
	}

	public boolean isMove()
	{
		return isMove;
	}

	public void setMove(boolean isMove)
	{
		this.isMove = isMove;
	}

	public boolean isCanRithtMove()
	{
		return canRithtMove;
	}

	public void setCanRithtMove(boolean canRithtMove)
	{
		this.canRithtMove = canRithtMove;
	}

	public boolean isCanLeftMove()
	{
		return canLeftMove;
	}

	public void setCanLeftMove(boolean canLeftMove)
	{
		this.canLeftMove = canLeftMove;
	}

	public boolean isCanUpMove()
	{
		return canUpMove;
	}

	public void setCanUpMove(boolean canUpMove)
	{
		this.canUpMove = canUpMove;
	}

	public boolean isCanDownMove()
	{
		return canDownMove;
	}

	public void setCanDownMove(boolean canDownMove)
	{
		this.canDownMove = canDownMove;
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
