package com.datastructure.unrolledlinked.runner;

import com.datastructure.unrolledlinked.implementation2.UnRolledLinkedListImpl;

public class UnRolledLinkedListRunner {

	public static void main(String[] args) {
		UnRolledLinkedListImpl<String> UnRolledLLRunner = new UnRolledLinkedListImpl<String>(5);
		UnRolledLLRunner.addData("1");
		UnRolledLLRunner.addData("2");
		UnRolledLLRunner.addData("3");
		UnRolledLLRunner.addData("4");
		UnRolledLLRunner.addData("5");
		UnRolledLLRunner.addData("112");
		UnRolledLLRunner.addData("12");
		UnRolledLLRunner.addData("10");
		UnRolledLLRunner.addData("13");
		UnRolledLLRunner.addData("114");
		UnRolledLLRunner.addData("14");
		UnRolledLLRunner.printLL();
	}
}