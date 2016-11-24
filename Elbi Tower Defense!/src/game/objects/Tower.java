package game.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Tower {
	
	//public static final Tower[] towerList = new Tower[200];

	public int cost;
	public String type;
	public String path;
	
	public Tower(int cost, String type) {
		
		this.cost = cost;
		this.type = type;
	}
	
	public abstract Image getTextureFile();
}