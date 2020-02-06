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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
			/*try {
				ClienteDAO dao = new ClienteDAO();
				String user = request.getParameter("textuser");
				String password = request.getParameter("textpass");
				if(dao.doRetrieveByUsernamePassword(user, password)!=null)
				{
					ClienteBean bean = dao.doRetrieveByUsernamePassword(user, password);
					System.out.println("Benvenuto "+bean.getNome()+" "+bean.getCognome());
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/provaLogin.jsp");
					rd.forward(request, response);
				}
				else
					System.out.println("Non trovato nessun utente con "+ user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		String nome = request.getParameter("textnome");
		String cognome = request.getParameter("textcognome");
		String email = request.getParameter("textemail");
		String  user = request.getParameter("textuser");
		String pasw = request.getParameter("textpass");
		ClienteDAO dao = new ClienteDAO();
		try {
			dao.doSave(new ClienteBean(nome,cognome,user,email,pasw));
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/provaLogin.jsp");
			rq.forward(request, response);
			System.out.println("Creato "+nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
