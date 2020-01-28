package controller;

import model.TavoloBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TavoloDAO;

/**
 * Servlet implementation class TavoloServlet
 */
@WebServlet("/TavoloServlet")

public class TavoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TavoloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Test AggiuntaTavolo
		/*
		TavoloDAO tavoloDAO = new TavoloDAO();
		
		try {
			tavoloDAO.addTavolo(13, 5, false);
			System.out.println("TUTTO REGOLARE QUI");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TestCase RimozioneTavolo
		try {
			tavoloDAO.removeTavolo(13);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TestCase doRetrieveByAll
		System.out.println("Test: doRetrieveByAll");
		ArrayList<TavoloBean> arrayListTavolo = new ArrayList<>();
		try {
			arrayListTavolo=tavoloDAO.doRetrieveByAll();
			System.out.println("Tavoli restituiti ");
			for (TavoloBean tavoloBean : arrayListTavolo) {
				System.out.println("Tavolo restituito con numero"+tavoloBean.getNumTavolo());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/prova.jsp");
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
