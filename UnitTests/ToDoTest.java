import org.junit.*;

import customcode.ProcessToDo;
import model.Todouser;
import static org.junit.Assert.*;

public class ToDoTest {

	@Test
	public void test_getUserByName() {
		System.out.println("Test if getUserByName returns id ...");
		long testid = ProcessToDo.getUserByName("rich");
		System.out.println("test id = " + testid);
		assertTrue(testid == 4);
	}   
	
	@Test
	public void test2_getUserByName() {
		System.out.println("Test if getUserByName returns id ...");
		long testid = ProcessToDo.getUserByName("joe");
		System.out.println("test id = " + testid);
		assertTrue(testid == 0);
	}   
	
}
