package de.aeg.server.Data;

public class GameObject {

	private Location loc;
	private MoveState move = MoveState.none;
	private int hp = 3;
	private int id;
	private String name;
	
	public GameObject(int id) {
		this.id = id;
	}

	public MoveState getMove() {
		return move;
	}

	public void setMove(MoveState move) {
		this.move = move;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
