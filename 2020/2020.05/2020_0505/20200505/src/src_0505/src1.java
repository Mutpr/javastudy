package src_0505;

/*
 * 
���� 11022��
�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����.
�� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����. (0 < A, B < 10)
�� �׽�Ʈ ���̽����� "Case #x: A + B = C" �������� ����Ѵ�. x�� �׽�Ʈ ���̽� ��ȣ�̰� 1���� �����ϸ�, C�� A+B�̴�.
 */

import java.util.*;

public class src1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 1; i<=t; i++ ) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			
			if(A>0 && B<10) {
				System.out.println("Case #"+ i+": "+ A + " + "+ B +" = "+(A+B));
			}else {
				continue;
			}
		
		}
		
		
	}
}