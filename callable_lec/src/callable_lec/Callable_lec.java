
package callable_lec;

import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
This appication have a thread pool with three threads, 
each thread read a text file located in D that has a number of integers and find there sum
finally print the sum of each file 
the name of files are 1,2 and 3


--------------------------------------
** Threads using Callable:
1. create class that implements callable and implement call();
2. create a thread poll: ExecuterServeces s = Executers.newFixedThreadpoll(10);
3. create objects and submit them into the threadpoll
4. collect results in future objects (casting).

*/

class ReadFile implements Callable {
    public String fname;
ReadFile(String f)
{
    fname=f;
}
    @Override
    public Integer call() throws Exception {
       int sum =0;
       try{String n;
           BufferedReader br = new BufferedReader(new FileReader(fname));
           while((n=br.readLine())!=null)
           {
               sum+=Integer.parseInt(n);
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
           
       return sum;
       
    }
    
}
public class Callable_lec {

    
    public static void main(String[] args) throws Exception {
      //define the pool and create threads, submit threads to the pool and print the results using future object
      ExecutorService service = Executors.newFixedThreadPool(30);
      ReadFile r1 = new ReadFile("d:\\1.txt");
      ReadFile r2 = new ReadFile("d:\\2.txt");
      ReadFile r3 = new ReadFile("d:\\3.txt");
      Future<Integer> x = service.submit(r1);
       Future<Integer> y = service.submit(r2);  
       Future<Integer> z = service.submit(r3);
        System.out.println(x.get());
        System.out.println(y.get());
        System.out.println(z.get());
        service.shutdown();
    }
    
}
