package tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SenderTCP {
	
	public static void main(String argv[]){
		InetAddress hostAddress;
		int port = 50000;
		Socket s;
		PrintStream output;
		String msg;
		Scanner scan = new Scanner(System.in);
		
		try {
			hostAddress = InetAddress.getLocalHost();
			s = new Socket(hostAddress, port);
			output = new PrintStream(s.getOutputStream());
			while (scan.hasNext()){
				System.out.println("> ");
				msg = scan.nextLine();
				output.println(msg);
			}
			scan.close();
			output.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(">> La connexion a échoué !");
		}
	}	
}
