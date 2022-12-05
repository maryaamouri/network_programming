/*
  this app have two thread pools each one contains two threads
** define an array with 1000 ints (random values), fill the array in the first thread pool 
since each thread fill a half
** find max value in the second pool k each thread in a half
print the max value in the array
 */
package callable2;

import java.util.concurrent.*;

class FillArr implements Callable {
    int s,e,arr[];

    public FillArr(int s, int e, int[] arr) {
        this.s = s;
        this.e = e;
        this.arr = arr;
    }

    @Override
    public Void call() throws Exception {
      for(int i=s;i<e;i++)
          arr[i] = (int) (Math.random()*100);
        return null;
      
    }
    
}

class FindMax implements Callable {
int s,e,arr[];

    public FindMax(int s, int e, int[] arr) {
        this.s = s;
        this.e = e;
        this.arr = arr;
    }
    @Override
    public Integer call() throws Exception {
       int max = arr[s];
       
       for(int i=s;i<e;i++)
           if(arr[i]>max)
               max = arr[i];
       return max;
    }
    
} 
        
public class Callable2 {

    
    public static void main(String[] args) throws Exception {
        //1. define thread pool
        //2. create 2 objects of class FillArr and pass the array in the constructor 
            //and submit them in the first thread pool
        //3. create two objects of class FindMax and pass the array in the constructor
              //and submit them in the second thread pool
        //4. print the max
        
     int []  a = new int [1000];
     ExecutorService service1  = Executors.newFixedThreadPool(5);
     FillArr a1 = new FillArr(0,499,a);
     FillArr a2 = new FillArr(500,1000,a);
     FindMax a3 = new FindMax(0,499,a);
     FindMax a4 = new FindMax(500,1000,a);
      
      service1.submit(a1);
      service1.submit(a2);
      System.out.println(a[10]);
     
     Future<Integer> m1 = service1.submit(a3);
     Future<Integer> m2 = service1.submit(a4);
     if(m1.get()>m2.get())
           System.out.println("The max value is "+m1.get());
     else  System.out.println("The max value is "+m2.get());
     
      service1.shutdown();
        
    }
    
}
