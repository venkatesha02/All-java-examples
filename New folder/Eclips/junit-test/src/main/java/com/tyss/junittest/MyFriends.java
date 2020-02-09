package com.tyss.junittest;

import java.util.ArrayList;

public class MyFriends {

	private ArrayList<String> al = new ArrayList<String>();
	
	public MyFriends() {
		al.add("Vinay");
		al.add("mayuri");
		al.add("rowdi");
		al.add("venki");
	}

	public String getName() {
		
		if(al.size()==0) {
			return null;
		}else {
			return al.remove(0);
		}
	}
}
