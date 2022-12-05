
package single_thread;
/*
How to create Threads? 
**Note: in this case threads are working in parallel.

A) Thread class:
1. extend thread class.
2. override run() method. 
3. create object of the class.
4. invoke start( ) method which execute run.

B) Runnable interface:
1. implement Runnable
2. override run() method. 
3. create object of Thread class and pass an object of class tha implements Runnable in the parameter.
4. invoke start( ) method which execute run.
*/

class myThread implements Runnable{
int threadnumber;

    public myThread(int threadnumber) {
        this.threadnumber = threadnumber;
    }
    @Override
    public void run() {
        for(int i=1;i<=5;i++)
           System.out.println("Thread # "+threadnumber+" is running");
    }
    
}
public class Single_Thread {
 public static void main(String[] args) {
        Thread [] th = new Thread [3];
        for(int i=0;i<3;i++)
        {
            th[i] = new Thread (new myThread(i+1));
            th[i].start();
        }
    }
    
    
}
