package de.aeg.server.Data;

import de.aeg.server.Server.Connection;

public class Player extends GameObject {

	private final Connection con;

	public Player(Connection con, int id) {
		super(id);

		this.con = con;
		con.write(this.getId() + "");
	}

	public void tick() {
		if (this.con.isConnected()) {
			String read = this.con.read();
			if (read != null) {
				System.out.println(read);
			}
		} else {
			this.setMove(MoveState.none);
		}
	}

}
