package com.git.cs309.mmoclient;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.git.cs309.mmoclient.connection.Connection;
import com.git.cs309.mmoclient.gui.LoginGUI;

public final class Client {
	private static volatile Connection connection;
	private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

	public static Connection getConnection() {
		return connection;
	}

	public static Dimension getScreenSize() {
		return SCREEN_SIZE;
	}

	public static void main(String[] args) {
		try {
			connection = new Connection(new Socket("localhost", 6667));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to connect to the server.");
			return;
		}
		LoginGUI.getSingleton().setVisible(true);
	}
}
