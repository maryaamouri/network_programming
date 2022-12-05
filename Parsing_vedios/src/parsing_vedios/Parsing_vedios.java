/*
Parsing vedios:

1. create URL.
2. check if it contain vedio-> if (url.getPath().contains(".mp4"))
3. open stream-> BufferedInputStream bin = new BufferedInputStream (url.openStream());
4. open file-> BufferedOutputStream bout = new BufferedOutputStream (new FileOutputStream(d:\\vedio.mp4));
5. define buffer-> byte []buff= new byte[1024];
6. write-> int data;
while((data=bin.read())!=-1) bout.write(buff,0,data);
7. close()
*/

package parsing_vedios;

import java.io.*;
import java.net.*;

public class Parsing_vedios {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://youtu.be/phyY7ExcFfo?t=1");
        if (url.getPath().contains(".mp4"))
        {
            BufferedInputStream bin = new BufferedInputStream (url.openStream());
            BufferedOutputStream bout = new BufferedOutputStream (new FileOutputStream("d:\\vedio.mp4"));
            byte[] buff= new byte[1024];
            int data;
while((data=bin.read())!=-1)
bout.write(buff,0,data);
bout.close();
        }else System.out.println("NONO");
        
    }
    
}
