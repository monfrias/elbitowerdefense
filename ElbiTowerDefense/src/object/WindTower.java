package object;

import java.awt.Image;

import javax.swing.ImageIcon;

public class WindTower extends Tower {
	
	public WindTower() {
		
		this.path = "res/towers/windTower.png";
		this.cost = 20;
		this.type = "water";
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