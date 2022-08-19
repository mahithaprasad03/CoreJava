package Ineuron_Java;

import java.util.Scanner;

public class RepeatedCharacterString {

	public static void main(String[] args) {
		
		String str1;
		
		String str2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a String");
		
		str1 = scan.nextLine();
		
		str2 = str1.toLowerCase();
		
		if(str2.isBlank()) {
			
			System.out.println("Blank string, execute again by entering a string value");
		}
		
		for(int i=0;i<str2.length();i++) {
			
			char a = str2.charAt(i);
			
			int count=0;
			
			for(int j=0;j<str2.length();j++) {
				
				if(a==str2.charAt(j)) {
					
					count++;
					
					if(count>1) {
					
					System.out.println(a);
					
					break;
					
					}
				}
			}
		}
		

	}

}
