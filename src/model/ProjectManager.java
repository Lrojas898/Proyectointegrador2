package model;

import java.util.Arrays;
/**
 * This Class is to create the projects manager  of the company with its specific attributes:
 * Name
 * Phone
 * Id
 * 
 * The project manager object will also store the project codes of all those projects who he/she has been assigned
 * @author luism
 *
 */
public class ProjectManager {
	private String name;
	private String phone; 
	private String id;
	private String projects[]=new String[10];
	private int projectIndex=0;
	
	/**
	 * Constructor method of Project Manager given the name, phone and id, an object project manager will be instantiated.
	 * @param name
	 * @param phone
	 * @param id
	 */

	
	
	public ProjectManager(String name, String phone, String id) {
		this.name = name;
		this.phone = phone;
		this.id = id;
	}
	
	/**
	 * Method to associate a project to its project manager. The id code of the project will be stored by the project manager who created it 
	 * @param projectCode
	 */
	
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
	/**
	 * To string method
	 */

	@Override
	public String toString() {
		return "ProjectManager [name=" + name + ", phone=" + phone + ", id=" + id + ", projects="
				+ Arrays.toString(projects) + ", projectIndex=" + projectIndex + "]";
	}
	
	
	
	
	
	
	
	
	

}
