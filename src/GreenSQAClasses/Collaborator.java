package GreenSQAClasses;
import GreenSQAClasses.Capsule;
import java.util.Scanner;
public class Collaborator {
	private String name; 
	private String phone;
	private String id;
	private String position;
	private int[] capsulesCreated= new int[50];
	private int capsulesIndex=0;
	public static Scanner console=new Scanner(System.in);

	
	public Collaborator(String name, String id, String phone, String position) {
		super();
		this.name = name;
		this.id=id;
		this.phone = phone;
		this.position = position;
	}

	public void addCapsule(int capsuleCode) {
		this.capsulesCreated[capsulesIndex]=capsuleCode;
		capsulesIndex++;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	

	public int[] getCapsulesCreated() {
		return capsulesCreated;
	}

	public void setCapsulesCreated(int[] capsulesCreated) {
		this.capsulesCreated = capsulesCreated;
	}

	public int getCapsulesIndex() {
		return capsulesIndex;
	}

	public void setCapsulesIndex(int capsulesIndex) {
		this.capsulesIndex = capsulesIndex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	


}
