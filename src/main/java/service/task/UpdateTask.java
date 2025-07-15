package service.task;

import infra.DAO;
import model.Priority;
import model.Status;
import model.Task;

public class UpdateTask {

	//altera Status da tarefa
	public static void updateStatus(Long id, Status status) {
		DAO<Task> dao = new DAO<>(Task.class);
		Task task = dao.abrirT().obterPorIdDetach(id);
		task.setStatus(status);
		dao.mergeUpdate(task);
		dao.fecharT().fechar();;
	}
	

	//altera prioridade da tarefa
	public static void updatePriority(Long id, Priority priority) {
		DAO<Task> dao = new DAO<>(Task.class);
		Task task =  dao.abrirT().obterPorIdDetach(id);
		task.setPriority(priority);
		dao.mergeUpdate(task);
		dao.fecharT().fechar();
	}
	
	//altera Título da tarefa
	public static void updateTitle(Long id, String title) {
		DAO<Task> dao = new DAO<>(Task.class);
		Task task = dao.abrirT().obterPorIdDetach(id);
		task.setTitle(title);
		dao.mergeUpdate(task);
		dao.fecharT().fechar();
	}
	
	//altera Descrição da tarefa
	public static void updateDescription(Long id, String description) {
		DAO<Task> dao = new DAO<>(Task.class);
		Task task = dao.abrirT().obterPorIdDetach(id);
		task.setDescription(description);
		dao.mergeUpdate(task);
		dao.fecharT().fechar();
	}
	
}
