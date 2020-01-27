package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrenotazioneDAO {

	public void doSave(PrenotazioneBean p) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into prenotazione(num_tavolo,username,data,ora_inizio,ora_fine) values (?,?,?,?,?);");
		ps.setInt(1,p.getNumTavolo());
		ps.setString(2, p.getUsername());
		ps.setDate(3,p.getData());
		ps.setTime(4, p.getOraInizio());
		ps.setTime(5, p.getOraFine());
		ps.execute();
	}
	
	public ArrayList<PrenotazioneBean> doRetrieveByUsername(String username) throws SQLException {
		Connection con = ConnectionPool.getConnection();
		ArrayList<PrenotazioneBean> prenotazioni = new ArrayList<PrenotazioneBean>();
		PreparedStatement ps = con.prepareStatement("select p.num_tavolo,p.username,p.data,p.ora_inizio,p.ora_fine from prenotazione p where p.username = ?;");
		ps.setString(1, username);
		ResultSet rs = ps.getResultSet();
		while(rs.next()) {
			prenotazioni.add(new PrenotazioneBean(rs.getDate(3), rs.getTime(4), rs.getTime(5), rs.getInt(1), rs.getString(2)));
		}
		return prenotazioni;
	}
}
