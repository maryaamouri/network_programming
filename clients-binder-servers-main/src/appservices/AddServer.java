/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appservices;

import java.sql.*;

/**
 *
 * @author Admin
 */
public class AddServer {

    /**
     * @param args the command line arguments
     */
    private static boolean addServer(String query) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "hr");
        try {
            con.createStatement().executeUpdate(query);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        
        String serverIP = "'localhost'";
        String serverName = "'TranslatorServer'";
        String serverPort = "'8778'";
        
        //String createTable = "create table servers (servername varchar2(20) , serverport varchar2(20) , serverip varchar2(20))";
        String query = "insert into servers values(" + serverName +','+ serverPort +','+ serverIP + ")";
        if (addServer(query))
            System.out.println("Server Added");
        else 
            System.out.println("Server add failed");
    }

}
