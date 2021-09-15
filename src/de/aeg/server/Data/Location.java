package de.aeg.server.Data;

public class Location {

	private int x, y, rot;

	public Location(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public Location(int[] xy) {
		this.setXY(xy);
	}
	
	public Location(int x, int y, int rotation) {
		this.setX(x);
		this.setY(y);
		this.setRot(0);
	}

	public Location(int[] xy, int rotation) {
		this.setXYRot(xy, rotation);
	}
	
	public void setXY(int[] xy) {
		this.setX(xy[0]);
		this.setY(xy[1]);
	}
	
	public void setXYRot(int[] xy, int rotation) {
		this.setXY(xy);
		this.setRot(0);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRot() {
		return rot;
	}

	public void setRot(int rot) {
		this.rot = rot;
	}

}
