package respository;

import model.User;

public interface Dao {
	public User get(String login,String password);
	


}
