package controller;

import java.io.IOException;
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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
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
		String nome = request.getParameter("textnome");
		String cognome = request.getParameter("textcognome");
		String email = request.getParameter("textemail");
		String user = request.getParameter("textuser");
		String pasw = request.getParameter("textpass");
		ClienteDAO dao = new ClienteDAO();
		RequestDispatcher rd = null;
		try {
			if (!dao.validateEmail(email) || !dao.validateName(nome) || !dao.validatePassword(pasw)
					|| !dao.validateSurname(cognome) || !dao.validateUsername(user)) {
				request.setAttribute("ERRORMSG", "Dati registrazione cliente non validi");
				rd = request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp");
			} else if (dao.existsEmail(email) || dao.existsUsername(user)) {
				request.setAttribute("ERRORMSG", "Dati registrazione cliente non validi");
				rd = request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp");
			} else {
				dao.doSave(new ClienteBean(nome, cognome, user, email, pasw));
				rd = request.getRequestDispatcher("WEB-INF/jsp/homepageRegistrazione.jsp");
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
