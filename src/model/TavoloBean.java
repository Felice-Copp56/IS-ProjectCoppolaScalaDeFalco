package model;

public class TavoloBean {
	
	private int numTavolo,numPosti;
	private boolean stato;
	
	
	public TavoloBean(int numTavolo,int numPosti,boolean stato)
	{
		this.numTavolo=numTavolo;
		this.numPosti=numPosti;
		this.stato=stato;
		
	}

	public int getNumTavolo() {
		return numTavolo;
	}

	public void setNumTavolo(int numTavolo) {
		this.numTavolo = numTavolo;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	
}
