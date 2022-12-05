/*
 Sender UDP
1. create socket (DatagramSocket)
2. create I/O buffer (array of bytes) -> this is the msg
3. create packet (DatagramPacket) for send and for recive 
 */
package udpsockets;
import java.net.*;
import java.util.Scanner;
public class Sender {
 
Sender() throws Exception
{
             // 1. create socket (DatagramSocket)
DatagramSocket socket = new DatagramSocket(); 
Scanner scan = new Scanner(System.in);
    System.out.println("Enter a message");
    
             // 2. create I/O buffer (array of bytes) -> this is the msg
    String smsg = scan.nextLine();
    String rmsg;
    byte []sbuffer = smsg.getBytes();
    byte []rbuffer = new byte[1500];//MTU=1500
    
              //3. create packet (DatagramPacket) and send  
    DatagramPacket packet = new DatagramPacket (sbuffer,sbuffer.length,InetAddress.getLoopbackAddress(),2020);
    socket.send(packet);
    System.out.println("message is send ..");
    
     
             //4. create packet (DatagramPacket)  and recive 
    packet = new DatagramPacket(rbuffer,rbuffer.length);
    socket.receive(packet);
    rmsg = rbuffer.toString().trim();
    System.out.println(rmsg);
}
    public static void main(String[] args) {
        try {
            new Sender();
        } catch (Exception e) {
        }
    }
}
