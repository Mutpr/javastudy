package Pack_20190718;

import java.util.*;

public class src1 {
	public static void main(String args[]) {
		
		//src1_2 src = new src1_2();
		
		Scanner sc = new Scanner(System.in);
		
		int a;
		int b;
		int sum=0;
		String inputString;
		
		do { 
			System.out.println("���ɾ �Է����ּ���."); 
			System.out.println("p: �ջ����α׷�");
			System.out.println("q: ���α׷� ����");
			inputString = sc.nextLine();
			//System.out.println(inputString);
			
			if(inputString.equals("p")) { //Ű����� ������ p�� �´ٸ� if�� �����Ѵ�.
				System.out.println("���ۼ��ڸ� �Է��Ͻÿ�:");
				a = sc.nextInt(); //a�� Ű����� �޴´�.
				System.out.println("������ڸ� �Է��Ͻÿ�:");
				b = sc.nextInt(); //b�� Ű����� �޴´�.
				
				for(; a<=b; a++) { //a���� b������ �ջ��ϴ� �ݺ���.
					sum += a;	//sum�� a�� ���� ���� �ִ´�.
				} System.out.println(sum); 
				
			} break;//do-while �ݺ������� �������´�.
		
				
		} while(!inputString.equals("q")); {
			//System.out.println();
			System.out.println("���α׷��� �����մϴ�."); //do-while �����̶� while�� ������ �ѹ� ����ȴ�.

		}
			
			
	 }
}	