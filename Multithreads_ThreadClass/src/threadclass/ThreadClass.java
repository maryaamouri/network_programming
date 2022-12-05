package threadclass;
/*
Synchronized threads:
when we have shared object between tow or more threads,
the threads must be synchronized.

**after starting thread 1 -> thread1.join(); 
**if we want a thread to wait for a time-> thread.wait(500);
or thread.sleep(500);
-----------
**helpful methods:
1. isAlive()
2. getName()
3. setName()
4. setProiaroty()[1-10]
5. sleep()
6. wait()
------------
Synchronize a resource:
if we want a method to be synchrinize we type Synchronize in the definitio,
befor the returned data type.
*/
class Process1 implements Runnable{
int x;
Process1 (int x)
{
    this.x=x;
}
    @Override
    public void run() {
        for(int i=0;i<5;i++,x++)
        System.out.println("Inside process #1 "+"   x = "+x);  
    }
    
}
class Process2 implements Runnable{
int x;
Process2 (int x)
{
    this.x=x;
}
    @Override
    public void run() {
        for(int i=0;i<5;i++,x++)
        System.out.println("Inside process #2 "+"   x = "+x);  
    }
}
public class ThreadClass {

    public static void main(String[] args) throws Exception {
        int x=0;
        Thread t1 = new Thread(new Process1(x));
         Thread t2 = new Thread(new Process2(x));
         t2.start();
         t1.start();
        // t1.join();
         
    }
}
