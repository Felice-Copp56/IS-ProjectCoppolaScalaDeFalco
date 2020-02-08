package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PrenotazioneBean;
import model.PrenotazioneDAO;

/**
 * Servlet implementation class ModificaPrenotazione
 */
@WebServlet("/ModificaPrenotazione")
public class ModificaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaPrenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int nt =  Integer.valueOf(request.getParameter("nt"));
		String oldT1 = request.getParameter("t1");
		String oldT2 = request.getParameter("t2");
		String d1 =  request.getParameter("d");
		request.getSession().setAttribute("data", d1);
		request.getSession().setAttribute("oldT1", oldT1);
		request.getSession().setAttribute("oldT2", oldT2);
		request.getSession().setAttribute("nt",String.valueOf(nt));
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/formUpdatePrenotazione.jsp");
		rq.forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
