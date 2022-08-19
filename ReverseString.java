package Ineuron_Java;

public class ReverseString {

	public static void main(String[] args) {
		
		String str1 = "iNeuron";
		String str2 = "";
		
		//without using inbuilt method
		
		for(int i=str1.length()-1;i>=0;i--) {
			
			str2 = str2 + str1.charAt(i);
		}
		
		System.out.println(str2);
		
		//Using inbuilt method
		
		StringBuffer str3 = new StringBuffer("iNeuron");
		System.out.println(str3.reverse());
		
	}	
		}
