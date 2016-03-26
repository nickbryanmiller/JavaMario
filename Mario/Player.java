import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Player {
	private static int xPos;
	private static int yPos;
	private static int height;
	private static int width;
	private static int xSpeed;
	private static int ySpeed;
	private static int acceleration;
	private static Boolean gravity;
	private static Boolean didJump;
	private static Boolean motionDone;
	private ImageIcon img;


	public Player() {
		
		img = new ImageIcon("marioStand.png");
		height = img.getIconHeight();
		width = img.getIconWidth();
		xPos = 100;
		yPos = 300;
		acceleration = 1;
		gravity = false;
		didJump = false;
		motionDone = true;

	}

	public void move() {

		if (motionDone == true) {
			// move Mario
			xPos += xSpeed;
			if (xPos <= 0) {
				xPos = xPos + 2;
			}

			// if(didJump == false) {
				yPos += ySpeed;

				if (yPos <= 0) {
					yPos = yPos + 30;
				}
			// }

			if (gravity == true) {
				yPos += 3;
				didJump = true;
			}

			if (yPos >= 330) {
				gravity = false;
				stand();
				yPos = 300;
			}
			if (yPos >= 300) {
				didJump = false;
			}
		}

		if (motionDone == false) {

			if (xPos <= 100) {
				motionDone = true;
			}
			else if (xPos > 100) {
				xPos = xPos - 5;
			}
		}

	}

	public void stand(){
		img = new ImageIcon("marioStand.png");
	}
	public void standLeft(){
		img = new ImageIcon("marioStandLeft.png");
	}

	public void jump(){
		if (motionDone == true) {
			img = new ImageIcon("marioJump.png");
		}
	}

	public void moveUp() {
		ySpeed = -30;
		gravity = true;

	}

	public void moveDown() {
		ySpeed = 10;
	}		

	public void setXspeed(int newSpeed) {
		xSpeed = newSpeed;
	}

	public void setYspeed(int newSpeed) {
		ySpeed = newSpeed;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}

	public void reachedEdge() {
		
		if (xPos >= 520) {
			motionDone = false;
		}

		// xPos = newX;

	}

	public Boolean getDidJump() {
		return didJump;
	}

	public void paint(Graphics2D brush) {
		brush.drawImage(img.getImage(), xPos, yPos, null);
	}

	public Rectangle2D.Double getBounds() {
		return new Rectangle2D.Double(xPos, yPos, width, height);
	}

}