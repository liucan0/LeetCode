package array;

import org.junit.After;

public class Test {
	 
	int[] array = {1,4,5,6,7,-1,-2,-3,-4};
	
	@After
	public void print(int[] array){
		for(int a : array){
			System.out.println(a);
		}
	}
}
