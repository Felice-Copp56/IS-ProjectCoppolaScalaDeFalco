package model;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ClienteDAO {
	private static Pattern pattern;
	public void doSave(ClienteBean c) throws SQLException {
		
			
			Connection conn = ConnectionPool.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO CLIENTE (NOME, COGNOME, USERNAME, EMAIL, PASSWO) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getCognome());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getPassword());
			
			ps.executeUpdate();
			//Esecuzione query
			
			
	}
	public Boolean checkUserExists(String user,String password) throws SQLException
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement("Select * from cliente where username=? and passwo=?;" );
		ps.setString(1,user);
		ps.setString(2, password);
		ResultSet x = ps.executeQuery();

		if (x.next()) {
			return true;
		}

		return false;
	}
	public Boolean existsEmail(String e) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement("Select * from cliente where email = ?;");
		ps.setString(1, e);
		ResultSet res = ps.executeQuery();
		return res.next();
	}
	public Boolean existsUsername(String u) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement("Select * from cliente where username = ?;");
		ps.setString(1, u);
		ResultSet res = ps.executeQuery();
		return res.next();
	}
	public ClienteBean doRetrieveByUsernamePassword(String username, String password) throws SQLException{
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT NOME, COGNOME, PASSWO, EMAIL, USERNAME FROM CLIENTE WHERE USERNAME= ? AND PASSWO= ?;");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet res = ps.executeQuery();
		if(res.next()) {
			ClienteBean cb=new ClienteBean();
			cb.setNome(res.getString(1));
			cb.setCognome(res.getString(2));
			cb.setUsername(res.getString(5));
			cb.setEmail(res.getString(4));
			cb.setPassword(res.getString(3));
			
		return cb;
		
		}
		return null;
	}
	public ClienteBean doRetrieveByEmail(String email) throws SQLException
	{
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement stm = conn.prepareStatement("SELECT NOME,COGNOME,USERNAME,EMAIL,PASSWO FROM CLIENTE WHERE EMAIL=?;");
		stm.setString(1,email);
		ResultSet res = stm.executeQuery();
		if(res.next())
		{
			ClienteBean cb = new ClienteBean();
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
		ClienteBean cb=new ClienteBean();
		PreparedStatement ps = conn.prepareStatement("SELECT NOME, COGNOME, USERNAME, EMAIL, PASSWO FROM CLIENTE WHERE USERNAME = ?;");
		ps.setString(1,user);
		ResultSet res = ps.executeQuery();
		if(res.next())
		{
			
			cb.setNome(res.getString(1));
			cb.setCognome(res.getString(2));
			cb.setEmail(res.getString(3));
			cb.setEmail(res.getString(4));
			cb.setPassword(res.getString(5));
			
		}
		return cb;
	}
	public void updatePersonalDetails(ClienteBean c, String nome, String cognome) throws SQLException {
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps=conn.prepareStatement("UPDATE CLIENTE SET NOME= ?, COGNOME= ? WHERE USERNAME= ?;");
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, c.getUsername());
			ps.executeUpdate();
			ps.close();
	}
	
	public void updateLoginData2(String oldUser,String newUser,String newPass,String newEm) throws SQLException {
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps=conn.prepareStatement("UPDATE CLIENTE SET USERNAME= ?, PASSWO= ?, EMAIL=? WHERE USERNAME=? ;");
			ps.setString(1, newUser);
			ps.setString(2, newPass);
			ps.setString(3, newEm);
			ps.setString(4, oldUser);
			ps.executeUpdate();
			ps.close();
	}
	public void updateLoginData(ClienteBean c, String username, String password,String email) throws SQLException{
		Connection conn=ConnectionPool.getConnection();
		PreparedStatement ps=conn.prepareStatement("UPDATE CLIENTE SET USERNAME= ?, PASSWO= ?, EMAIL=? WHERE USERNAME=? ;");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, c.getUsername());
			
			
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

	public Boolean validateName(String s) {
		String regex = "[a-zA-Z ‘àèìòù]{3,40}";
		return s.matches(regex);
	}
	
	public Boolean validateSurname(String s) {
		String regex = "[a-zA-Z ‘àèìòù]{3,40}";
		return s.matches(regex);
	}
	
	public Boolean validateUsername(String s) {
		String regex = "[a-z0-9_-]{3,16}";
		return s.matches(regex);
	}
	
	public Boolean validateEmail(String s) {
		String regex = "[a-zA-Z0-9][a-zA-Z0-9\\.]*@([a-zA-Z]+)\\.[a-zA-Z]+";
		return s.matches(regex);
	}
	
	public Boolean validatePassword(String s) {
		String regex = "[a-zA-Z0-9]{7,20}";
		return s.matches(regex);
	}
}
