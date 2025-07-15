package service.user;

import infra.DAO;
import model.User;

public class UpdateUser {

	//Altera dados de um usuário
	public static void setUpdateUser(Long id, String name, String email) {
		DAO<User> dao = new DAO<>(User.class);
		
		User user = dao.abrirT().obterPorIdDetach(id);
		
		user.setName(name);
		user.setEmail(email);
		
		dao.mergeUpdate(user);
		
		dao.fecharT().fechar();
		
		System.out.println();
	}
	
	//Altera nome do usuário
	public static void setUpdateUserName(Long id, String name) {
		DAO<User> dao = new DAO<>(User.class);
		User user = dao.abrirT().obterPorIdDetach(id);
		user.setName(name);
		dao.mergeUpdate(user);
		dao.fecharT().fechar();
	}
	
	//Altera o email do usuario
	public static void setUpdateUserEmail(Long id, String email) {
		DAO<User> dao = new DAO<>(User.class);
		User user = dao.abrirT().obterPorIdDetach(id);
		user.setEmail(email);
		dao.mergeUpdate(user);
		dao.fecharT().fechar();
	}
}
