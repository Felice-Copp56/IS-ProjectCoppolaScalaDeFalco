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

import model.ClienteBean;
import model.ClienteDAO;
import model.PrenotazioneBean;
import model.PrenotazioneDAO;

/**
 * Servlet implementation class ModificaDatiAccesso
 */
@WebServlet("/ModificaDatiAccesso")
public class ModificaDatiAccesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaDatiAccesso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = (String) request.getSession().getAttribute("user");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		ClienteDAO dao = new ClienteDAO();
		PrenotazioneDAO pDao = new PrenotazioneDAO();
		
		if(user.equals(username))
		{
			ClienteBean c;
				try {
					c = dao.doRetrieveByUsername(username);
					if(c!=null)
					{
						dao.updateLoginData(c, username, password, email);
						RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/formFiltraTavoli.jsp");
						rq.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}	
		if(user.equals(username)==false)
		{
					ClienteBean bean;
					try {
						bean = dao.doRetrieveByUsername(username);
						if(bean==null)
						{
							System.out.println(user);
							ClienteBean BeanUpdato = dao.doRetrieveByUsername(user);

							dao.updateLoginData(BeanUpdato, username, password, email);
							RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/formFiltraTavoli.jsp");
							request.getSession().setAttribute("user", username);
							rq.forward(request, response);
							System.out.println(BeanUpdato.getUsername());
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
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
