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

import controller.AggiungiTavolo;
import controller.HomeGestoreTavoli;
import controller.HomeTitolare;
import controller.LoginServlet;
import model.TavoloDAO;

public class TestAggiuntaTavolo extends Mockito {
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private AggiungiTavolo gestore;

	@BeforeEach
	void setUp() throws Exception {
		request= new MockHttpServletRequest();
		response= new MockHttpServletResponse();
		gestore = new AggiungiTavolo();
	}
	
	@Test
	public void AggiuntaTavolo1() throws ServletException, IOException
	{
		String errorMessage = ("Tavolo non aggiunto");
		request.setParameter("numeroT", " ");
		request.setParameter("numeroP", "4");
		
		gestore.doGet(request, response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void AggiuntaTavolo2() throws ServletException, IOException, SQLException
	{
		TavoloDAO dao = mock(TavoloDAO.class);
		when(dao.getTable(5)).thenReturn(true);
		gestore.setTavolo(dao);
		String errorMessage = ("Tavolo già presente");
		request.setParameter("numeroT", "5");
		request.setParameter("numeroP", "4");
		
		gestore.doGet(request, response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	
	@Test
	public void AggiuntaTavolo3() throws ServletException, IOException, SQLException
	{
		TavoloDAO dao = mock(TavoloDAO.class);
		when(dao.getTable(5)).thenReturn(true);
		gestore.setTavolo(dao);
	
		request.setParameter("numeroT", "6");
		request.setParameter("numeroP", "4");
		
		gestore.doGet(request, response);
		
	}
	
}
