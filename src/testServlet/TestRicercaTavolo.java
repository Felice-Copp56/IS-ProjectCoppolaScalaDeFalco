package testServlet;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.FiltraTavoli;
import model.TavoloDAO;

public class TestRicercaTavolo extends Mockito {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private FiltraTavoli servlet;
	
	@BeforeEach
	void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		servlet =  new FiltraTavoli();
	}
	
	@Test
	public void RicercaTavolo1() throws ServletException, IOException {
		
		TavoloDAO dao = mock(TavoloDAO.class);
		servlet.setTavolo(dao);
		String errorMessage = ("Dati errati, reinserisci");
		
		request.setParameter("numeroPersone", "-1");
		request.setParameter("Data", "2020-02-16");
		request.setParameter("fasciaOraria", "18:00/19:00");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RicercaTavolo2() throws ServletException, IOException {
		
		TavoloDAO dao = mock(TavoloDAO.class);
		servlet.setTavolo(dao);
		String errorMessage = ("Dati errati, reinserisci");
		
		request.setParameter("numeroPersone", "3");
		request.setParameter("Data", "2020-02-14");
		request.setParameter("fasciaOraria", "18:00/19:00");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	//Con Andrea
	@Test
	public void RicercaTavolo3() throws ServletException, IOException {
		
		TavoloDAO dao = mock(TavoloDAO.class);
		servlet.setTavolo(dao);
		String errorMessage = ("Dati errati, reinserisci");
		
		request.setParameter("numeroPersone", "3");
		request.setParameter("Data", "2020-02-16");
		request.setParameter("fasciaOraria", "Scegli...");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RicercaTavolo4() throws ServletException, IOException {
		
		TavoloDAO dao = mock(TavoloDAO.class);
		servlet.setTavolo(dao);
		
		
		request.setParameter("numeroPersone", "3");
		request.setParameter("Data", "2020-02-16");
		request.setParameter("fasciaOraria", "18:00/19:00");
		
		servlet.doGet(request,response);
		
	}
}
