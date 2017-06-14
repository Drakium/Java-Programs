public class ParenthesesDiv2Easy{
 public static void main(String[] args){
    String z = "(((((((((((((((((((((())))))))))))))))))))))";
    System.out.println(getDepth(z));
    
    
    }
    public static int getDepth(String s){
        int max = 0;
        int newm = 0;
        for(int i =0; i< s.length(); i++){
            if (s.charAt(i) == '('){
             max = max +1; 
            }
            if (s.charAt(i) == ')'){
              
            	if (newm <= max  ){
           		  newm= max; 
                  max = 0;
           	    }
                max = 0;
            }
       //     max = 0;
            
        }
        return newm;
    }
    
}