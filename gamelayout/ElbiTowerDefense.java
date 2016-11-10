import java.awt.EventQueue;
import javax.swing.JFrame;

public class ElbiTowerDefense extends JFrame {
	
	public ElbiTowerDefense() {
		initUI();
	}

	private void initUI() {
		Board b = new Board();
		add(b);
		b.animate(20);
		setSize(1080, 720);
		setResizable(false);
		setTitle("Elbi Tower Defense v1.0");
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//main class
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//Override
			public void run() {
			ElbiTowerDefense lbtd = new ElbiTowerDefense();

			lbtd.setVisible(true);
			}
		});
	}
}