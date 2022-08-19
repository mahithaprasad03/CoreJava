package Ineuron_Java;

import java.util.Scanner;

class CheckPangram{
	
	String str2 = "abcdefghijklmnopqrstuvwxyz";
	
	int num;
	
	public void pangram (String str) {
		
		String str1 = str.toLowerCase();
		
		System.out.println(str1);
		
		for(int j=0;j<str2.length();j++) {
		
		num = str1.indexOf(str2.charAt(j));
	
		System.out.println(num);
		
		if(num<0) {
			
			System.out.println("Given string is not a pangram");
			break;
		}
		 
	 }
		
		if(num>=0) {
			
			System.out.println("Given string is a pangram");
		}
	}
}

public class PangramString {

	public static void main(String[] args) {
		
		String str1;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the string to check whether it is pangram");
		
		str1 = scan.nextLine();
		
		if(str1.isBlank()) {
			
			System.out.println("Blank string, execute again by entering a string value");
		}
		
		else if(str1.length()<26) {
			
			System.out.println("Given string is not a pangram");
		}
		
		
		else {
			
			CheckPangram obj = new CheckPangram();
			
			obj.pangram(str1);
		}

	}

}
