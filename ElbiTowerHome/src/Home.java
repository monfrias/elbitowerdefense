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
    JPanel toGame = new JPanel();
    JPanel home = new JPanel();
    JPanel window = new JPanel();
    JButton sg = new JButton("START GAME");
    JButton ins = new JButton("INSTRUCTIONS");
    JButton backToHome = new JButton("RETURN TO HOME");
    JButton proceedToGame = new JButton("PROCEED TO GAME");
    JButton next1 = new JButton("NINSTRUCTION"); //inst1
    JButton prev2 = new JButton("PINSTRUCTION"); //inst2
    JButton next2 = new JButton("NINSTRUCTION");
    JButton prev3 = new JButton("PINSTRUCTION"); //inst3
    JButton next3 = new JButton("NINSTRUCTION");
    JButton prev4 = new JButton("PINSTRUCTION"); //inst4
    JButton next4 = new JButton("NINSTRUCTION");
    JButton prev5 = new JButton("PINSTRUCTION"); //inst5
    JButton next5 = new JButton("NINSTRUCTION");
    JButton prev6 = new JButton("PINSTRUCTION"); //inst6
    JButton next6 = new JButton("NINSTRUCTION");
    JButton prev7 = new JButton("PINSTRUCTION"); //inst7
    JButton next7 = new JButton("NINSTRUCTION");
    JButton prev8 = new JButton("PINSTRUCTION"); //inst8
    JButton next8 = new JButton("NINSTRUCTION");
    JButton prev9 = new JButton("PINSTRUCTION"); //inst9
    JLabel MainPageBG = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\home.jpg"));
    JLabel IMGinst1 = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\Page 1.jpg"));
    JLabel IMGinst2 = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\Page 2.jpg"));
    JLabel IMGinst3 = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\Page 3.jpg"));
    JLabel IMGinst4 = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\Page 4.jpg"));
    JLabel IMGinst5 = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\Page 5.jpg"));
    JLabel IMGinst6 = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\Page 6.jpg"));
    JLabel IMGinst7 = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\Page 7.jpg"));
    JLabel IMGinst8 = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\Page 8.jpg"));
    JLabel IMGinst9 = new JLabel(new ImageIcon("C:\\Users\\ASUS\\workspace\\ElbiTowerHome\\src\\Image\\Page 9.jpg"));
    CardLayout cl = new CardLayout();
    
    public Home(){
    	frame.setSize(new Dimension(1200,800));
        frame.setLocationRelativeTo(null);
    	frame.setLayout(new BorderLayout());
    	
    	this.changeButtonFeatUU(backToHome);
    	this.changeButtonFeatU(sg);
    	this.changeButtonFeatD(ins);
    	this.changeButtonFeatUU(proceedToGame);
    	this.changeButtonFeatC(next1);
    	this.changeButtonFeatR(next2);
    	this.changeButtonFeatR(next3);
    	this.changeButtonFeatR(next4);
    	this.changeButtonFeatR(next5);
    	this.changeButtonFeatR(next6);
    	this.changeButtonFeatR(next7);
    	this.changeButtonFeatR(next8);
    	this.changeButtonFeatL(prev2);
    	this.changeButtonFeatL(prev3);
    	this.changeButtonFeatL(prev4);
    	this.changeButtonFeatL(prev5);
    	this.changeButtonFeatL(prev6);
    	this.changeButtonFeatL(prev7);
    	this.changeButtonFeatL(prev8);
    	this.changeButtonFeatC(prev9);
    	
    	window.setLayout(cl);
    	toGame.add(proceedToGame);
    	MainPageBG.add(sg);
    	MainPageBG.add(ins);
    	IMGinst1.add(backToHome);
    	IMGinst1.add(next1);
    	IMGinst2.add(backToHome);
    	IMGinst2.add(prev2);
    	IMGinst2.add(next2);
    	IMGinst3.add(backToHome);
    	IMGinst3.add(prev3);
    	IMGinst3.add(next3);
    	IMGinst4.add(backToHome);
    	IMGinst4.add(prev4);
    	IMGinst4.add(next4);
    	IMGinst5.add(backToHome);
    	IMGinst5.add(prev5);
    	IMGinst5.add(next5);
    	IMGinst6.add(backToHome);
    	IMGinst6.add(prev6);
    	IMGinst6.add(next6);
    	IMGinst7.add(backToHome);
    	IMGinst7.add(prev7);
    	IMGinst7.add(next7);
    	IMGinst8.add(backToHome);
    	IMGinst8.add(prev8);
    	IMGinst8.add(next8);
    	IMGinst9.add(backToHome);
    	IMGinst9.add(prev9);
    	
    	home.add(MainPageBG);
    	inst1.add(IMGinst1);
    	inst2.add(IMGinst2);
    	inst3.add(IMGinst3);
    	inst4.add(IMGinst4);
    	inst5.add(IMGinst5);
    	inst6.add(IMGinst6);
    	inst7.add(IMGinst7);
    	inst8.add(IMGinst8);
    	inst9.add(IMGinst9);
    	//inst1.setBackground(Color.CYAN);
    	toGame.setBackground(Color.CYAN);
    	
    	window.add(home, "1");
    	window.add(toGame, "2");
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
    	
    	backToHome.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(window, "1");
				
			}
    		
    	});
    	
    	proceedToGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(window, "1"); //to follow //main game
				
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
    
    public void changeButtonFeatD(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(700,400,300,60);
    }

    public void changeButtonFeatU(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(700,310,300,60);
    }
    
    public void changeButtonFeatUU(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(500,120,300,60);
    }
    
    public void changeButtonFeatR(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(700,600,300,60);
    }
    
    public void changeButtonFeatL(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(200,600,300,60);
    }
    
    public void changeButtonFeatC(JButton b){
    	b.setBackground(new Color(255, 51, 51));
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	    b.setFont(new Font("Tahoma", Font.BOLD, 24));
	    b.setBounds(500,600,300,60);
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
