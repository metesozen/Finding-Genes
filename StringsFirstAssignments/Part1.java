
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;

public class Part1 {
    String findSimpleGene (String dna){
        String result="";
        int startindex=dna.indexOf("ATG");
        if(startindex==-1){
            return "";
        }
        int endindex=dna.indexOf("TAA",startindex);
        if (endindex==-1) {
            return "";
        }
        if ((endindex-startindex)%3==0){
        return(dna.substring(startindex,endindex+3));}
        else {return "";}
    }
    void testSimpleGene() {
        String dna="ATGTAGACGATCAGCTAATCATC";
        System.out.println("DNA zinciri: "+dna);
        String gen=findSimpleGene(dna);
        System.out.println("DNA geni: "+gen);
        
        dna="TACTACTATATTTTATGCATCAGCATCGA";
        System.out.println("DNA zinciri: "+dna);
        gen=findSimpleGene(dna);
        System.out.println("DNA geni: "+gen);
        
        dna="CAGATTAAGCATGTAGCATCAGCAT";
        System.out.println("DNA zinciri: "+dna);
        gen=findSimpleGene(dna);
        System.out.println("DNA geni: "+gen);
        
        dna="GACATTAAATGGACATGACATTAAGATA";
        System.out.println("DNA zinciri: "+dna);
        gen=findSimpleGene(dna);
        System.out.println("DNA geni: "+gen);
    }
}
