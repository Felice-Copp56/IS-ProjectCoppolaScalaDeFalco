package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteBean;
import model.ClienteDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		String user = request.getParameter("textuser");
		String password = request.getParameter("textpass");
		try {
			ClienteDAO dao = new ClienteDAO();
			if (user.equals(" ") || password.equals(" ")) {
				request.setAttribute("ERRORMSG", "Credenziali di accesso non valide");
				System.out.println(request.getAttribute("ERRORMSG"));
				rd = request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp");
			} else if (dao.doRetrieveByUsernamePassword(user, password) != null) {
				ClienteBean bean = dao.doRetrieveByUsernamePassword(user, password);
				rd = request.getRequestDispatcher("WEB-INF/jsp/formFiltraTavoli.jsp");
				request.getSession().setAttribute("user", bean.getUsername());

			} else {
				request.setAttribute("ERRORMSG", "Credenziali di accesso non valide");
				System.out.println(request.getAttribute("ERRORMSG"));
				rd = request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
