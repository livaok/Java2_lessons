package lesson6;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author liva
 */
public class Client {

	public static void main(String[] args) {

		int serverPort = 6666;

		try {
			InetAddress ipAdress = InetAddress.getLocalHost();

			System.out.println("Я новый клиент!");
			System.out.println("Подключаюсь к серверу...");

			Socket socket = new Socket(ipAdress, serverPort);

			System.out.println("Установлено соединение...");

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			DataInputStream dataInputStream = new DataInputStream(is);
			DataOutputStream dataOutputStream = new DataOutputStream(os);

			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				String msg = keyboard.readLine();
				System.out.println("Текст " + msg + " отправлен на сервер");
				dataOutputStream.writeUTF(msg);
				dataOutputStream.flush();

				String responseServer = dataInputStream.readUTF();

				System.out.println("Получен ответ от сервера : " + responseServer);
			}
		}
		catch (EOFException e) {
			System.out.println("Клиент вышел");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
