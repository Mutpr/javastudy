import java.util.*;
public class src2_20200129 {
	public static void main(String args[]) {
		week Today = null;
		
		Calendar CAL = Calendar.getInstance();
		int Week = CAL.get(Calendar.DAY_OF_WEEK);
		
		switch(Week) {
		case 1:
			Today = week.SUNDAY;
			break;
		case 2:
			Today = week.TUESDAY;
			break;
		case 3:
			Today = week.WEDNESDAY;
			break;
		case 4:
			Today = week.THURSDAY;
			break;
		case 5:
			Today = week.FRIDAY;
			break;
		case 6:
			Today = week.SATURDAY;
			break;
		case 7:
			Today = week.SUNDAY;
			break;
			
		}
		
		System.out.println("���� ����:" + Today);
		
		if(Today == week.SUNDAY) {
			System.out.println("�Ͽ��Ͽ��� �౸�� �մϴ�.");
		}else {
			System.out.println("������ �ڹ� ���� �մϴ�.");
		}
	}
}