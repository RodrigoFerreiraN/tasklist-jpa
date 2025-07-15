package service.task;

import infra.DAO;
import model.Priority;
import model.Status;
import model.Task;
import model.User;
import service.user.FindUser;

public class NewTask {
	public static void registerNewTask(String title, String description, Status status, Priority priority, Long id) {
		User taskOwner = FindUser.findUserById(id);
		Task task = new Task(title, description, status, priority, taskOwner);
		DAO<Task> dao = new DAO<>(Task.class);
		dao.incluirAtomico(task);
		dao.fechar();
	}
}
