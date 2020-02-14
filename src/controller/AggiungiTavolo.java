package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TavoloDAO;

/**
 * Servlet implementation class AggiungiTavolo
 */
@WebServlet("/AggiungiTavolo")
public class AggiungiTavolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TavoloDAO dao = new TavoloDAO();
       
       public void setTavolo(TavoloDAO dao)
       {
    	   this.dao=dao;
       }
    /**
     * 
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiTavolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String numeroT1 = request.getParameter("numeroT");
		String numeroP1 = request.getParameter("numeroP");
		try {
			if(numeroT1.equals(" ")|| numeroP1.equals(" "))
			{
				
			request.setAttribute("ERRORMSG", "Tavolo non aggiunto");
			}			
				else
				{
					int numeroT = Integer.valueOf(request.getParameter("numeroT"));
					int numeroP = Integer.valueOf(request.getParameter("numeroP"));
					dao.addTavolo(numeroT, numeroP);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/formFiltraTavoliGestoreTavoli.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
