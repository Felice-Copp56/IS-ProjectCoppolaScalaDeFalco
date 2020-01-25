package model;

public class TavoloBean {
	
	private int num_tavolo,num_posti;
	private boolean stato_tavolo;
	
	public TavoloBean(int num_tavolo,int num_posti,boolean stato)
	{
		this.num_tavolo=num_tavolo;
		this.num_posti=num_posti;
		this.stato_tavolo=stato;
	}
	public int getNum_tavolo() {
		return num_tavolo;
	}
	public void setNum_tavolo(int num_tavolo) {
		this.num_tavolo = num_tavolo;
	}
	public int getNum_posti() {
		return num_posti;
	}
	public void setNum_posti(int num_posti) {
		this.num_posti = num_posti;
	}
	public boolean isStato_tavolo() {
		return stato_tavolo;
	}
	public void setStato_tavolo(boolean stato_tavolo) {
		this.stato_tavolo = stato_tavolo;
	}
}
