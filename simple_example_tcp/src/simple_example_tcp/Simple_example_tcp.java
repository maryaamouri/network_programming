/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simple_example_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author HITECH
 */
public class Simple_example_tcp {

   public Simple_example_tcp() throws Exception
   {
       ServerSocket server_socket = new ServerSocket(1066);
       System.out.println("Port # "+server_socket.getLocalPort()+" port is open");
        //new Client();
       Socket socket = server_socket.accept();
      
       System.out.println("client "+socket.getInetAddress()+" has connected");
       
       BufferedReader in_socket = new BufferedReader (new InputStreamReader(socket.getInputStream()));
       PrintWriter out_socket = new PrintWriter (new OutputStreamWriter(socket.getOutputStream()),true);
       
       out_socket.println("Welcom!");
       String message = in_socket.readLine();
       System.out.println("Client said : "+message);
       in_socket.close();
       socket.close();
       System.out.println("Socket is closed");
   }

    public static void main(String[] args) {
        try {
        new  Simple_example_tcp();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
           
    }
    
}
