package com.git.cs309.mmoclient.gui;

public final class ChatMessage implements Comparable<ChatMessage> {
	private final MessageGroup group;
	private final String message;
	private final long time;

	public ChatMessage(final MessageGroup group, final String message) {
		this.group = group;
		this.message = message;
		time = System.currentTimeMillis();
	}

	// Compare them based on creation time.
	@Override
	public int compareTo(ChatMessage o) {
		return (int) (o.time - time);
	}

	public MessageGroup getGroup() {
		return group;
	}

	public String getMessage() {
		return message;
	}
}
