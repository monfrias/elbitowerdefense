package game.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tower {
	
	public String textureFile = "";
	public static final Tower[] towerList = new Tower[200];
	public static final Tower lightningTower = new LightningTower(0, 10).getTextureFile("tower1");
	public int id;
	public int cost;
	public Image texture;
	
	public Tower(int id, int cost) {
		if(towerList[id] != null) {
			System.out.println("Tower Initialization Error");
		}
		
		else {
			towerList[id] = this;
			this.id = id;
			this.cost = cost;
		}
	}
	
	public Tower getTextureFile(String str) {
		this.textureFile = str;
		this.texture = new ImageIcon("res/towers/" + this.textureFile + ".png").getImage();
		
		return null;
	}
	
}
