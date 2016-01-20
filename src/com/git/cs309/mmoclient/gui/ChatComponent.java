package com.git.cs309.mmoclient.gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public final class ChatComponent extends Component {
	private final List<ChatMessage> partyMessages = new ArrayList<>();
	private final List<ChatMessage> globalMessages = new ArrayList<>();
	private final List<ChatMessage> localMessages = new ArrayList<>();
	private final List<ChatMessage> privateMessages = new ArrayList<>();
	
	public void addMessage(final MessageGroup group, final String message) {
		switch (group) {
		case PARTY:
			partyMessages.add(new ChatMessage(group, message));
			break;
		case GLOBAL:
			globalMessages.add(new ChatMessage(group, message));
			break;
		case LOCAL:
			localMessages.add(new ChatMessage(group, message));
			break;
		case PRIVATE:
			privateMessages.add(new ChatMessage(group, message));
			break;
		default:
			System.err.println("No case for message group: "+group);
		}
	}
}
