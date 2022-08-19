package Ineuron_Java;

import java.util.Scanner;

public class CountSpecialCharacteers {

	public static void main(String[] args) {
		
		String str1;
		
		String str2;
		
		int count=0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a String");
		
		str1 = scan.nextLine();		
		
		str2 = str1.toLowerCase();
		
		for(int i=0;i<str2.length();i++) {
			
			if(!(str2.charAt(i)>=97 && str2.charAt(i)<=122 || str2.charAt(i)>='0'&& str2.charAt(i)<='9')) {
				
				count++;
				
				System.out.println(str2.charAt(i));
			}
		}
		
		System.out.println(count);
	}
}
