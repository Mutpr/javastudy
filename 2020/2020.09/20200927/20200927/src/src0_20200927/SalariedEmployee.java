package src0_20200927;

class SalariedEmployee extends Person{
	protected int hourIncome; 
	
	@Override
	public int computeSalary() { //�ӱ� ���
		//�ð��� �ӱ� * ���� �ð� ��ȯ
		hourIncome = hourIncome*12;
		return hourIncome;
	}
	
	public SalariedEmployee(String name, int emp, int hour) {
		super(name, emp);
		hourIncome = hour;
	}
	
	@Override
	public String toString() {
		super.toString();
		return "�ð��� �ӱ�> "+hourIncome;
	}
	
	}
