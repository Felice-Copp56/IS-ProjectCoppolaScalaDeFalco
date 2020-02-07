package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TavoloBean;
import model.TavoloDAO;

/**
 * Servlet implementation class FiltraTavoliXGT
 */
@WebServlet("/FiltraTavoliXGT")
public class FiltraTavoliXGT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private TavoloDAO tDao = new TavoloDAO();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltraTavoliXGT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data = request.getParameter("Data");
		String fasciaOraria = request.getParameter("fasciaOraria");
		ArrayList<TavoloBean> tavoli = new ArrayList<>();
		HashMap<TavoloBean,Integer> map = new HashMap<>();
		String t1 = fasciaOraria.split("/")[0]+":00";
		String t2 = fasciaOraria.split("/")[1]+":00";
		try {
			tavoli = tDao.doRetrieveAll();
			for(TavoloBean t:tavoli) {
				if(tDao.checkPrenotazione(t.getNumTavolo(), Date.valueOf(data), Time.valueOf(t1), Time.valueOf(t2)))
					map.put(t, 1);
				else map.put(t,0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("map", map);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/tavoliXGT.jsp");
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
