package de.aeg.server.Main;

import de.aeg.server.Server.Server;

public class ServerMain {

	public static void main(String[] args) {
		Server server = new Server(32768);
		server.start();
	}

}
