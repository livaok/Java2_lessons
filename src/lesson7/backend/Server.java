package lesson7.backend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liva
 */
public class Server {

	static final int PORT = 8666;
	List<ClientHandler> clients = new ArrayList<>();

	public Server() {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;

		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Сервер запущен");

			while (true) {
				clientSocket = serverSocket.accept();
				ClientHandler client = new ClientHandler(clientSocket, this);
				clients.add(client);
				new Thread(client).start();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				clientSocket.close();
				System.out.println("Сервер завершает работу");
				serverSocket.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendMsgToAllClients(String msg) {
		for (ClientHandler client : clients) {
			client.sendMsg(msg);
		}
	}

	public void sendMsgToClient(String msg, ClientHandler clientHandler) {
		for (ClientHandler client : clients) {
			if (client.equals(clientHandler)) {
				client.sendMsg(msg);
			}
		}
	}

	public void removeClientFromServer(ClientHandler client) {
		clients.remove(client);
	}
}
