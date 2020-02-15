package model;

public class ClienteBean {

	private String nome,cognome,username,email,password;
	
	public ClienteBean(String n,String c,String u,String e,String p)
	{
		this.nome=n;
		this.cognome=c;
		this.username=u;
		this.password=p;
		this.email = e;
	}
	
	public ClienteBean() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
