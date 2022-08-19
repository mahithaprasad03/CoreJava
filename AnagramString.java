package Ineuron_Java;

import java.util.Scanner;

public class AnagramString {

	public static void main(String[] args) {
		
		String str1;
		
		String str2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the first string");
		
		str1 = scan.nextLine();
		
		String str3 = str1.toLowerCase();
		
		System.out.println("Enter the second string");
		
		str2 = scan.nextLine();
		
		String str4 = str2.toLowerCase();
		
		if(str3.length()!= str4.length()) {
			
			System.out.println("Given strings are not an anagram");			
		}
		
		else if(str3.isBlank()|| str4.isBlank()) {
			
			System.out.println("Blank strings, execute again by entering string values");
		}
		
		else {
			
			
			int num=0;	
			int count1 =0;
			int count2=0;
				
				for(int j=0;j<str3.length();j++) {	
				 
				 if(num==-1) {
					 
					 System.out.println("Given string are not an anagram");
					 break;
				 }
				 
				 else {
					 
					 num = str3.indexOf(str4.charAt(j));
					 
					 for(int i=0;i<str3.length();i++) {
						 
						 if(str3.charAt(j)== str4.charAt(i)) {
							 
							 count2++;
						 }
						 
						 if(str3.charAt(j)== str3.charAt(i)) {
							 
							 count1++;
						 }			 
						 
					 }
					 
					 if(count1!=count2) {
						 
						 System.out.println("Given strings are not an anagram");
						 break;
					 }
					 
				 }
							
			}
				
				if(num!=-1 && count1==count2) {
					
					System.out.println("Given strings are an anagram");
				}						
		}
		
		}
	
	}
	


	


