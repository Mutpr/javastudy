package src0_20200927;

public class Person {
	protected String name;
	protected int EmpNumber; 
	
	public Person(String na, int emp) {
		name = na;
		EmpNumber = emp;
	}
	
	int computeSalary() {
		return 1;
	}
	
	public String getName() {
		return name;
	}

	public int getEmpNumber() {
		return EmpNumber;
	}
	
	public String toString() {
		System.out.println("�̸�> "+name +"\n"+"���> "+EmpNumber);
		return name+EmpNumber;
				
	}

}
