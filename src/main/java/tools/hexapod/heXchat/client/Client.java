package tools.hexapod.heXchat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private String url;
	private int port;
	private Socket socket;

	public Client(String url, int port) {
		this.url = url;
		this.port = port;
	}

	public void connect() {
		try {
			socket = new Socket(url, port);
			// InputStream is = socket.getInputStream();
			// DataInputStream dis = new DataInputStream(is);

			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			while (true)
				dos.writeUTF("Hello server");
			// String str = dis.readUTF();
			// System.out.println("Client receive from srever:" + str);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
