package src3_210806;

public class MyDetailInfo extends MyInfo{
	String number;
	String univ;
	
	public MyDetailInfo(String name, int age) {
		super(name, age);
		this.name = name;
		this.age = age;
	}
	
	public String numberSetting() {
		return number;
	}
	
	public String UnivSetting() {
		return univ;
	}
	
	public void getInfo(String number, String univ) {
		this.number=number;
		this.univ=univ;
	}
	
	public String toString() {
		return "�̸�:"+super.name+"\n ����:"+super.age+"\n ��ȣ: "+number+"\n ����: "+univ;
	}
	}