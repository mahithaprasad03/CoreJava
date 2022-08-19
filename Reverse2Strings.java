package Ineuron_Java;

public class Reverse2Strings {

	public static void main(String[] args) {
		
		String str1="Think Twice";
		String str2="";
		
	
		String []str3 = str1.split(" ");
		
		for(int i=0;i<str3.length;i++) {
		
			for(int j=(str3[i].length())-1; j>=0;j--) {
				
				str2 = str2 + str3[i].charAt(j);
			}
			
			str2 = str2 + " ";
		}
		
		System.out.println(str2);
		
	}

}
