import java.util.Arrays;
public class Quorum{
   public static void main(String[] args) {  
    int k = 1;
    int[] arr = {5,2,3};
   // count(arr,k);
    System.out.println(count(arr,k));
   } 
    public static int count(int[] arr, int k){
        int min = arr[0];
        if (k == 1){
            for(int i = 0; i <arr.length; i++){
                if (arr[i] < min){
                  min = arr[i];
                }else {
                  min=min;
                }
            }
            return min;
        }
        int set = 0;
        if (k == arr.length){
             return k;
        }else{
            Arrays.sort(arr);
            for(int j =0; j< k; j++){
              set = set + arr[j];
                
            }
        }
        return set;
    }
  
}
//It was able to pass all the test but still got challenged for something