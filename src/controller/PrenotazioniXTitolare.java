package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PrenotazioneBean;
import model.PrenotazioneDAO;

/**
 * Servlet implementation class PrenotazioniXTitolare
 */
@WebServlet("/PrenotazioniXTitolare")
public class PrenotazioniXTitolare extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PrenotazioneDAO dao = new PrenotazioneDAO();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioniXTitolare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ArrayList<PrenotazioneBean> prenotazioni = dao.doRetrieveAll();
			request.setAttribute("ps", prenotazioni);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/prenotazioniXTitolare.jsp");

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
