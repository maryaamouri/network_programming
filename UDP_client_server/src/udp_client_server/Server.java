/*
Server: 
In the client side takes a port number which means random port number.

*** create server socket-> DatagramSocket client= new DatagramSocket(port_number);

A) Receive data:
1. create buffer->  byte received_data [] = new byte [1500];
2. create packet-> DatagramPacket received_packet= new DatagramPacket(received_data,received_data.length);
3. receive msg-> server.receive(received_packet);

B) Send data:
1. create buffer-> byte [] sent_buffer = new byte(msg.getBytes());
2. create packet-> DatagramPacket sent_packet = new DatagramPacket 
(sent_buffer,sent_buffer.length,received_packet.getInetAddress(),received_packet.getPort());
3. send msg-> client.send(sent_packet);

*/
package udp_client_server;
import java.net.*;

public class Server  {
    public static void main(String[] args)throws Exception {
        DatagramSocket server = new DatagramSocket(1234);
        int i=1;
        //recive:
        while(true){
        byte received_data [] = new byte [1500];
        DatagramPacket received_packet = new DatagramPacket(received_data,received_data.length);
        server.receive(received_packet);
        System.out.println(new String(received_data).trim());
    
        //send:
        String msg = "Welcom client number "+i++;
        DatagramPacket sent_packet = new DatagramPacket(msg.getBytes(),msg.getBytes().length,received_packet.getAddress(),received_packet.getPort());
        server.send(sent_packet);
        }
       
    }
    
        
}
