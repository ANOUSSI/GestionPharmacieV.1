package model;

public class User {
	 int id;
	private String login;
	  private String password;
	private String createAt;
	
	public User() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatat() {
		return createAt;
	}
	public void setCreatat(String creatat) {
		this.createAt = createAt;
	}
	



}
