/*
 There is basket full of fruits. 
 2 people come and divide 1 fruit is left. 
 Like that 3,4,5 and 6 people when the come and divide ALWAYS one fruit is left.
 When the seventh person comes and the fruits are divided the fruits gets equally distributed. 
 How many fruits are there?
 @
 	Author: Venkatesha N
 @
 */

import java.util.Scanner;

interface Find{
	
	public int search(int n);
	
}

class All implements Find{

	@Override
	public int search(int n) {
		int res=0;
		for (int i = 1; i < n; i++) {
			if(i%2==1) {
				if(i%3==1) {
					if(i%4==1) {
						if(i%5==1) {
							if(i%6==1) { 
								if(i%7==0) {
									res = i;
									//System.out.println(i);
								}
							}
						}
					}
				}
			}
		}
		return res;
	}
}
public class Fruit extends All {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Enter n Value");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		All a = new All();
		int result =a.search(n);
		System.out.println(result);
	}
}