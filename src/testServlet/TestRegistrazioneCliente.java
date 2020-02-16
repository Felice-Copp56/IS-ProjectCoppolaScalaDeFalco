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

import controller.RegistrationServlet;
import model.ClienteDAO;

class TestRegistrazioneCliente extends Mockito  {

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private RegistrationServlet servlet;
	
	@BeforeEach
	void setUp() throws Exception {
		request= new MockHttpServletRequest();
		response= new MockHttpServletResponse();
		servlet= new RegistrationServlet();
	}
	
	@Test
	public void RegistrazioneCliente_1() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail"," ");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice23");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_2() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","@f.coppola");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice23");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_3() throws ServletException, IOException, SQLException
	{
	
		String email = "Felice1.@gmail.com";
		ClienteDAO dao = mock(ClienteDAO.class);
		when(dao.existsEmail(email)).thenReturn(true);
		servlet.setCliente(dao);
		
		String errorMessage = "Email già presente";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice1.@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice23");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_4() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_5() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice123Felice123Felice123Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_6() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice 123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_7() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","F");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_8() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","FeliceFeliceFeliceFeliceFeliceFeliceFeliceFelice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_9() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice234");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_10() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Cp");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_11() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","CoppolaCoppolaCoppolaCoppolaCoppolaCoppolaCoppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_12() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola2345");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_13() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser"," ");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_14() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice23felice23felice23felice23");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_15() throws ServletException, IOException
	{
		String errorMessage = "Dati registrazione cliente non validi";
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felicec");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_16() throws ServletException, IOException, SQLException
	{
		String u = "felice23";
		ClienteDAO dao = mock(ClienteDAO.class);
		when(dao.existsUsername(u)).thenReturn(true);
		servlet.setCliente(dao);
		
		String errorMessage = "Username già presente";
		
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felic34@gmail.com");
		request.setParameter("textuser","felice23");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errorMessage, attribute);
	}
	@Test
	public void RegistrazioneCliente_17() throws ServletException, IOException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		
		
		request.setParameter("textnome","Felice");
		request.setParameter("textcognome","Coppola");
		request.setParameter("textemail","Felice.1@gmail.com");
		request.setParameter("textuser","felice234");
		request.setParameter("textpass","Felice123");
		servlet.doGet(request,response);
		
	}
	
	
	
	
	
}
