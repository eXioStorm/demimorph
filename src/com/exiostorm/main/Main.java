package com.exiostorm.main;

import com.exiostorm.gui.Window;

//This class is the "main" class that runs the game.
public class Main {
	public static void main(String[] args) {

		System.out.println("[Window]: Starting...");
		Window.createWindow();
		Window.setVisible();
		System.out.println("[Window]: Started!");
	}

}
