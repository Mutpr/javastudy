package src_20200608;

public class Service {
	String id;
	int pass;
	
	public static boolean login (String id, int pass) {
	//�Ű����� id ���� hallym, pass�� 3456�� ��쿡�� true�� �����ϰ�
	//�� ���� ���� false�� �����ϴ� ���� ����� �� ��
		if(id.equals("hallym") && pass == 3456 ) {
			return true;
			
		}else {
			return false;
		}	
		}
	
	public static void logout(String id) {
		System.out.println(id+" �� �α׾ƿ� �Ǿ����ϴ�.");
		return;
	}
}