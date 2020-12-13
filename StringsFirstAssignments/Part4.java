
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
import edu.duke.*;
import java.io.*;

public class Part4 {
    void urele(){
      String url = "https://www.dukelearntoprogram.com/course2/data/manylinks.html"; // update to https
      URLResource ur = new URLResource(url);
      for (String s : ur.words()) {
         String str = s.toLowerCase();
         int pos=str.indexOf("youtube");
         if(pos!=-1)
         {
          String quote = "\"";
          int firstIndex = s.lastIndexOf(quote, pos);
          int secondIndex = s.indexOf(quote,pos+1);
          System.out.println(s.subSequence(firstIndex+1, secondIndex));
         }
      }
    }

}
