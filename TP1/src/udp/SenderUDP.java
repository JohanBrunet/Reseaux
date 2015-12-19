package udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SenderUDP {

	public static void main (String [] argv) {
		int sendPort = 60000;
		int otherHostReceivePort = 50000;
		String msg = "Bonjour !";
		byte[] byteArray = msg.getBytes();

		DatagramSocket socket;
		DatagramPacket packet;

		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			socket = new DatagramSocket(sendPort);
			packet = new DatagramPacket(byteArray, byteArray.length, ip, otherHostReceivePort);
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
