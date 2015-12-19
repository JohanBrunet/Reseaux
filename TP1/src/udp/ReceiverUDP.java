package udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiverUDP {
	
	public static void main (String [] argv){

		int sendPort = 60000;
		int receivePort = 50000;
		String s;
		byte[] byteArray = new byte[3];
		
		DatagramPacket packet;
		DatagramSocket socket;

		try {
			socket = new DatagramSocket(receivePort);
			packet = new DatagramPacket(byteArray, byteArray.length);
			socket.receive(packet);
			s = packet.getData().toString();
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
