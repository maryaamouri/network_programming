/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appservices;

import java.sql.*;
import java.util.concurrent.*;

/**
 *
 * @author Admin
 */
public class Binder implements Callable<String> {

    public Binder() throws SQLException {

    }
    private String serverName;

    public Binder(String serverName) {
        this.serverName = serverName;
    }

    private static ResultSet dbResult(String query) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "hr");
        return con.createStatement().executeQuery(query);
    }

    private static boolean checkIfExist(String serverName) throws Exception {

        ResultSet rs = dbResult("select * from servers where servername ='" + serverName + "'");

        if (rs.next()) {
        return true;
        }
        return false;

    }

    @Override
    public String call() throws Exception {

        if (checkIfExist(serverName)) {
            ResultSet rs = dbResult("select * from servers where servername ='" + serverName + "'");
            rs.next();
            return rs.getString("SERVERPORT");
        }
        return null;

    }

}
