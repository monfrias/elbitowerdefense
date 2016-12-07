package object;

import java.awt.Image;

import javax.swing.ImageIcon;

public class LibTower extends Tower {
	
	public LibTower() {
		this.cost = 40;
		this.type = "LibTower";
		this.path = "res/towers/MainLibTower.png";
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