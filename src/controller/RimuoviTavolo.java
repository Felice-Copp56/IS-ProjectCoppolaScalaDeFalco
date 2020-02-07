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
 * Servlet implementation class RimuoviTavolo
 */
@WebServlet("/RimuoviTavolo")
public class RimuoviTavolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TavoloDAO dao = new TavoloDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviTavolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int nt = Integer.valueOf(request.getParameter("nt"));
		try {
			dao.removeTavolo(nt);
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
