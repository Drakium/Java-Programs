import java.util.*;

public class SimpleSnake{
   public static void main(String[] args) {
      Scanner inn = new Scanner(System.in);
      System.out.println("input the grid:");
      Random rand = new Random();
      
      int newInt = 5;//inn.nextInt();
      int grid = newInt*newInt;
      int first = grid/2;
      int second = first%10;
      int temp = 0;
      int randomNum=0;
       int randomNum2=0;
      first = first - second;
      System.out.println(grid);
      System.out.println(first);
   
      String gArray[] = new String[grid];
      String snakeGrid[][] = new String[newInt][newInt];
     
      snakePath(snakeGrid,newInt,grid,first,second,temp,rand,randomNum,randomNum2);
      System.out.println();
      System.out.println();
     
      newInt = 20;//inn.nextInt();
      grid = newInt*newInt;
      first = grid/2;
      second = first%10;
      temp = 0;
      first = first - second;
      System.out.println(grid);
      System.out.println(first);
      String zArray[] = new String[grid];
      String znakeGrid[][] = new String[newInt][newInt];
      snakePath(znakeGrid,newInt,grid,first,second,temp,rand,randomNum,randomNum2);

       System.out.println();
      System.out.println();
     
      newInt = 10;//inn.nextInt();
      grid = newInt*newInt;
      first = grid/2;
      second = first%10;
      temp = 0;
      first = first - second;
      System.out.println(grid);
      System.out.println(first);
      String cArray[] = new String[grid];
      String cnakeGrid[][] = new String[newInt][newInt];
      snakePath(cnakeGrid,newInt,grid,first,second,temp,rand,randomNum,randomNum2);

      
      }
      public static void snakePath(String[][] snakeGrid, int newInt, int grid, int first, int second, int temp,Random rand,int randomNum,int randomNum2){
       randomNum=0;
       randomNum2=0;

      for(int i = 0; i < newInt; i++){
         for(int j=0; j <newInt; j++){
         if(temp == newInt){
         System.out.println("");
            temp=0;
         }

            snakeGrid[i][j] = "*";
            System.out.print(snakeGrid[i][j]);
          temp++; 
         }
        

      }
      System.out.println("");
      
       for(int i = 0; i< first; i++){
         randomNum=rand.nextInt(newInt);
         randomNum2=rand.nextInt(newInt); 
         snakeGrid[randomNum][randomNum2] = " "; 
        // System.out.println(randomNum);
        // System.out.println(randomNum2);
      }
      temp = 0;
      System.out.println("");
      
     int snakeTail = rand.nextInt(newInt);
     int snakeTail2 = rand.nextInt(newInt);
     // while(snakeGrid[snakeTail][snakeTail2] != " "){
          snakeTail =  0;//rand.nextInt(newInt);
          snakeTail2 = 0;//rand.nextInt(newInt);

      //}
      snakeGrid[snakeTail][snakeTail2] = "<";
      int pivotOne=snakeTail;
      int pivotTwo=snakeTail2;
      
     int snakeHead = newInt-1;//rand.nextInt(newInt);
     int snakeHead2 = newInt-1;//rand.nextInt(newInt);
     // while(snakeGrid[snakeHead][snakeHead2] != " "){
     //     snakeHead = rand.nextInt(newInt);
         // snakeHead2 = rand.nextInt(newInt);

    //  }      
       snakeGrid[snakeHead][snakeHead2] = ">";
       
      int pivotThree = snakeHead;
      int pivotFour = snakeHead2;
      int whileCount=0;
       temp = 0;
 
    if ((snakeGrid[pivotOne+1][pivotTwo] == " " && snakeGrid[pivotOne][pivotTwo+1] == " ") || (snakeGrid[pivotThree-1][pivotFour] == " " && snakeGrid[pivotThree][pivotFour -1] == " ")){
   
     System.out.println("No path found");
      
    }else{
  //  System.out.println("possible path");
      int posneg = 0;
      int temps;
             
        while(snakeGrid[pivotOne][pivotTwo] != " "){
         posneg= rand.nextInt(2);

         if (posneg == 1){
            posneg=rand.nextInt(2);
            
            if (posneg==1){
             temps = pivotOne;
             pivotOne = pivotOne+ 1;
            
             if (pivotOne> newInt-1){
              
               pivotOne= pivotOne-1;
                temps = pivotOne;
             }
             
            }else {
             temps=pivotOne;
             pivotOne = pivotOne- 1;
             if(pivotOne <0){
               
               pivotOne= pivotOne+1;
               temps=pivotOne;
             }
            }
            if (snakeGrid[pivotOne][pivotTwo] == " "){
               pivotOne = temps;
            
            }
            posneg=1;
         }
         if(posneg==0){
             posneg=rand.nextInt(2);
            if (posneg==1){
            temps=pivotTwo;
             pivotTwo = pivotTwo+ 1;
            if (pivotTwo> (newInt-1)){
              pivotTwo= pivotTwo-1;
              temps=pivotTwo;

             }
            }else {
            temps=pivotTwo;
             pivotTwo = pivotTwo- 1;
            if (pivotTwo<0){
               
               pivotTwo= pivotTwo+1;
               temps=pivotTwo;

             }
            }
         if (snakeGrid[pivotOne][pivotTwo] == " "){
               pivotTwo= temps;
            
            }
        }
        whileCount=whileCount+1;
        if(whileCount== 100000){
        System.out.println("NONE FOUND");
        break;
        }
        if(pivotOne ==pivotThree && pivotTwo == pivotFour){
        System.out.println("Path found!");
        break;
        }
       }
      
     
      for(int i = 0; i < newInt; i++){
         for(int j=0; j <newInt; j++){
         if(temp == newInt){
         System.out.println("");
            temp=0;
         }
            System.out.print(snakeGrid[i][j]);
          temp++; 
         }        
      }
     }
            
   }
   }