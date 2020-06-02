package com.exiostorm.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.exiostorm.main.GameScreen;

public class Window {
	public static JFrame window;
	public static GameScreen gameScreen = new GameScreen();
	
	
	public static void createWindow() {
		window = new JFrame("DemiMorph");
		window.setIconImage(new ImageIcon("Resources/demo/icon.png").getImage());
		window.add(gameScreen); // Add the main game loop - eXioStorm
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.pack();
		window.setLocationRelativeTo(null);
		System.out.println("[Gui][DisplayManager]: Created Window");
	}
	public static void setVisible() {
		if (window!=null) {window.setVisible(true);
		System.out.println("[Gui][DisplayManager]: Created Window set to visible");
		}
	}
}
