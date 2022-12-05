/*
---------------------------------------------
DNS resolution: to get the IP from the URL Domain name 
 InetAddress.getByName(name);
---------------------------------------------
there are a text file that contains a set of domain names
Read the file in the main method 
assign a thread for each domain name
each thread should resolve all the IPs that associated with the domain name 
and return all the IPs as string  
----------------------------------------------
*/

package dns_lec;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;
class Dname implements Callable{
    String name;
Dname(String name)
{
    this.name= name;
}
    @Override
    public InetAddress call() throws Exception {
        return  InetAddress.getByName(name);
    }
    
}
public class Dnslec {

    public static void main(String[] args) throws Exception {
       
       BufferedReader buff = new BufferedReader (new FileReader("D:\\names.txt"));
       String line;
       ArrayList <String> list = new ArrayList<String>();
       while((line=buff.readLine())!=null)
           list.add(line);
       buff.close();
      // ------------------
     ExecutorService service = Executors.newFixedThreadPool(list.size());
     Dname d[] = new Dname[list.size()];
     int i =0;
     Future<String> f []= new Future  [list.size()];
     
     for(Dname n :d)
     {
          n = new Dname(list.get(i));
          i++;
          f[i] = service.submit(n);
     }
        
        for (Future<String> f1 : f) {
            System.out.println(f1 + "  ");    
        }
        service.shutdown();
    }
    
}
