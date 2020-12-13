
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    boolean twoOccurrences(String stringa, String stringb){
        int ilk=stringb.indexOf(stringa);
        //System.out.println(ilk);
        if (ilk==-1) return false;
        else{
            int ikinci=stringb.indexOf(stringa, ilk+1);
            //System.out.println(ikinci);
            if(ikinci==-1) return false;
            else return true;
        }
    }
    void testing(){
        System.out.println(twoOccurrences("a","banana"));
        System.out.println(twoOccurrences("atg","ctgtatgta"));
        System.out.println(twoOccurrences("by","A story by Abby Long"));
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
    }
    String lastPart(String stringa, String stringb){
        int ilk=stringb.indexOf(stringa);
        if(ilk==-1) return stringb;
        return (stringb.substring(ilk+stringa.length(), stringb.length()));
    }

}
