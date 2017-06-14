//Christian Solano
//CSC 199
//Long horse trip
import java.util.*;

public class xlongHorseTrip{
   
	public static void main(String[] args) {
  // System.out.println("test");
   int[] array= new int[6];
   Scanner inn = new Scanner(System.in);
   System.out.println("input the number of instances:");
   int newInt = inn.nextInt();
   System.out.println("first set instance amount:");
   int first = inn.nextInt();
   int variable = 0;
   int[] secondary = new int[10];
   int min = 10000;
   int max = 0;
   array[0] = first;
   for (int i = 1; i < first+1; i++){
      array[i] = inn.nextInt();      

   }
  
   System.out.println(array[0] +" "+ array[1] +" "+ array[first]);
   }
}