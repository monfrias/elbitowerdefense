package object;

import java.awt.Image;

import javax.swing.ImageIcon;

public class MathTower extends Tower {
	
	public MathTower() {
	
		this.path = "res/towers/MathTower.png";
		this.cost = 30;
		this.type = "MathTower";
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
