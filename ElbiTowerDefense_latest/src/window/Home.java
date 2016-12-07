package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
//import javax.swing.border.Border;
import java.awt.event.ActionListener;

public class Home extends JFrame{
	private static final long serialVersionUID = -8138909970488094916L;
	
	JFrame frame = new JFrame("eLBi Tower Defense");
    JPanel inst1 = new JPanel();
    JPanel inst2 = new JPanel();
    JPanel inst3 = new JPanel();
    JPanel inst4 = new JPanel();
    JPanel inst5 = new JPanel();
    JPanel inst6 = new JPanel();
    JPanel inst7 = new JPanel();
    JPanel inst8 = new JPanel();
    JPanel inst9 = new JPanel();
    JPanel home = new JPanel();
    JPanel window = new JPanel();
    
    Frame f;
    
    JLabel noPlayer = new JLabel("Enter Number of Players: ");
	final JTextField players = new JTextField(15);
    
    JButton sg = new JButton("START GAME");
    JButton ins = new JButton("INSTRUCTIONS");
    
    JButton backToHome = new JButton("Back to Home");
    JButton proceedToGame = new JButton("Proceed to Game");
    
    JButton prev1 = new JButton("PREV");
    JButton b1 = new JButton("BACK TO HOME");
    JButton next1 = new JButton("NEXT"); //(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\rightarrow.jpg"));
    
    JButton prev2 = new JButton("PREV"); 
    JButton b2 = new JButton("BACK TO HOME");
    JButton next2 = new JButton("NEXT");
    
    JButton prev3 = new JButton("PREV"); 
    JButton b3 = new JButton("BACK TO HOME");
    JButton next3 = new JButton("NEXT");
    
    JButton prev4 = new JButton("PREV"); 
    JButton b4 = new JButton("BACK TO HOME");
    JButton next4 = new JButton("NEXT");
    
    JButton prev5 = new JButton("PREV"); 
    JButton b5 = new JButton("BACK TO HOME");
    JButton next5 = new JButton("NEXT");
    
    JButton prev6 = new JButton("PREV"); 
    JButton b6 = new JButton("BACK TO HOME");
    JButton next6 = new JButton("NEXT");
    
    JButton prev7 = new JButton("PREV"); 
    JButton b7 = new JButton("BACK TO HOME");
    JButton next7 = new JButton("NEXT");
    
    JButton prev8 = new JButton("PREV"); 
    JButton b8 = new JButton("BACK TO HOME");
    JButton next8 = new JButton("NEXT");
    
    JButton prev9 = new JButton("PREV"); 
    JButton b9 = new JButton("BACK TO HOME");
    JButton next9 = new JButton("NEXT");
    
    JLabel MainPageBG = new JLabel(new ImageIcon("res/help/home.jpg"));
    JLabel IMGinst1 = new JLabel(new ImageIcon("res/help/p1.jpg"));
    JLabel IMGinst2 = new JLabel(new ImageIcon("res/help/p2.jpg"));
    JLabel IMGinst3 = new JLabel(new ImageIcon("res/help/p3.jpg"));
    JLabel IMGinst4 = new JLabel(new ImageIcon("res/help/p4.jpg"));
    JLabel IMGinst5 = new JLabel(new ImageIcon("res/help/p5.jpg"));
    JLabel IMGinst6 = new JLabel(new ImageIcon("res/help/p6.jpg"));
    JLabel IMGinst7 = new JLabel(new ImageIcon("res/help/p7.jpg"));
    JLabel IMGinst8 = new JLabel(new ImageIcon("res/help/p8.jpg"));
    JLabel IMGinst9 = new JLabel(new ImageIcon("res/help/p9.jpg"));
    CardLayout cl = new CardLayout();
    
