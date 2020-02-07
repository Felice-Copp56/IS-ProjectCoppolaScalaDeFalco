package model;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class TavoloDAO {
	
	public int getMaxTableNumber() throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("SELECT num_tavolo from tavolo order by num_tavolo desc limit 1;");
		ResultSet res = stm.executeQuery();
		if(res.next())
			return res.getInt(1);
		return 1;
		
	}
	public ArrayList<TavoloBean> filtraTavoliXCliente(Date d,Time t1,Time t2,int np) throws SQLException{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("select * from tavolo t where t.num_posti = ? and not exists ( select * from prenotazione p where p.num_tavolo = t.num_tavolo and p.data = ? and ora_inizio = ? and ora_fine = ? );");
		stm.setInt(1, np);
		stm.setDate(2, d);
		stm.setTime(3, t1);
		stm.setTime(4,t2);
		ResultSet res = stm.executeQuery();
		ArrayList<TavoloBean> arrayListTavolo = new ArrayList<TavoloBean>();
		while(res.next()) {
			TavoloBean t = new TavoloBean(res.getInt("t.num_tavolo"),res.getInt("t.num_posti"),res.getBoolean("t.stato_tavolo"));
			System.out.println(t.getNumTavolo()+" " +t.getNumPosti());
			arrayListTavolo.add(t);
		}
		return arrayListTavolo;
	}
	public Boolean checkPrenotazione(int numTavolo,Date d,Time t1,Time t2) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("select count(*) as numeroPre from prenotazione p where p.num_tavolo = ? and p.data = ? and ora_inizio = ?  and ora_fine = ?;");
		stm.setInt(1, numTavolo);
		stm.setDate(2, d);
		stm.setTime(3,t1);
		stm.setTime(4, t2);
		ResultSet res = stm.executeQuery();
		if(res.next()) {
			if(res.getInt(1)==0)
				return true;
		}
		return false;
	}
	
	public ArrayList<TavoloBean> doRetrieveAll() throws SQLException {	
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
	
	public HashMap<TavoloBean, Integer> tavoliPiuGettonati() throws SQLException{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("select t.num_tavolo,t.num_posti, count(*) as numeroPrenotazioni from tavolo t, prenotazione p  where p.num_tavolo = t.num_tavolo group by t.num_tavolo order by numeroPrenotazioni desc;");
		ResultSet rs = stm.executeQuery();
		HashMap<TavoloBean,Integer> tavoli = new HashMap<TavoloBean, Integer>();
		while(rs.next()) {
			TavoloBean t = new TavoloBean(rs.getInt(1),rs.getInt(2),false);
			tavoli.put(t,rs.getInt(3));
		}
		return tavoli;
	}
}
