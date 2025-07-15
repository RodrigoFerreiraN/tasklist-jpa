package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks", schema="task_list")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="task_title", length = 200, nullable = false)
	private String title;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@ManyToOne(optional = false)
	@JoinColumn(nullable = false)
	private User taskOwner;
	
	public Task() {
		
	}
	
	
	
	public Task(String title, String description, Status status, Priority priority, User taskOwner) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.taskOwner = taskOwner;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public User getTaskOwner() {
		return taskOwner;
	}
	public void setTaskOwner(User taskOwner) {
		this.taskOwner = taskOwner;
	}
	
	
}
