package com.git.cs309.mmoclient.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.git.cs309.mmoclient.Client;
import com.git.cs309.mmoserver.packets.LoginPacket;

public final class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4537727222546132067L;

	private static final LoginGUI SINGLETON = new LoginGUI();

	public static LoginGUI getSingleton() {
		return SINGLETON;
	}
	private final JTextField usernameField = new JTextField("Username");
	private final JPasswordField passwordField = new JPasswordField("Password");

	private final JButton loginButton = new JButton("Log in");

	private LoginGUI() {
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Client.getConnection().addOutgoingPacket(
						new LoginPacket(null, usernameField.getText(), String.valueOf(passwordField.getPassword())));
			}

		});
		JPanel mainPanel = new JPanel();
		JPanel fieldPanel = new JPanel();
		fieldPanel.add(usernameField);
		fieldPanel.add(passwordField);
		fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
		mainPanel.add(fieldPanel);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(loginButton);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		mainPanel.add(buttonPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		add(mainPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}
}
