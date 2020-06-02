package com.exiostorm.handlers.keybindpresets;

import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import com.exiostorm.gamestate.GameStateManager;
import com.exiostorm.handlers.KeyBinding;
import com.exiostorm.main.GameScreen;

public class MenuPreset {
	public MenuPreset() {
	}

	public static void set(JComponent i, GameStateManager gsm) {
		KeyBinding.addKeyBinding(i, KeyEvent.VK_UP, "menuUp", (evt) -> {
			gsm.getState().incrementChoice(false);
		});
		KeyBinding.addKeyBinding(i, KeyEvent.VK_DOWN, "menuDown", (evt) -> {
			gsm.getState().incrementChoice(true);
		});
		KeyBinding.addKeyBinding(i, KeyEvent.VK_ENTER, "menuSelect", (evt) -> {
			//System.out.println("test");
			gsm.getState().select();
		});
		KeyBinding.addKeyBinding(i, KeyEvent.VK_F12, "screenshot", (evt) -> {
			GameScreen.screenshot = true;
		});
	}
}
