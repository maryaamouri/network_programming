/*
Parsing images:
1. create URL.
2. create URL connection-> URLConnection conn = url.openConnection();
3. check if it contain images-> if (conn.getContent().getClass().getName().contains("Image")||("Picture"))
4. read image-> BufferedImage im = ImageIO.read(url);
5. write image-> ImageIO.write(im, "bmp", new File("path\\image.gpj"));
*/
package url2;


import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
import javax.imageio.*;
public class Url2 {

   
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.aaup.edu/sites/default/files/AAUP20-celebration-Final.jpg");
         /*   BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine())!=null)
                System.out.println(line);*/
         
       URLConnection conn = url.openConnection();
       //parsing html
       /*   BufferedReader br = new BufferedReader (new InputStreamReader(conn.getInputStream()));
         String line;
            while ((line = br.readLine())!= null)
                     System.out.println(line);*/
       // types of content 
       
       if (conn.getContent().getClass().getName().contains("InputStream"))
                System.out.println("Stream");
       else 
            if (conn.getContent().getClass().getName().contains("Image")||conn.getContent().getClass().getName().contains("Picture"))
            {
               BufferedImage im = ImageIO.read(url);
                ImageIO.write(im, "bmp", new File("D:\\University\\first_semester_2022\\networks_programming\\image.bmp"));
                 ImageIO.write(im, "jpg", new File("D:\\University\\first_semester_2022\\networks_programming\\image.jpg"));
               ImageIO.write(im, "png", new File("D:\\University\\first_semester_2022\\networks_programming\\image.png"));
            }
           

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
