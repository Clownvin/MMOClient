package com.git.cs309.mmoclient.gui;

import com.git.cs309.mmoserver.packets.MessagePacket;

public enum MessageGroup {
	PRIVATE(MessagePacket.PRIVATE_CHAT), PARTY(MessagePacket.PARTY_CHAT), GLOBAL(MessagePacket.GLOBAL_CHAT), LOCAL(MessagePacket.LOCAL_CHAT);
	
	private final byte groupByte;
	
	private MessageGroup(final byte groupByte) {
		this.groupByte = groupByte;
	}
	
	public static MessageGroup getGroupForByte(final byte groupByte) {
		switch (groupByte) {
		case MessagePacket.GLOBAL_CHAT:
			return GLOBAL;
		case MessagePacket.LOCAL_CHAT:
			return LOCAL;
		case MessagePacket.PARTY_CHAT:
			return PARTY;
		case MessagePacket.PRIVATE_CHAT:
			return PRIVATE;
		default:
			return LOCAL;
		}
	}
	
	public byte getGroupByte() {
		return groupByte;
	}
}
