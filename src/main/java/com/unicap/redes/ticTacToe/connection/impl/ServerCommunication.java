package com.unicap.redes.tictactoe.connection.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.unicap.redes.tictactoe.common.TransferObject;
import com.unicap.redes.tictactoe.connection.IServerCommunication;

public class ServerCommunication implements IServerCommunication {
	public static Scanner scanner = new Scanner(System.in);
	private DatagramSocket socket;
	private InetAddress address;
	private final int severPort = 8085;
	private byte[] buffer;
	private final int bufferLength = 1024;
	TransferObject receivedObject;
	
	
	public ServerCommunication(){
		try {
			socket = new DatagramSocket();
			address = InetAddress.getByName("172.17.17.253");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void server() {

		/*try {

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	public void send(TransferObject objectToSend) {
		try {
			DatagramPacket sendPacket;
			sendPacket = this.buildResponse(objectToSend, this.address, this.severPort);
			this.socket.send(sendPacket);
			this.buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			this.socket.receive(packet);
			this.analyzeRequest(packet);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		socket.close();

	}

	private TransferObject serverMenu() {
		System.out.println("1 - Get Board");
		System.out.println("2 - Make a Move");
		/*
		 * String asw = this.scanner.nextLine(); if (asw.equals("1")) { return new
		 * TransferObject(CommunicationCode.GET_BOARD.ordinal(), ""); } else if
		 * (asw.equals("2")) { System.out.
		 * println(" ----------- Make Move [Format]: piece, position ------------");
		 * System.out.println("________EX: 1,5_______"); asw = this.scanner.nextLine();
		 * return new TransferObject(CommunicationCode.MAKE_A_MOVE.ordinal(), asw); }
		 */
		return null;
	}

	private TransferObject datagramToTransferObject(DatagramPacket packet) throws IOException, ClassNotFoundException {
		byte[] data = packet.getData();
		ByteArrayInputStream byteInputStream = new ByteArrayInputStream(data);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
		TransferObject receivedObject = (TransferObject) objectInputStream.readObject();
		System.out.println("Obj recived: " + receivedObject);
		return receivedObject;
	}

	private DatagramPacket buildResponse(TransferObject objectToSend, InetAddress address, int port)
			throws IOException {
		// TransferObject objectToSend = new TransferObject(code, message);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(objectToSend);
		byte[] data = outputStream.toByteArray();
		return new DatagramPacket(data, data.length, address, port);

	}

	private void analyzeRequest(DatagramPacket packet) throws IOException, ClassNotFoundException {
		int opCode;
		this.setReceivedObject(this.datagramToTransferObject(packet));
		opCode = this.getReceivedObject().getCode();
		DatagramPacket response = null;
		buffer = new byte[bufferLength];

		//System.out.println(receivedObject.getMessage());

	}

	public void login(String nickname) {
		// TODO Auto-generated method stub

	}

	public void logout() {
		// TODO Auto-generated method stub

	}

	public void challengePlayer(int opponentId) {
		// TODO Auto-generated method stub

	}

	public void acceptChallenge() {
		// TODO Auto-generated method stub

	}

	public void makeMove(int movePosition) {
		// TODO Auto-generated method stub

	}

	public TransferObject getReceivedObject() {
		return receivedObject;
	}

	public void setReceivedObject(TransferObject receivedObject) {
		this.receivedObject = receivedObject;
	}

}
