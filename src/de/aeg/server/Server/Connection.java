package de.aeg.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {

	private final Socket socket;
	private PrintWriter outchan;
	private BufferedReader inchan;
	private boolean connected;

	public Connection(Socket socket) {
		this.socket = socket;
		try {
			outchan = new PrintWriter(socket.getOutputStream(), true);
			inchan = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			connected = true;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public boolean isConnected() {
		this.checkConnection();
		return this.connected;
	}

	private void checkConnection() {
		if (!(this.connected = socket.isConnected())) {
			try {
				this.socket.close();
				this.outchan.close();
				this.inchan.close();
			} catch (IOException e) {
			}
		}
	}

	public String read() {
		if (!this.isConnected()) {
			return null;
		}
		try {
			if (inchan.ready()) {
				String read = inchan.readLine();
//				String trash;
//				System.out.print("Trash: ");
//				while ((trash = inchan.readLine()) != null) {
//					System.out.print(trash + " ,");
//				}
//				System.out.println();
				socket.getInputStream().skip(socket.getInputStream().available());
				return read;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void write(String msg) {
		outchan.println(msg);
	}

}
