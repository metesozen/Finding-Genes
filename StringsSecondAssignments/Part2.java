
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    int howMany(String stringa, String stringb){
        int counter=0;
        int currindex=0;
        currindex=stringb.indexOf(stringa);
        //System.out.println(stringa.length());
        if(currindex==-1) return 0;
        while(currindex!=-1){
        currindex=stringb.indexOf(stringa,currindex+stringa.length());
        counter++;
    }
    return counter;
    }
    void testHowMany (){
        System.out.println("test 1: " + howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println("test 2: " + howMany("AA","ATAAAA"));
        System.out.println("test 3: " + howMany("AAT","TAAGAAF"));
        System.out.println("test 4: " + howMany("AA","AAAAAATAAAAYTYSTASTAAAAA"));
    }

}
