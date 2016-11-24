package game.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public class LightningTower extends Tower {
	
	public LightningTower(int cost, String type) {
		super(cost, type);
		this.path = "res/towers/tower1.png";
	}

	public Image getTextureFile() {
		return new ImageIcon(path).getImage();
	}
}
