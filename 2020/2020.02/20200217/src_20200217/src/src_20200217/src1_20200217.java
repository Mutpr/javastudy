package src_20200217;

import java.util.*;
public class src1_20200217 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int line = scan.nextInt();
		
		for(int i=1; i<=line; i++) {
			for(int j=4; j>=i; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k<=i; k++) {
				System.out.print("*");
			}System.out.println();
		}
	}
}