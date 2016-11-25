package object;

import java.awt.Image;

import javax.swing.ImageIcon;

public class IBSTower extends Tower {

	public IBSTower() {

		this.path = "res/towers/BiologicalScienceTower.png";
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