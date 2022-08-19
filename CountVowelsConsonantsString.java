package Ineuron_Java;

import java.util.Scanner;

public class CountVowelsConsonantsString {

	public static void main(String[] args) {
		
		String str1;
		
		String str2;
		
		String vowels = "aeiou";
		
		int count=0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a String");
		
		str1 = scan.nextLine();		
		
		str2 = str1.toLowerCase();
		
		for(int i=0;i<str2.length();i++) {
			
			int num=0;
			
			num=vowels.indexOf(str2.charAt(i));
			
			if(num>=0) {
				
				count++;
				}
			//System.out.println(count);
			}
		
			System.out.println(count);
			System.out.println("Number of vowels = "+ count);
			System.out.println("Number of consonants = "+ (str2.length()-count));
		}
		
		

	}


