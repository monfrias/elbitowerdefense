package game.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FireTower extends Tower {

	public FireTower(int cost, String type) {
		super(cost, type);
		this.path = "res/towers/tower2.png";
	}

	public Image getTextureFile() {
		
		return new ImageIcon(path).getImage();
	}

}
