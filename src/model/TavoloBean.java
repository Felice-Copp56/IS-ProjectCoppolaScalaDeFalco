package model;

public class TavoloBean {
	
	private int numTavolo,numPosti;

	
	
	public TavoloBean(int numTavolo,int numPosti)
	{
		this.numTavolo=numTavolo;
		this.numPosti=numPosti;
	
		
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


}
