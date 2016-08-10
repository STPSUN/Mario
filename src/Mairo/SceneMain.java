package Mairo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class SceneMain extends JFrame implements Runnable, KeyListener
{
	private int mairoImageNum = 0;
	LoadResource loadResource = new LoadResource();
	Mairo mairo = Mairo.getInstance();
	GameOver gameOver = GameOver.getInstance();

	Thread threadSceneMain = new Thread(this);

	Turtle turtle1 = new Turtle(250, 480, 250, 350, false, true, false, false);
	Thread threadTurtle1 = new Thread(turtle1);

	Turtle turtle2 = new Turtle(200, 340, 100, 200, false, true, false, false);
	Thread threadTurtle2 = new Thread(turtle2);

	Turtle triangle = new Turtle(300, 200, 280, 430, false, true, false, false);
	Thread threadTriangle = new Thread(triangle);

	Turtle flower = new Turtle(417, 420, 420, 520, false, false, false, true);
	Thread threadFlower = new Thread(flower);

	Obstacle column = new Obstacle(100, 199, 40, 55);
	Thread threadColumn = new Thread(column);
	
	Thread threadMairo = new Thread(mairo);

	public SceneMain()
	{
		// TODO Auto-generated constructor stub
		setSize(900, 600);
		setVisible(true);
		this.addKeyListener(this);

		threadSceneMain.start();
		threadMairo.start();
		threadTurtle1.start();
		threadTurtle2.start();
		threadTriangle.start();
		threadFlower.start();
		threadColumn.start();
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
				Thread.sleep(30);
				this.repaint();
				ifGameOver();

			} catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public void ifGameOver()
	{
		if (mairo.isDead() == true)
		{
			Thread.currentThread().suspend();
			threadMairo.suspend();
			threadTurtle1.suspend();

		}

	}

	public void paint(Graphics g)
	{
		int temp1 = 0;
		int temp2 = 0;
		int temp3 = 0;
		BufferedImage bufferedImage = new BufferedImage(900, 600, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2 = bufferedImage.getGraphics();

		try
		{
			g2.drawImage(ImageIO.read(loadResource.sceneList.get(0)), 0, 0, this);

			g2.drawImage(ImageIO.read(loadResource.monsterList.get(0)), turtle1.getTurtleX(), turtle1.getTurtleY(),
					this);
			g2.drawImage(ImageIO.read(loadResource.monsterList.get(0)), turtle2.getTurtleX(), turtle2.getTurtleY(),
					this);
			g2.drawImage(ImageIO.read(loadResource.monsterList.get(4)), triangle.getTurtleX(), triangle.getTurtleY(),
					this);

			g2.drawImage(ImageIO.read(loadResource.obstacleList.get(2)), column.getObstacleX(), column.getObstacleY(),
					this);
			g2.drawImage(ImageIO.read(loadResource.obstacleList.get(3)), flower.getTurtleX(), flower.getTurtleY(),
					this);
			g2.drawImage(ImageIO.read(loadResource.obstacleList.get(2)), 420, 480, this);
			for (int i = 0; i < 15; i++)
			{
				g2.drawImage(ImageIO.read(loadResource.obstacleList.get(0)), temp1, 540, this);
				temp1 += 60;
			}

			for (int i = 0; i < 5; i++)
			{
				g2.drawImage(ImageIO.read(loadResource.obstacleList.get(1)), temp2 + 200, 250, this);
				temp2 += 60;
			}

			for (int i = 0; i < 3; i++)
			{
				g2.drawImage(ImageIO.read(loadResource.obstacleList.get(1)), temp3 + 100, 400, this);
				temp3 += 60;
			}
			
			
			g2.drawImage(ImageIO.read(loadResource.mairoList.get(mairo.getImageNum())), mairo.getMairoX(), mairo.getMairoY(),
					this);

		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}

		g.drawImage(bufferedImage, 0, 0, this);
	}

	public void mairoImage(int i)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		switch (e.getKeyCode())
		{
		case 37:
			mairo.ifLeftMove();
			break;
		case 39:
			mairo.ifRightMove();
			break;
		case 38:
			mairo.ifUpMove();
			break;
	
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		mairo.keyUp();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

}
