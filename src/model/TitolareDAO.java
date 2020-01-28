package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class TitolareDAO {
	
	public TitolareBean doRetrieveByCode() throws SQLException{
		
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("SELECT codice_titolare from titolare where codice_titolare=?");
		ResultSet res = stm.executeQuery();
		TitolareBean titolare;
		if(res.next())
		{
			titolare = new TitolareBean(res.getInt("codice_titolare"));
		}
		else
			titolare=null;
	return titolare;
	}

}
