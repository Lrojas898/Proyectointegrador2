package GreenSQAClasses;
import GreenSQAClasses.Project;
import java.util.Scanner;

public class Client {
	private String name; 
	private String id;
	private String phone;
	private String projects[]= new String[10];
	private int projectsIndex=0;
	public static Scanner console=new Scanner(System.in);
	
	public Client(String name, String id, String phone) {
		super();
		this.name = name;
		this.id=id;
		this.phone = phone;
	}

	
	public String getName() {
		return name;
	}
	
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
