package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TitolareDAO;

/**
 * Servlet implementation class ServletProvaJsp
 */
@WebServlet("/HomeTitolare")
public class HomeTitolare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeTitolare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String codiceTitolare = request.getParameter("textitolare");
		RequestDispatcher rq = null;
		TitolareDAO dao = new TitolareDAO();
		try {
			if(codiceTitolare.equals(" ")){
					request.setAttribute("ERRORMSG", "Credenziali di accesso non valide");
					rq = request.getRequestDispatcher("WEB-INF/jsp/homepages.jsp");
			}
			if(dao.doRetrieveByCode(codiceTitolare)!=null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/homePageTitolare.jsp");
				rd.forward(request, response);
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
