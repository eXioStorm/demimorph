package com.exiostorm.handlers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class KeyBinding {
	//TODO probably need to initialize im/ap rather than have them called locally??
	public KeyBinding() {
	}

	public static void addKeyBinding(JComponent comp, int keyCode, String id, ActionListener actionListener) {
		InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap ap = comp.getActionMap();
		im.put(KeyStroke.getKeyStroke(keyCode, 0, false), id);
		ap.put(id, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionListener.actionPerformed(e);
			}
		});
	}

	public static void changeKeyBinding(JComponent comp, int keyCode, String id, ActionListener actionListener) {
		InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap ap = comp.getActionMap();
		im.remove(KeyStroke.getKeyStroke(keyCode, 0, false));
		ap.remove(id);
		im.put(KeyStroke.getKeyStroke(keyCode, 0, false), id);
		ap.put(id, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionListener.actionPerformed(e);
			}
		});
	}

	public static void clearKeyBindings(JComponent comp) {
		InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap ap = comp.getActionMap();
		im.clear();
		ap.clear();
	}
}
