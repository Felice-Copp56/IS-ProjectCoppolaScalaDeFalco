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

import controller.ModificaInfoPersonali;
import controller.RegistrationServlet;
import model.ClienteDAO;

public class TestModificaInfoPersonali extends Mockito {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private ModificaInfoPersonali servlet;
	
	@BeforeEach
	void setUp() throws Exception {
		request= new MockHttpServletRequest();
		response= new MockHttpServletResponse();
		servlet= new ModificaInfoPersonali();
	}
	
	@Test
	public void ModificaInfoPersonali1() throws ServletException, IOException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Modifica non valida");
		request.setParameter("nome", " ");
		request.setParameter("cognome", "Coppola");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaInfoPersonali2() throws ServletException, IOException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Modifica non valida");
		request.setParameter("nome", "FeliceFeliceFeliceFeliceFeliceFeliceC23 ");
		request.setParameter("cognome", "Coppola");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaInfoPersonali3() throws ServletException, IOException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Modifica non valida");
		request.setParameter("nome", "Felice23 ");
		request.setParameter("cognome", "Coppola");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaInfoPersonali4() throws ServletException, IOException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Modifica non valida");
		request.setParameter("nome", "Felice");
		request.setParameter("cognome", " ");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaInfoPersonali5() throws ServletException, IOException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Modifica non valida");
		request.setParameter("nome", "Felice");
		request.setParameter("cognome", "CoppolaCoppolaCoppolaCoppolaCoppolaCoppolaC");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	
	@Test
	public void ModificaInfoPersonali6() throws ServletException, IOException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Modifica non valida");
		request.setParameter("nome", "Felice");
		request.setParameter("cognome", "Coppola123");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaInfoPersonali7() throws ServletException, IOException, SQLException {
		
		ClienteDAO dao = mock(ClienteDAO.class);
		when(dao.doRetrieveByUsername("felicec")).thenReturn(null);
		servlet.setCliente(dao);
		
		request.setParameter("nome", "Felice");
		request.setParameter("cognome", "Coppola");
		
		servlet.doGet(request,response);
		
	}
	
}
