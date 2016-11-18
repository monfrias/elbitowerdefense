package com.TestGame.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.TestGame.framework.GameObject;
import com.TestGame.framework.ObjectId;
import com.TestGame.window.Handler;

public class Player extends GameObject {
	
	private final float MAX_SPEED = 10;
	private float width = 48, height = 96;
	private float gravity = 0.5f;
	
	private Handler handler;
	
	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> objectList) {
		x += velX;
		y += velY;
		
		if(falling || jumping) {
			velY += gravity;
			if(velY > MAX_SPEED) velY = MAX_SPEED;
		}
		
		Collision(objectList);
	}
	
	private void Collision(LinkedList<GameObject> objectList) {
		
//		for(int i = 0; i < handler.objectList.size(); i++) {
//			GameObject tempObject = handler.objectList.get(i);
//			
//			if(tempObject.getId() == ObjectId.Block) {
//				
//				if(getBoundsTop().intersects(tempObject.getBounds())) {
//					y = tempObject.getY() + (height/2);
//					velY = 0;
//				}
//				
//				if(getBounds().intersects(tempObject.getBounds())) {
//					y = tempObject.getY() - height;
//					velY = 0;
//					falling = false;
//					jumping = false;
//				}
//				
//				else {
//					falling = true;
//				}
//			}
//		}
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.red);
		
		g2d.draw(getBounds());
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());
	}

	public Rectangle getBounds() {
		return new Rectangle((int) ((int)x+(width/2)-(width/4)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int) ((int)x+(width/2)-(width/4)), (int)y, (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}
}