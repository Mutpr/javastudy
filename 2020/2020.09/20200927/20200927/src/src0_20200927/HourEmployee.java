package src0_20200927;

class HourEmployee extends Person{
	protected int income;
	protected int workHour;
	int totalIncome;
	
	@Override
	public int computeSalary() { //�ӱ� ���
		//�ð��� �ӱ� * ���� �ð� ��
		totalIncome = income*workHour;
		return totalIncome;
	}
	
	public HourEmployee(String name, int emp, int in, int work) {
		super(name, emp);
		// TODO Auto-generated constructor stub
		income = in;
		workHour = work; 
	}
	
	@Override
	public String toString() {
		super.toString();
		return "���� �ð�> "+workHour
				+"�ð��� �ӱ�> "+income 
				+"�� �ӱ�> "+totalIncome;
	}
}