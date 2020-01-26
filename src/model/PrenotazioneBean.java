package model;

import java.sql.Date;
import java.sql.Time;

public class PrenotazioneBean {
	private Date data;
	private Time oraInizio,oraFine;
	private int numTavolo;
	private String username;
	
	public PrenotazioneBean(Date data, Time oraInizio, Time oraFine, int numTavolo, String username) {
		super();
		this.data = data;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.numTavolo = numTavolo;
		this.username = username;
	}
	public int getNumTavolo() {
		return numTavolo;
	}
	public void setNumTavolo(int numTavolo) {
		this.numTavolo = numTavolo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getOraInizio() {
		return oraInizio;
	}
	public void setOraInizio(Time oraInizio) {
		this.oraInizio = oraInizio;
	}
	public Time getOraFine() {
		return oraFine;
	}
	public void setOraFine(Time oraFine) {
		this.oraFine = oraFine;
	}
	
	
}
