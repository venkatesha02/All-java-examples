/*

 There are 5 subject marks scored by the student. 
 The college considers the BEST of THREE marks only.
 Say sub1 = 75, sub2= 67, sub3=50, sub4= 90 and sub5 = 77 
 The output should be :- 90,77,75
 In case a student is absent then his/her subject marks will be equated to -1. 
 Given that a student could be absent in only one subject ONLY. 
 Then BEST of TWO should be considered.
 For example :
 Say sub1 = 75, sub2= 67, sub3=50, sub4= -1 and sub5 = 77 
 The output should be :- Ignoring sub1 consider BEST of TWO i.e. 77 and 75
 @
 	Author: Venkatesha N
 @

 */


package com.testyantra.marks;

class DAO{
	int a;
	int b;
	int c;
	int d;
	int e;
}

public class Marks extends DAO {

	public static void main(String[] args) {

		DAO all=new DAO();
		all.a = 1;
		all.b = 2;
		all.c = 8;
		all.d = 4;
		all.e = 5;

		DAO result= data(all);

		if(all.a!=-1 && all.b!=-1 && all.c!=-1 && all.d!=-1 && all.e!=-1) {
			System.out.println(result.a);

			System.out.println(result.b);

			System.out.println(result.c);
		}
		else {

			System.out.println(result.a);

			System.out.println(result.b);
		}

	}

	private static DAO data(DAO all) {
		int temp;
		for (int i = 0; i <=5; i++) {

			if(all.b >all.a) {
				//System.out.println("ok");
				temp=all.b;
				all.b=all.a;
				all.a=temp;
		
			}
			if(all.c >all.b) {
				temp=all.c;
				all.c=all.b;
				all.b=temp;
				
			}
			else if(all.d >all.c) {
				temp=all.d;
				all.d=all.c;
				all.c=temp;
				
			}
			else if(all.e >all.d) {
				temp=all.e;
				all.e=all.d;
				all.d=temp;
				
			}
			
		}
		return all;
	}
	

}
