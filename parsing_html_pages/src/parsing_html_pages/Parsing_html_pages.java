/*
Parsing html
1. create URL-> URL url = new URL("https//:www"+dn);
2. open streams-> BufferedWriter bw = new BufferedWriter(new FileWriter("path"+.html"));
                  BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
3. read/write
4. close streams
*/
package parsing_html_pages;

/*
Write a java program that read a file named "websites.txt" that contains domainames
stor the domain names in ArrayList
give each domain name to thread that parse html of the page using URL
stor the content in a txt file for each domain name
threads are working in parallel
*/

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

class Task implements Callable{
    String dn;
Task(String dn)
{
 this.dn= dn;   
}
    @Override
    public Void call()   {
        try{
            URL url = new URL("https://"+dn);
            //read bytes
          /*  BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("D:\\University\\first_semester_2022\\networks_programming\\"+dn+".html"));
            BufferedInputStream bins = new BufferedInputStream(url.openStream());
            byte b [] = new byte [bins.available()];
           
            while(bins.read(b)!=-1)
                bw.write(b);
          
            System.out.println("Task " + dn +" is completed");*/
          //read chars
        
         BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\University\\first_semester_2022\\networks_programming\\"+dn+".html"));
           BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine())!=null)
                bw.write(line);
             bw.close();
            // bins.close();
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return null;
        
    }
    
}
public class Parsing_html_pages {

    public static void main(String[] args)  {
       
        try{
            
            BufferedReader br = new BufferedReader (new FileReader("D:\\websites.txt"));
            ArrayList <String> list = new ArrayList<String>();
            String line;
           
            while((line=br.readLine())!=null)
                list.add(line);
           
           Task[] tasks = new Task [list.size()];int i=0;
            for(String s :list)
            {
                tasks [i]= new Task(s);
                tasks[i].call();
                i++;
                
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
