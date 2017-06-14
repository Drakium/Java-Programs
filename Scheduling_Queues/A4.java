
//Christian Solano
//CSC 139 section 02
//Assignment 4
import java.util.*;
import java.io.*;
public class A4 {

       public static void main(String[] args) { 
       //Input and output files
        String fileName = "input.txt";
        String fileName2 = "output.txt";
        String line = null;
        //initialize the arrays for the first 3 digits
        int[] firstNums = new int[3];
        int[] pagez = new int[0];
        int[] framez = new int[0];
        //Linked List fifo for First in first out with integer
        LinkedList<Integer> fifo = new LinkedList<Integer>();
        
        //Linked list Pages for Least Recently Used, class pages that holds multiple elements
        LinkedList<Pages> lru = new LinkedList<Pages>();
        
        int pages=0,frames=0,pageRequest=0,f=0;
        
        boolean firstLine=false;
        int count =0;
        int timeStamp = 0;
        
        
        
         try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);
            FileWriter fileWriter = 
               new FileWriter(fileName2);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = 
               new BufferedWriter(fileWriter);
            //makes sure to traverse through the whole file to add to arrays before moving on 
             while((line = bufferedReader.readLine()) != null) {
               Scanner scanNums = new Scanner(line);
               if (firstLine ==false){
                  pages= scanNums.nextInt();
                  frames= scanNums.nextInt();
                  pageRequest= scanNums.nextInt();
                  firstLine = true;
                  line = bufferedReader.readLine();
                  pagez = new int[pageRequest];
                  framez = new int[frames];
                  scanNums = new Scanner(line);
                  
               }
               
               pagez[f] = scanNums.nextInt();
               f = f+1;
               
             } 
           System.out.println(pages+" " + frames +" "+ pageRequest);
            for (int i=0; i<pagez.length; i++){
          
           }
           
