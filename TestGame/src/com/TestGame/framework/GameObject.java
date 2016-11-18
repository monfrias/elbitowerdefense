package com.TestGame.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {

	protected float x, y;
	protected ObjectId id;
	protected float velX = 0, velY = 0;
	protected boolean falling = true;
	protected boolean jumping = false;
	
	public GameObject(float x, float y, ObjectId id) {
		
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public abstract void tick(LinkedList<GameObject> objectList);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getVelX() {
		return this.velX;
	}
	public float getVelY() {
		return this.velY;
	}
	
	public void setVelX(float velX) {
		this.velX = velX;
	}
	
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	public ObjectId getId() {
		return this.id;
	}
}
