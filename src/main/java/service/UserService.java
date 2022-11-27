package service;
import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.text.SimpleDateFormat;

	import connexion.HttpConnexion;
	import model.User;
import respository.Dao;
	public class UserService implements Dao {
		HttpConnexion connexion=new HttpConnexion();
		PreparedStatement statement;
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		public User get(String login, String password) {
			String query = "SELECT* FROM user WHERE login=? and password=?";
			System.out.println("ddddqfsqdfsdqfsdf");
			
			try {
				statement = connexion.connect().prepareStatement(query);
				statement.setString(1, login);
				statement.setString(2, password);
				ResultSet rs = statement.executeQuery();
				User user = null;
				while (rs.next()) {
				  user = new User();
					user.setId(rs.getInt("id"));
					user.setLogin(rs.getString("login"));
					user.setPassword(rs.getString("password"));
					
					
				}	
				rs.close();
				statement.close();
				return user;
			} catch (SQLException ex) {
				// Exception handling
				System.out.println(ex);

			}
			
			return null;
				
		}

	}



