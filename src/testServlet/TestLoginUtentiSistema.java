package testServlet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.HomeGestoreTavoli;
import controller.HomeTitolare;
import controller.LoginServlet;
import controller.RegistrationServlet;
import model.ClienteDAO;
import model.GestoreTavoliDAO;
import model.TitolareDAO;

public class TestLoginUtentiSistema extends Mockito {
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private LoginServlet servletCliente;
	private HomeTitolare servletTitolare;
	private HomeGestoreTavoli servletGestore;

	@BeforeEach
	void setUp() throws Exception {
		request= new MockHttpServletRequest();
		response= new MockHttpServletResponse();
		servletCliente = new LoginServlet();
		servletTitolare = new HomeTitolare();
		servletGestore = new HomeGestoreTavoli();
	}
	
	@Test
	public void LoginCliente_1() throws SQLException, ServletException, IOException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		String username = "felice2";
		String password = "Felice12";
		when(dao.checkUserExists(username, password)).thenReturn(true);
		servletCliente.setCliente(dao);
		
		String errorMessage = ("Credenziali di accesso non valide");
		request.setParameter("textuser"," Felc34");
		request.setParameter("textpass","Felice12");
		servletCliente.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void LoginCliente_2() throws SQLException, ServletException, IOException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		String username = "felice23";
		String password = "Felice123";
		when(dao.checkUserExists(username, password)).thenReturn(true);
		servletCliente.setCliente(dao);
		
		String errorMessage = ("Credenziali di accesso non valide");
		request.setParameter("textuser"," felice23");
		request.setParameter("textpass","Felice123");
		servletCliente.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void LoginCliente_3() throws SQLException, ServletException, IOException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		String username = "felice23";
		String password = "Felice123";
		when(dao.checkUserExists(username, password)).thenReturn(true);
		
		servletCliente.setCliente(dao);
		
		
		request.setParameter("textuser"," felice23");
		request.setParameter("textpass","Felice123");
		servletCliente.doGet(request,response);		
	}

	@Test
	public void LoginGestoreT_1() throws SQLException, ServletException, IOException {
		GestoreTavoliDAO dao = mock(GestoreTavoliDAO.class);
		String codiceGT = "GT-1";
		when(dao.checkExists(codiceGT)).thenReturn(true);
		
		servletGestore.setGestore(dao);
		String errorMessage = ("Credenziali di accesso non valide");
		
		request.setParameter("textgestore", "GT-2");
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
		
		servletGestore.doGet(request,response);
		
	}

	@Test
	public void LoginGestoreT_2() throws SQLException, ServletException, IOException {
		GestoreTavoliDAO dao = mock(GestoreTavoliDAO.class);
		String codiceGT = "GT-1";
		when(dao.checkExists(codiceGT)).thenReturn(true);
		
		servletGestore.setGestore(dao);
		
		request.setParameter("textgestore", "GT-1");
		servletGestore.doGet(request,response);
	}
	@Test
	public void LoginTitolare1() throws SQLException, ServletException, IOException {
		TitolareDAO dao = mock(TitolareDAO.class);
		String codiceT = "T-1";
		when(dao.checkTitolareExists(codiceT)).thenReturn(true);
		
		servletTitolare.setTitolare1(dao);
		String errorMessage = ("Credenziali di accesso non valide");
		request.setParameter("textitolare", "T-2");
		
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
		
		servletTitolare.doGet(request,response);
		
	}
	@Test
	public void LoginTitolare2() throws SQLException, ServletException, IOException {
		TitolareDAO dao = mock(TitolareDAO.class);
		String codiceT = "T-1";
		when(dao.checkTitolareExists(codiceT)).thenReturn(true);
		
		servletTitolare.setTitolare1(dao);
		
		request.setParameter("textitolare", "T-1");
		
		servletTitolare.doGet(request,response);
		
	}
}
