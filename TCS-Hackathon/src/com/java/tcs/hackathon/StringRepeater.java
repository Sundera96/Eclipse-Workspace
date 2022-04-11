package com.java.tcs.hackathon;

public class StringRepeater {

	public static void main(String[] args) {
		String input = "156888011065";
		String input2 = "aabbbccsssn";
		System.out.println(removeKRepeatedChar(input2.toCharArray(),3));
	}
	
	private static String removeKRepeatedChar(final char[] inputString, final int k) {
		int index=0;
		int basePtr=-1;
		while(index<inputString.length) {
			if(basePtr==-1||inputString[index]!=inputString[basePtr]) {
				basePtr++;
				inputString[basePtr]=inputString[index++];
			}else {
				int canOmit=0;
				while(inputString[index]==inputString[basePtr]) {
					index++;
					canOmit++;
				}
				if(canOmit==k-1) {
					basePtr--;
				}else {
					int backIndex=index-1;
					while(canOmit!=0) {
						inputString[++basePtr]=inputString[backIndex--];
						canOmit--;
					}
				}
			}
		}
		return String.valueOf(inputString).substring(0,basePtr+1);
	}
}
