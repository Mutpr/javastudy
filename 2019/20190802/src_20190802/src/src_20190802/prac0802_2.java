/*
 * �ΰ��� �ֻ����� ������ �� ������ ���� ����ϰ�, ���� ���� 5�� �ƴϸ� ��� �ֻ����� ������,
 * ���� ���� 5�̸� ������ ���ߴ� �ڵ� �ۼ�
 */
package src_20190802;

import java.util.*;

public class prac0802_2 {
	public static void main(String args[]) {
		
		while(true){ //�ϴ� ����ȴ�
			
			int num1 = //�ʱ�ȭ��
					(int)(Math.random()*6)+1; //����ȯ //math.random���� ������ ���ش�.
			int num2 = //�ʱ�ȭ ��
					(int)(Math.random()*6)+1; //����ȯ //math.random���� ���� ǥ���� ���ش�.
			
			if(num1+num2==5) { //num1�� num2�� ���ؼ� 5�̸� 
				System.out.print("("+num1+","+num2+")"); //���� ����ϰ�
				break;//�ݺ����� ����������
			}else{ //5�� �ƴ϶�� �ƴ϶��
				System.out.print("("+num1+","+num2+")"); //��� �ݺ��Ѵ�.
				}
		}
		}
	}