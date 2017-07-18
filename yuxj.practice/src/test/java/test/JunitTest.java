package test;

import org.junit.Test;

public class JunitTest {
	
	@Test
	public void TestString(){
		 String a = "a"+"b"+1;
		 String b = "ab1";
		 System.out.println(a == b);
		 System.out.println(new JunitTest());
	}

}
