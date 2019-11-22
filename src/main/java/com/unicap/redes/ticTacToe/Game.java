package com.unicap.redes.tictactoe;

import java.io.File;

import com.unicap.redes.tictactoe.common.CommunicationCode;
import com.unicap.redes.tictactoe.common.TransferObject;
import com.unicap.redes.tictactoe.connection.impl.ServerCommunication;
import com.unicap.redes.tictactoe.iouser.KeyboardEvents;
import com.unicap.redes.tictactoe.iouser.MouseEvents;

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
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(1);
		final long startNanoTime = System.nanoTime();
		
		final ServerCommunication client = new ServerCommunication();
		
		new AnimationTimer() {

			public void handle(long currentNanoTime) {
				gc.clearRect(0, 0, 1024, 700);
				gc.drawImage(mainScene, 220, 50, 600, 600);
				if (keyboard.getInput().contains("NUMPAD1") || mouse.getInput().contains("pos_1")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), "1,0"));
				}
				if (keyboard.getInput().contains("NUMPAD2") || mouse.getInput().contains("pos_2")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), "1,1"));
				}
				if (keyboard.getInput().contains("NUMPAD3") || mouse.getInput().contains("pos_3")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), "1,2"));
				}
				if (keyboard.getInput().contains("NUMPAD4") || mouse.getInput().contains("pos_4")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), "1,3"));
				}
				if (keyboard.getInput().contains("NUMPAD5") || mouse.getInput().contains("pos_5")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), "1,4"));
				}
				if (keyboard.getInput().contains("NUMPAD6") || mouse.getInput().contains("pos_6")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), "1,5"));
				}
				if (keyboard.getInput().contains("NUMPAD7") || mouse.getInput().contains("pos_7")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), "1,6"));
				}
				if (keyboard.getInput().contains("NUMPAD8") || mouse.getInput().contains("pos_8")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), "1,7"));
				}
				if (keyboard.getInput().contains("NUMPAD9") || mouse.getInput().contains("pos_9")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), "1,8"));
				} 
				
				client.send(new TransferObject(CommunicationCode.GET_BOARD.ordinal(), null));
				
				if(client.getReceivedObject() != null) {
					
					if(client.getReceivedObject().getMessage().charAt(1) == '1') {
						gc.fillText("X", 255, 190);
					}
					if(client.getReceivedObject().getMessage().charAt(4) == '1') {
						gc.fillText("X", 470, 190);
					}
					if(client.getReceivedObject().getMessage().charAt(7) == '1') {
						gc.fillText("X", 680, 190);
					}
					if(client.getReceivedObject().getMessage().charAt(10) == '1') {
						gc.fillText("X", 255, 400);
					}
					if(client.getReceivedObject().getMessage().charAt(13) == '1') {
						gc.fillText("X", 470, 400);
					}
					if(client.getReceivedObject().getMessage().charAt(16) == '1') {
						gc.fillText("X", 680, 400);
					}
					if(client.getReceivedObject().getMessage().charAt(19) == '1') {
						gc.fillText("X", 255, 610);
					}
					if(client.getReceivedObject().getMessage().charAt(22) == '1') {
						gc.fillText("X", 470, 610);
					}
					if(client.getReceivedObject().getMessage().charAt(25) == '1') {
						gc.fillText("X", 680, 610);
					}
				}		
			}

		}.start();

		theStage.show();
	}

}
