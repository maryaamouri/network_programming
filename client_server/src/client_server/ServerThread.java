package client_server;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread implements Runnable{
Socket socket;
int number;
    ServerThread(Socket accept, int c) throws Exception {
        socket=accept;
        number=c;
    }

    @Override
    public void run() {
    try {
        BufferedReader buff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter p = new PrintWriter(socket.getOutputStream());
        
        String msg = buff.readLine();
        p.write(msg.toUpperCase());
        
    } catch (Exception e) {
       e.printStackTrace();
    }
        
    }
    
}
