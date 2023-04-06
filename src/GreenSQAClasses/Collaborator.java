package GreenSQAClasses;
import GreenSQAClasses.Capsule;
import java.util.Scanner;
/**
 * This Class is to create the collaborators of the company with its specific attributes:
 * Name
 * Phone
 * Id
 * position
 * 
 * The collaborator object will also store the capsules codes of all those capsules who he/she has created 
 * @author luism
 *
 */
public class Collaborator {
	private String name; 
	private String phone;
	private String id;
	private String position;
	private int[] capsulesCreated= new int[50];
	private int capsulesIndex=0;
	public static Scanner console=new Scanner(System.in);

	/**
	 * Constructor method of Client given the name, phone and id, and position an object Client will be instantiated.
	 * @param name
	 * @param id
	 * @param phone
	 * @param position
	 */
	public Collaborator(String name, String id, String phone, String position) {
		super();
		this.name = name;
		this.id=id;
		this.phone = phone;
		this.position = position;
	}
	/**
	 * Method to associate a capsule created to its collaborator. The id code of the capsule will be stored by the collaborator who created it 
	 * @param capsuleCode
	 */

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
