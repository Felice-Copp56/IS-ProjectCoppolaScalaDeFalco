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

import model.PrenotazioneDAO;

/**
 * Servlet implementation class UpdatePrenotazione
 */
@WebServlet("/UpdatePrenotazione")
public class UpdatePrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePrenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Date oldData = Date.valueOf((String) request.getSession().getAttribute("data"));
		Time t1 = Time.valueOf((String) request.getSession().getAttribute("oldT1"));
		Time t2 = Time.valueOf((String) request.getSession().getAttribute("oldT2"));
		int nt = Integer.parseInt( (String) request.getSession().getAttribute("nt"));
		Date data =Date.valueOf((String) request.getParameter("Data"));
		String fasciaOraria = request.getParameter("fasciaOraria");
		Time nt1 = Time.valueOf((String) fasciaOraria.split("/")[0]+":00");
		Time nt2 = Time.valueOf((String) fasciaOraria.split("/")[1]+":00");
		PrenotazioneDAO dao = new PrenotazioneDAO();
		
		try {
			dao.update(oldData, t1, t2, nt, data, nt1, nt2);
			request.getSession().removeAttribute("data");
			request.getSession().removeAttribute("oldT1");
			request.getSession().removeAttribute("oldT2");
			request.getSession().removeAttribute("nt");
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/formFiltraTavoli.jsp");
			rq.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher rq1 = request.getRequestDispatcher("WEB-INF/homepage.jsp");
			rq1.forward(request, response);
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
