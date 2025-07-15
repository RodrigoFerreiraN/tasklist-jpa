package service.user;

import java.util.List;

import infra.DAO;
import model.User;

public class FindUser {
	//busca um único usuário por ID
	public static User findUserById(Long id) {
		DAO<User> dao = new DAO<>(User.class);
		User user = dao.obterPorId(id);
		dao.fechar();
		
		return user;		
	}
	
	//busca uma lista de usuários passando a quantidade que deseja e o deslocamento 
	public static List<User> findUserList(int qtde, int deslocamento){
		DAO<User> dao = new DAO<>(User.class);
		List<User> userList = dao.obterTodos(qtde, deslocamento);
		dao.fechar();
		return userList;
	}
	
	//TODO busca usuario pelo nome
	public static List<User> findUserByName(String name){
		DAO<User> dao = new DAO<>(User.class);
		List<User> user = dao.buscaPorCampo("name", name);
		
		return user;
	}
}
