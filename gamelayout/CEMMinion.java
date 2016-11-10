import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class CEMMinion {
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    public CEMMinion() {
        createCEMMinion();
    }

    private void createCEMMinion() {
        ImageIcon ii = new ImageIcon("pictures/minions/CEMMinion.png");
        image = ii.getImage();
        x = 80;
        y = 80;
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