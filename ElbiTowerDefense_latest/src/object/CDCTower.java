package object;

import java.awt.Image;

import javax.swing.ImageIcon;

public class CDCTower extends Tower {
	
	public CDCTower() {
		
		this.path = "res/towers/CommunicationsTower.png";
		this.cost = 20;
		this.type = "CDCTower";
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
