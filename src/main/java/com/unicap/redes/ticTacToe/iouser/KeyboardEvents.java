package com.unicap.redes.ticTacToe.iouser;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class KeyboardEvents {
	private Scene scene;
	private ArrayList<String> input = new ArrayList<String>();

	public KeyboardEvents(Scene scene) {
		super();
		this.scene = scene;
		keyPressed(); // iniciando o listner
		keyReleased();
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public ArrayList<String> getInput() {
		return input;
	}

	public void setInput(ArrayList<String> input) {
		this.input = input;
	}

	public void keyPressed() {
		this.scene.setOnKeyPressed((EventHandler<? super KeyEvent>) new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();
				if (!input.contains(code))
					input.add(code);
			}
		});
	}

	public void keyReleased() {
		this.scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();
				// input.remove(code);
			}
		});
	}

}