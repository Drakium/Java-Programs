//Christian Solano
//CSC 199
//Topcoder SRM 681 XorLists
//Points- Challenged for them so 0
//Data from contest


public class xXorLists{
    int k=0;
    int f = 0;
    public int countList(int[] s, int m){
        k = s.length;
        if (k == 1){
            f = s[0]+ m;
        }
        return f;
    }
    
}