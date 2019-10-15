package implement;

import java.util.*; 
import java.io.*;

class Occupancy {  
	public static int[] calculateOccupancy(int[] initial) throws Exception {
		for(int i=0; i < initial.length; i++) {
			if(i == 0) {
				initial[i] = calculation(0, initial[i+1]);
			} else if(i == initial.length-1) {
				initial[i] = calculation(initial[i-1], 0);
			} else {
				initial[i] = calculation(initial[i-1], initial[i+1]);
			}
			
		}
		return initial; 

	}
	private static int calculation(int left, int right) throws Exception {		
		if((left == 0 && right == 0) || (left == 0 && right == 0)) {
			// both neighbors are at home or away
			return 1;
		} else if((left == 0 && right == 1) || (left == 1 && right == 0)) {
			return 0;
		} else {
			throw new Exception();
		}
	}	

	public static void main (String[] args) throws Exception {  
		//Scanner s = new Scanner(System.in);
		System.out.print(calculateOccupancy(new int[] {1,1,0,0,1,0,1})); 
	}   

}


