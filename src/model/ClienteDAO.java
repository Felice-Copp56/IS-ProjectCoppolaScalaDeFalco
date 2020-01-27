package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public ClienteBean doRetrieveByUsernamePassword(ClienteBean c){
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps = conn.prepareStatement(""
				+ "SELECT NOME, COGNOME, PASSWORD, EMAIL "
				+ "FROM CLIENTE "
				+ "WHERE EMAIL= ? AND PASSWORD= ?");
		ps.setString(1, email);
		ResultSet res = ps.executeQuery();
		if(rs.next()) {
			ClienteBean c=new ClienteBean(res.getString("nome"),res.getString("cognome"),res.getString("username"),res.getString("passwo")))
			u.setId(rs.getInt(1));
			u.setNome(rs.getString(2));
			u.setCognome(rs.getString(3));
			u.setPass(rs.getString(4));
			u.setEmail(rs.getString(5));
			u.setRuolo(rs.getInt(6));
			
			
			
			return u;
		return c;
		
	}
}
