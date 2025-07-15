package service.user;

import infra.DAO;
import model.User;

public class NewUser {
	public static void registerNewUser(String name, String email) {
		User user =  new User(name, email);
		DAO<User> dao = new DAO<>(User.class);
		dao.incluirAtomico(user);
		dao.fechar();
	}
}