           //Calls in first in first out method with linked list and arrays
            FIFO(fileName2,framez,pagez,fifo,bufferedWriter);
            
            
            //Calls Least Recently used with 
            LRU(fileName2,framez,pagez,lru,bufferedWriter);
          // System.out.println(fifo.peek());
            bufferedReader.close();   
            bufferedWriter.close();  
            
            
            
            
         } 
                 
       //Catches file not found error
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            
        } 



       }
       //First In First Out Queue with linkedlist
       public static void FIFO (String Fname,int[] fra, int[] pag, LinkedList<Integer> fif,BufferedWriter OutTxt){
         int cap = 0;
         int framCheck= 0;
         int limitF = 0;
         try{
         OutTxt.write("Output:");
         OutTxt.newLine();
         OutTxt.write("FIFO");
         OutTxt.newLine();
         for (int i = 0; i < pag.length; i++){
         //Checks if the page being passed already exist in the queue
            if (checkList(fif,pag[i])== true){
               framCheck = checkFrame(fif,pag[i]);
               OutTxt.write("Page " + pag[i]+ " already in Frame " + framCheck);
               OutTxt.newLine();
            }
            else{
           //if the frame is already full it goes through replacing
               if (cap > fra.length-1){
                  OutTxt.write("Page "+fif.get(limitF)+ " unloaded from Frame "+ limitF +", Page " + pag[i] +" loaded into Frame " + limitF);
                  OutTxt.newLine();
                  fif.set(limitF, pag[i]);
                  limitF=limitF+1;
                  if(limitF == fra.length){
                    
                     limitF = 0;
                  }
               }else{
               // adds the pages to the linkedlist queue while frame buffer not full
                  fif.add(pag[i]); 
                  OutTxt.write("Page "+fif.get(fif.size()-1)+ " loaded into Frame " + cap);
                  OutTxt.newLine();
                  fra[cap] = fif.get(cap);
                  cap = cap+1;
                }
            }
            
          // } 
            
         
         
         }
         }
         
         //Catches File exception from output
         catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + Fname + "'");
           
        }
       
       }
       //Least Recently Used
       public static void LRU(String Fname,int[] fra, int[] pag, LinkedList<Pages> leastRec,BufferedWriter OutTxt){
         int timeChange = 0;
         int framCheck = 0;
         int cap = 0;
         int limitF = 0;
         int current = 0;
         try{
            OutTxt.write("LRU");
            OutTxt.newLine();
            for (int i =0; i< pag.length; i++){
               leastRec = incrementTime(leastRec);
               if (checkListLru(leastRec,pag[i])== true){
               
                  framCheck = checkFrameLru(leastRec,pag[i]);
                  OutTxt.write("Page " + pag[i]+ " already in Frame " + framCheck);
                  leastRec.set(framCheck, new Pages (leastRec.get(framCheck).PageRequestNum,0,true));
                  
                 OutTxt.newLine();
               }
               else{
              //
                if (cap > fra.length-1){
                
                   timeChange = checkTimeStamp(leastRec);
                   timeChange = timeChange - 1;    
                   OutTxt.write("Page "+leastRec.get(timeChange).PageRequestNum+ " unloaded from Frame "+ timeChange +", Page " + pag[i] +" loaded into Frame " + timeChange);
                   OutTxt.newLine();
                   
                   leastRec.set(timeChange, new Pages (pag[i],0,true));
                   
                   limitF=limitF+1;
                   if(limitF == fra.length){
                    
                      limitF = 0;
                   }
                }else{
              ;
                 leastRec.add(new Pages(pag[i],0,true));
                 OutTxt.write("Page "+leastRec.get(leastRec.size()-1).PageRequestNum+ " loaded into Frame " + cap  );
                 OutTxt.newLine();
               
                cap = cap+1;
               }
               
              }
            }
         
         
         }
         catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + Fname + "'");
           
        }

       
       
       }
       //Checks what frame there already exist the num
       public static int checkFrame(LinkedList<Integer> checking,int frameCheck){
        for (int k = 0; k < checking.size(); k++){
               if (checking.get(k) == frameCheck){
               return k;
               }
            
            }
            return 0;
       }
       //Checks the list if the number is in there already returns true or false
       public static boolean checkList(LinkedList<Integer> checking,int numCheck){
            for (int k = 0; k < checking.size(); k++){
               if (checking.get(k) == numCheck){
               return true;
               }
            
            }
         
            return false;
       
       }
       //Goes through LRU list to see if number already loaded in a frame
       public static boolean checkListLru(LinkedList<Pages> checking,int numCheck){
            for (int k = 0; k < checking.size(); k++){
               if (checking.get(k).PageRequestNum == numCheck){
               return true;
               }
            
            }
         
            return false;
       
       }
       
       //checks what frame there is the number
        public static int checkFrameLru(LinkedList<Pages> checking,int frameCheck){
        for (int k = 0; k < checking.size(); k++){
               if (checking.get(k).PageRequestNum == frameCheck){
               return k;
               }
            
            }
            return 0;
       }
       
       //Checks LRU for count, highest count gets replaced
       public static int checkTimeStamp(LinkedList<Pages> checking){
         int highestTime = 0;
         int count = 0;
         for (int i = 0; i <checking.size(); i++){
            if (highestTime < checking.get(i).timeStamp){
       
           
               highestTime = checking.get(i).timeStamp;
               count= count +1;
            }
               
         }
        // System.out.println();
        // System.out.println("Hightime " + highestTime);
         //System.out.println();
         return count;
       
       }
       //Increments the time in the Pages timestamp for later checking
       public static LinkedList<Pages> incrementTime(LinkedList<Pages> checking){
        int timeIncrease = 0;
        for(int i = 0; i < checking.size(); i++){
           //gets current time and adds +1
               timeIncrease = checking.get(i).timeStamp;
               timeIncrease = timeIncrease+1;
               checking.set(i,new Pages(checking.get(i).PageRequestNum,timeIncrease,true));
        }
         return checking;
       }



}
//Pages class that holds the page number, the time incremental, and the bit iv
class Pages{
   public int PageRequestNum;
   public int timeStamp;
   public boolean Bit;
   
   Pages(int a,int b,boolean c){
      PageRequestNum = a;
      timeStamp = b;
      Bit = c;
   
   }
   public String toString(){
         return PageRequestNum + " " +timeStamp+ " "+ Bit + " ";
   }

}