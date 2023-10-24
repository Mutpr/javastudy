
public class MainStringArrayArgument {
	public static void main(String args[]) {
		/*
		 * (String args[]): java Ŭ������ ���α׷��� �����ϸ� 
		 * JVM�� ���̰� 0�� *string �迭�� ���� ����*�ϰ� 
		 * main() �޼ҵ带 ȣ���Ҷ� �Ű������� �����Ѵ�.
		 * "java Ŭ����" �ڿ� �������� ���е� ���ڿ� ����� �ְ� �����ϸ� 
		 * String �迭�� ����, main() �޼ҵ带 ȣ���Ҷ� �Ű������� ����.
		 * main() �޼ҵ�� string[] args �Ű� ������ ���ؼ� Ŀ�ǵ� ���ο���
		 * �Էµ� �������� ���� �Էµ� �����͸� �� �� �ְ� ��.
		 */
		if(args.length != 2) { //�Էµ� ������ ������ �ΰ��� �ƴ� ���
			System.out.println("���α׷��� ����");
			System.out.println("java MainStringArrayArgument num1 num2");
			System.exit(0);
		}
		
		String StrNum1 = args[0]; //ù��° ������ ���
		String StrNum2 = args[1]; //�ι�° ������ ���
		
		int num1 = Integer.parseInt(StrNum1); //���ڿ��� ������ ��ȯ
		int num2 = Integer.parseInt(StrNum2); //���ڿ��� ������ ��ȯ
		
		int result = num1+num2;
		System.out.println(num1 + "+" + num2 + "=" + result);
		
		//������ �����ϸ� �Ű����� ���� �ʾ� ���� 0�� String �迭�� �Ű������� ���޵�.
	}

}