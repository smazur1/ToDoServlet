package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TODOSTATUS database table.
 * 
 */
@Entity
@NamedQuery(name="Todostatus.findAll", query="SELECT t FROM Todostatus t")
public class Todostatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long statusid;

	private String statuscode;

	private String statusdesc;

	//bi-directional many-to-one association to Todo
	@OneToMany(mappedBy="todostatus")
	private List<Todo> todos;

	public Todostatus() {
	}

	public long getStatusid() {
		return this.statusid;
	}

	public void setStatusid(long statusid) {
		this.statusid = statusid;
	}

	public String getStatuscode() {
		return this.statuscode;
	}

	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	public String getStatusdesc() {
		return this.statusdesc;
	}

	public void setStatusdesc(String statusdesc) {
		this.statusdesc = statusdesc;
	}

	public List<Todo> getTodos() {
		return this.todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public Todo addTodo(Todo todo) {
		getTodos().add(todo);
		todo.setTodostatus(this);

		return todo;
	}

	public Todo removeTodo(Todo todo) {
		getTodos().remove(todo);
		todo.setTodostatus(null);

		return todo;
	}

}