import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Brick{

	private static int xPos;
	private static int yPos;
	private static int height;
	private static int width;
	private static int xSpeed;
	private static int ySpeed;
	private static boolean motionDone;
	private ImageIcon img;

	public Brick(int x, int y) {

	 	img = new ImageIcon("brick.png");
		height = img.getIconHeight();
		width = img.getIconWidth();
		xPos = x;
		yPos = y;
		xSpeed = 0;
		ySpeed = 0;
		motionDone = true;
	}

	public void move() {

		// xPos += xSpeed;
		// yPos += ySpeed;

		// System.out.println("The x position of the brick is: " + xPos);
		// System.out.println("The value of the motionDone is: " + motionDone);

		if (motionDone == false) {

			if (xPos <= 100) {
				motionDone = true;
			}
			else if (xPos > 100) {
				xPos = xPos - 5;
			}
		}
		
	}

	public void edgeReached() {
		motionDone = false;
		// move();
	}

	public void setxPos(int x) {
		xPos = x;
	}

	public void setyPos(int y) {
		yPos = y;
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

	public boolean getMotion() {
		return motionDone;
	}

	public void paint(Graphics2D brush) {
		brush.drawImage(img.getImage(), xPos, yPos, null);
	}

	public Rectangle2D.Double getBounds() {
		return new Rectangle2D.Double(xPos, yPos, width, height);
	}
}