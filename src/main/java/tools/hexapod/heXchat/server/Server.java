package tools.hexapod.heXchat.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

	private ServerSocket server;
	private final int port;

	public Server(int p) {
		port = p;
	}

	public void run() {

		try {
			server = new ServerSocket(port);
			System.out.println("Server is started!");
			while (true) {
				Socket socket = server.accept();
				System.out.println("New session");
				new Session(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Session extends Thread {

		private Socket socket;

		public Session(Socket s) {
			socket = s;
		}

		@Override
		public void run() {

			try {
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);

				// OutputStream os = socket.getOutputStream();
				// DataOutputStream dos = new DataOutputStream(os);
				while (true) {
					System.out.println("server: " + dis.readUTF());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}