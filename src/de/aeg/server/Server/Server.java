package de.aeg.server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server extends Thread {

	private ServerSocket servsoc;
	private ArrayList<Lobby> lobbies;
	private final int port;
	
	public Server(int port) {
		this.port = port;
	}
	
	@Override
	public void run() {
		try {
			servsoc = new ServerSocket(this.port);
			this.lobbies = new ArrayList<>();
			Lobby tmplobby = new Lobby();
			while(true) {
				Connection newcon = new Connection(this.servsoc.accept());
				System.out.println("new connection " + newcon.getSocket().getInetAddress());
				if(tmplobby.isOpen()) {
					tmplobby.addPlayer(newcon);
					if(!tmplobby.isOpen()) {
						System.out.println("Lobby " + (this.lobbies.size() + 1) + " is closed, starting...");
						tmplobby.start();
						lobbies.add(tmplobby);
						tmplobby = new Lobby();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
