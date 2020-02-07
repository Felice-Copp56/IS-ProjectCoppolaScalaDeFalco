package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TavoloDAO;

/**
 * Servlet implementation class AggiungiTavolo
 */
@WebServlet("/AggiungiTavolo")
public class AggiungiTavolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private TavoloDAO dao = new TavoloDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiTavolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int numeroT = Integer.valueOf(request.getParameter("numeroT"));
		int numeroP = Integer.valueOf(request.getParameter("numeroP"));
		try {
			dao.addTavolo(numeroT, numeroP, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
