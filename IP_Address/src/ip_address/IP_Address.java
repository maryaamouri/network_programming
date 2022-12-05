/*
InetAddress class: 
*****create InetAddress:
1. InetAddress.getLocalHost()
2. InetAddress.getLoopbackAddress();
3. InetAddress.getByName("www.google.com");
4. []=InetAddress.getAllByName("ebay.com");
5. addr = InetAddress.getByAddress(new byte[]{(byte)185,37,12,3 });

-------------------------
*****print InetAddress:
1. addr.getHostName()
2. addr.getHostAddress()
2. addr.getAddress()

*/
package ip_address;

import java.net.*;


public class IP_Address {

    
    public static void main(String[] args) throws Exception {
       
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        
         addr = InetAddress.getLoopbackAddress();
        System.out.println(addr.getHostAddress());
        
        addr = InetAddress.getByName("www.google.com");
        System.out.println("google  "+addr.getHostAddress());
        InetAddress addresses []=InetAddress.getAllByName("ebay.com");
        for(InetAddress ip: addresses)
        System.out.println("ebay  "+ip.getHostAddress());
        System.out.println("---------------");
        byte [] ip = new byte[]{(byte)185,37,12,3 };
        addr = InetAddress.getByAddress(ip);
        System.out.println(addr.getHostName()+" "+ addr.getHostAddress());
       
        
    }
    
}
/*
package javaapplication8;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;
class FindD implements Callable <String>
{
String dName;
public FindD(String name) {
this.dName = name;
}
public String call()
{
String ip="";
ip=dName+" \n "+" ---------- "+"\n";
try{
InetAddress a[]=InetAddress.getAllByName(dName);
for(InetAddress a1:a)
ip=ip+" "+a1.getHostAddress();
}catch(Exception e){}
return ip;
}
}
public class JavaApplication8 {
public static void main(String[] args) throws Exception{
ArrayList <String> as =new ArrayList<String>();
ArrayList <Future> f =new ArrayList<Future>();
ArrayList <FindD> t =new ArrayList<FindD>();
BufferedReader bf=new BufferedReader(new FileReader("d://domin.txt"));
String line;
while((line=bf.readLine())!=null)
as.add(line); 
for (int i = 0; i < as.size(); i++) 
t.add(new FindD(as.get(i)));
ExecutorService service = Executors.newFixedThreadPool(as.size());
for (int i = 0; i < as.size(); i++) 
f.add(service.submit(t.get(i)));
for (int i = 0; i < as.size(); i++) 
System.out.println(f.get(i).get());
service.shutdown();
}
}



*/