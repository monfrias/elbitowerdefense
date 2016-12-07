package object;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Tower {
	
	//public static final Tower[] towerList = new Tower[200];

	public int cost;
	public String type;
	public String path;
	
	public abstract Image getTextureFile();
	public abstract int getCost();
	public abstract String getType();
}