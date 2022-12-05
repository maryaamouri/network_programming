/*
Client:
In the client side takes 0 as port number which means random port number.

*** create client socket-> DatagramSocket client= new DatagramSocket(0);

A) Send data:
1. create buffer->  byte [] sent_buffer = msg.getBytes();
2. create packet-> DatagramPacket sent_packet = new DatagramPacket (sent_buffer,sent_buffer.length,InetAddress,port);
3. send msg-> client.send(sent_packet);

B) Receive data:
1. create buffer->  byte received_data [] = new byte [1500];
2. create packet-> DatagramPacket received_packet= new DatagramPacket(received_data,received_data.length);
3. receive msg-> client.receive(received_packet);

---------------------------

*/

package udp_client_server;

import java.net.*;

public class UDP_client_server {

   
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket(0);
        //send:
        String msg = "Hi there!";
        byte [] sent_buffer = msg.getBytes();
        DatagramPacket sent_packet = new DatagramPacket(msg.getBytes(),msg.getBytes().length,InetAddress.getLocalHost(),1234);
        client.send(sent_packet);
        
        //recive:
        byte received_data [] = new byte [1500];
        DatagramPacket received_packet = new DatagramPacket(received_data,received_data.length);
 client.receive(received_packet);
        System.out.println(new String(received_data).trim());

    }
    
}
