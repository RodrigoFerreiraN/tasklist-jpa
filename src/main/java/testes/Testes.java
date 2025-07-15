package testes;

import java.util.List;

import model.User;
import service.user.FindUser;

public class Testes {
	
	public static void main(String[] args) {
//		NewUser.registerNewUser("Usuario Um", "userUM@gmail.com");
//		NewUser.registerNewUser("Usuario Dois", "userDOIS@gmail.com");
//		NewUser.registerNewUser("Usuario Três", "userTRES@gmail.com");
	
//		NewTask.registerNewTask("To do user 2", "Descrição da tarefa do usuário DOIS", Status.TODO, Priority.ALTA, 2L);
//		NewTask.registerNewTask("To do user 3", "Descrição da tarefa do usuário TRES", Status.TODO, Priority.ALTA, 3L);
//		NewTask.registerNewTask("Outra tarefa do user 3", "Descrição da segunda tarefa do usuário TRES", Status.TODO, Priority.ALTA, 3L);
		
		//User user = FindUser.findUserById(1L);
		//System.out.println("Nome: " + user.getName() + " - email: " + user.getEmail());
		//List<User> users = FindUser.findUserList(3, 0);
		//for (User user : users) {
		//	System.out.println("Nome: " + user.getName() + " - email: " + user.getEmail());
		//}
		
//		List<Task> tasks = FindTask.findUserTask(3, 0);
//		for (Task task : tasks) {
//			System.out.println("Nome: " + task.getTaskOwner().getName() + "Tarefa: " + task.getTitle());
//		}
		
		//UpdateUser.setUpdateUser("Rodrigo", "rodrigoferreiran055@gmail.com", 1L);
		
		//RemoveTask.removeTaskById(1L);
		//RemoveUser.removeById(1L);
		
//		List<UserTaskDTO> task =  FindTask.findUserTasks(3, 0, 3L);
//		for (UserTaskDTO t : task) {
//			
//			System.out.println("Nome: " + t.getOwnerName() + " - Tarefa: " + t.getTitle() + " - Status: " + t.getStatus());
//		}
		
//		UpdateTask.updateStatus(1L, Status.EM_PROGRESSO);
//		UpdateTask.updatePriority(2L, Priority.MEDIA);
//		UpdateTask.updateTitle(2L, "Primeira Tarefa");
//		UpdateTask.updateDescription(2L, "Fazer a primeira tarefa");
		
//		UpdateUser.setUpdateUserEmail(1L, "wayne@waynecorp.com");
		
		List<User> user = FindUser.findUserByName("B.Wayne");
		for (User user2 : user) {
			System.out.println(user2.getName());
		}
		
	}
}
