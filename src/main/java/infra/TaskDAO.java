package infra;

import java.util.List;

import model.Task;

public class TaskDAO extends DAO<Task>{
	
	public TaskDAO() {
		super(Task.class);
	}
	
	public List<Task> findTasksByUserId(int qtde, int deslocamento, Long id){
		List<Task> tasks = em.createQuery(
				"SELECT t FROM Task t WHERE t.taskOwner.id = :userId",
				Task.class
				)
		.setParameter("userId", id)
		.setFirstResult(deslocamento)
		.setMaxResults(qtde)
		.getResultList();
		
		em.close();
		return tasks;
	}
}
