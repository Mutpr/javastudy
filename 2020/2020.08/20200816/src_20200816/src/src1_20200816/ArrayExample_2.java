package src1_20200816;

import java.util.*;
public class ArrayExample_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score [];
		int sub = scan.nextInt();
		score = new int[sub];
		
		
		//int i;
		int count = 0;
		
		for(int i=0; i<=score.length-1; i++) {
			score[i] = (int) (Math.random()*10+1);
			count++;
			System.out.println(score[i]);
		}
		
		System.out.println("�迭�� ����: "+count);
		
	}

}