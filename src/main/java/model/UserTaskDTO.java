package model;

public class UserTaskDTO {
	String ownerName;
	String title;
	Status status;
	
	public UserTaskDTO(String ownerName, String title, Status status2) {
		this.ownerName = ownerName;
		this.title = title;
		this.status = status2;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
