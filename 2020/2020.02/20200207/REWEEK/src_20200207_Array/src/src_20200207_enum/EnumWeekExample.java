package src_20200207_enum;
import java.util.*;

public class EnumWeekExample {
	public static void main(String args[]) {
		week today = null; // ����Ÿ�� ���� ����
		
		Calendar cal = Calendar.getInstance(); 
		int Week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(Week) {
		case 1:
			today = week.sunday; //���� ��� ����
			break;
		case 2:
			today = week.monday;
			break;
		case 3:
			today = week.tuesday;
			break;
		case 4:
			today = week.wednesday;
			break;
		case 5:
			today = week.thursday;
			break;
		case 6:
			today = week.friday;
			break;
		case 7:
			today = week.saturday;
			break;
		}
		
	}
}