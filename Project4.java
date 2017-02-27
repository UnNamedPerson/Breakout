import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;



public class Project4 extends JPanel implements KeyListener{
	
	double Time = 0;   // Starting time
	int circleX = 5;
	int circleY = 400;
	
	int G = (int) 9;
	int x1;
	int y1;
	int circleW = 5;
	int circleH = 5;
	
	int Vi_x = 15; // the initial (x) speed that will be used in the equation
	int Vi_y = -8; // the initial (y) speed that will be used in the equation
	
	int SpeedOfX = 0; // the final (x) speed that will be used to update the x position 
	double SpeedOfY = 0; //the final (y) speed that will be used to update the y position 
	
	int angle = (int) Math.toRadians(65) ;    // if you have to, change the starting angle later

	int RectH = 14;
	int RectW = 46;
	int RectX = 40;
	int RectY = 400;
	
	
	int rect2Height = 46;
	int rect2Width = 10;
	int rect2X =  20;
	int rect2Y =  290;
	int rect2XChange = 5;
	
	JLabel Lives;
	JLabel Points;
	JLabel Space;
	JLabel maxPoint;
	JLabel lostMessage;
	JLabel levels;
	
	int maxP = 0;
	
	JButton Restart;

	
	int lives = 3;
	int points = 0;
	int circleTime = 0;
	int Level = 1;
	
	int TimeN = 1;
	int timeDelay = 80;
	
	protected Timer Timer;
	
	
	
	
	@Override
	public void paintComponent (Graphics A){
		
		A.setColor(Color.orange);
		
		A.fillArc(getWidth() - 50, 20, 35, 35, 0, circleTime);
		
		A.setColor(Color.blue);
		
		A.fillArc(circleX, circleY, circleW, circleH, 0, 360);
		
		A.setColor(Color.RED);
		
		A.fillRect(RectX, RectY, RectW , RectH);
	
		A.setColor(Color.lightGray);
		
		A.fillRect(rect2X, rect2Y, rect2Width, rect2Height);
		
	}
	
	
	
	
	
	public Project4(){	
		
		Timer Timer = new Timer(timeDelay, new ITimer());
		Timer.start();

		setFocusable(true);
		
		addKeyListener(this);
		
		Lives = new JLabel("Lives: " + lives);
		add(Lives);
		
		Space = new JLabel("   ");
		add(Space);
		
		Points = new JLabel("Points: " + points);
		add(Points);
		
		lostMessage = new JLabel("");
		add(lostMessage);
		
//		Restart = new JButton("Restart game");
//		add(Restart);
//		Restart.addActionListener(new restartTime());
		
		maxPoint = new JLabel("        Max Point: " + maxP );
		add(maxPoint);
		
		levels = new JLabel("   Level: " + Level);
		add(levels);
		
		

		
//		StartTime = new JButton("Unfreez Time");
//		add(StartTime);
//		StartTime.addActionListener(new TimeStart());
		
		}	
	
	
	
	
	protected class ITimer implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			SpeedOfX = (int) (Vi_x * (Math.cos(angle)));
			
			SpeedOfY =  ((Vi_y * Math.sin(angle)) +  G*Time);
			
//			SpeedOfY = (int) (Vi_y +  G*Time);
			
			Time += 0.002 ;
			
//			Vi_y = SpeedOfY;
			
//			RectX += 5;
			
			
			////////////////////////////////////
//			System.out.println(Math.sin(angle));
//			System.out.println(SpeedOfY);
//			System.out.println(circleY);
			////////////////////////////
			
			
			circleX += SpeedOfX ;
			circleY += SpeedOfY ;
			
			G += 9;
			
			if(circleX >= getWidth() - circleW){
				Vi_x = Vi_x * -1;
			}
			
			if(circleX < 2){
				Vi_x = Vi_x * -1;
			}
			
