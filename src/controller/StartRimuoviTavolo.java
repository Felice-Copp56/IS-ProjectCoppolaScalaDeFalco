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

import model.TavoloBean;
import model.TavoloDAO;

/**
 * Servlet implementation class startRimuoviTavolo
 */
@WebServlet("/StartRimuoviTavolo")
public class StartRimuoviTavolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TavoloDAO dao = new TavoloDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartRimuoviTavolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ArrayList<TavoloBean> ts = dao.doRetrieveAll();
			request.setAttribute("tavoli",ts);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rimuoviTavolo.jsp");

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
