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
	private TitolareDAO dao = new TitolareDAO();
	
	public void setTitolare1(TitolareDAO titolare) {
		// TODO Auto-generated method stub
		this.dao=titolare;
	}

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String codiceTitolare = request.getParameter("textitolare");
		
		//TitolareDAO dao = new TitolareDAO();
		try {
			if(codiceTitolare.equals(" ")){
					request.setAttribute("ERRORMSG", "Credenziali di accesso non valide");
					request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp").forward(request, response);
			}
			if(dao.checkTitolareExists(codiceTitolare))
			{
				request.getRequestDispatcher("WEB-INF/jsp/homePageTitolare.jsp").forward(request, response);
				
			}
			else
			{
				request.setAttribute("ERRORMSG", "Credenziali di accesso non valide");
				request.getRequestDispatcher("WEB-INF/jsp/homepage.jsp").forward(request, response);
			}
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

	public void setTitolare(TitolareDAO dao) {
		// TODO Auto-generated method stub
		
	}

}
