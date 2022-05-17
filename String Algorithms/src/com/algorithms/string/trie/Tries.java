package com.algorithms.string.trie;

public class Tries {

	private final TrieNode root;
	
	Tries(){
		root = new TrieNode();
	}
	class TrieNode{
		char data;
		TrieNode[] syllable;
		int stringRepeatCounter;
		boolean isTerminating;
		
		public TrieNode() {
			syllable = new TrieNode[26];
		}
		public TrieNode(char data) {
			this();
			this.data = data;
		}
	}
	
	public void insertIntoTrie(String input) {
		input = input.toLowerCase();
		TrieNode currNode = root;
		for(int index=0;index<input.length();index++) {
			int charIndex = input.charAt(index)-'a';
			if(currNode.syllable[charIndex]==null) {
				currNode.syllable[charIndex] = new TrieNode(input.charAt(index));
			}
			currNode = currNode.syllable[charIndex];
		}
		currNode.isTerminating=true;
	}
	
	public boolean searching(String input) {
		input = input.toLowerCase();
		TrieNode currNode = root;
		for(char letter: input.toCharArray()) {
			if(currNode.syllable[letter-'a']==null) {
				return false;
			}
			currNode = currNode.syllable[letter-'a'];
		}
		return true;
	}
	
//	public void deleteString(String input) {
//		input = input.toLowerCase();
//		TrieNode currNode = root;
//		for(char letter: input.toCharArray()) {
//			if(currNode.syllable[letter-'a']==null) {
//				return;
//			}else {
//				
//			}
//			currNode = currNode.syllable[letter-'a'];
//		}
//	}
	
	public static void main(String[] args) {
		String string1 = "Sundera";
		String string2 = "Sun";
		String string3 = "Sunderamurthy";
		String string4 = "Sundi";
		Tries triesDSA = new Tries();
		triesDSA.insertIntoTrie(string1);
		triesDSA.insertIntoTrie(string2);
		triesDSA.insertIntoTrie(string3);
		triesDSA.insertIntoTrie(string4);
		System.out.println(triesDSA.searching("a"));
	}
}
