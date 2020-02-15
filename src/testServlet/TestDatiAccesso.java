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
	public void ModificaDatiAccesso1()
	{
		
	}
}
