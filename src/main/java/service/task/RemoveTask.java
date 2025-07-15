package service.task;

import infra.DAO;
import model.Task;

public class RemoveTask {
	//remove a tarefa pelo id
	public static void removeTaskById(Long id) {
		DAO<Task> dao = new DAO<>(Task.class);
		dao.remover(id);
		dao.fechar();
	}
	
	//TODO método para remover todas as tarefas do usuario
	
}
