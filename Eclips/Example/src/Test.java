
public class Test {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int i,j,x=0;
		for ( i = 0; i < 5; i++) 
			for (j = 0; j < i; j++) {
				x+=(i+j-1);
				break;	
			}		
			System.out.println(x);
		
		
	}

}
