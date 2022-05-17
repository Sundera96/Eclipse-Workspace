package com.algorithms.string;

public class StringSearchAlgorithms {

	public static void main(String[] args) {
		StringSearchAlgorithms stringSearchAlgorithmsRunner = new StringSearchAlgorithms();
		char[] pattern = "dsgwadsgz".toCharArray();
		char[] string = "adsgwadsxdsgwadsgz".toCharArray();
		stringSearchAlgorithmsRunner.kmpAlgorithm(string,pattern);
	}
	
	// 
	public void kmpAlgorithm(char[] inputString,char[] stringToBeMatched) {
		int[] table = prefixTable(stringToBeMatched,stringToBeMatched.length);
		int stringIndex = 0;
		int patternIndex = 0;
		while(stringIndex<inputString.length) {
			if(inputString[stringIndex]==stringToBeMatched[patternIndex]) {
				if(patternIndex==stringToBeMatched.length-1) {
					System.out.println("String Matched ");
					return;
				}
				stringIndex++;
				patternIndex++;
			}else if(patternIndex>0) {
				patternIndex = table[patternIndex-1];
			}else {
				stringIndex++;
			}
		}
	}
	
	
	//dsgwadsgz
	private int[] prefixTable(char[] string, int m) {
		int[] indexArr = new int[m];
		int index =1;
		int prefixIndex=0;
		while(index<m) {
			if(string[index]==string[prefixIndex]) {
				indexArr[index]=prefixIndex+1;
				prefixIndex++;
				index++;
			}else if(prefixIndex>0) {
				prefixIndex--;
			}else {
				index++;
			}
		}
		return indexArr;
	}
	
}
