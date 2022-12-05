/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appservices;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
class S2Session extends Thread {

    Socket conn;

    public S2Session(Socket conn) {
        this.conn = conn;
    }

    public void run() {
        try {

            System.out.println("Client "+ chatServer.clientNum +" is connected now!");
            BufferedReader bufr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            String data = bufr.readLine();
            while (!data.equals("bye")) {
                bufw.write("Client " + TranslatorServer.clientNum + " : " + data);
                bufw.newLine();
                bufw.flush();
                data = bufr.readLine();
            }
            conn.close();
        }
    
    catch (Exception e) {
            e.printStackTrace();
    }
}


}





public class chatServer {

    /**
     * @param args the command line arguments
     */
    static int clientNum = 0;
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        try {
            ServerSocket chat = new ServerSocket(5472);
            System.out.println("Chat Server is running now ...");
            while (true) {
                new S2Session(chat.accept()).start();
            }
        } catch (Exception e) {
            System.out.println("The server is down!");
        }
    }

}
