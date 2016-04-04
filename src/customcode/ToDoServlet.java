package customcode;

import java.io.IOException;
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
		
		
/*		
		else if (request.getParameter("option").equals("2")) {

			String type = request.getParameter("type");

			
			List<Studentgrade> students = null;

			students = ProcessGrades.getStudentGradeByType(type);
			//

			session.setAttribute("assignments", students);
			request.getRequestDispatcher("/output.jsp").forward(request, response);

		} else if (request.getParameter("option").equals("3")) {

			int studentid = Integer.parseInt(request.getParameter("studentid"));
			String type = request.getParameter("type");
			List<Studentgrade> students = null;

			students = ProcessGrades.getStudentGradeByIDAndType(studentid, type);

			session.setAttribute("assignments", students);
			request.getRequestDispatcher("/output.jsp").forward(request, response);

		} else if (request.getParameter("option").equals("7")) {

			int id = Integer.parseInt(request.getParameter("id"));
			int grade = Integer.parseInt(request.getParameter("grade"));
			int count = 0;
			System.out.println("student id = " + request.getParameter("studentid"));

			int studentid = Integer.parseInt(request.getParameter("studentid"));
			List<Studentgrade> students = null;

			count = ProcessGrades.updateGrade(id, grade);
			System.out.println("count = " + count);
			students = ProcessGrades.getStudentGradeByID(studentid);

			session.setAttribute("assignments", students);
			request.getRequestDispatcher("/output.jsp").forward(request, response);

		} else if (request.getParameter("option").equals("8")) {

	//		int studentid = Integer.parseInt(request.getParameter("id"));
			int grade = Integer.parseInt(request.getParameter("grade"));
			int count = 0;
			System.out.println("student id = " + request.getParameter("studentid"));
			String assignment = request.getParameter("assignment");
			String assigntype = request.getParameter("type");

			int studentid = Integer.parseInt(request.getParameter("studentid"));
			List<Studentgrade> students = null;

			ProcessGrades.insertGrade(studentid, assignment, assigntype, grade);
			System.out.println("count = " + count);
			
			students = ProcessGrades.getStudentGradeByID(studentid);

			session.setAttribute("assignments", students);
			request.getRequestDispatcher("/output.jsp").forward(request, response);
	}  
	*/
}
}
