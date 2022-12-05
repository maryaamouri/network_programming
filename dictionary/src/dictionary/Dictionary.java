/**
 write a java program that translate english to arabic using URL
 */
package dictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;


public class Dictionary {

     public static void main(String[] args) {
        try {
            Scanner scan = new Scanner (System.in);
            System.out.println("Enter a word");
            String word = scan.next();
            URL url = new URL ("https://dictionary.cambridge.org/dictionary/english-arabic/"+word);
            BufferedReader br = new BufferedReader (new InputStreamReader(url.openStream()));
            String line;
              while((line=br.readLine())!=null)
              { if(line.contains("<div class=\"examp dexamp\">"))
                  System.out.println(line.trim());
              }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
