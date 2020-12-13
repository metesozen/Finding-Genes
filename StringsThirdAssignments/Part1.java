
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
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
    public StorageResource getAllGenes (String dna){
        StorageResource geneList=new StorageResource();
        int startIndex=0;
        while (true) {
            String currentgene = findGene(dna,startIndex);
            if (currentgene.isEmpty()) {
                break;
            }
            geneList.add(currentgene);
            startIndex=(dna.indexOf(currentgene,startIndex)+currentgene.length());
        }
        return geneList;
    }
    float cgRatio (String dna){
            int longetivity=dna.length();
            int ctr=0;
            int ctr2=0;
            while(longetivity--!=0){
                char karakter=dna.charAt(ctr2);
                ctr2++;
                if(karakter == 'C' || karakter == 'G') ctr++;
            }
            float ratio = (float) ctr/(dna.length());
            return ratio;
        }
    int countCTG (String dna){
        int ctr=0;
        int indexctg=0;
        while (true){
            indexctg=dna.indexOf("CTG",indexctg);
            if (indexctg==-1) break;
            ctr++;
            indexctg=indexctg+3;
        }
        return ctr;
    }
    void processGenes (StorageResource sr){
        int ctr=0;
        int ctr2=0;
        int ctr3=0;
        int longest=0;
        for(String g:sr.data()){
            ctr3++;
            if(g.length()>60) {
                System.out.println("This string longer than 60: "+g);
                ctr++;
            }
            if(cgRatio(g)>0.35){
                System.out.println("This string's cg ratio is higher than 0,35: "+g);
                ctr2++;
            }
            if(g.length()>longest) longest=g.length();
        }
        System.out.println("Number of strings longer than 60: "+ctr);
        System.out.println("Number of strings' cgratio higher than 0,35: "+ctr2);
        System.out.println("Longest string: "+longest);
        System.out.println("Number of genes: "+ctr3);
    }
    void testProcessGenes(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        processGenes(getAllGenes (dna));
        System.out.println(countCTG(dna));

    }
    public void teston(String dna){
        System.out.println("Testing on: "+dna);
        StorageResource genes=getAllGenes(dna);
        for (String g:genes.data()){
            System.out.println(g);
        }
    }
    public void test(){
        //System.out.println(cgRatio("ATGCCATAG"));
        System.out.println(countCTG("G"));
        //teston("AATGCTAACTAGCTGACTAAT");
        //teston("");
    }
}
