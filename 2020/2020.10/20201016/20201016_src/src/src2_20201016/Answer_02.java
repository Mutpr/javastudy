package src2_20201016;

public class Answer_02 {

	public static void main(String[] args) {
		System.out.print(max(4,6,9,23,6));
	}
	

	private static int max(int a, int b, int c, int d, int e) {
		int [] array1 = {a, b, c, d, e};
		int max = 0;
		for(int i =0; i<=array1.length-1; i++) {
			if(max<array1[i]) {
				max = array1[i];
				}
			}
				return max;
	}
	}
