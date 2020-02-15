package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.TavoloBean;

import javax.servlet.RequestDispatcher;
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
     private TavoloDAO tDao = new TavoloDAO();  
     
     public void setTavolo(TavoloDAO dao)
     {
    	 tDao=dao;
     }
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data = request.getParameter("Data");
		String fasciaOraria = request.getParameter("fasciaOraria");
		String numeroPersone = request.getParameter("numeroPersone");
		ArrayList<TavoloBean> tavoli = new ArrayList<>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(dateFormat.format(date));
		String dataCurrent = dateFormat.format(date);
		
		String t1="";
		String t2="";
		
		try {
			//Verificare modifiche
			if(numeroPersone.equals("") || Integer.parseInt(numeroPersone)<0 || data.compareTo(dataCurrent)<0 || data.equals("") || fasciaOraria.equals("Scegli..."))
			{
				request.setAttribute("ERRORMSG", "Dati errati, reinserisci");
				request.getRequestDispatcher("WEB-INF/jsp/formFiltraTavoli.jsp").forward(request, response);
				return;
			}
			else {
			 t1 = fasciaOraria.split("/")[0]+":00";
			 t2 = fasciaOraria.split("/")[1]+":00";
			tavoli = tDao.filtraTavoliXCliente(Date.valueOf(data), Time.valueOf(t1), Time.valueOf(t2),Integer.parseInt(numeroPersone));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("tavoli", tavoli);
		request.setAttribute("data", data);
		request.setAttribute("t1", t1);
		request.setAttribute("t2", t2);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/tavoliXUtente.jsp");
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
