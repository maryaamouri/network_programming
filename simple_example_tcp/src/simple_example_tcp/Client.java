/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simple_example_tcp;
import java.io.*;
import java.net.*;
public class Client {
    public Client() throws Exception {
        Socket socket = new Socket (InetAddress.getLoopbackAddress(),1066);
        System.out.println("Successfuly connection");
        
        BufferedReader in_socket = new BufferedReader (new InputStreamReader (socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter (new OutputStreamWriter (socket.getOutputStream()),true);
        
        String message = in_socket.readLine();
         in_socket.close();
        out_socket.println("Thanks");
        
        System.out.println("Server says "+message);
        
        socket.close();
        System.out.println("connection is closed");
}
    public static void main (String args[])
    {
        try {
            new Client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
