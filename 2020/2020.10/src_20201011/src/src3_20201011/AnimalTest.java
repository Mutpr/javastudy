package src3_20201011;

public class AnimalTest {
	public static void play(Animal ani) {
		ani.run();
		ani.sound();
	}
	public static void main(String[] args) {
		Animal animal = new Baby("�Ż���");
		play(animal);
		animal = new Dog("������");
		play(animal);
	}

}