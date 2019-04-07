package lesson7.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author liva
 */
public class ClientHandler implements Runnable {

	private static int         clientsCount = 0;
	private        Server      server;
	private        Socket      clientSocket;
	private        PrintWriter outMessage;
	private        Scanner     inMessage;

	ClientHandler(Socket clientSocket, Server server) {
		try {
			clientsCount++;
			this.server = server;
			this.clientSocket = clientSocket;
			this.outMessage = new PrintWriter(clientSocket.getOutputStream());
			this.inMessage = new Scanner(clientSocket.getInputStream());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			this.close();
		}
	}

	private void close() {
		server.removeClientFromServer(this);
		clientsCount--;
		server.sendMsgToAllClients("Осталось клиентов в чате " + clientsCount);
	}

	public void sendMsg(String msg) {
		outMessage.println(msg);
		outMessage.flush();
	}

	@Override
	public void run() {
		try {
			server.sendMsgToAllClients("Появился новый клиент ");

			while (true) {
				if (inMessage.hasNext()) {
					String clientMsg = inMessage.nextLine();
					System.out.println(clientMsg);

					if (clientMsg.equalsIgnoreCase("Exit")) {
						break;
					}

					server.sendMsgToAllClients(clientMsg);
				}
				inMessage.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			this.close();
		}
	}
}
