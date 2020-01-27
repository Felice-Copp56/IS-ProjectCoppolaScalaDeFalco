package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
	
	public void doSave(ClienteBean c) throws SQLException {
		
		try (Connection conn = ConnectionPool.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO CLIENTE"
					+ "(NOME, COGNOME, USERNAME, PASSWO, EMAIL) "
					+ "VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCognome());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getPassword());
			ps.setString(5, c.getEmail());
			
			ps.executeUpdate();
			
		}
	}
	
	public ClienteBean doRetrieveByUsernamePassword(String email, String password) throws SQLException{
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps = conn.prepareStatement(""
				+ "SELECT NOME, COGNOME, PASSWORD, EMAIL "
				+ "FROM CLIENTE "
				+ "WHERE EMAIL= ? AND PASSWO= ?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet res = ps.executeQuery();
		if(res.next()) {
			ClienteBean cb=new ClienteBean(res.getString("nome"),res.getString("cognome"),res.getString("username"),res.getString("email"),res.getString("passwo"));
			cb.setNome(res.getString(1));
			cb.setCognome(res.getString(2));
			cb.setEmail(res.getString(3));
			cb.setEmail(res.getString(4));
			cb.setPassword(res.getString(5));
			
		return cb;
		
		}
		return null;
	}
	
	public void updatePersonalDetails(String nome, String cognome, String email) throws SQLException {
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps=conn.prepareStatement(""
				+"UPDATE CLIENTE "
				+"SET NOME= ?, COGNOME= ?, EMAIL= ?");
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, email);
			ps.executeUpdate();
			ps.close();
	}
	
	public void updateLoginData(String username, String password) throws SQLException{
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps=conn.prepareStatement(""
				+"UPDATE CLIENTE "
				+"SET USERNAME= ?, PASSWO= ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
			ps.close();
	}
	
	public void updatePassword(String password) throws SQLException{
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps=conn.prepareStatement(""
				+"UPDATE CLIENTE "
				+"SET PASSWO= ?");
			ps.setString(1, password);
			ps.executeUpdate();
			ps.close();
	}
	
	public ArrayList<String> getClientiAbituali() throws SQLException{
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps = conn.prepareStatement("select c.nome,c.cognome,c.username from cliente c,prenotazione p where c.username = p.username group by c.nome order by count(*) desc limit 5;");
		ResultSet rs = ps.executeQuery();
		ArrayList<String> clienti = new ArrayList<String>();
		while(rs.next()) {
			clienti.add(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		return clienti;
	}
}