			if (circleY + circleH >= RectY && circleY + circleH <= RectY + RectH ){
				if(RectX <= (circleX + circleW) && circleX <= RectX + (RectW)){
					
				Time = 0;
				G = (int)9;
				Vi_y = -8;
				
				points += 3;
				Points.setText(("Points: " + points));
				
				}
			}
			
			
			if ( circleY <= rect2Y + rect2Height  &&  circleY >= rect2Y){	
				if(circleX <= (rect2X + rect2Width + 2) && circleX + circleW >= (rect2X)){
				
					
//					System.out.println("Actual hit rectangle");
					
					Vi_x = Vi_x * -1;
					
					points += 50;
					Points.setText(("Points: " + points));
					
					rect2Height = 0;
					rect2Width = 0;
				}
				
//				System.out.println("hit rectangle");
				
			}
			
			
			if(circleY - circleH > getHeight()){
								
				circleX = 10;
				circleY = 400;	
				RectX = 40;
				RectY =  400;
				Time = 0;
				G = (int)9;
				Vi_y = -8;
								
				lives--;
				Lives.setText("Lives: " + lives);
				
				rect2Width = 10;
				rect2Height = 46;
			}
			
	
			
//check out later if interested to change			
			
//			if ( lives < 2){
//				
//				System.out.println("before Lost message");
//				
//				if(circleY - (circleH + 100) < getHeight()){
//					
//				System.out.println("Lost message");
//				
//				lostMessage.setText("YOU LOST !! game will restart again within seconds");
//				
//				
//				}
//			}
			
			
			
			
			// code for resetting the game points and lives
			
			if(lives == 0){
				
				Level = 1;
				levels.setText(("   Level: " + Level));
				
				points = 0;
				Points.setText(("Points: " + points));
				
			    RectH = 14;
				RectW = 46;
				
				RectX = 40;
				lives = 3;
				Lives.setText("Lives: " + lives);

//				Timer.stop();
//				timeDelay = 10;
//				Timer.setInitialDelay(timeDelay);
				
				try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				System.out.println("That didn't work");
				e1.printStackTrace();
			}
				
				
				
				circleTime = 0;
				
				rect2Width = 10;
				rect2Height = 46;
				
				Vi_x = 15;
				
			}
			

		
			if(circleTime == 360){
				
				circleTime = 0; 
				circleX = 10;
				 circleY = 400;	
				 
				 RectX = 40;
//				 RectY = (getHeight() + 400);
				 
				Time = 0;
				G = (int)9;
				Vi_y = -8;
				
				if(RectW > 12){
				RectW -= 4 ;
				}else if(RectW <= 12){
					RectW = RectW;
				}
				
				
				Vi_x += 1 ; 
				
				points += 60;
				Points.setText(("Points: " + points));
				
				Level ++;
				levels.setText(("   Level: " + Level));
				
//				lives = 3;
//				Lives.setText("Lives: " + lives);
				
				rect2Width = 10;
				rect2Height = 46;
			
				try {
				Thread.sleep(350);
			} catch (InterruptedException e1) {
				System.out.println("That didn't work");
				e1.printStackTrace();
			}
				
			}
			
			
			
			if(maxP < points){
				maxP = points;
				maxPoint.setText("       Max Point: " + maxP );
				
			}
			
			
			if (rect2X + rect2Width + 2  > getWidth()){
				rect2XChange  = rect2XChange * -1;
				
			} else if (rect2X < 2){
				rect2XChange = rect2XChange * -1;
			}
			
			
//			if(circleX < (rect2X + rect2Width) && circleX + circleW > (rect2X - 6)){
//				
//				System.out.println("hit rect from the left ");
//				
//				if (circleY < rect2Y && circleY > rect2Y + rect2Height){
//				Vi_x = Vi_x * -1;
//				}
//			}
		
			
			
			circleTime += 1.5;
		
			rect2X += rect2XChange;
		
			
			repaint();
			
			
		}
		
	}

	

	@Override
	public void keyTyped(KeyEvent e) {
		
		if(e.getSource().equals(e.VK_KP_RIGHT)){
			
			System.out.println(RectX);
			
			RectX += 15;
	} 
		if (e.getSource().equals(e.VK_KP_LEFT)){
		
			System.out.println(RectX);
			
			RectX += -15;
	}
		
		repaint();
		
	}

	
	

	@Override
	public void keyPressed(KeyEvent e) {
		
//		System.out.println(e.VK_KP_RIGHT);
//		System.out.println(e.VK_LEFT);

		if(e.getKeyCode() == (e.VK_RIGHT)){
			
//			System.out.println(RectX);
//			System.out.println("Pressing right");
			
			RectX += 15;
	} 
		if (e.getKeyCode() == (e.VK_LEFT)){
			
	
//			System.out.println(RectX);
//			System.out.println("Pressing left");

			
			RectX += -15;
	}
		
		repaint();
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(e.VK_KP_RIGHT)){
			
			RectX += 0;
	} 
		if(e.getSource().equals(e.VK_KP_LEFT)){
			
			RectX += 0;
	} 
		
		repaint();

		
	}
	
	

}
