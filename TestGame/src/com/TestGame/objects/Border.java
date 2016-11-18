package com.TestGame.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.TestGame.framework.GameObject;
import com.TestGame.framework.ObjectId;
import com.TestGame.framework.Texture;
import com.TestGame.window.Game;

public class Border extends GameObject {
	
	Texture tex = Game.getInstance();
	
	public Border(float x, float y, ObjectId id) {
		
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> objectList) {
		
		
	}

	public void render(Graphics g) {

		g.drawImage(tex.blocks, (int)x, (int)y, null);

	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 40, 40);
	}	
}
