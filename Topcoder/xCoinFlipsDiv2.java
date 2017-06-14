//Christian Solano
//CSC 199
//Topcoder SRM 681 CoinFlipsDiv2
//Points- Challenged for them so 0
//Data from contest

public class xCoinFlipsDiv2{
     int n= 0;
      int i =1;
      int k = 0;
    public int countCoins(String state){
        n = state.length();
        while (i!=n){
        if (state.charAt(i) != state.charAt(i-1)){
            k++;
            i++;
                
        }
            }
    return k;
    }
    
}