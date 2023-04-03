package GreenSQAClasses;

import java.util.Arrays;

public class ProjectManager {
	private String name;
	private String phone; 
	private String id;
	private String projects[]=new String[10];
	private int projectIndex=0;
	
	
	public ProjectManager(String name, String phone, String id) {
		this.name = name;
		this.phone = phone;
		this.id = id;
	}
	
	public void addProjects(String projectCode) {
		this.projects[projectIndex]=projectCode;
		this.projectIndex++;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProjectManager [name=" + name + ", phone=" + phone + ", id=" + id + ", projects="
				+ Arrays.toString(projects) + ", projectIndex=" + projectIndex + "]";
	}
	
	
	
	
	
	
	
	
	

}
