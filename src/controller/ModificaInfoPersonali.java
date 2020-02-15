package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteBean;
import model.ClienteDAO;

/**
 * Servlet implementation class ModificaInfoPersonali
 */
@WebServlet("/ModificaInfoPersonali")
public class ModificaInfoPersonali extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ClienteDAO dao = new ClienteDAO();
       public void setCliente(ClienteDAO dao)
       {
    	   this.dao=dao;
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaInfoPersonali() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = (String) request.getSession().getAttribute("user");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		//ClienteDAO dao = new ClienteDAO();
		try {
			ClienteBean bean = dao.doRetrieveByUsername(user);
			if(nome.equals(" ")||cognome.equals(" ")) {
				request.setAttribute("ERRORMSG", "Modifica non valida");
				request.getRequestDispatcher("WEB-INF/jsp/modificaInformazioniPersonali.jsp").forward(request, response);
				return;
			}
			if(!dao.validateName(nome)||!dao.validateSurname(cognome))
			{
				request.setAttribute("ERRORMSG", "Modifica non valida");
				request.getRequestDispatcher("WEB-INF/jsp/modificaInformazioniPersonali.jsp").forward(request, response);
				return;
			}
			else
				if(bean!=null)
				{
					dao.updatePersonalDetails(bean, nome, cognome);
					request.getSession().setAttribute("nome", nome);
					request.getSession().setAttribute("cognome", cognome);
					RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/formFiltraTavoli.jsp");
					rq.forward(request, response);
					System.out.println(bean.getNome()+bean.getCognome());
				}
			
			/*else
				System.out.println(bean.getCognome());*/
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
