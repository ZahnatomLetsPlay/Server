package de.aeg.server.Server;

import java.util.ArrayList;

import de.aeg.server.Data.Player;

public class Lobby extends Thread {

	private final ArrayList<Player> players;
	private World world;
	
	public Lobby() {
		this.players = new ArrayList<Player>();
	}
	
	/**
	 * Creates new player with connection
	 * @param Takes connection
	 */
	public void addPlayer(Connection connection) {
		if(this.isOpen()) {
			this.players.add(new Player(connection, players.size() +1));
		}
	}
	
	public boolean isOpen() {
		return this.players.size() < 1;
		// return this.players.size() < 4;
	}
	
	@Override
	public void run() {
		world = new World(players);
		while(true) {
			world.tick();
		}
	}
	
}
