package com.list.skip.runner;

import com.list.skip.impl.SkipListImpl;

public class SkipListRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SkipListImpl<Integer,String> skipList = new SkipListImpl<Integer,String>();
		skipList.add(1, "sundera");
		skipList.add(2, "undera");
		skipList.add(3, "ndera");
		skipList.add(4, "dera");
		skipList.add(5, "era");
		skipList.add(6, "ra");
		skipList.add(7, "a");
		skipList.add(8, "1");
		skipList.add(9, "2");
		skipList.add(10, "3");
		skipList.add(11, "4");
		skipList.add(12, "5");
		skipList.add(13, "6");
		skipList.add(14, "7");
		skipList.remove(14);
		skipList.remove(2);
		skipList.remove(5);
		skipList.printSkipList();
	}

}
