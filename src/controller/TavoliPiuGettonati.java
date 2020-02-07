package controller;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class TavoliPiuGettonati
 */
@WebServlet("/TavoliPiuGettonati")
public class TavoliPiuGettonati extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TavoloDAO dao = new TavoloDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TavoliPiuGettonati() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HashMap<TavoloBean,Integer> tavoliG = dao.tavoliPiuGettonati();
			request.setAttribute("tavoli", tavoliG);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/tavoliPiuGettonati.jsp");

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
