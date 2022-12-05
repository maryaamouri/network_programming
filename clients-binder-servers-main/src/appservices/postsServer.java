/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appservices;

/**
 *
 * @author Admin
 */
import java.io.*;
import java.net.*;

class getLastPosts extends Thread {

    Socket con;

    public getLastPosts(Socket con) {
        this.con = con;
    }

    public void run() {
        try {
            //here what your server should do ....
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class postsServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        try {
            ServerSocket posts = new ServerSocket(5555);
            System.out.println("Posts Server is running now ...");
            while (true) {

                new getLastPosts(posts.accept()).start();

            }
        } catch (Exception e) {
            System.out.println("The server is down!");
        }
    }

}
