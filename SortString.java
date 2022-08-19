package Ineuron_Java;

import java.util.Arrays;
import java.util.Scanner;

public class SortString {

	public static void main(String[] args) {
		
		String str1;
		
		String str2;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a String");
		
		str1 = scan.nextLine();		
		
		str2 = str1.toLowerCase();
		
		//Using sort method
		
		char []a=str2.toCharArray();
		
		Arrays.sort(a);
		
		System.out.println(a);
		
		//without using sort method
		
		for(int i=0;i<a.length;i++) {
			
			for(int j=0;j<a.length;j++) {
				
			if(a[i]<a[j]) {
				
				char temp =a[i];
				a[i]=a[j];
				a[j]=temp;
			}
			}			
		}
		
		System.out.println(a);
	}

}
