package chap06;

import java.util.Scanner;

public class bakjun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int[] mod = new int[10];
		int count = 0;
		
		for(int i = 0; i<mod.length;i++)
		{
			// 카운트 초기화
			count = 0;
			// 입력
			int num = Integer.parseInt(input.nextLine());
			
			for(int j = 0;j<=i;j++) {count += mod[j]==mod[i]?1:0;}
			
			mod[i] = num%42;
		}
		
		if(count==mod.length){count = mod.length+1-count;}
		
		else if(count == 1){count = mod.length;}
		
		else {count = (mod.length-1)-count;}
		
		System.out.println(count);
	}
}
