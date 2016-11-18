package com.TestGame.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.TestGame.framework.GameObject;
import com.TestGame.framework.ObjectId;
//import com.TestGame.objects.Block;

public class Handler {
	
	public LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	private GameObject tempObject;
	
	public void tick() {
		
		for(int i = 0; i < objectList.size(); i++) {
			
			tempObject = objectList.get(i);
			tempObject.tick(objectList);
		}
	}
	
	public void render(Graphics g) {
		
		for(int i = 0; i < objectList.size(); i++) {
			
			tempObject = objectList.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		
		this.objectList.add(object);
	}
	
	public void removeObject(GameObject object) {
		
		this.objectList.remove(object);
	}
	
//	public void createLevel() {
//		for(int i = 0; i < Game.HEIGHT; i+=40) {
//			addObject(new Block(0, Game.HEIGHT-32, ObjectId.Block));
//		}
//		
//		for(int i = 0; i < Game.WIDTH/2; i+=40) {
//			addObject(new Block(i, Game.HEIGHT-32, ObjectId.Block));
//		}
//		
//		for(int i = 200; i < 600; i+=40) {
//			addObject(new Block(i, 400, ObjectId.Block));
//		}
//	}
}