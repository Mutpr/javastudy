package src3_20201012;

public class Answer_03 {

	public static void main(String[] args) {
		Operation oper = null;
		oper = new Hair("�� �Ӹ�");
		run(oper);
		Hair.tint("brown");
		oper = new Fruit("���");
		run(oper);
		Fruit.pack("10");
	}

	private static void run(Operation oper) {
		oper.wash();
		oper.cut();
	}
	
	
	}