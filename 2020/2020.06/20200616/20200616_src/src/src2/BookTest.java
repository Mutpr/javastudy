package src2;

public class BookTest {
	public static void main(String [] args) {
		Magazine bookA = new Magazine("��1","280","�������� ��������","");
		Magazine bookB = new Magazine("��ѱ�", "104","��Ʈ��ũ �㽺ŲƮ","");
		
		bookA.setInfo("�߸�����: 2020�� 3��");
		bookB.setInfo("�߸�����: 2000�� 3��");
		
		System.out.println(bookA);
		System.out.println(bookB);
		
	}
}