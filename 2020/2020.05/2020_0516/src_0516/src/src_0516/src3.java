package src_0516;

import java.util.*;
public class src3 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);

		String[] hexa2bin = {"0000", "0001", "0010", "0011","0100", "0101", 
				"0110", "0111","1000", "1001", "0010", 
				"0011","1100", "1101", "1110", "1111"};
		String[] bin2HEXA =	{"0", "1", "2", "3",  "4", "5", "6", "7",
							"8", "9", "A", "B", "C", "D", "E", "F"};
		String[] bin2hexa =	{"0", "1", "2", "3","4", "5", "6", "7",
							"8", "9", "a", "b","c", "d", "e", "f"};

			System.out.print("16���� ���ڿ��� �Է��Ͻÿ�: ");

		String userHex = scan.next();

		for (int i=0; i< userHex.length(); i++){
			for(int j=0; j <bin2hexa.length; j++) {
				if(userHex.equals("s")||userHex.equals("S")) {
				System.out.println("�����մϴ�.");
				break;
				}else {
					if ( userHex.substring(i,i+1).compareTo(bin2hexa[j])==0) {
						System.out.print(hexa2bin[j]+ " ");
						break;
						
					}
					else if ( userHex.substring(i,i+1).compareTo(bin2HEXA[j])==0) {
						System.out.print(hexa2bin[j]+ " ");
						break;
					}
						
						
				}

			}
		}
		
}
}
