package com.git.cs309.mmoclient.connection;

import java.io.IOException;
import java.net.Socket;

import com.git.cs309.mmoclient.packets.PacketHandler;
import com.git.cs309.mmoserver.connection.AbstractConnection;
import com.git.cs309.mmoserver.packets.Packet;
import com.git.cs309.mmoserver.packets.PacketFactory;
import com.git.cs309.mmoserver.util.StreamUtils;

public class Connection extends AbstractConnection {

	public Connection(Socket socket) throws IOException {
		super(socket);
	}
	
	@Override
	public void run() {
		while (!this.disconnected) {
			try {
				Packet packet = PacketFactory.buildPacket(StreamUtils.readBlockFromStream(input), this);
				PacketHandler.handlePacket(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
