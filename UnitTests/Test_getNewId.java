import static org.junit.Assert.*;

import org.junit.Test;
import customcode.ProcessToDo;
import model.Todouser;

public class Test_getNewId {

	@Test
	public void test_getNewId() {
		
		long newid = ProcessToDo.getNewId();
		System.out.println("test newid = " + newid);
		assertTrue(newid == 27);
		
		
		
	}

}
