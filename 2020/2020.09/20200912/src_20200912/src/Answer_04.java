
import java.util.*;
public class Answer_04 {
	public static void main(String[] args) {
		
		String[] title= {"�ڹ�", "���̽�", "�ڵ�", "�ڹٽ�ũ��Ʈ","�ڷᱸ��"};
		int[] pages= {150, 100, 120, 200, 180};
		int max_page=max_index(pages);
		
		System.out.println("�ִ� ������ �� : " + pages[max_page]);
		System.out.println("�ִ� ���������� ���� å : " + title[max_page]);
	}

	static int max_index(int...max) {
		int max_index = max[0];
		for(int i =0; i<=max.length-1; i++) {
			if(max_index < max[i])
				max_index = max[i];
		}
		return max_index;
	}

}