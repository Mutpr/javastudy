package src2_20201012;


import java.util.*;
public class Answer_02 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int select;
		String song = null;
		
		Media media = new Media() {
			void play(String instru) {
				 System.out.println(instru+" ����մϴ�. ");
			}

			void stop(String instru) {
				System.out.println(instru + " �����մϴ�. ");
			}
		};
		
		System.out.println("��⸦ �����ϼ���.");
		System.out.println("1. mp3 2. CDplay 3. WindowMediaPlay");
		
		switch (select=scan.nextInt()) {
		
		case 1:
			System.out.println("MP3�� ����մϴ�.");
			/* song = scan.nextLine(); */
			media.play("MP3");
			media.stop("MP3");
			break;
			
		case 2:
			System.out.println("CDplay�� �����ϼ̽��ϴ�.");
			media.play("CDplay");
			media.stop("CDplay");
			break;
			
		case 3: 
			System.out.println("WindowMediaPlayer �� �����ϼ̽��ϴ�.");
			media.play("WindowMediaPlayer");
			media.stop("WindowMediaPlayer");
			break;
		}

	}

}