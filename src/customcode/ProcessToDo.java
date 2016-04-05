package customcode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.DBUtil;
import model.Todo;
import model.Todostatus;
import model.Todouser;

public class ProcessToDo {

	public static List<Todo> getListById(long _userid) {
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select t from Todo t where t.todouser.userid = :userid";
		TypedQuery<Todo> q = em.createQuery(qString, model.Todo.class);
		q.setParameter("userid", _userid);

		List<Todo> todolist = null;


		try {

			todolist = q.getResultList();
			if (todolist == null || todolist.isEmpty())
				todolist = null;

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			em.close();
			System.out.println("Finished");
			return todolist;
		}

	}



	public static void updateToDo(long todoid, long statusid) {
		//
		Todo td = new Todo();
		Date today = new Date();
		System.out.println("today " + today);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		td = getToDo(todoid);
		
		Todostatus tds = new Todostatus();
		tds.setStatusid(statusid);
//		td.setTodoid(todoid);
		td.setTodostatus(tds);
		td.setStatusdate(today);

		trans.begin();
		try {
			em.merge(td);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();	
			System.out.println("Finished");

		}

		}

	public static Todo getToDo(long _todoid) {

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select t from Todo t where t.todoid = :todoid";
        Todo td = new Todo();

		Query q = em.createQuery(qString, model.Todo.class);
		q.setParameter("todoid", _todoid);
		long userId = 0;

		try {
			//		trans.begin();
			System.out.println("username = " + _todoid);
			td =  (Todo) q.getSingleResult();

			System.out.println("todoid = " + _todoid );
			//			trans.commit();

		} catch (Exception e) {
			System.out.println(e);
			//			trans.rollback();
		} finally {

			em.close();
			System.out.println("Finished");
			return td;
		}


	}

	

		public static void insertTodo(long _userid, String _type, String _desc, long _statusid,
				Date duedate, long _priority) {
			//
			Date today = new Date();
			System.out.println("today " + today);

			long maxid = getNewId();

			Todo td = new Todo();
				
			Todostatus tds = new Todostatus();
			Todouser tdu = new Todouser();
				
			tdu.setUserid(_userid);
			
			tds.setStatusid(_statusid);
						
			td.setTodoid(maxid);			
			td.setTodotype(_type);
			td.setPriority(_priority);
			td.setDuedate(duedate);
			td.setTododesc(_desc);
			td.setStatusdate(today);
			
			td.setTodostatus(tds);
			td.setTodouser(tdu);
			

			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();


			int count = 0;

			try {
				trans.begin();
				em.persist(td);

				trans.commit();

			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {

				em.close();
				System.out.println("Finished");

			}

		}

		public static long getNewId() {

			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "Select (max(t.todoid) + 1) from Todo t";


			Query q = em.createQuery(qString, model.Todo.class);
			long newId = 0;

			try {
				//		trans.begin();
				newId = (long) q.getSingleResult();
				//			trans.commit();

			} catch (Exception e) {
				System.out.println(e);
				//			trans.rollback();
			} finally {

				em.close();
				System.out.println("Finished");
				return newId;
			}
		}

		

		public static long getUserByName(String _username) {

			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "Select u.userid from Todouser u where u.username = :username";


			Query q = em.createQuery(qString, model.Todouser.class);
			q.setParameter("username", _username);
			long userId = 0;

			try {
				//		trans.begin();
				System.out.println("username = " + _username);
				userId = (long) q.getSingleResult();

				System.out.println("username = " + _username + " userid = " + userId);
				//			trans.commit();

			} catch (Exception e) {
				System.out.println(e);
				//			trans.rollback();
			} finally {

				em.close();
				System.out.println("Finished");
				return userId;
			}


		}
		
		
		public static List<Todo> getCompletedList() {
			//
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "Select t from Todo t where t.todostatus.statusid = :statusid";
			TypedQuery<Todo> q = em.createQuery(qString, model.Todo.class);
			q.setParameter("statusid", 4);

			List<Todo> todolist = null;


			try {

				todolist = q.getResultList();
				if (todolist == null || todolist.isEmpty())
					todolist = null;

			} catch (Exception e) {
				System.out.println(e);
			} finally {

				em.close();
				System.out.println("Finished");
				return todolist;
			}

		}


	}
