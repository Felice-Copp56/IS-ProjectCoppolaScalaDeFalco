package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import model.TavoloBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TavoloDAO;

/**
 * Servlet implementation class FiltraTavoli
 */
@WebServlet("/FiltraTavoli")
public class FiltraTavoli extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private TavoloDAO tDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltraTavoli() {
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
		String numeroPersone = request.getParameter("numeroPersone");
		ArrayList<TavoloBean> tavoli = new ArrayList<>();
		try {
			tavoli = tDao.filtraTavoliXCliente(Date.valueOf(data), Time.valueOf(fasciaOraria.split("/")[0]), Time.valueOf(fasciaOraria.split("/")[1]));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(TavoloBean t: tavoli) {
			System.out.println(t.getNumTavolo());
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
