package model;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
	
	public void doSave(ClienteBean c) throws SQLException {
		
			
			Connection conn = ConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO CLIENTE (NOME, COGNOME, USERNAME, EMAIL, PASSWO) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCognome());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getPassword());
			
			ps.executeUpdate();
			//Commento casuale
			
	}
	
	public ClienteBean doRetrieveByUsernamePassword(String username, String password) throws SQLException{
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT NOME, COGNOME, PASSWO, EMAIL, USERNAME FROM CLIENTE WHERE USERNAME= ? AND PASSWO= ?;");
		ps.setString(1, username);
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
	public ClienteBean doRetrieveByUsername(String user) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT NOME, COGNOME, USERNAME, EMAIL, PASSWO FROM CLIENTE WHERE USERNAME = ?;");
		ps.setString(1,user);
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			ClienteBean cb = new ClienteBean(res.getString("nome"),res.getString("cognome"),res.getString("username"),res.getString("email"),res.getString("passwo"));
			cb.setNome(res.getString(1));
			cb.setCognome(res.getString(2));
			cb.setEmail(res.getString(3));
			cb.setEmail(res.getString(4));
			cb.setPassword(res.getString(5));
			
		return cb;
		}
		return null;
	}
	public void updatePersonalDetails(ClienteBean c, String nome, String cognome) throws SQLException {
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps=conn.prepareStatement("UPDATE CLIENTE SET NOME= ?, COGNOME= ? WHERE USERNAME= ?;");
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getUsername());
			ps.executeUpdate();
			ps.close();
	}
	
	public void updateLoginData(ClienteBean c, String username, String password) throws SQLException{
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps=conn.prepareStatement("UPDATE CLIENTE SET USERNAME= ?, PASSWO= ? WHERE NOME= ? AND COGNOME= ? AND EMAIL= ?;");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, c.getNome());
			ps.setString(4, c.getCognome());
			ps.setString(5, c.getEmail());
			ps.executeUpdate();
			ps.close();
	}
	
	public void updatePassword(ClienteBean c, String password) throws SQLException{
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps=conn.prepareStatement("UPDATE CLIENTE SET PASSWO = ? WHERE USERNAME= ?;");
			ps.setString(1, password);
			ps.setString(2, c.getUsername());
			ps.executeUpdate();
			ps.close();
	}
	
	public ArrayList<ClienteBean> getClientiAbituali() throws SQLException{
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps = conn.prepareStatement("select c.nome,c.cognome,c.username from cliente c,prenotazione p where c.username = p.username group by c.nome order by count(*) desc limit 5;");
		ResultSet rs = ps.executeQuery();
		ArrayList<ClienteBean> clienti = new ArrayList<>();
		while(rs.next()) {
			clienti.add(new ClienteBean(rs.getString(1), rs.getString(2), rs.getString(3), " ", " "));
		}
		return clienti;
	}
}
