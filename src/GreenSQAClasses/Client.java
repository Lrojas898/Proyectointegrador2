package GreenSQAClasses;
import GreenSQAClasses.Project;
import java.util.Scanner;
/**
 * This Class is to create the clients of the company with its specific attributes:
 * Name
 * Phone
 * Id
 * 
 * The client object will also store the project codes of all those projects who he/she has requested to the company.
 * @author luism
 *
 */

public class Client {
	private String name; 
	private String id;
	private String phone;
	private String projects[]= new String[10];
	private int projectsIndex=0;
	public static Scanner console=new Scanner(System.in);
	
	/**
	 * Constructor method of Client given the name, phone and id, an object Client will be instantiated.
	 * @param name
	 * @param id
	 * @param phone
	 */
	public Client(String name, String id, String phone) {
		super();
		this.name = name;
		this.id=id;
		this.phone = phone;
	}

	
	public String getName() {
		return name;
	}
	/**
	 * Method to associate  a project to its client. The id code of the project will be stored by the client who requested it to the company
	 * @param project
	 */
	
	public void addProject(String project) {
		this.projects[projectsIndex]=project;
		projectsIndex++;
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
	

}
