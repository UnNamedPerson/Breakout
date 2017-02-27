import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Project4_Test extends JFrame{
	
	public Project4_Test(){	
		
		Project4 Project4A = new Project4();
		Project4A.requestFocusInWindow();
//		setLayout(new FlowLayout());
		add(Project4A);
		setTitle("Project4 Graphics");
		setSize(540,540);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

	}	
	
	
	
public static void main(String[] args) {
	
	new Project4_Test().setVisible(true);
}

}
