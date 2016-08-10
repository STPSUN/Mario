package Mairo;

import java.io.File;
import java.util.ArrayList;

public class LoadResource
{
	ArrayList<File> sceneList = new ArrayList<File>();
	ArrayList<File> monsterList = new ArrayList<File>();
	ArrayList<File> obstacleList = new ArrayList<File>();
	ArrayList<File> mairoList = new ArrayList<File>();
	
	
	public LoadResource()
	{
		// TODO Auto-generated constructor stub
		addSceneListItem();
		addMonsterListItem();
		addObstacleListItem();
		addMairoListItem();
	}
	
	public void addSceneListItem()
	{
		sceneList.add(new File("src\\image\\mairo\\firststageend.gif"));
	}
	
	public void addMonsterListItem()
	{
		monsterList.add(new File("src\\image\\mairo\\Turtle1.gif"));
		monsterList.add(new File("src\\image\\mairo\\Turtle2.gif"));
		monsterList.add(new File("src\\image\\mairo\\Turtle3.gif"));
		monsterList.add(new File("src\\image\\mairo\\Turtle4.gif"));
		monsterList.add(new File("src\\image\\mairo\\Triangle1.gif"));
	}
	
	public void addObstacleListItem()
	{
		//µØ°å
		obstacleList.add(new File("src\\image\\mairo\\ob10.gif"));
		//Ç½
		obstacleList.add(new File("src\\image\\mairo\\ob1.gif"));
		//Öù×Ó
		obstacleList.add(new File("src\\image\\mairo\\ob6.gif"));
		//»¨
		obstacleList.add(new File("src\\image\\mairo\\flower1.gif"));
	}
	
	public void addMairoListItem()
	{
		mairoList.add(new File("src\\image\\mairo\\1.gif"));
		mairoList.add(new File("src\\image\\mairo\\6.gif"));
		mairoList.add(new File("src\\image\\mairo\\2.gif"));
		mairoList.add(new File("src\\image\\mairo\\7.gif"));
		mairoList.add(new File("src\\image\\mairo\\3.gif"));
		mairoList.add(new File("src\\image\\mairo\\8.gif"));
		mairoList.add(new File("src\\image\\mairo\\4.gif"));
		mairoList.add(new File("src\\image\\mairo\\9.gif"));
		mairoList.add(new File("src\\image\\mairo\\5.gif"));
		mairoList.add(new File("src\\image\\mairo\\10.gif"));
		System.out.println("hhh");
	}
	
}
