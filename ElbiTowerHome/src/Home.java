import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
//import javax.swing.border.Border;
import java.awt.event.ActionListener;

public class Home extends JFrame{
	private static final long serialVersionUID = -8138909970488094916L;
	
	JFrame frame = new JFrame("eLBi Tower Defense");
    JPanel instruction = new JPanel();
    JPanel toGame = new JPanel();
    JPanel home = new JPanel();
    JPanel window = new JPanel();
    JButton sg = new JButton("START GAME");
    JButton ins = new JButton("INSTRUCTIONS");
    JButton backToHome = new JButton("RETURN TO HOME");
    JButton proceedToGame = new JButton("PROCEED TO GAME");
    JLabel background = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTower\\src\\Image\\home.jpg"));
    CardLayout cl = new CardLayout();
    
    public Home(){
    	frame.setSize(new Dimension(1200,800));
        frame.setLocationRelativeTo(null);
    	frame.setLayout(new BorderLayout());
    	
    	sg.setBackground(new Color(255, 51, 51));
	    sg.setForeground(Color.WHITE);
	    sg.setFocusPainted(false);
	    sg.setFont(new Font("Tahoma", Font.BOLD, 24));
	    //a.setBorder(new RoundedBorder());
	    sg.setBounds(750,300,300,60);
	    
	    ins.setBackground(new Color(255, 51, 51));
	    ins.setForeground(Color.WHITE);
	    ins.setFocusPainted(false);
	    ins.setFont(new Font("Tahoma", Font.BOLD, 24));
	    ins.setBounds(750,400,300,60);
	    
	    backToHome.setBackground(new Color(255, 51, 51));
	    backToHome.setForeground(Color.WHITE);
	    backToHome.setFocusPainted(false);
	    backToHome.setFont(new Font("Tahoma", Font.BOLD, 24));
	    backToHome.setBounds(500,350,300,60);
	    
	    proceedToGame.setBackground(new Color(255, 51, 51));
	    proceedToGame.setForeground(Color.WHITE);
	    proceedToGame.setFocusPainted(false);
	    proceedToGame.setFont(new Font("Tahoma", Font.BOLD, 24));
	    proceedToGame.setBounds(500,350,300,60);
    	
    	window.setLayout(cl);
    	background.add(sg);
    	background.add(ins);
    	instruction.add(backToHome);
    	toGame.add(proceedToGame);
    	home.add(background);
    	instruction.setBackground(Color.CYAN);
    	toGame.setBackground(Color.CYAN);
    	
    	window.add(home,  "1");
    	window.add(instruction,  "2");
    	window.add(toGame, "3");
    	cl.show(window, "1");
    	
    	backToHome.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(window, "1");
				
			}
    		
    	});
    	
    	proceedToGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(window, "1");
				
			}
    		
    	});
    	
    	sg.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(window, "2");
				
			}
    		
    	});
    	
    	ins.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "3");
				
			}
    		
    	});
    	
    	frame.add(window);
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	//frame.pack();
    	frame.setVisible(true);
    }

	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new Home();
				
			}
			
		});
	    
	    
	    
	   /* Container contentPane = frame.getContentPane();
	    
	    
	    JLabel background=new JLabel(new ImageIcon("C:\\Users\\ASUS\\Pictures\\sky-03.jpg"));
	    contentPane.add(background);
	    
	    JButton a = new JButton("START GAME");
	    a.setBackground(new Color(255, 51, 51));
	    a.setForeground(Color.WHITE);
	    a.setFocusPainted(false);
	    a.setFont(new Font("Tahoma", Font.BOLD, 24));
	    //a.setBorder(new RoundedBorder());
	    a.setBounds(500,250,300,60);
	    
	    
	    JButton b = new JButton("INSTRUCTIONS");
	    b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(500,350,300,60);
	    
	    background.add(a);
	    background.add(b);
	    
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    frame.setVisible(true);*/
    }
}
