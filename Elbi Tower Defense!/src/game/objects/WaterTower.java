package game.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public class WaterTower extends Tower {
	
	public WaterTower(int cost, String type) {
		super(cost, type);
		this.path = "res/towers/tower3.png";
	}

	public Image getTextureFile() {
		return new ImageIcon(path).getImage();
	}
}
