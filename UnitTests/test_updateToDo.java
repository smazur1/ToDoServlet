import static org.junit.Assert.*;

import org.junit.Test;
import customcode.ProcessToDo;
import model.Todo;

public class test_updateToDo {

	@Test
	public void test_updateToDo() {
		
		ProcessToDo.updateToDo(23, 4);
		System.out.println("test updateToDo(23)= "  );
		Todo todos = ProcessToDo.getToDo(23);
		
	//	assertTrue(todos.getTodostatus.getTodostatusid() == 4);
		
	}

}
