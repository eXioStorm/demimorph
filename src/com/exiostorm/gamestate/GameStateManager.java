package com.exiostorm.gamestate;

import java.util.HashMap;

import com.exiostorm.handlers.ResourceManager;
import com.exiostorm.main.GameScreen;

public class GameStateManager {
	// public static GameState currentState;
	// public static GameState prevState;
	// private PauseState pauseState;
	public static HashMap<String, GameState> GameStates;

	public GameStateManager() {
		GameStates = new HashMap<String, GameState>();
		GameStates.put("currentState", null);
		GameStates.put("prevState", null);
		if (GameStates.get("currentState") != null) {
			 System.out.println("currentState starts as non-null");
		}
		if (GameStates.get("currentState") == null) {
			 System.out.println("currentState starts as null");
			loadState("MenuState", new MenuState(this));
			System.out.println(GameStates);
			setState("MenuState");
		}
	}

	public GameState getState() {
		return GameStates.get("currentState");
	}

	public void loadState(String stateName, GameState stateData) {
		if (!loadCheck(stateName)) {
			GameStates.put(stateName, stateData);
		}
	}

	public void setState(String state) {
		if (setCheck(state)) {
			ResourceManager.setState(state);
			GameStates.put("prevState", GameStates.get("currentState"));
			// prevState = currentState;
			GameStates.put("currentState", GameStates.get(state));
			// currentState = GameStates.get(state);
		}
	}

	public void unloadState(String stateName) {
		loadCheck(stateName);
		if (stateCheck(stateName)) {
			GameStates.remove(stateName);
		}
	}

	public void update() {
		if (GameStates.get("currentState") != null)
			(GameStates.get("currentState")).update();
	}

	public void draw(java.awt.Graphics2D g) {
		if (GameStates.get("currentState") != null)
			GameStates.get("currentState").draw(g);
		else {
			g.setColor(java.awt.Color.BLACK);
			g.fillRect(0, 0, GameScreen.WIDTH, GameScreen.HEIGHT);
		}
	}

	public static boolean loadCheck(String state) {
		if (GameStates.containsKey(state)) {
			System.out.println("State exists already.");
			return true;
		} else {
			return false;
		}

	}

	public static boolean setCheck(String state) {
		if (!GameStates.containsKey(state)) {
			System.out.println("State does not exist.");
			return false;
		} else {
			return true;
		}
	}

	public static boolean stateCheck(String state) {
		GameState status = GameStates.get(state);
		if (GameStates.get("prevState") == status || GameStates.get("currentState") == status) {
			System.out.println("State has another access point");
			return false;
		} else {
			return true;
		}
	}

	public void setPaused(boolean b) {
		// TODO Auto-generated method stub

	}
}
