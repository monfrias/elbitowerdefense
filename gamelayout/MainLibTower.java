import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class MainLibTower {
	private int dx;
	private int dy;
	private int x;
	private int y;
	private Image image;

	public MainLibTower() {
		createMainLibTower();
	}

	private void createMainLibTower() {
		ImageIcon ii = new ImageIcon("pictures/towers/MainLibTower.png");
		image = ii.getImage();
		//temporary values, fixed sprite (display only)
        x = 610;
		y = 410;
	}

	public void move(int xPos, int yPos) {
		this.x = xPos;
		this.y = yPos;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}

	/*public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }*/
}