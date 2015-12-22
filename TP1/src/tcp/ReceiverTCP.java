package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ReceiverTCP {
	
	public static void main(String argv[]){
		int port = 50000;
		ServerSocket serverSocket;
		Socket socket;
		Scanner scanner;
		
		try {
			serverSocket = new ServerSocket(port);
			socket = serverSocket.accept();
			scanner = new Scanner(socket.getInputStream());
			while (scanner.hasNext()) {
				String message = scanner.nextLine();
				System.out.println("> Message reçu :");
				System.out.println(message);
			}
			System.out.println(">> La connexion a été fermée !");
			scanner.close();
			serverSocket.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
