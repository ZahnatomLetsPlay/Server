package de.aeg.server.Server;

import java.util.ArrayList;

import de.aeg.server.Data.GameObject;
import de.aeg.server.Data.Player;

public class World {

	private final ArrayList<Player> players;
	private final ArrayList<GameObject> objs;
	
	public World(ArrayList<Player> players) {
		this.players = players;
		objs = new ArrayList<>();
		//adds players to objs list
		this.players.forEach(n -> objs.add(n));
	}

	public void tick() {
		for(Player player : players) {
			player.tick();
		}
	}

}
