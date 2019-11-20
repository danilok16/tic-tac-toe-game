package com.unicap.redes.ticTacToe;

import java.io.File;

import com.unicap.redes.ticTacToe.iouser.KeyboardEvents;
import com.unicap.redes.ticTacToe.iouser.MouseEvents;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Game extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage theStage) throws Exception {
		theStage.setTitle("Timeline Example");

		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);

		Canvas canvas = new Canvas(1024, 700);
		root.getChildren().add(canvas);

		final GraphicsContext gc = canvas.getGraphicsContext2D();
		final Image mainScene = new Image(new File("src/main/resources/images/scene.png").toURI().toString());

		final KeyboardEvents keyboard = new KeyboardEvents(theScene);
		final MouseEvents mouse = new MouseEvents(theScene);

		Font theFont = Font.font("Helvetica", FontWeight.BOLD, 150);
		gc.setFont(theFont);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		final long startNanoTime = System.nanoTime();

		new AnimationTimer() {

			public void handle(long currentNanoTime) {
				gc.clearRect(0, 0, 1024, 700);
				gc.drawImage(mainScene, 220, 50, 600, 600);
				if (keyboard.getInput().contains("NUMPAD1") || mouse.getInput().contains("pos_1")) {
					gc.fillText("X", 255, 190);
				}
				if (keyboard.getInput().contains("NUMPAD2") || mouse.getInput().contains("pos_2")) {
					gc.fillText("X", 470, 190);
				}
				if (keyboard.getInput().contains("NUMPAD3") || mouse.getInput().contains("pos_3")) {
					gc.fillText("X", 680, 190);
				}
				if (keyboard.getInput().contains("NUMPAD4") || mouse.getInput().contains("pos_4")) {
					gc.fillText("X", 255, 400);
				}
				if (keyboard.getInput().contains("NUMPAD5") || mouse.getInput().contains("pos_5")) {
					gc.fillText("X", 470, 400);
				}
				if (keyboard.getInput().contains("NUMPAD6") || mouse.getInput().contains("pos_6")) {
					gc.fillText("X", 680, 400);
				}
				if (keyboard.getInput().contains("NUMPAD7") || mouse.getInput().contains("pos_7")) {
					gc.fillText("X", 255, 610);
				}
				if (keyboard.getInput().contains("NUMPAD8") || mouse.getInput().contains("pos_8")) {
					gc.fillText("X", 470, 610);
				}
				if (keyboard.getInput().contains("NUMPAD9") || mouse.getInput().contains("pos_9")) {
					gc.fillText("X", 680, 610);
				}

			}

		}.start();

		theStage.show();
	}

}
