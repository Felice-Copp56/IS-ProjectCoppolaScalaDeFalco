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
 * Servlet implementation class StartModificaDatiAccesso
 */
@WebServlet("/StartModificaDatiAccesso")
public class StartModificaDatiAccesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartModificaDatiAccesso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClienteDAO dao = new ClienteDAO();
		ClienteBean c = new ClienteBean();
		try {
			c = dao.doRetrieveByUsername((String)request.getSession().getAttribute("user"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("u", c.getUsername());
		request.setAttribute("e", c.getEmail());
		request.setAttribute("p", c.getPassword());
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/modificaDatiAccesso.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
