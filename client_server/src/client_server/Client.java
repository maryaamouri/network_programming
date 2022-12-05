
package client_server;

import java.io.*;
import java.net.*;
import java.util.*;
public class Client {

    public Client() throws Exception {
        Socket socket = new Socket(InetAddress.getLoopbackAddress(),3333);
        System.out.println("Client is connected..");
        BufferedReader buff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter p = new PrintWriter(socket.getOutputStream());
        Scanner scan  = new Scanner(System.in);
        String res,msg="";
        do{
           System.out.println("Say somthing to server :");
        msg= scan.nextLine();
        p.write(msg);
        res = buff.readLine();
        System.out.println("Server says: "+ res);  
        
        }while (!(msg.equals("EXIT")));
        System.out.println("Client disconnected..");  
    }
  
}
