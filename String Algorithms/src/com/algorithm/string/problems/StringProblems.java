package com.algorithm.string.problems;

public class StringProblems {
	
	public class Coordinates{
		final int x;
		final int y;
		public Coordinates(int x,int y) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
		}
	}

	private static void combinationOfString(String prefix, String str) {
		if(str.length()>0) {
			System.out.println(prefix+str.charAt(0));
			combinationOfString(prefix+str.charAt(0),str.substring(1));
			combinationOfString(prefix,str.substring(1));
		}
	}
	
	public static void main(String[] args) {
		//combinationOfString("","sun");
		//char[][] matrix = {{'a','c','p','r','c'},{'x','s','o','p','c'},{'v','o','v','n','i'},{'w','g','f','m','n'},{'q','a','t','i','t'}};
		//String word = "microsoft";
		StringProblems problems = new StringProblems();
		System.out.println(problems.patternMatching("abcabczzzde","*abc???de*"));
		//System.out.println(problems.findWord(matrix, word));
		
	}
	
	private boolean findWord(final char[][] matrix, final String word) {
		word.toLowerCase();
		final int[] wordToMatch = new int[26];
		boolean[][] isVisited;
		int[] wordsMatched;
		for(int index=0;index<word.length();index++) {
			wordToMatch[word.charAt(index)-'a']+=1;
		}
		for(int rowIndex=0;rowIndex<matrix.length;rowIndex++) {
			for(int colIndex=0;colIndex<matrix[0].length;colIndex++) {
				wordsMatched = new int[26];
				isVisited = new boolean[matrix.length][matrix[0].length];
				if(toProcessCell(wordToMatch,wordsMatched,matrix[rowIndex][colIndex])>0) {
					//consider the matrix location as a start and run a dfs search
					System.out.println(matrix[rowIndex][colIndex]+"   ##############################");
					if(dfs(matrix,wordToMatch,wordsMatched,new Coordinates(rowIndex,colIndex),word.length()-1,isVisited)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	

	private boolean dfs(char[][] matrix, int[] wordToMatch, int[] wordsMatched, Coordinates location,
			int matchedCount, boolean[][] isVisited) {
		if (matchedCount == 0) {
			return true;
		}
		if(toProcessCell(wordToMatch, wordsMatched, matrix[location.x][location.y]) > 0) {
			wordsMatched[matrix[location.x][location.y] - 'a'] += 1;
			isVisited[location.x][location.y]=true;
			for (int rowIndex = location.x - 1; rowIndex <= location.x + 1; rowIndex++) {
				for (int colIndex = location.y - 1; colIndex <= location.y + 1; colIndex++) {
					if (rowIndex >= 0 && rowIndex < matrix.length && colIndex >= 0 && colIndex < matrix[0].length
							&& !(rowIndex == location.x && colIndex == location.y)) {
						if (!isVisited[rowIndex][colIndex]) {
							if (toProcessCell(wordToMatch, wordsMatched, matrix[rowIndex][colIndex]) > 0) {
								System.out.println(matrix[location.x][location.y]+" --> "+matrix[rowIndex][colIndex]+"  Matched Elements "+ matchedCount);
								boolean flag = dfs(matrix, wordToMatch, wordsMatched, new Coordinates(rowIndex, colIndex),
										matchedCount - 1,isVisited);
								if (flag) {
									return true;
								}else {
									wordsMatched[matrix[rowIndex][colIndex] - 'a'] -= 1;
									isVisited[rowIndex][colIndex]=false;
								}
							}
						}

					}
				}
			}
		}
		return false;
	}
	
	private int toProcessCell(int[] wordsToMatch,int[] wordsMatched,char c) {
		return wordsToMatch[c-'a']-wordsMatched[c-'a'];
	}
		
	/*
	 *  Patterns are ? and *
	 *  ? char matches with any character found in the text
	 *  * matches series of characters or strings including an exact match
	 */
	public boolean patternMatching(String text, String pattern) {
		int textIndex = 0;
		int patternIndex = 0;
		boolean canSkip = false;
		int lastAstrixIndex = -1;
		while (textIndex < text.length()) {
			if(patternIndex==pattern.length()) {
				if(lastAstrixIndex==patternIndex-1) {
					break;
				}else {
					return false;
				}
			}
			char c = pattern.charAt(patternIndex);
			if (c == '?') {
				if (text.charAt(textIndex) >= 97 && text.charAt(textIndex) <= 122) {
					textIndex++;
					patternIndex++;
				}
			} else if (c == '*') {
				lastAstrixIndex = patternIndex++;
				canSkip = true;
			} else if (c == text.charAt(textIndex)) {
				textIndex++;
				patternIndex++;
				canSkip = false;
			} else if (canSkip) {
				textIndex++;
			} else {
				if(lastAstrixIndex!=-1) {
					patternIndex = lastAstrixIndex;
					canSkip = true;
				}else {
					return false;
				}
			}
		}
		while(patternIndex<pattern.length()) {
			if(pattern.charAt(patternIndex)!='*') {
				return false;
			}
			patternIndex++;
		}
		return true;
	}
	
}
