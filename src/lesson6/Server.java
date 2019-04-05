package lesson6;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liva
 */
public class Server {

	public static void main(String[] args) {

		int port = 6666;

		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Ожидание клиента...");

			Socket clientSocket = serverSocket.accept();
			System.out.println("Клиент подключился!");

			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();

			DataInputStream dataInputStream = new DataInputStream(is);
			DataOutputStream dataOutputStream = new DataOutputStream(os);

			String line = null;
			while (true) {
				System.out.println("Ожидание информации от клиента...");

				line = dataInputStream.readUTF();

				if (line.equalsIgnoreCase("exit")) {
					System.out.println("Клиент хочет выйти");
					break;
				}
				System.out.println("Клиент написал " + line);
				dataOutputStream.writeUTF("Текст " + line + " получен сервером");
				dataOutputStream.flush();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
