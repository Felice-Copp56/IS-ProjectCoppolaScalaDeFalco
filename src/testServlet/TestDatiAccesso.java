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

import controller.ModificaDatiAccesso;
import controller.RegistrationServlet;
import model.ClienteDAO;

public class TestDatiAccesso extends Mockito {
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private ModificaDatiAccesso servlet;

	@BeforeEach
	void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		servlet = new ModificaDatiAccesso();
	}
	@Test
	public void ModificaDatiAccesso1() throws ServletException, IOException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "Scala123");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso2() throws ServletException, IOException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea23andrea23andrea23andrea23");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "Scala123");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso3() throws ServletException, IOException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","Andrea23");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "Scala123");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso4() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		when(dao.existsUsername("marco23")).thenReturn(true);
		servlet.setCliente(dao);
		String errMessage = ("Username già presente");
		request.setParameter("username","marco23");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "Scala123");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso5() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea23");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "S");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	
	@Test
	public void ModificaDatiAccesso6() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea47");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "S");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso7() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea23");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "Scala123Scala123Scala123");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso8() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea47");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "Scala123Scala123Scala123");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso9() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea23");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "Scala");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso10() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea47");
		request.setParameter("email", "Scala1.@gmail.com");
		request.setParameter("password", "Scala");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso11() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea23");
		request.setParameter("email", "S");
		request.setParameter("password", "Scala");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso12() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea47");
		request.setParameter("email", "S");
		request.setParameter("password", "Scala");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso13() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea23");
		request.setParameter("email", "S@gmail@gmail.com");
		request.setParameter("password", "Scala");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso14() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		servlet.setCliente(dao);
		String errMessage = ("Credenziali non valide");
		request.setParameter("username","andrea47");
		request.setParameter("email", "S@gmail@gmail.com");
		request.setParameter("password", "Scala");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
	@Test
	public void ModificaDatiAccesso15() throws ServletException, IOException, SQLException
	{
		ClienteDAO dao = mock(ClienteDAO.class);
		when(dao.existsEmail("Felice1.@gmail.com")).thenReturn(true);
		servlet.setCliente(dao);
		String errMessage = ("Email già presente");
		request.setParameter("username","andrea23");
		request.setParameter("email", "Felice1.@gmail.com");
		request.setParameter("password", "Scala");
		
		servlet.doGet(request,response);
		String attribute = (String) request.getAttribute("ERRORMSG");
		assertEquals(errMessage, attribute);
	}
}
