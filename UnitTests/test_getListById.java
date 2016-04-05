import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import customcode.ProcessToDo;
import model.Todo;

public class test_getListById {

	@Test
	public void test_getListById() {
		
		List<Todo> todos = ProcessToDo.getListById(1);
		System.out.println("test getListById = "  );
	//	assertTrue(todos.newid == 27);
	}

}
