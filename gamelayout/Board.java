import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
//import javax.swing.Timer;
import java.util.Timer;
import java.util.TimerTask;

public class Board extends JPanel{
    private CAMinion caminion;
    private CASMinion casminion;
    private CDCMinion cdcminion;
    private CEMMinion cemminion;
    private CFNRMinion cfnrminion;
    private CHEMinion cheminion;
    private CVMMinion cvmminion;
    private BiologicalScienceTower biologicalsciencetower;
    private CommunicationsTower communicationstower;
    private MathTower mathtower;
    private MainLibTower mainlibtower;
    private MainBase mainbase;
    private PortalOne portalone;
    static Timer timer;
    static int interval;
    //private final int DELAY = 10;
    
    public Board() {
        initBoard();
    }

    private void initBoard() {
        //addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        caminion = new CAMinion();
        casminion = new CASMinion();
        cdcminion = new CDCMinion();
        cemminion = new CEMMinion();
        cfnrminion = new CFNRMinion();
        cheminion = new CHEMinion();
        cvmminion = new CVMMinion();
        biologicalsciencetower = new BiologicalScienceTower();
        communicationstower = new CommunicationsTower();
        mathtower = new MathTower();
        mainlibtower = new MainLibTower();
        mainbase = new MainBase();
        portalone = new PortalOne();
        //timer = new Timer(DELAY, this);
        //timer.start();        
    }

    //Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(caminion.getImage(), caminion.getX(), caminion.getY(), this);
        //g2d.drawImage(biologicalsciencetower.getImage(), biologicalsciencetower.getX(), biologicalsciencetower.getY(), this);
        //g2d.drawImage(communicationstower.getImage(), communicationstower.getX(), communicationstower.getY(), this);
        //g2d.drawImage(mathtower.getImage(), mathtower.getX(), mathtower.getY(), this);
        //g2d.drawImage(mainlibtower.getImage(), mainlibtower.getX(), mainlibtower.getY(), this);
        //g2d.drawImage(mainbase.getImage(), mainbase.getX(), mainbase.getY(), this);
        g2d.drawImage(portalone.getImage(), portalone.getX(), portalone.getY(), this);     
    }

    public void animate(int seconds) {
    	interval = seconds;
    	timer = new Timer();
    	timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	if(setInterval() >= 1) {
	        		Thread t = new Thread(new Runnable() {
						public void run() {
							int x = 80;
							int y = 80;
							while(true) {
								try{
									Thread.sleep(40);
									if(y < 330) {
										caminion.move(x, y);
										repaint();
										y+=1;
									} else if(x < 900) {
										caminion.move(x, y);
										repaint();
										x+=1;
									} else {
										break;
									}
								}catch (Exception e) {}
							}
						}
					});
					t.start();
	        	}
	        }
	    }, 0, 1000);
    }

    private static final int setInterval() {
	    if (interval == 1)
	        timer.cancel();
	    return (interval -= 2);
	}

    /*//Override
    public void actionPerformed(ActionEvent e) {
        caminion.move();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {
        //Override
        public void keyReleased(KeyEvent e) {
            caminion.keyReleased(e);
        }
        //Override
        public void keyPressed(KeyEvent e) {
            caminion.keyPressed(e);
        }
    }*/
}