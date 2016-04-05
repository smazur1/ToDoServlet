package customcode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBUtil;
import model.Todo;

/**
 * Servlet implementation class StudentGradeName
 */
@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		if (request.getParameter("option").equals("1")) {

			String username = request.getParameter("username");
			System.out.println("user = " + username);
			long userid = ProcessToDo.getUserByName(username);
			if (userid == 0) {

				System.out.println("userid for " + username + " not found");
			} else {

				List<Todo> todos = null;

				todos = ProcessToDo.getListById(userid);

				session.setAttribute("username", username);
				session.setAttribute("userid", userid);
				session.setAttribute("todolist", todos);
				
				request.getRequestDispatcher("/output.jsp").forward(request, response);

			}

		}

		else if (request.getParameter("option").equals("2")) {

			long userid = Long.parseLong(request.getParameter("userid"));
			long todoid = Long.parseLong(request.getParameter("todoid"));

			long statusid = Long.parseLong(request.getParameter("statusid"));

			List<Todo> todolist = null;

			ProcessToDo.updateToDo(todoid, statusid);
			System.out.println("after update");

	    	todolist = ProcessToDo.getListById(userid);
			
    //        request.setAttribute("todoid", "");
    //        session.setAttribute("todoid", "");
    //        request.setAttribute("statusid", "");
			session.setAttribute("todolist", todolist);
		
			request.getRequestDispatcher("/output.jsp").forward(request, response);

		} else if (request.getParameter("option").equals("3")) {

			//

			long userid = Long.parseLong(request.getParameter("userid"));
			long statusid = Long.parseLong(request.getParameter("statusid"));
			String todotype = request.getParameter("todotype");
			String tododesc = request.getParameter("tododesc");
			long priority = Long.parseLong(request.getParameter("priority"));

			int year = Integer.parseInt(request.getParameter("year"));
			int month = Integer.parseInt(request.getParameter("month"));
			int day = Integer.parseInt(request.getParameter("day"));
			GregorianCalendar duedate = new GregorianCalendar(year, month, day);
			
			ProcessToDo.insertTodo(userid, todotype, tododesc, statusid, duedate.getTime(), priority);
			System.out.println("count = ");

			List<Todo> todos = null;

			todos = ProcessToDo.getListById(userid);

			session.setAttribute("userid", userid);
			session.setAttribute("todolist", todos);
			request.getRequestDispatcher("/output.jsp").forward(request, response);

		} else if (request.getParameter("option").equals("4")) {
			// show comleted list

			List<Todo> todos = null;

			todos = ProcessToDo.getCompletedList();

			// session.setAttribute("username", username);
			// session.setAttribute("userid", userid);
			session.setAttribute("todolist", todos);
			request.getRequestDispatcher("/output2.jsp").forward(request, response);

		}

	}
}
