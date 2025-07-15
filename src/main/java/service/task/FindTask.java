package service.task;

import java.util.List;
import java.util.stream.Collectors;

import infra.DAO;
import infra.TaskDAO;
import model.Task;
import model.UserTaskDTO;

public class FindTask {
	
	//busca por uma determinada tarefa por ID
	public static Task findTaskById(Long id) {
		DAO<Task> dao = new DAO<>(Task.class);
		Task task = dao.obterPorId(id);
		dao.fechar();
		return task;
	}
	
	//lista as tarefas do usuario
	//passando um id de usuario, traz o TÍTULO das tarefas associadas a este
	public static List<String> findTitleUserTasks(int qtde, int deslocamento, Long id){
		TaskDAO dao = new TaskDAO();
		List<Task> tasks = dao.findTasksByUserId(qtde, deslocamento, id);
		List<String> userTasks = tasks.stream()
				.map(Task::getTitle).collect(Collectors.toList());
		
		return userTasks;
	}
	
	//passando um id de usuario, retorna uma List<Task> com nome, Título e Status da tarefa
	public static List<UserTaskDTO> findUserTasks(int qtde, int deslocamento, Long id){
		TaskDAO dao = new TaskDAO();
		List<Task> tasks = dao.findTasksByUserId(qtde, deslocamento, id);
		List<UserTaskDTO> userTasks = tasks.stream().map(
				task -> new UserTaskDTO(
						task.getTaskOwner().getName(),
						task.getTitle(),
						task.getStatus()
						)
				
				).collect(Collectors.toList());
		
		return userTasks;
	}
}
