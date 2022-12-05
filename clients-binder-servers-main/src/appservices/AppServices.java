/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appservices;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 *
 * @author Admin
 */
public class AppServices { // client class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        System.out.println("Enter server name : ");
        //String serverName = "chatServer";
        String serverName = input.nextLine();

        ExecutorService service = Executors.newFixedThreadPool(1);
        Binder binder = new Binder(serverName);
        Future task = service.submit(binder);

        String serverPort = (String) task.get();
        if (serverPort == null) {
            serverPort = "";
        }
        while (true) {
            switch (serverPort) {
                case "8778": { //TranslatorServer

                    System.out.println("PORT : " + serverPort);
                    try {
                        Socket soc = new Socket("localhost", 8778);
                        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
                        BufferedReader bufr = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                        BufferedReader bufrc = new BufferedReader(new InputStreamReader(System.in));

                        String rec = bufr.readLine();
                        if (rec != null) {
                            System.out.println(rec);
                        }
                        String data = bufrc.readLine();
                        if (data != null) {
                            bufw.write(data);
                            bufw.newLine();
                            bufw.flush();
                        }
                        rec = bufr.readLine();
                        if (rec != null) {
                            System.out.println(rec);

                        }

                        //data = bufrc.readLine();
                        //bufw.write(data);
                        //bufw.newLine();
                        bufw.flush();
                        soc.close();
                    } catch (Exception e) {
                        System.out.println("The server is down!");
                        break;
                    }

                    break;
                }
                case "5472": { //chatServer
                    System.out.println("PORT : " + serverPort);
                    try {
                        Socket soc = new Socket("localhost", 5472);
                        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
                        BufferedReader bufr = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                        BufferedReader bufrc = new BufferedReader(new InputStreamReader(System.in));
                        String data = bufrc.readLine();
                        while (!data.equals("bye")) {
                            if (data != null) {
                                bufw.write(data);
                                bufw.newLine();
                                bufw.flush();
                            }//if
                            String rec = bufr.readLine();
                            if (rec != null) {
                                System.out.println(rec);
                            }
                            data = bufrc.readLine();
                        }
                        bufw.write(data);
                        bufw.newLine();
                        bufw.flush();
                        soc.close();
                    } catch (Exception e) {
                        System.out.println("The server is down!");
                        break;
                    }

                    break;
                }
                case "5555": { //postsServer
                    System.out.println("PORT : " + serverPort);
                    Socket soc = new Socket("localhost", 5555);

                    break;
                }
                default: {
                    System.out.println("There is no server with this name");

                }
            }
            System.out.println("Enter server name : ");

            serverName = input.nextLine();

            service = Executors.newFixedThreadPool(1);
            binder = new Binder(serverName);
            task = service.submit(binder);

            serverPort = (String) task.get();
            if (serverPort == null) {
                serverPort = "";
            }
        }

    }

}
