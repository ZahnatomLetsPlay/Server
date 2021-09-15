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

	public Connection(Socket socket) {
		this.socket = socket;
		try {
			outchan = new PrintWriter(socket.getOutputStream(), true);
			inchan = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public String read() {
		try {
			if (inchan.) {
				String read = inchan.readLine();
				String trash;
				System.out.print("Trash: ");
				while ((trash = inchan.readLine()) != null) {
					System.out.print(trash + " ,");
				}
				System.out.println();
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
