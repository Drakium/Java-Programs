//A3 
//Christian Solano
//Scheduling Algorithms


import java.util.*;
import java.io.*;
public class A3 {
    private static int timeQuan = 0;
    private static int processAmount=0;
    private static int processComplete = 0;
    
    private static int[] ProcessNum = new int[10];
    private static int[] ArrivalTime = new int[10];
    private static int[] CpuBurstTime = new int[10];
    private static int[] PriorityNum = new int[10];
    
    private static int[] OutputTime = new int[20];
    private static int[] OutputProcess = new int[20];
    
    
    private static int f =0;
    private static List<Integer> numGrab = new ArrayList<Integer>();
    private static int[][] outputStuff = new int[10][4];
    
    public static void main(String[] args) { 
        // The name of the file to open.
        
        String fileName = "input.txt";
        String fileName2 = "output.txt";
        // This will reference one line at a time
        String line = null;

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
           // while((line = bufferedReader.readLine()) != null) {
            //    System.out.println(line);
          //  }   
          while((line = bufferedReader.readLine()) != null) {
            //line = bufferedReader.readLine();
              //System.out.println(line.charAt(3));
           
            if (line.charAt(0) == 'R' && line.charAt(1) == 'R' ){
               char timeQ = line.charAt(3);
               timeQuan = Character.getNumericValue(timeQ);
               line = bufferedReader.readLine();
               numGrab.add(Integer.parseInt(line));
               processAmount = numGrab.get(0);
               
               
           
                             
                 //System.out.println(ProcessNum[0] + " " + ArrivalTime[0] + " " + CpuBurstTime[0]
                 //+ " " + PriorityNum[0]);            
                 LinkedList<Processes> ProcList = new LinkedList<Processes>();
               for (int i =0; i <processAmount; i++){
                  
                 
                  line = bufferedReader.readLine();
                  Scanner scanNums = new Scanner(line);
                                    
                  ProcList.add(new Processes(scanNums.nextInt(),scanNums.nextInt(),scanNums.nextInt(),scanNums.nextInt()));
                  
               //   System.out.println(ProcList);
                   //System.out.println(ProcessNum[i] + " " + ArrivalTime[i] + " " + CpuBurstTime[i]
                // + " " + PriorityNum[i]);               
               }
               int[] Queue = new int[processAmount];
                 // System.out.println(ProcList.get(0)[0]);
                //System.out.println(((Processes) ProcList.get(1)).CPUBurstTime);
                
               RoundRobin(fileName2,bufferedWriter,OutputTime,OutputProcess,Queue,processComplete,processAmount,timeQuan,ProcList);
               //System.out.println(timeQuan);
               for (int i =0; i <OutputTime.length;i++){
                  OutputTime[i] = 0;
                  OutputProcess[i]= 0;
               }
            } 
            
             if (line.charAt(0) == 'S' && line.charAt(1) == 'J'){
                line = bufferedReader.readLine();
               numGrab.add(Integer.parseInt(line));
               processAmount = numGrab.get(f);
               LinkedList<Processes> SJFList = new LinkedList<Processes>();
               for (int i =0; i <processAmount; i++){
                  
                 
                  line = bufferedReader.readLine();
                  Scanner scanNums = new Scanner(line);
                                    
                  SJFList.add(new Processes(scanNums.nextInt(),scanNums.nextInt(),scanNums.nextInt(),scanNums.nextInt()));
                  
                 //System.out.println(SJFList);
                   //System.out.println(ProcessNum[i] + " " + ArrivalTime[i] + " " + CpuBurstTime[i]
                // + " " + PriorityNum[i]);
                            
               }

             
               ShortestJobFirst(fileName2,bufferedWriter,OutputTime,OutputProcess,processComplete,processAmount,SJFList);
               //System.out.println(numGrab);
               for (int i =0; i <OutputTime.length;i++){
                  OutputTime[i] = 0;
                  OutputProcess[i]= 0;
               }

            } 
             if (line.charAt(0) == 'P' && line.charAt(3) == 'n'){
                line = bufferedReader.readLine();
               numGrab.add(Integer.parseInt(line));
               processAmount = numGrab.get(f);
               LinkedList<Processes> NpList = new LinkedList<Processes>();
               for (int i =0; i <processAmount; i++){
                  
                 
                  line = bufferedReader.readLine();
                  Scanner scanNums = new Scanner(line);
                                    
                  NpList.add(new Processes(scanNums.nextInt(),scanNums.nextInt(),scanNums.nextInt(),scanNums.nextInt()));
                  
               //  System.out.println(NpList);
                   //System.out.println(ProcessNum[i] + " " + ArrivalTime[i] + " " + CpuBurstTime[i]
                // + " " + PriorityNum[i]);
                            
               }

              PRnonPre(fileName2,bufferedWriter,OutputTime,OutputProcess,processComplete,processAmount,NpList);
           //    First(OutputTime,OutputProcess,processComplete,processAmount,SJFList);
               //System.out.println(numGrab);
               for (int i =0; i <OutputTime.length;i++){
                  OutputTime[i] = 0;
                  OutputProcess[i]= 0;
               }

            } 
             if (line.charAt(0) == 'P' && line.charAt(3) == 'w'){
               line = bufferedReader.readLine();
               numGrab.add(Integer.parseInt(line));
               processAmount = numGrab.get(f);
               LinkedList<Processes> PreList = new LinkedList<Processes>();
               for (int i =0; i <processAmount; i++){
                  
                 
                  line = bufferedReader.readLine();
                  Scanner scanNums = new Scanner(line);
                                    
                  PreList.add(new Processes(scanNums.nextInt(),scanNums.nextInt(),scanNums.nextInt(),scanNums.nextInt()));
                  
               //  System.out.println(NpList);
                   
               }
               
               PRwPre(fileName2,bufferedWriter,OutputTime,OutputProcess,processComplete,processAmount,PreList);

               for (int i =0; i <OutputTime.length;i++){
                  OutputTime[i] = 0;
                  OutputProcess[i]= 0;
               }
             }
            
            
            line = bufferedReader.readLine();
            f = f+1;
           }
            bufferedReader.close();   
            bufferedWriter.close();      
        }
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
     
     
//Round Robin SCheduling Algorithm     
     public static void RoundRobin(String Fname,BufferedWriter OutTxt,int[] OT, int[] OP,int[] Q,int Pcom,int pAmount,int TQ,List<Processes> PList){
       //Arrival Time can be ignored
     
      int x =0;
      int y = 0;
      int nextNum =0; 
      OT[0] = 0;
      int z = 0; 
      int[] waitTime = new int[pAmount];
      int avgWait = 0;
      int ServiceTime = 0;
      int last1 = 1;
      
     //Used to assign the complete number of processes from queue. 
      while (Pcom != pAmount){
         x = ((Processes) PList.get(y)).CPUBurstTime;
         //Sets queue for read CPUBurst
         if (x - TQ < 0 ){
            nextNum = x- TQ;
            OT[y+1] = z+x;
            OP[y] = ((Processes) PList.get(y)).ProcessNumber;
            Pcom = Pcom+1;
            z= z+ x;
            y= y+1;
         
         }else {
            nextNum = x - TQ;  
            OT[y+1] = z+ TQ;
            OP[y] = ((Processes) PList.get(y)).ProcessNumber;
            y= y+1;
            z = z +TQ;
            //Adds processes to end of queue with lower amount of cpuburst - Time quantum
            PList.add(new Processes(((Processes) PList.get(0)).ProcessNumber,((Processes) PList.get(0)).ArrivalTime,
            nextNum,((Processes) PList.get(0)).PriorityNums));
       }
      
     
     }
    //Calculates average wait time  
     avgWait = OT[pAmount]-OT[last1];
     
     for (int i =1; i < pAmount; i++){
      ServiceTime = ServiceTime + OT[i];
     }
     avgWait = avgWait +ServiceTime;
     
     double avgF = ((double)avgWait/ pAmount);
     
     //Prints everything to 'output.txt' file
     try{
     OutTxt.write("RR " + TQ);
     OutTxt.newLine();
     
     for (int i =0; i < 12; i++){
       OutTxt.write(OT[i] + " " + OP[i]);
       OutTxt.newLine();
       }
       OutTxt.write("AVG Waiting Time: " + avgF);
       OutTxt.newLine();
       OutTxt.newLine();
     }
     catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + Fname + "'");
           
        }
     }
  //SJF scheduling algorithms   
     public static void ShortestJobFirst(String Fname,BufferedWriter OutTxt,int[] OT, int[] OP,int Pcom,int pAmount,List<Processes> PList){
     int x = 0;
     int y = 0;
     int z = 0;
     int trackTime = 0;
     int temp1 =0;
     int temp2 =0;
     int temp3 =0;
     int temp4 =0;
     int[] QQ =new int[10];
     int avgWait = 0;
      int ServiceTime = 0;
      int last1 = 1;

     
     //For CPU Burst Time order
     for (int i =0; i<pAmount; i++){
     
      for (int j = i+1; j< pAmount; j++){
           if (((Processes) PList.get(i)).CPUBurstTime > ((Processes) PList.get(j)).CPUBurstTime){
               temp1 = ((Processes) PList.get(i)).ProcessNumber;
               temp2 = ((Processes) PList.get(i)).ArrivalTime;
               temp3 = ((Processes) PList.get(i)).CPUBurstTime;
               temp4 = ((Processes) PList.get(i)).PriorityNums;   
               PList.set(i, new Processes(((Processes) PList.get(j)).ProcessNumber,
               ((Processes) PList.get(j)).ArrivalTime,((Processes) PList.get(j)).CPUBurstTime,
               ((Processes) PList.get(j)).PriorityNums));
               PList.set(j, new Processes(temp1,temp2,temp3,temp4));
           }
       }
      }
     //For Arrival Time order
     for (int i =0; i<pAmount; i++){
     
      for (int j = i+1; j< pAmount; j++){
           if ((((Processes) PList.get(i)).ArrivalTime+ ((Processes) PList.get(i)).CPUBurstTime) > (((Processes) PList.get(j)).ArrivalTime+((Processes) PList.get(j)).CPUBurstTime)){
               temp1 = ((Processes) PList.get(i)).ProcessNumber;
               temp2 = ((Processes) PList.get(i)).ArrivalTime;
               temp3 = ((Processes) PList.get(i)).CPUBurstTime;
               temp4 = ((Processes) PList.get(i)).PriorityNums;   
               PList.set(i, new Processes(((Processes) PList.get(j)).ProcessNumber,
               ((Processes) PList.get(j)).ArrivalTime,((Processes) PList.get(j)).CPUBurstTime,
               ((Processes) PList.get(j)).PriorityNums));
               PList.set(j, new Processes(temp1,temp2,temp3,temp4));
           }
       }
      }
      OT[0] = trackTime;
      //Timeflip tracks time to compare 
      
     while (z != pAmount){
      y = y+ ((Processes) PList.get(z)).CPUBurstTime;
      trackTime = trackTime + ((Processes) PList.get(z)).ArrivalTime;
      OT[z+1] = y;
      OP[z] = ((Processes) PList.get(z)).ProcessNumber;
      z = z+1;
     }
      avgWait = OT[pAmount]-OT[last1];
     
     for (int i =1; i < pAmount; i++){
      ServiceTime = ServiceTime + OT[i];
     }
    
     double avgF = ((double)ServiceTime/ pAmount);

     //Prints everything to 'output.txt' file
     try{
     OutTxt.write("SJF");
     OutTxt.newLine();
     for (int i =0; i < 7; i++){
       OutTxt.write(OT[i] + " " + OP[i]);
       OutTxt.newLine();
       }
        OutTxt.write("AVG Waiting Time: " + avgF);
       OutTxt.newLine();
       OutTxt.newLine();

       OutTxt.newLine();
     }
     catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + Fname + "'");
            
        }
     
     }
 //Priority Scheduling non pre    
     public static void PRnonPre(String Fname,BufferedWriter OutTxt,int[] OT, int[] OP,int Pcom,int pAmount,List<Processes> PList){
     
     int x = 0;
     int y = 0;
     int z = 0;
     int trackTime = 0;
     int temp1 =0;
     int temp2 =0;
     int temp3 =0;
     int temp4 =0;
     int[] QQ =new int[10];
     int avgWait = 0;
      int ServiceTime = 0;
      int last1 = 1;

     
     //For CPU Burst Time order
     for (int i =0; i<pAmount; i++){
     
      for (int j = i+1; j< pAmount; j++){
           if (((Processes) PList.get(i)).PriorityNums > ((Processes) PList.get(j)).PriorityNums){
               temp1 = ((Processes) PList.get(i)).ProcessNumber;
               temp2 = ((Processes) PList.get(i)).ArrivalTime;
               temp3 = ((Processes) PList.get(i)).CPUBurstTime;
               temp4 = ((Processes) PList.get(i)).PriorityNums;   
               PList.set(i, new Processes(((Processes) PList.get(j)).ProcessNumber,
               ((Processes) PList.get(j)).ArrivalTime,((Processes) PList.get(j)).CPUBurstTime,
               ((Processes) PList.get(j)).PriorityNums));
               PList.set(j, new Processes(temp1,temp2,temp3,temp4));
           }
       }
      }
      //For Arrival Time order
     for (int i =0; i<pAmount; i++){
     
      for (int j = i+1; j< pAmount; j++){
           if (((Processes) PList.get(i)).ArrivalTime> ((Processes) PList.get(j)).ArrivalTime){
               temp1 = ((Processes) PList.get(i)).ProcessNumber;
               temp2 = ((Processes) PList.get(i)).ArrivalTime;
               temp3 = ((Processes) PList.get(i)).CPUBurstTime;
               temp4 = ((Processes) PList.get(i)).PriorityNums;   
               PList.set(i, new Processes(((Processes) PList.get(j)).ProcessNumber,
               ((Processes) PList.get(j)).ArrivalTime,((Processes) PList.get(j)).CPUBurstTime,
               ((Processes) PList.get(j)).PriorityNums));
               PList.set(j, new Processes(temp1,temp2,temp3,temp4));
           }
       }
      }

      
      OT[0] = trackTime;
       //Timeflip tracks time to compare 
     while (z != pAmount){
      y = y+ ((Processes) PList.get(z)).CPUBurstTime;
      trackTime = trackTime + ((Processes) PList.get(z)).ArrivalTime;
      OT[z+1] = y;
      OP[z] = ((Processes) PList.get(z)).ProcessNumber;
      z = z+1;
     }
     avgWait = OT[pAmount]-OT[last1];
     
     for (int i =1; i < pAmount; i++){
      ServiceTime = ServiceTime + OT[i] -((Processes) PList.get(i)).ArrivalTime;;
     }
     //avgWait = ServiceTime;
     //avgWait = (avgWait/3);
     double avgF = ((double)ServiceTime/ pAmount);

     //Prints everything to output files
     try{
     OutTxt.write("PR_noPREMP");
     OutTxt.newLine();
     for (int i =0; i < 7; i++){
       OutTxt.write(OT[i] + " " + OP[i]);
       OutTxt.newLine();
       }
         OutTxt.write("AVG Waiting Time: " + avgF);
       OutTxt.newLine();

       OutTxt.newLine();
     }
     catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + Fname + "'");
            
        }

     
     
     }
   //Priority scheduling with pre  
      public static void PRwPre(String Fname,BufferedWriter OutTxt,int[] OT, int[] OP,int Pcom,int pAmount,List<Processes> PList){
      int x = 0;
     int y = 0;
     int z = 0;
     int w = 0;
     int trackTime = 0;
     int temp1 =0;
     int temp2 =0;
     int temp3 =0;
     int temp4 =0;
     int[] QQ =new int[10];
      int avgWait = 0;
      int ServiceTime = 0;
      int last1 = 1;

      for (int i =0; i<pAmount; i++){
     
         for (int j = i+1; j< pAmount; j++){
              if (((Processes) PList.get(i)).ArrivalTime> ((Processes) PList.get(j)).ArrivalTime){
                  temp1 = ((Processes) PList.get(i)).ProcessNumber;
                  temp2 = ((Processes) PList.get(i)).ArrivalTime;
                  temp3 = ((Processes) PList.get(i)).CPUBurstTime;
                  temp4 = ((Processes) PList.get(i)).PriorityNums;   
                  PList.set(i, new Processes(((Processes) PList.get(j)).ProcessNumber,
                  ((Processes) PList.get(j)).ArrivalTime,((Processes) PList.get(j)).CPUBurstTime,
                  ((Processes) PList.get(j)).PriorityNums));
                  PList.set(j, new Processes(temp1,temp2,temp3,temp4));
              }
          }
      }
      
      for (int i = 0; i < pAmount; i++){
         QQ[i] = ((Processes) PList.get(i)).ArrivalTime;

      }
     
      OT[0] = trackTime;
     while (z != pAmount){
      y = y+ ((Processes) PList.get(z)).CPUBurstTime;
      trackTime = trackTime + ((Processes) PList.get(z)).ArrivalTime;
      OT[z+1] = y;
      OP[z] = ((Processes) PList.get(z)).ProcessNumber;
      z = z+1;
     }
     avgWait = OT[pAmount]-OT[last1];
     
     for (int i =1; i < pAmount; i++){
      ServiceTime = ServiceTime + OT[i] -((Processes) PList.get(i)).ArrivalTime;;
     }
     //avgWait = ServiceTime;
     //avgWait = (avgWait/3);
     double avgF = ((double)ServiceTime/ pAmount);

     
     try{
     OutTxt.write("PR_withPREMP");
     OutTxt.newLine();
     for (int i =0; i < 7; i++){
       OutTxt.write(OT[i] + " " + OP[i]);
       OutTxt.newLine();
       }
         OutTxt.write("AVG Waiting Time: " + avgF);
       OutTxt.newLine();

       OutTxt.newLine();
     }
     catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + Fname + "'");
                   }

      int QueuePoint = QQ[0];
      int QueuePoint2 = QQ[pAmount-1];
      int QueuePoint3 = trackTime+1;
      int followQ = 0;
      OT[0] = 0;
   //Compares arrivaltime to priority and cpuburst  
     /* while (QueuePoint != QueuePoint2){
         while (QQ[trackTime] != QQ[QueuePoint3]){
            OP[followQ] = ((Processes) PList.get(QueuePoint)).ProcessNumber;
            OT[followQ+1] = trackTime;
            PList.set(trackTime, new Processes(((Processes) PList.get(trackTime)).ProcessNumber,
                  (((Processes) PList.get(trackTime)).ArrivalTime)+1,(((Processes) PList.get(QueuePoint)).CPUBurstTime)-1,
                  ((Processes) PList.get(trackTime)).PriorityNums));
                  
                                       

                  
                   for (int i =0; i<pAmount; i++){
     
                     for (int j = i+1; j< pAmount; j++){
                          if (((Processes) PList.get(i)).ArrivalTime> ((Processes) PList.get(j)).ArrivalTime){
                              temp1 = ((Processes) PList.get(i)).ProcessNumber;
                              temp2 = ((Processes) PList.get(i)).ArrivalTime;
                              temp3 = ((Processes) PList.get(i)).CPUBurstTime;
                              temp4 = ((Processes) PList.get(i)).PriorityNums;   
                              PList.set(i, new Processes(((Processes) PList.get(j)).ProcessNumber,
                              ((Processes) PList.get(j)).ArrivalTime,((Processes) PList.get(j)).CPUBurstTime,
                              ((Processes) PList.get(j)).PriorityNums));
                              PList.set(j, new Processes(temp1,temp2,temp3,temp4));
                          }
                      }
                    }
               QQ[trackTime] = QQ[trackTime] +1;
               if (QQ[trackTime] == QQ[QueuePoint3]){
                  trackTime = trackTime +1; 
                  QueuePoint3 = QueuePoint3 +1;
                  break;
               }
         }
         QueuePoint = QueuePoint+1;
         //System.out.print(QueuePoint + " " + QueuePoint2);
      }
      
     // System.out.println(QQ[0] + " " + QQ[1]);
     System.out.println(PList);
     for (int i =0; i < 15; i++){
       System.out.println(OT[i] + " " + OP[i]);
       }
       System.out.println("");
      */
      }
      
      
}

//Process used for linkedlist which holds all elements and prints to string     
class Processes{
   public int ProcessNumber;
   public int ArrivalTime;
   public int CPUBurstTime;
   public int PriorityNums;
   
   Processes(int a, int b, int c, int d){
      ProcessNumber = a;
      ArrivalTime = b;
      CPUBurstTime = c;
      PriorityNums=d;
   
   
   }
   public String toString(){
         return ProcessNumber + " " + ArrivalTime + " " +
         CPUBurstTime + " " + PriorityNums;
   }

}
