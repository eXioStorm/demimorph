package com.exiostorm.gamestate.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.exiostorm.audio.JukeBox;
import com.exiostorm.gamestate.GameState;
import com.exiostorm.gamestate.GameStateManager;
import com.exiostorm.gui.Window;
import com.exiostorm.handlers.keybindpresets.MenuPreset;
import com.exiostorm.main.GameScreen;

public class MenuState extends GameState {

	private BufferedImage icon;

	private byte currentChoice = 0;
	private byte menuOptions = 1;

	private Color titleColor;
	private Font titleFont;

	private Font font;
	private Font font2;

	public MenuState(GameStateManager gsm) {

		super(gsm);

		try {

			// load menu icon
			icon = ImageIO.read(getClass().getResourceAsStream("/demo/test.png")).getSubimage(0, 0, 40, 15);
			
			// titles and fonts
			titleColor = Color.WHITE;
			titleFont = new Font("Times New Roman", Font.PLAIN, 28);
			font = new Font("Arial", Font.PLAIN, 14);
			font2 = new Font("Arial", Font.PLAIN, 9);

			// load sound fx
			JukeBox.load("SFX/menuoption.ogg", "buttons", "menuoption");
			JukeBox.load("SFX/menuselect.ogg", "buttons", "menuselect");
			JukeBox.play("menuoption", "effect", 1, true);
			JukeBox.play("menuselect", "effect", 1, true);
			// other
			if (GameScreen.keyBindings != "menu") {
					GameScreen.keyBindings = "menu";
					//System.out.println(Window.window.getComponents());
					MenuPreset.set(Window.gameScreen, gsm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void init() {

	}

	public void update() {


	}

	public void draw(Graphics2D g) {
		// game dimensions
		int w = GameScreen.WIDTH;
		int h = GameScreen.HEIGHT;
		
		// draw bg
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, w, h);
		
		// draw selector icon
		if (currentChoice == 0)
			g.drawImage(icon, w / 22 * 8, h / 82 * 77, null);
		else if (currentChoice == 1)
			g.drawImage(icon, w / 22 * 8, h / 130 * 173, null);
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		//g.drawString("Platformer", w / 3, h / 2);
		g.setFont(font2);

		// draw menu options
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Start", w / 20 * 8, h / 21 * 15);
		g.drawString("Quit", w / 20 * 8, h / 28 * 23);
		// other
		g.setFont(font2);

	}
	public void select() {
		if (currentChoice == 0) {
			JukeBox.play("menuselect", "effect", 1, false);
			// PlayerSave.init();
		} else if (currentChoice == 1) {
			//JukeBox.clearHard();
			System.exit(0);
		}
	}
	public void incrementChoice(boolean AS) {
		JukeBox.play("menuoption", "effect", 1, true);
		if (AS == false) {
			--currentChoice;
			if (currentChoice < 0) {
				currentChoice = menuOptions;
			}
		}
		if (AS == true) {
			++currentChoice;
			if (currentChoice > menuOptions) {
				currentChoice = 0;
			}
		}
	}
}
