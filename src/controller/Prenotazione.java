package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PrenotazioneBean;
import model.PrenotazioneDAO;

/**
 * Servlet implementation class Prenotazione
 */
@WebServlet(".")
public class Prenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Prenotazione() {
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
		PrenotazioneDAO prenDAO = new PrenotazioneDAO();
		/*
		 * System.out.println("Test: doRetrieveByUsername"); ArrayList<PrenotazioneBean>
		 * prenotazioni = new ArrayList<PrenotazioneBean>(); prenotazioni =
		 * prenDAO.doRetrieveByUsername("u1"); for(PrenotazioneBean p : prenotazioni) {
		 * System.out.println(p.getUsername()); }
		 */

		/*
		 * Test doretrieveByDates
		 * 
		 * ArrayList<PrenotazioneBean> prenotazioniPerData = new
		 * ArrayList<PrenotazioneBean>();
		 * 
		 * prenotazioniPerData=prenDAO.doRetrieveByDates(Date.valueOf("2020-01-01"),
		 * Date.valueOf("2020-02-01")); for (PrenotazioneBean p : prenotazioniPerData)
		 * System.out.println(p.getData().toString()); }
		 */

		/*
		 * * Test doSave try { prenDAO.doSave(new
		 * PrenotazioneBean(Date.valueOf("2020-05-05"), Time.valueOf("18:00:00"),
		 * Time.valueOf("19:00:00"), 3, "u2")); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		/*try {
			prenDAO.remove(new PrenotazioneBean(Date.valueOf("2020-05-05"), Time.valueOf("18:00:00"),
					Time.valueOf("19:00:00"), 3, "u2"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ArrayList<PrenotazioneBean> prova  =prenDAO.doRetrieveByDates(Date.valueOf("2020-05-05"), Date.valueOf("2020-05-05"));
		for(PrenotazioneBean p: prova) {
			System.out.println(p.getData());
		}
			/*try {
		prenDAO.update(p, Date.valueOf("2000-01-01"), Time.valueOf("17:00:00"), Time.valueOf("18:00:00"));
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}*/
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
