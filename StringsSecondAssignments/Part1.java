
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon (String dna, int startIndex, String stopCodon){
        //startIndex = dna.indexOf("ATG");
        int currIndex=dna.indexOf(stopCodon, startIndex+3);
        while (currIndex!=-1){
            int diff=currIndex-startIndex;
            if (diff % 3 == 0) return currIndex;//valid stop codon found
            else currIndex=dna.indexOf(stopCodon, currIndex+1);
        }
        return dna.length();
    }
    public void testFindStopCodon (){
        System.out.println(findStopCodon("AAUGCATGCATAGCAGATAACAAACACACACA",0,"TAA"));
    }
    public String findGene(String dna, int where){
        int firstindex=dna.indexOf("ATG",where);//find index of ATG as start index
        if (firstindex==-1) return "";
        int taaindex=findStopCodon(dna,firstindex,"TAA");
        int tagindex=findStopCodon(dna,firstindex,"TAG");
        int tgaindex=findStopCodon(dna,firstindex,"TGA");
        int temp= Math.min(taaindex,tagindex);
        int minindex=Math.min(temp,tgaindex);
        if (minindex!=dna.length()) return dna.substring(firstindex,minindex+3);
        else return "";
    }
    public void testFindGene(){
        String dna1="ACAGATACAGTAGCATA";//no start codone ATG
        System.out.println(findGene(dna1,0));
        String dna2="AGAATGGATTACGATAAGTAAGACATA";//one valid stop codon
        System.out.println(findGene(dna2,0));
    }
    public void printAllGenes (String dna){
        int startIndex=0;
        while (true) {
            String currentgene = findGene(dna,startIndex);
            if (currentgene.isEmpty()) {
                break;
            }
            System.out.println(currentgene);
            startIndex=(dna.indexOf(currentgene,startIndex)+currentgene.length());
            System.out.println(startIndex);
        }
    }
    public void teston(String dna){
        printAllGenes(dna);
    }
    public void test(){
        teston("AATGCTAACTAGCTGACTAAT");
        teston("");
    }
}
