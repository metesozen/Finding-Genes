
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    int findStopCodon (String dna, int startIndex, String stopCodon){
        int currIndex=dna.indexOf(stopCodon, startIndex+3);
        while (currIndex!=-1){
            int diff=currIndex-startIndex;
            if (diff % 3 == 0) return currIndex;//valid stop codon found
            else currIndex=dna.indexOf(stopCodon, currIndex+1);
        }
        return dna.length();
    }
    String findGene(String dna, int where){
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
    void printAllGenes (String dna){
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
    
    int countGenes (String dna){
        int startIndex=0;
        int count=0;
        while (true) {
            String currentgene = findGene(dna,startIndex);
            if (currentgene.isEmpty()) {
                break;
            }
            count++;
            startIndex=(dna.indexOf(currentgene,startIndex)+currentgene.length());
        }
        return count;
    }
    void testCountGenes(){
        String dna1="ATGTAAGATGCCCTAGT";
        System.out.println(countGenes(dna1));
        //String dna2="";
    }

}
