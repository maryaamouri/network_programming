/*

Java Database connectivity theory:
1.    Import packeges
2.    Load and register a driver 
3.    Establish a connection 
4.    Create statement
5.    Execute Query
6.    Process results 
7.    Close the connection 

------------------------------------------------

Types of SQL Queries:
1. DDL: Data Definition Language-> changning the structure of database (create, alter, Rename, Drop, Comment, Trancate). 
2. DML: Data Manipulation Language->changing the value of a table  (insert, update, delete, lock, call)==> int executeUpdate (String sql)==> returns the number of affected rows.
3. DQL: Data Query Language->fitching the data from tables (select statements)==>ResultSet  excuteQuery (String sql).
4. DCL: Data Control Language.->(commit, Rollback, Savepoint, setTranaction, grant, Revoke). 

 */
package javadatabase;

import java.sql.*;

public class JavaDatabase {

   
        public static void main(String[] args) throws Exception{

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");// ("URL","username","password");

        Statement stmt = con.createStatement();



/*
----------------------------------------------
//stmt.executeUpdate("insert into countries values('GZ','Gazza',3)");
------------------------------
int userid=6;
String username="Mhmd";
String query = "insert into student values (?,?);
PrepareStatement st = con.prepareStatement(query);
st.setString(2,userid);
st.setInt(1,username);
int count = st.executeUpdate();
System.out.print(count+" row/s affected");
-----------------------------------------------
*/


ResultSet rs = stmt.executeQuery("select * from countries where region_id=3");

while (rs.next())
            System.out.println(rs.getString("country_id")+"\t"+rs.getString("country_name")+"\t"+rs.getInt("region_id")); 

con.close();
    }
    
}
