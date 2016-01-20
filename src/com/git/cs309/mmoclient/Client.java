package com.git.cs309.mmoclient;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.git.cs309.mmoclient.connection.Connection;
import com.git.cs309.mmoclient.gui.LoginGUI;

public final class Client {
	private static volatile Connection connection;
	private static volatile LoginGUI loginGUI = new LoginGUI();
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		connection = new Connection(new Socket("localhost", 6667));
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
