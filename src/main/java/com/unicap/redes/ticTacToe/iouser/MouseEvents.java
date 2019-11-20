package com.unicap.redes.ticTacToe.iouser;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class MouseEvents {
	private Scene scene;
	private ArrayList<String> input = new ArrayList<String>();

	public MouseEvents(Scene scene) {
		super();
		this.scene = scene;
		buttonPressed();
		buttonReleased();
		move();
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

	public void buttonPressed() {
		this.scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				String code = e.getButton().toString();
				if (!input.contains(code)) {
					input.add(code);
				}
				if (e.getSceneX() >= 220 && e.getSceneX() <= 395 && e.getSceneY() >= 60 && e.getSceneY() <= 224) {
					if (!input.contains("pos_1")) {
						input.add("pos_1");
					}
				} else if (e.getSceneX() >= 420 && e.getSceneX() <= 620 && e.getSceneY() >= 60
						&& e.getSceneY() <= 224) {
					if (!input.contains("pos_2")) {
						input.add("pos_2");
					}
				} else if (e.getSceneX() >= 645 && e.getSceneX() <= 814 && e.getSceneY() >= 60
						&& e.getSceneY() <= 224) {
					if (!input.contains("pos_3")) {
						input.add("pos_3");
					}
				} else if (e.getSceneX() >= 220 && e.getSceneX() <= 395 && e.getSceneY() >= 250
						&& e.getSceneY() <= 450) {
					if (!input.contains("pos_4")) {
						input.add("pos_4");
					}
				} else if (e.getSceneX() >= 420 && e.getSceneX() <= 620 && e.getSceneY() >= 250
						&& e.getSceneY() <= 450) {
					if (!input.contains("pos_5")) {
						input.add("pos_5");
					}
				} else if (e.getSceneX() >= 645 && e.getSceneX() <= 814 && e.getSceneY() >= 250
						&& e.getSceneY() <= 450) {
					if (!input.contains("pos_6")) {
						input.add("pos_6");
					}
				} else if (e.getSceneX() >= 220 && e.getSceneX() <= 395 && e.getSceneY() >= 475
						&& e.getSceneY() <= 650) {
					if (!input.contains("pos_7")) {
						input.add("pos_7");
					}
				} else if (e.getSceneX() >= 420 && e.getSceneX() <= 620 && e.getSceneY() >= 475
						&& e.getSceneY() <= 650) {
					if (!input.contains("pos_8")) {
						input.add("pos_8");
					}
				} else if (e.getSceneX() >= 645 && e.getSceneX() <= 814 && e.getSceneY() >= 475
						&& e.getSceneY() <= 650) {
					if (!input.contains("pos_9")) {
						input.add("pos_9");
					}
				}

			}
		});

	}

	public void buttonReleased() {
		this.scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				String code = e.getButton().toString();
				input.remove(code);
			}
		});
	}

	public void move() {
		this.scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				System.out.println("X:" + e.getSceneX());
				System.out.println("Y:" + e.getSceneY());
			}
		});
	}
}
