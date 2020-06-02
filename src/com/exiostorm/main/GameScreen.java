package com.exiostorm.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.exiostorm.audio.JukeBox;
import com.exiostorm.gamestate.GameStateManager;

//This Class is the main game loop. - eXioStrom
@SuppressWarnings("serial")
public class GameScreen extends JPanel implements Runnable/*, KeyListener*/ {

	// dimensions
	public static final int WIDTH = 360;
	public static final int HEIGHT = 240;
	public static final int SCALE = 2;

	// game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;

	// image
	public static BufferedImage image;
	private Graphics2D g;

	// game state manager
	private GameStateManager gsm;

	// other
	public static boolean screenshot;
	public static String keyBindings;

	public GameScreen() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
		System.out.println("[Gui][GameScreen]: Created GameScreen");
	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			//addKeyListener(this);
			thread.start();
		}
	}

	private void init() {
		JukeBox.Init();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB); // was TYPE_INT_RGB
		g = (Graphics2D) image.getGraphics();
		running = true;
		gsm = new GameStateManager();
		
	}

	public void run() {
		init();
		long start;
		long elapsed;
		long wait;

		// game loop
		while (running) {
			start = System.nanoTime();
			update();
			draw(); //TODO
			drawToScreen();
			elapsed = System.nanoTime() - start;

			wait = targetTime - elapsed / 1000000;
			if (wait < 0)
				wait = 5;

			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void update() {
		gsm.update();
		//Keys.update();
	}

	 private void draw() {//TODO
	 gsm.draw(g);
	 }
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g2.dispose();
		if (screenshot) {
			screenshot = false;
			try {
				long i = System.nanoTime();
				System.out.println("[Gui][GameScreen]: Saved screenshot - " + i + ".png");
				java.io.File out = new java.io.File(i + ".png");
				javax.imageio.ImageIO.write(image, "png", out);
			} catch (Exception e) {
			}
		}
	}

	//public void keyTyped(KeyEvent key) {
	//}

	//public void keyPressed(KeyEvent key) {
	//	if (key.isControlDown()) {
	//		if (key.getKeyCode() == KeyEvent.VK_S) {
	//			screenshot = true;
	//			return;
	//		}
	//	}
	//	Keys.keySet(key.getKeyCode(), true);
	//}

	//public void keyReleased(KeyEvent key) {
	//	Keys.keySet(key.getKeyCode(), false);
	//}

}
