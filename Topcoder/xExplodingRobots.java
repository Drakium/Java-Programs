//Christian Solano
//CSC 199
//Topcoder SRM 681 ExplodingRobots
//Points- Challenged for them so 0
//Data from contest

public class xExplodingRobots{
    int[] r1 = {0,0};
    int[] r2 = {0,0};
    
    public String canExplode(int x1, int y1, int x2, int y2,String instructions){
        r1[0] = x1;
        r1[1] = y1;
        r2[0] = x2;
        r2[1] = y2;
        if (instructions.charAt(0) == 'U'){
         r1[1] = y1+1;   
         r2[1] = y2+1;
            if (r1 == r2){
                return "explode"; 
            }else {return "safe";}
        }
        if (instructions.charAt(0) == 'D'){
         r1[1] = y1-1;   
         r2[1] = y2-1;
            if (r1 == r2){
                return "explode"; 
            }else {return "safe";}
        }
        
        if (instructions.charAt(0) == 'L'){
         r1[1] = x1-1;   
         r2[1] = x2-1;
            if (r1 == r2){
                return "explode"; 
            }else {return "safe";}
        }
        if (instructions.charAt(0) == 'R'){
         r1[1] = x1+1;;   
         r2[1] = x2+1;
            if (r1 == r2){
                return "explode"; 
            }else {return "safe";}
        }
        
        return "explode";
    }
}