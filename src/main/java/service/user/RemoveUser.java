package service.user;

import infra.DAO;
import model.User;

public class RemoveUser {
	public static void removeById(Long id) {
		DAO<User> dao = new DAO<>(User.class);
		dao.remover(id);
		dao.fechar();
	}
	
}
