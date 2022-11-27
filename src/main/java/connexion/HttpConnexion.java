package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.Result;

public class HttpConnexion {
	/*
	 * public String name="anoussi"; public String password="noussi"; public String
	 * getName() { return name; } public void setName(String name) { this.name =
	 * name; } public String getPassword() { return password; } public void
	 * setPassword(String password) { this.password = password; }
	 */
	Connection connection = null;
	PreparedStatement pst;
	Result rs;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public PreparedStatement getPst() {
		return pst;
	}

	public void setPst(PreparedStatement pst) {
		this.pst = pst;
	}

	public HttpConnexion() {
		super();
	}

	public Connection connect() {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 //connection = DriverManager.getConnection( "jdbc:mysql://localhost/pharma1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "123456");
			connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/pharma1","root", "123456");
		 } catch (Exception exception) {
			 System.out.println("-------------------------------------");
	         System.out.println(exception);
	         System.out.println("-------------------------------------");
		 }
		 System.out.println("conoeinfoere");
		 
		 System.out.println(connection);
		 return connection;

}
}
	
