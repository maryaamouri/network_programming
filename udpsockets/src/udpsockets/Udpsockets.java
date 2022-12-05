/*
Receiver class 
*/
package udpsockets;
import java.net.*;
import java.util.Scanner;
public class Udpsockets {

    Udpsockets () throws Exception{
        DatagramSocket socket = new DatagramSocket (2020);
        System.out.println("Receiver is running.");
         Scanner scan = new Scanner (System.in);
         byte [] buffer = new byte [1500];// MTU = 1500, the max transmition unit,how much data can be transfored in a single packet
   DatagramPacket packet = new DatagramPacket (buffer,buffer.length);
    socket.receive(packet);
    String msg = new String(buffer).trim();
        System.out.println(msg+" received");
    InetAddress sender = packet.getAddress();
    int port = packet.getPort();
        System.out.println("Enter a message");
        msg=scan.nextLine();
     buffer = msg.getBytes();
     packet = new DatagramPacket(buffer,buffer.length,sender,port);
    socket.send(packet);
    }  
    
    public static void main(String[] args) {
        try {
             new Udpsockets();
             
        } catch (Exception e) {
        }
      
    }
    
}
