package src1_20201018;

import java.util.*;
public class DistanceComp {
	public void longDistance(Distance [] distance) {
		Scanner scan = new Scanner(System.in);
		distance = new Distance[scan.nextInt()];
		int max = distance[0].getDist();
		int value;
		for(int i = 0; i<=distance.length-1; i++) {
			System.out.println("�̸��� �Ÿ��� �Է��ϼ���.");
			distance[i].setName(scan.nextLine());
			distance[i].setDist(scan.nextInt());
			value = distance[i].getDist();
			if(value>max) {
				max = value;
			}
		}
	}
}