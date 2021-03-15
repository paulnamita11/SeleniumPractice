package Listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(Listeners.TestNGlistenersDemo.class)
public class TestNGlistenersDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside Test1");
	}

}
