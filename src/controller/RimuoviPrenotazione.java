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
 * Servlet implementation class RimuoviPrenotazione
 */
@WebServlet("/RimuoviPrenotazione")
public class RimuoviPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrenotazioneDAO dao = new PrenotazioneDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviPrenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String) request.getSession().getAttribute("user");
		// TODO Auto-generated method stub
		int nt =  Integer.valueOf(request.getParameter("nt"));
		Date d = Date.valueOf((String) request.getParameter("d"));
		Time t1 = Time.valueOf((String) request.getParameter("t1"));
		Time t2 = Time.valueOf((String) request.getParameter("t2"));
		try {
			dao.remove(nt,d,t1,t2,user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/formFiltraTavoli.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