    public Home(){
    	frame.setSize(new Dimension(1200,800));
        frame.setLocationRelativeTo(null);
    	frame.setLayout(new BorderLayout());
    	
    	
    	
    	this.changeButtonFeatU(sg);
    	this.changeButtonFeatD(ins);
    	
    	//this.changeButtonFeatD(backToHome);
    	//this.changeButtonFeatU(proceedToGame);
    	
    	this.changeButtonFeatL(prev1);
    	this.changeButtonFeatC(b1);
    	this.changeButtonFeatR(next1);
    	
    	this.changeButtonFeatL(prev2);
    	this.changeButtonFeatC(b2);
    	this.changeButtonFeatR(next2);
    	
    	this.changeButtonFeatL(prev3);
    	this.changeButtonFeatC(b3);
    	this.changeButtonFeatR(next3);
    	
    	this.changeButtonFeatL(prev4);
    	this.changeButtonFeatC(b4);
    	this.changeButtonFeatR(next4);
    	
    	this.changeButtonFeatL(prev5);
    	this.changeButtonFeatC(b5);
    	this.changeButtonFeatR(next5);
    	
    	this.changeButtonFeatL(prev6);
    	this.changeButtonFeatC(b6);
    	this.changeButtonFeatR(next6);
    	
    	this.changeButtonFeatL(prev7);
    	this.changeButtonFeatC(b7);
    	this.changeButtonFeatR(next7);
    	
    	this.changeButtonFeatL(prev8);
    	this.changeButtonFeatC(b8);
    	this.changeButtonFeatR(next8);
    	
    	this.changeButtonFeatL(prev9);
    	this.changeButtonFeatC(b9);
    	this.changeButtonFeatR(next9);
    	
    	window.setLayout(cl);
    	MainPageBG.add(sg);
    	MainPageBG.add(ins);
    	
    	IMGinst1.add(prev1);
    	IMGinst1.add(b1);
    	IMGinst1.add(next1);
    	
    	IMGinst2.add(prev2);
    	IMGinst2.add(b2);
    	IMGinst2.add(next2);
    	
    	IMGinst3.add(prev3);
    	IMGinst3.add(b3);
    	IMGinst3.add(next3);
    	
    	IMGinst4.add(prev4);
    	IMGinst4.add(b4);
    	IMGinst4.add(next4);
    	
    	IMGinst5.add(prev5);
    	IMGinst5.add(b5);
    	IMGinst5.add(next5);
    	
    	IMGinst6.add(prev6);
    	IMGinst6.add(b6);
    	IMGinst6.add(next6);
    	
    	IMGinst7.add(prev7);
    	IMGinst7.add(b7);
    	IMGinst7.add(next7);
    	
    	IMGinst8.add(prev8);
    	IMGinst8.add(b8);
    	IMGinst8.add(next8);
    	
    	IMGinst9.add(prev9);
    	IMGinst9.add(b9);
    	IMGinst9.add(next9);
    	
    	home.add(MainPageBG);
    	//toGame.add(panel);
    	inst1.add(IMGinst1);
    	inst2.add(IMGinst2);
    	inst3.add(IMGinst3);
    	inst4.add(IMGinst4);
    	inst5.add(IMGinst5);
    	inst6.add(IMGinst6);
    	inst7.add(IMGinst7);
    	inst8.add(IMGinst8);
    	inst9.add(IMGinst9);
    	
    	window.add(home, "1");
    	//window.add(new Frame(), "2");
    	window.add(inst1, "3");
    	window.add(inst2, "4");
    	window.add(inst3, "5");
    	window.add(inst4, "6");
    	window.add(inst5, "7");
    	window.add(inst6, "8");
    	window.add(inst7, "9");
    	window.add(inst8, "10");
    	window.add(inst9, "11");
    	cl.show(window, "1");
    	
    	this.action(b1);
    	this.action(b2);
    	this.action(b3);
    	this.action(b4);
    	this.action(b5);
    	this.action(b6);
    	this.action(b7);
    	this.action(b8);
    	this.action(b9);
    	this.action(backToHome);
    	
    	proceedToGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(window, "1"); //to follow //main game
				
			}
    		
    	});
    	
    	sg.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				cl.show(window, "2");
				frame.setVisible(false);
				f = new Frame();
				
			}
    		
    	});
    	
    	ins.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "3");
				
			}
    		
    	});
    	
    	next1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "4");
				
			}
    		
    	});
    	
    	next2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "5");
				
			}
    		
    	});
    	
    	next3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "6");
				
			}
    		
    	});
    	
    	next4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "7");
				
			}
    		
    	});
    	
    	next5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "8");
				
			}
    		
    	});
    	
    	next6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "9");
				
			}
    		
    	});
    	
    	next7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "10");
				
			}
    		
    	});
    	
    	next8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "11");
				
			}
    		
    	});
    	
    	next9.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "1"); //main game
				
			}
    		
    	});
    	
    	prev1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "1");
				
			}
    		
    	});
    	
    	prev2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "3");
				
			}
    		
    	});
    	
    	prev3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "4");
				
			}
    		
    	});
    	
    	prev4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "5");
				
			}
    		
    	});
    	
    	prev5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "6");
				
			}
    		
    	});
    	
    	prev6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "7");
				
			}
    		
    	});
    	
    	prev7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "8");
				
			}
    		
    	});
    	
    	prev8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "9");
				
			}
    		
    	});
    	
    	prev9.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "10");
				
			}
    		
    	});
    	
    	frame.add(window);
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	frame.setVisible(true);
    }
    
    public void action(JButton b){
    	b.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(window, "1");
				
			}
    		
    	});
    }
    
    public void changeButtonFeatU(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(700,310,300,60);
    }
    
    public void changeButtonFeatD(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(700,400,300,60);
    }
    
    public void changeButtonFeatL(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(120,90,100,60);
    }
    
    public void changeButtonFeatC(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(460,90,300,50);
    }
    
    public void changeButtonFeatR(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(980,90,100,50);
    }

	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new Home();
				
			}
			
		});
    }
}
