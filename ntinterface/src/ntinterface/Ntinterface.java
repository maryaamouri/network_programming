/*


** create netWorkInterface:
NetworkInterface ni=NetworkInterface.getByInetAddress(ip);
** get all network interfaces:
Enumeration <NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

NetworkInterface inter;
while (interfaces.hasMoreElements()){
inter=interfaces.nextElement();
System.out.println(inter.getDisplayName()+"\n-------------------------------\n");

** get all IP related to interface:
Enumeration <InetAddress> addresses = inter.getInetAddresses();
while (addresses.hasMoreElements()){
InetAddress add = addresses.nextElement();
System.out.println(add.getHostAddress());


*/



/**
A text file contains IPs
* write a java program that read the file and stor the IPs in ArrayList
* create a thread pool 
* each thread takes an IP finds all network  network interfaces related 
Then for each IP print all network interfaces
 */


package ntinterface;
import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.net.*;


class FindIP implements Callable <NetworkInterface> {
    byte [] b;
    InetAddress addr;
     FindIP(String s)
     {  String parts [] = s.split("\\.");
     int i=0;
     for(String p : parts)
     {    b[i]= (byte)Integer.parseInt(p);
         i++;
     } 
         addr=null;
         }
     public NetworkInterface call ()
    {
        NetworkInterface nl = null;
        try{
            addr = InetAddress.getByAddress(b);
            nl = NetworkInterface.getByInetAddress(addr);
        }catch(Exception e)
        {
            
        }
        return nl;
        
    }
}
    
public class Ntinterface {

    
    public static void main(String[] args) throws Exception {
        String path="D:\\IPs.txt";
       BufferedReader buff = new BufferedReader (new FileReader(path));
       ArrayList<String> list = new ArrayList<String>();
       ArrayList<Future> f = new ArrayList<Future>();
       String line;
       while((line = buff.readLine())!=null)
           list.add(line);
       buff.close();
       //---------
       ExecutorService service  = Executors.newFixedThreadPool(list.size());
       //define array of Future Objects
       
    }
    
}
/*

import java.io.*;
import java.util.*;
import java.net.*;
public class JavaApplication1 {
public static void main(String[] args) throws Exception {
byte addr[]=new byte[]{(byte)192,(byte)168,1,38};
NetworkInterface ni=NetworkInterface.getByInetAddress(InetAddress.getByAddress(addr));
//185.37.12.3
Enumeration <NetworkInterface>interfaces=NetworkInterface.getNetworkInterfaces();
NetworkInterface inter;
while (interfaces.hasMoreElements()){
inter=interfaces.nextElement();
System.out.println(inter.getDisplayName()+"\n-------------------------------\n");
Enumeration <InetAddress> addresses = inter.getInetAddresses();
while (addresses.hasMoreElements()){
InetAddress add = addresses.nextElement();
System.out.println(add.getHostAddress());
}
}
}
}

*/
