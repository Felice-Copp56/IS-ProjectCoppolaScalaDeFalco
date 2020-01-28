package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestoreTavoliDAO {
	
	public GestoreTavoliBean doRetrieveByCode(int code) throws SQLException {
		
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement ps = conn.prepareStatement(""
				+ "SELECT CODICE_GESTORE_TAVOLI"
				+ "FROM GESTORE_TAVOLI "
				+ "WHERE CODICE_GESTORE_TAVOLI= ?");
		ps.setInt(1, code);
		ResultSet res = ps.executeQuery();
		if(res.next()) {
			GestoreTavoliBean gt=new GestoreTavoliBean(res.getInt("codice_gestore_tavoli"));
			gt.setCodiceGestoreTavoli(res.getInt(1));
			return gt;
		}
		return null;
	}
}
