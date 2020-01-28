package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TavoloDAO {
	
	public ArrayList<TavoloBean> doRetrieveByAll() throws SQLException {
		
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("SELECT * FROM tavolo t;");
		ResultSet res = stm.executeQuery();
		ArrayList<TavoloBean> arrayListTavolo = new ArrayList<>();
		while(res.next()) {
			
			TavoloBean tableBean = new TavoloBean(res.getInt("t.num_tavolo"),res.getInt("t.num_posti"),res.getBoolean("t.stato_tavolo"));
			arrayListTavolo.add(tableBean);
		}
		return arrayListTavolo;
	}
	
	public void addTavolo(int numTavolo,int numPosti,boolean statoTavolo) throws SQLException
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("INSERT INTO tavolo(num_tavolo,num_posti,stato_tavolo) VALUES(?,?,?);");
		stm.setInt(1,numTavolo);
		stm.setInt(2,numPosti);
		stm.setBoolean(3,statoTavolo);
		stm.execute();
	}
	
	public void removeTavolo(int numTavolo) throws SQLException
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("DELETE FROM tavolo WHERE num_tavolo=?;");
		stm.setInt(1,numTavolo);
		stm.execute();
		
	}
}
