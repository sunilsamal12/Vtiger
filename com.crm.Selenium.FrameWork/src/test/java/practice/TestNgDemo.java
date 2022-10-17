package practice;

import org.testng.annotations.Test;


public class TestNgDemo {
	@Test
	public void Sample1() {
		System.out.println("hii");
		int[] arr= {1,2};
		System.out.println(arr[1]);
	}
	@Test(dependsOnMethods="Sample1")
	public void Sample2() {
		System.out.println("hello");
	}
	@Test(dependsOnMethods="Sample1")
	public void Sample3() {
		System.out.println("bye");
	}

}
