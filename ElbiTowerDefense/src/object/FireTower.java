package object;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FireTower extends Tower {

	public FireTower() {

		this.path = "res/towers/fireTower.png";
		this.cost = 10;
		this.type = "fire";
	}

	public Image getTextureFile() {
		
		return new ImageIcon(path).getImage();
	}
	
	public int getCost() {
		
		return this.cost;
	}


	public String getType() {

		return this.getType();
	}

}