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

	public Boolean checkTitolareExists(String codiceT) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionPool.getConnection();
		PreparedStatement stm = con.prepareStatement("SELECT codie_titolare from titolare where codice_titolare=?;");
		stm.setString(1,codiceT);
		ResultSet res = stm.executeQuery();
		if(res.next())
		{
			return true;
		}
		return false;
	}

}
