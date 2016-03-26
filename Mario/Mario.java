import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

	
public class Mario {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Welcome to Nick's Version of Mario!");
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(583,486);
        frame.setTitle("mario");
        frame.setResizable(false);
        frame.add(new GamePanel());
        frame.setVisible(true);
        
        Music music = new Music();
        try {
			music.playTheme();
		}
		catch(Exception ex) {
		}
	}

	private static class GamePanel extends JPanel {

		Music music;
		Player player;
		Brick brick;
		Timer timer;
		GamePanel panel;
		ImageIcon background;
		int switcher = 0;

		public GamePanel() {
			super();

			// call initializeGameObjects()
			initializeGameObjects();
			
			// add Ash as a keyListener
			addKeyListener(new Mover());

			setFocusable(true);			
		}

		public void initializeGameObjects() {
			// instantiate player, buildings, objects, and boundaries
			music = new Music();
			player = new Player();
			brick = new Brick(400, 100);

			// set up timer to run GameMotion() every 10ms
			timer = new Timer(10, new GameMotion());
			timer.start();

			background = new ImageIcon("background.jpg");
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
		
			// paint player, buildings, objects, and boundaries
			g2.drawImage(background.getImage(),0,0,null);
			
			brick.paint(g2);
			player.paint(g2);
			
		}

		private class GameMotion implements ActionListener {

			public GameMotion() {
				
			}

			public void actionPerformed(ActionEvent evt) {

				//check if Ash hits the anything
				checkForHit();
				
				brick.move();
				player.move();
				
				//call repaint
				repaint();
				switcher++;

			}
		}


		private class Mover implements KeyListener {

			public void keyPressed(KeyEvent evt) {
				// change Ash's look for left and right key presses
				int key = evt.getKeyCode();

				if (key == KeyEvent.VK_LEFT) {
					player.standLeft();
					player.setXspeed(-2);
					player.setYspeed(0);					
				}

				if (key == KeyEvent.VK_RIGHT) {
					player.stand();
					player.setXspeed(2);
					player.setYspeed(0);

				}

				if (key == KeyEvent.VK_DOWN) {
					
				}

				if (key == KeyEvent.VK_UP) {
					// if (player.getDidJump() == false) {
						player.moveUp();
						player.jump();
						try {
						music.playJump();
						}
						catch(Exception ex) {
						}
					// }
				}

			}
			public void keyReleased(KeyEvent evt) {

				int keylet = evt.getKeyCode();

				// set player to stand
				if (keylet == KeyEvent.VK_LEFT) {
					player.setXspeed(0);
				}

				if (keylet == KeyEvent.VK_RIGHT) {
					player.setXspeed(0);
				}

				if (keylet == KeyEvent.VK_DOWN) {
					
				}

				if (keylet == KeyEvent.VK_UP) {
					player.setYspeed(0);
				}
			}
			public void keyTyped(KeyEvent evt) {}
		}

		public void checkForHit() {
			// System.out.println(player.getY());

			if (player.getBounds().intersects(brick.getBounds())) {
				try {
					music.playBrick();
				}
				catch(Exception ex) {
				}

				player.moveDown();
			}

			if (player.getX() >= 520) {
				
				player.reachedEdge();
				brick.edgeReached();
			}
		}

	}
}