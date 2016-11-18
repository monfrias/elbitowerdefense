package com.TestGame.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.TestGame.framework.GameObject;
import com.TestGame.framework.ObjectId;
import com.TestGame.framework.Texture;
import com.TestGame.window.Animation;
import com.TestGame.window.Game;
import com.TestGame.window.Handler;

public class ULMinion extends GameObject {
	
	private float speed = 10;
	private float width = 40, height = 40;
	private String movement = "rrrrrrrrrrrrrrdddd";
	
	private Handler handler;
	
	private Animation ulminionWalk;
	
	Texture tex = Game.getInstance();
	
	public ULMinion(float x, float y, ObjectId id) {
		super(x, y, id);
		ulminionWalk = new Animation(10, tex.ul_minion[0], tex.ul_minion[1], tex.ul_minion[2]);
	}

	public void tick(LinkedList<GameObject> objectList) {
		
		for(int i = 0; i < movement.length(); i++) {
			String dir = Character.toString(movement.charAt(i));
			
			if(dir.equals("r")) {
				x += velX;
			}
			
			if(dir.equals("d")) {
				y += velY;
			}
		}
		
		ulminionWalk.runAnimation();
	}

	public void render(Graphics g) {
		
	}

	public Rectangle getBounds() {
		return null;
	}

}