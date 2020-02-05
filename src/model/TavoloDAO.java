package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class TavoloDAO {
	public ArrayList<TavoloBean> filtraTavoliXCliente(Date d,Time t1,Time t2 ) throws SQLException{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("select * from tavolo t where not exists ( select * from prenotazione p where p.num_tavolo = t.num_tavolo and p.data = ? and ora_inizio = ? and ora_fine = ?);");
		stm.setDate(1, d);
		stm.setTime(2, t1);
		stm.setTime(3,t2);
		ResultSet res = stm.executeQuery();
		ArrayList<TavoloBean> arrayListTavolo = new ArrayList<TavoloBean>();
		while(res.next()) {
			TavoloBean t = new TavoloBean(res.getInt("t.num_tavolo"),res.getInt("t.num_posti"),res.getBoolean("t.stato_tavolo"));
			arrayListTavolo.add(t);
		}
		return arrayListTavolo;
	}
	public Boolean checkPrenotazione(int numTavolo,Date d,Time t1,Time t2) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("select * from tavolo t where not exists ( select * from prenotazione p where p.num_tavolo = ? and p.data = ? and ora_inizio = ? and ora_fine = ?);");
		stm.setInt(1, numTavolo);
		stm.setDate(2, d);
		stm.setTime(3,t1);
		stm.setTime(4, t2);
		ResultSet res = stm.executeQuery();
		if(res.next()) {
			return true;
		}
		return false;
	}
	
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
