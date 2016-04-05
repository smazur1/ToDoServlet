package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TODO database table.
 * 
 */
@Entity
@NamedQuery(name="Todo.findAll", query="SELECT t FROM Todo t")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long todoid;

	@Temporal(TemporalType.DATE)
	private Date duedate;

	private long priority;

	@Temporal(TemporalType.DATE)
	private Date statusdate;

	private String tododesc;

	private String todotype;

	//bi-directional many-to-one association to Todostatus
	@ManyToOne
	@JoinColumn(name="STATUSID")
	private Todostatus todostatus;

	//bi-directional many-to-one association to Todouser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Todouser todouser;

	public Todo() {
	}

	public long getTodoid() {
		return this.todoid;
	}

	public void setTodoid(long todoid) {
		this.todoid = todoid;
	}

	public Date getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public long getPriority() {
		return this.priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getTododesc() {
		return this.tododesc;
	}

	public void setTododesc(String tododesc) {
		this.tododesc = tododesc;
	}

	public String getTodotype() {
		return this.todotype;
	}

	public void setTodotype(String todotype) {
		this.todotype = todotype;
	}

	public Todostatus getTodostatus() {
		return this.todostatus;
	}

	public void setTodostatus(Todostatus todostatus) {
		this.todostatus = todostatus;
	}

	public Todouser getTodouser() {
		return this.todouser;
	}

	public void setTodouser(Todouser todouser) {
		this.todouser = todouser;
	}

}