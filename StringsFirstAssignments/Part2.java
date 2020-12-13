
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    String findSimpleGene (String dna, String startcodon, String stopcodon){
        String result="";
        int startindex=dna.indexOf(startcodon);
        boolean lower=false;
        if(startindex==-1){
            dna=dna.toUpperCase();
            startindex=dna.indexOf(startcodon);
            if(startindex==-1){
                return "";
            }
            else {
                lower=true;
            }
        }
        int endindex=dna.indexOf(stopcodon,startindex);
        if (endindex==-1) {
            return "";
        }
        if(lower){dna=dna.toLowerCase();}
        if((endindex-startindex)%3==0){
        return(dna.substring(startindex,endindex+3));}
        else return "";
    }
    void testSimpleGene() {
        String dna="cagatgatattgatgtagtaacaga";
        System.out.println("DNA zinciri: "+dna);
        String gen=findSimpleGene(dna,"ATG","TAA");
        System.out.println("DNA geni: "+gen);
        
        dna="TACTACTATATTTTATGCATCAGCATCGA";
        System.out.println("DNA zinciri: "+dna);
        gen=findSimpleGene(dna,"ATG","TAA");
        System.out.println("DNA geni: "+gen);
        
        dna="CAGATTAAGCATGTAGCATCAGCAT";
        System.out.println("DNA zinciri: "+dna);
        gen=findSimpleGene(dna,"ATG","TAA");
        System.out.println("DNA geni: "+gen);
        
        dna="GACATTAAATGGACATGACATTAAGATA";
        System.out.println("DNA zinciri: "+dna);
        gen=findSimpleGene(dna,"ATG","TAA");
        System.out.println("DNA geni: "+gen);
        
        dna="atgtaa";
        System.out.println("DNA zinciri: "+dna);
        gen=findSimpleGene(dna,"ATG","TAA");
        System.out.println("DNA geni: "+gen);
    }

}
