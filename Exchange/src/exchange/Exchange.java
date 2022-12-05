/**
 write a java program that calculates the coins
 */
package exchange;
import java.io.*;
import java.net.*;
import java.util.*;
public class Exchange {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner (System.in);
            System.out.println("Enter the ammount of coins");
            double coin = scan.nextDouble();
            String c1 = scan.next();
            String c2 = scan.next();
            URL url = new URL ("https://www.x-rates.com/calculator/?from="+c1+"&to="+c2+"&amount="+coin);
            BufferedReader br = new BufferedReader (new InputStreamReader(url.openStream()));
            String line;
              while((line=br.readLine())!=null)
              { if(line.contains("ccOutputRslt"))
                  System.out.println(line.substring(line.indexOf(">")+1, line.indexOf("<span class=\"ccOutputTrail\">"))+"$");
              }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
