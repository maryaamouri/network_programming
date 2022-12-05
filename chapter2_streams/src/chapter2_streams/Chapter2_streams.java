
package chapter2_streams;

import java.io.*;

/*

Streams Sammary:


***** Read/WriteFROM FILES *****

** Read/Write as Bytes:

A) Without Buffere:
InputStream in = new FileInputStream( "Filename" );
OutputStream out = new FileOutputStream( "Filename" );


B) With Buffere:
BufferedInputStream bin = new BufferedInputStream( new FileOutputStream( "Filename" ));
BufferedOutputStream bout = new BufferedOutputStream( new FileOutputStream( "Filename" ));


** Read/Write as Chars:

A) Without Buffere:
File Reader fr = new File Reader ("filename");
FileWriter fw = new FileWriter ("filename");

B) With Buffere:
BufferedReader br= new BufferedReader (  new FileReader ("filename"));
BufferedWriter br= new BufferedWriter (  new FileWriter ("filename"));


** Read/Write Using StreamReader/StreamWriter (read as bytes and convert to chars): 
A) Without Buffere:
InputStreamReader isr = new InputStreamReader (new FileInputStream ("filename"));
OutputStreamWriter osr = new OutputStreamWriter (new FileOutputStream ("filename"));

B) With Buffere:
BufferedReader bris = new BufferedReader (new InputStreamReader (new FileInputStream ("filename")));
BufferedWriter bwos = new BufferedWriter (OutputStreamWriter (new FileOutputStream ("filename"));


-------------------------------------------------------------------------
***** Read/Write FROM Consol *****

A) Without Buffere:
InputStreamReader isr = new InputStreamReader (System.in);
OutputStreamWriter osr = new OutputStreamWriter (System.out);

B) With Buffere:
BufferedReader bris = new BufferedReader (new InputStreamReader (System.in));
BufferedWriter bwos = new BufferedWriter (OutputStreamWriter (System.out));

------------------------------------------------------------------------
***** Writing using PrintWriter & PrintStream classes *****
(auto flush)


A) As Bytes:
PrintStream ps1 = new PrintStream (new BufferedOutputStream( System.out) ,true);
PrintStream ps2 = new PrintStream (new BufferedOutputStream( new FileOutputStream( "Filename" )) ,true);

B) As Chars:
PrintWriter pw1 = new PrintWriter (new BufferedWriter (OutputStreamWriter (System.out) ,true);
PrintWriter pw2 = new PrintWriter (new BufferedWriter (  new FileWriter ("filename")) ,true);
 */
public class Chapter2_streams {

    public static void main(String[] args) throws IOException {
     
      PrintStream ps1 = new PrintStream (new BufferedOutputStream( System.out) ,true);
      ps1.println("HI");
               }
    
}
