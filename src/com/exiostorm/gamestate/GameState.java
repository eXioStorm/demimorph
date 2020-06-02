package com.exiostorm.gamestate;

import java.awt.Graphics2D;

import com.exiostorm.gamestate.GameStateManager;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	//public abstract void handleInput();

	public abstract void select();

	public void incrementChoice(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
