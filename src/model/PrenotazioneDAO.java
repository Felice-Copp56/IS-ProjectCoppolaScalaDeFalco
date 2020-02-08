package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class PrenotazioneDAO {

	public void doSave(Date d,Time t1,Time t2,int nt,String u) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		System.out.println(d+""+t1+""+t2+""+nt+""+u);
		PreparedStatement ps = con.prepareStatement(
				"insert into prenotazione(num_tavolo,username,data,ora_inizio,ora_fine) values (?,?,?,?,?);");
		ps.setInt(1, nt);
		ps.setString(2, u);
		ps.setDate(3, d);
		ps.setTime(4, t1);
		ps.setTime(5, t2);
		ps.execute();
	}

	public ArrayList<PrenotazioneBean> doRetrieveByUsername(String username) {
		Connection con = null;
		ArrayList<PrenotazioneBean> prenotazioni = new ArrayList<PrenotazioneBean>();

		try {
			con = ConnectionPool.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"select p.num_tavolo,p.data,p.ora_inizio,p.ora_fine from prenotazione p where p.username = ?;");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PrenotazioneBean p = new PrenotazioneBean();
				p.setData(rs.getDate(2));
				p.setNumTavolo(rs.getInt(1));
				p.setOraFine(rs.getTime(4));
				p.setOraInizio(rs.getTime(3));
				prenotazioni.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return prenotazioni;
	}
	public void updateUsername(PrenotazioneBean p,String username) throws SQLException
	{
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement("update prenotazione set username=?, num_tavolo=?, data=?, ora_inizio=?, ora_fine=?;");
		ps.setString(1,username);
		ps.setInt(2, p.getNumTavolo());
		ps.setDate(3, p.getData());
		ps.setTime(4, p.getOraInizio());
		ps.setTime(5, p.getOraFine());
	
		ps.execute();
		
	}
	public void update(Date oldData,Time oldTime1,Time oldTime2,int nTavolo,Date data, Time t1, Time t2) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update prenotazione set data = ?,ora_inizio = ?,ora_fine = ? where num_tavolo = ? and data = ?  and ora_inizio = ? and ora_fine = ?;");
		ps.setDate(1, data);
		ps.setTime(2, t1);
		ps.setTime(3, t2);
		ps.setInt(4, nTavolo);
		ps.setDate(5, oldData);
		ps.setTime(6, oldTime1);
		ps.setTime(7, oldTime2);
		ps.execute();
	}

	public void updateTimes(PrenotazioneBean p, Time t1, Time t2) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update prenotazione set ora_inizio = ?,ora_fine = ? where prenotazione.num_tavolo = ? and prenotazione.data = ?  and prenotazione.ora_inizio = ? and prenotazione.ora_fine = ?;");
		ps.setTime(1, t1);
		ps.setTime(2, t2);
		ps.setInt(3, p.getNumTavolo());
		ps.setDate(4, p.getData());
		ps.setTime(5, p.getOraInizio());
		ps.setTime(6, p.getOraFine());
		ps.execute();
	}

	public void updateDate(PrenotazioneBean p, Date d) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"update prenotazione set data = ? where prenotazione.num_tavolo = ? and prenotazione.data = ?  and prenotazione.ora_inizio = ? and prenotazione.ora_fine = ?;");
		ps.setDate(1, d);
		ps.setInt(2, p.getNumTavolo());
		ps.setDate(3, p.getData());
		ps.setTime(4, p.getOraInizio());
		ps.setTime(5, p.getOraFine());
		ps.execute();
	}

	public void remove(int nt,Date d,Time t1,Time t2,String u) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"delete from prenotazione where num_tavolo = ? and username = ? and data = ? and ora_inizio = ? and ora_fine = ?;");
		ps.setInt(1, nt);
		ps.setString(2, u);
		ps.setDate(3, d);
		ps.setTime(4, t1);
		ps.setTime(5, t2);
		ps.execute();
	}
	public void removeByNumTavolo(int nt) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement(
				"delete from prenotazione where num_tavolo = ? ;");
		ps.setInt(1, nt);
		ps.execute();
	}

	public ArrayList<PrenotazioneBean> doRetrieveByDates(Date d1, Date d2) throws SQLException {
		Connection con;
		ArrayList<PrenotazioneBean> prenotazioni = new ArrayList<PrenotazioneBean>();

		
			con = ConnectionPool.getConnection();

			PreparedStatement ps = con.prepareStatement(
					"select p.num_tavolo,p.username,p.data,p.ora_inizio,p.ora_fine from prenotazione p where p.data between ? and ?;");
			ps.setDate(1, d1);
			ps.setDate(2, d2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PrenotazioneBean p = new PrenotazioneBean();
				p.setNumTavolo(rs.getInt("num_tavolo"));
				p.setUsername(rs.getString("username"));
				p.setData(rs.getDate("data"));
				p.setOraInizio(rs.getTime("ora_inizio"));
				p.setOraFine(rs.getTime("ora_fine"));
				prenotazioni.add(p);
			}
		
		return prenotazioni;
	}
	
	public ArrayList<PrenotazioneBean> doRetrieveAll() throws SQLException {	
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("SELECT data,ora_inizio,ora_fine,num_tavolo,username FROM eltanque.prenotazione;");
		ResultSet rs = stm.executeQuery();
		ArrayList<PrenotazioneBean> ps = new ArrayList<>();
		while(rs.next()) {
			PrenotazioneBean p = new PrenotazioneBean(rs.getDate(1),rs.getTime(2),rs.getTime(3),rs.getInt(4),rs.getString(5));
			ps.add(p);
		}
		return ps;
	}
}
