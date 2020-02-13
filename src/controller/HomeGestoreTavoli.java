package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GestoreTavoliDAO;

/**
 * Servlet implementation class HomeGestoreTavoli
 */
@WebServlet("/HomeGestoreTavoli")
public class HomeGestoreTavoli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeGestoreTavoli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codiceGestore = request.getParameter("textgestore");
		RequestDispatcher rq = null;
		GestoreTavoliDAO dao = new GestoreTavoliDAO();
		try {
			if(codiceGestore.equals(" "))
			{
				request.setAttribute("ERRORMSG", "Credenziali di accesso non valide");
				rq = request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp");
			}
			if(dao.doRetrieveByCode(codiceGestore)!=null)
			{
				rq = request.getRequestDispatcher("WEB-INF/jsp/homeGestoreTavoli.jsp");
				
			}
			else
			{
				request.setAttribute("ERRORMSG", "Credenziali di accesso non valide");
				rq = request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rq.forward(request, response);
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
