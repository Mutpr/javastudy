package src_0516;

import java.util.*;
public class src4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int yeol = scan.nextInt();
		int hang = scan.nextInt();
		int [][] array1 = new int [yeol][hang];
		int num = 1;
		
		for(int l = 1; l<=array1.length-1; l++) {
			System.out.println();
			for(int k = 1; k<=array1[l].length-1; k++) {
				 array1[l][k]=num;
				 System.out.print(array1[l][k]+"\t");
				 num++;
			}
		
		}
	
	}

}