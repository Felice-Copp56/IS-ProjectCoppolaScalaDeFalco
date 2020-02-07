package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class TitolareDAO {
	
	public TitolareBean doRetrieveByCode(String codiceTitolare) throws SQLException{
		
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("SELECT codice_titolare from titolare where codice_titolare=?");
		stm.setString(1, codiceTitolare);
		ResultSet res = stm.executeQuery();
		TitolareBean titolare;
		if(res.next())
		{
			titolare = new TitolareBean(codiceTitolare);
		}
		else
			titolare=null;
	return titolare;
	}

}
