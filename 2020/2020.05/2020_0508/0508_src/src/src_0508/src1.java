package src_0508;

import java.util.*;

public class src1 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int max = 1; 
		int value; 
		int [] array1 = new int[9];
		int index = -1;
		int i;
		
		for(i =0; i<=array1.length-1; i++) {
			array1[i] = scan.nextInt();
			value = array1[i];
			
			if(max<value) {
				max = value;
				index = i+1;
			}
		}System.out.println(max);
		System.out.println(index);
		
		
		
		
	}

}