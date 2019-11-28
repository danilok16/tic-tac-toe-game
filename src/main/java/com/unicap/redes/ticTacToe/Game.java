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

public class Game extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage theStage) throws Exception {
		theStage.setTitle("JOGO DA VELHA");

		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);

		Canvas canvas = new Canvas(1024, 700);
		root.getChildren().add(canvas);

		final GraphicsContext gc = canvas.getGraphicsContext2D();
		final Image mainScene = new Image(new File("src/main/resources/images/scene.png").toURI().toString());

		final KeyboardEvents keyboard = new KeyboardEvents(theScene);
		final MouseEvents mouse = new MouseEvents(theScene);

		final Font theFont = Font.font("Helvetica", FontWeight.BOLD, 150);
		final Font playerFont = Font.font("Helvetica", FontWeight.BOLD, 30);
		gc.setFont(theFont);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(1);
		final long startNanoTime = System.nanoTime();

		final ServerCommunication client = new ServerCommunication();

		client.login();
		
		final String LABEL_X = "X";
		final String LABEL_O = "O";

		new AnimationTimer() {

			public void handle(long currentNanoTime) {
				gc.clearRect(0, 0, 800, 700);
				drawPlayerInformation(gc, client, playerFont);
				gc.setFont(theFont);
				gc.drawImage(mainScene, 220, 50, 600, 600);
				if (keyboard.getInput().contains("NUMPAD1") || mouse.getInput().contains("pos_1")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), client.getPlayer().getCod() + ",0",0));
					mouse.resetInputs();
				}
				if (keyboard.getInput().contains("NUMPAD2") || mouse.getInput().contains("pos_2")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), client.getPlayer().getCod() + ",1",0));
					mouse.resetInputs();
				}
				if (keyboard.getInput().contains("NUMPAD3") || mouse.getInput().contains("pos_3")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), client.getPlayer().getCod() + ",2",0));
					mouse.resetInputs();
				}
				if (keyboard.getInput().contains("NUMPAD4") || mouse.getInput().contains("pos_4")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), client.getPlayer().getCod() + ",3",0));
					mouse.resetInputs();
				}
				if (keyboard.getInput().contains("NUMPAD5") || mouse.getInput().contains("pos_5")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), client.getPlayer().getCod() + ",4",0));
					mouse.resetInputs();
				}
				if (keyboard.getInput().contains("NUMPAD6") || mouse.getInput().contains("pos_6")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), client.getPlayer().getCod() + ",5",0));
					mouse.resetInputs();
				}
				if (keyboard.getInput().contains("NUMPAD7") || mouse.getInput().contains("pos_7")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), client.getPlayer().getCod() + ",6",0));
					mouse.resetInputs();
				}
				if (keyboard.getInput().contains("NUMPAD8") || mouse.getInput().contains("pos_8")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), client.getPlayer().getCod() + ",7",0));
					mouse.resetInputs();
				}
				if (keyboard.getInput().contains("NUMPAD9") || mouse.getInput().contains("pos_9")) {
					client.send(new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), client.getPlayer().getCod() + ",8",0));
					mouse.resetInputs();
				}
				
				client.send(new TransferObject(CommunicationCode.GET_BOARD.ordinal(), null,0));
				
				if(client.getReceivedObject() != null && client.getReceivedObject().getCode() == 6) {
					gc.clearRect(0, 0, 800, 700);
					drawWinnerLine(gc, client);
				}

				if (client.getReceivedObject() != null && client.getReceivedObject().getMessage().contains("0")) {
					
					if (client.getReceivedObject().getMessage().charAt(1) == '1') {
						gc.setFill( Color.RED );
						gc.fillText(LABEL_X, 255, 190);
					} else if (client.getReceivedObject().getMessage().charAt(1) == '2') {
						gc.setFill( Color.GREEN );
						gc.fillText(LABEL_O, 255, 190);
					}
					if (client.getReceivedObject().getMessage().charAt(4) == '1') {
						gc.setFill( Color.RED );
						gc.fillText(LABEL_X, 470, 190);
					} else if (client.getReceivedObject().getMessage().charAt(4) == '2') {
						gc.setFill( Color.GREEN );
						gc.fillText(LABEL_O, 470, 190);
					}
					if (client.getReceivedObject().getMessage().charAt(7) == '1') {
						gc.setFill( Color.RED );
						gc.fillText(LABEL_X, 680, 190);
					} else if (client.getReceivedObject().getMessage().charAt(7) == '2') {
						gc.setFill( Color.GREEN );
						gc.fillText(LABEL_O, 680, 190);
					}
					if (client.getReceivedObject().getMessage().charAt(10) == '1') {
						gc.setFill( Color.RED );
						gc.fillText(LABEL_X, 255, 400);
					} else if (client.getReceivedObject().getMessage().charAt(10) == '2') {
						gc.setFill( Color.GREEN );
						gc.fillText(LABEL_O, 255, 400);
					}
					if (client.getReceivedObject().getMessage().charAt(13) == '1') {
						gc.setFill( Color.RED );
						gc.fillText(LABEL_X, 470, 400);
					} else if (client.getReceivedObject().getMessage().charAt(13) == '2') {
						gc.setFill( Color.GREEN );
						gc.fillText(LABEL_O, 470, 400);
					}
					if (client.getReceivedObject().getMessage().charAt(16) == '1') {
						gc.setFill( Color.RED );
						gc.fillText(LABEL_X, 680, 400);
					} else if (client.getReceivedObject().getMessage().charAt(16) == '2') {
						gc.setFill( Color.GREEN );
						gc.fillText(LABEL_O, 680, 400);
					}
					if (client.getReceivedObject().getMessage().charAt(19) == '1') {
						gc.setFill( Color.RED );
						gc.fillText(LABEL_X, 255, 610);
					} else if (client.getReceivedObject().getMessage().charAt(19) == '2') {
						gc.setFill( Color.GREEN );
						gc.fillText(LABEL_O, 255, 610);
					}
					if (client.getReceivedObject().getMessage().charAt(22) == '1') {
						gc.setFill( Color.RED );
						gc.fillText(LABEL_X, 470, 610);
					} else if (client.getReceivedObject().getMessage().charAt(22) == '2') {
						gc.setFill( Color.GREEN );
						gc.fillText(LABEL_O, 470, 610);
					}
					if (client.getReceivedObject().getMessage().charAt(25) == '1') {
						gc.setFill( Color.RED );
						gc.fillText(LABEL_X, 680, 610);
					} else if (client.getReceivedObject().getMessage().charAt(25) == '2') {
						gc.setFill( Color.GREEN );
						gc.fillText(LABEL_O, 680, 610);
					}
				}else {
					theStage.close();
				}
			}
		}.start();

		theStage.show();
		
	}
	
	@Override
	public void stop(){
		ServerCommunication client = new ServerCommunication();
		client.send(new TransferObject(CommunicationCode.LOGOUT.ordinal(), null,0));
	}
	
	public void drawPlayerInformation(GraphicsContext gc, ServerCommunication client, Font playerFont) {
		gc.setFill( Color.BLACK );
		gc.setStroke( Color.RED );
		gc.setLineWidth(1);
		gc.setFont(playerFont);
		gc.fillText("Jogador: "+client.getPlayer().getCod(), 10, 40);
	}
	
	public void drawWinnerLine(GraphicsContext gc, ServerCommunication client) {
		gc.setFill( Color.BLACK );
		gc.setStroke( Color.RED );
		gc.setLineWidth(1);
		gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		gc.fillText("Vencedor: Jogador - "+client.getPlayer().getCod(), 400, 400);
	}
}
