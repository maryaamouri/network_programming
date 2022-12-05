/*
TCP / IP

write a java program that represents client server architecture
where multible clients connect to the server 
The client send an message
the server replay the same message capitalized

 */
package client_server;

import java.io.IOException;
import java.net.*;
public class Client_server {

   public static int c =0;
    public static void main(String[] args) throws Exception {
        ServerSocket server_socket = null;
        try {
              server_socket= new ServerSocket(3333);
             System.out.println("Port number "+server_socket.getLocalPort()+" is open");
             while (c<3)
             {
//                 ServerThread s = new ServerThread(); 
                 Thread th = new Thread (new ServerThread(server_socket.accept(),c));
                 c++;
                 th.start();
             }
             
             
        } catch (Exception e) {
            System.out.println("cannot find connection  " );
         e.printStackTrace();
        }finally{
            server_socket.close();
        }
       
    }
    
}
