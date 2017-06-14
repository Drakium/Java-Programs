public class Istr{
    
    public int count(String s,int k){
       int[] test = new int[26];
        int num=0;
        int z = 0;
        int fin = 0;
        int end = 0;
       for (char c = 'a'; c <='z'; c++){
           num = 0;
           
        for (int i =0; i < s.length(); i++){
            if (c ==s.charAt(i)){
            num = num + 1;
            }
       		
        }
       	test[z] = num;
           z = z+1;
       }
        for (int j =0; j < 26; j++){
           fin = test[j];
           if (fin > k){
               fin = fin -k;
             }
           fin = fin * fin;
           end = end + fin;
          
        }
           return end;
    }
    
}