package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TODOUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Todouser.findAll", query="SELECT t FROM Todouser t")
public class Todouser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;

	private String username;

	//bi-directional many-to-one association to Todo
	@OneToMany(mappedBy="todouser")
	private List<Todo> todos;

	public Todouser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Todo> getTodos() {
		return this.todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public Todo addTodo(Todo todo) {
		getTodos().add(todo);
		todo.setTodouser(this);

		return todo;
	}

	public Todo removeTodo(Todo todo) {
		getTodos().remove(todo);
		todo.setTodouser(null);

		return todo;
	}

}