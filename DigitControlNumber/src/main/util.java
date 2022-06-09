package main;
import java.util.*;
public class util {
	
	public static String getRandomNumberString() {
		// TODO Auto-generated method stub
		Random rnd = new Random();
	    int number = rnd.nextInt(999);
	    return String.format("%03d", number);

	}
	
	public static void Multiply(String Display) {
		// TODO Auto-generated method stub
		List<Integer> l3 = new ArrayList<Integer>(); 
		for(char ch : Display.toCharArray()) { 
		    l3.add( Integer.valueOf(String.valueOf(ch))); 
		} 
		//System.out.println("Integer at list "+l3.size());
		
		int Total=0;
		int lastS=0;
		int j=0;
		for(int i=1 ;i<=l3.size();i++){
			
			//System.out.println(i+"x"+l3.get(j)+" = "+i*l3.get(j));
            Total += i*l3.get(j);
            j++;
		}
		
        Integer reminder = Math.floorMod(Total, 11);
            if (reminder==10) {
            	 lastS=1;
            } else {
            	lastS=reminder;
           }
       //System.out.println("Total "+Total+" reminder "+reminder+" lastS "+lastS);
            
	   System.out.println("13 Digit DCN Number of user is "+Display+lastS);
	       
	}
	
}
