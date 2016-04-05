import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import customcode.ProcessToDo;
import model.Todo;


public class test_getToDo {

	@Test
	public void test_getToDo() {
	Todo todos = ProcessToDo.getToDo(21);
	System.out.println("test getToDo(21)= "  );
	assertTrue(todos.getTodotype().equals("study"));
	}

}
