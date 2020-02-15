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
	private ClienteDAO dao = new ClienteDAO();

	public void setCliente(ClienteDAO cliente) {
		this.dao = cliente;
	}

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
		
		String user = request.getParameter("textuser");
		String password = request.getParameter("textpass");
		try {
			//ClienteDAO dao = new ClienteDAO();
			if (user.equals(" ") || password.equals(" ")) {
				request.setAttribute("ERRORMSG", "Credenziali di accesso non valide");
				System.out.println(request.getAttribute("ERRORMSG"));
				request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp").forward(request, response);
			} else if (dao.checkUserExists(user, password)) {
				ClienteBean bean = dao.doRetrieveByUsernamePassword(user, password);
				request.getSession().setAttribute("user", bean.getUsername());
				request.getSession().setAttribute("password", bean.getPassword());
				request.getSession().setAttribute("email", bean.getEmail());
				request.getSession().setAttribute("nome", bean.getNome());
				request.getSession().setAttribute("cognome", bean.getCognome());
				request.getRequestDispatcher("WEB-INF/jsp/formFiltraTavoli.jsp").forward(request, response);
				//request.getSession().setAttribute("user", bean.getUsername());

			} else {
				request.setAttribute("ERRORMSG", "Credenziali di accesso non valide");
				System.out.println(request.getAttribute("ERRORMSG"));
				request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
