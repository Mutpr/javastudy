package Forsrc_20200212;

import java.util.*;
public class src_For_No1 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int i = scan.nextInt();
		
		for(int j = 1; j<9; j++) {
			System.out.println(i + "X" + j + "=" + i*j );
		}
		}
}