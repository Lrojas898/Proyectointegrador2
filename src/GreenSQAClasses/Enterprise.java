package GreenSQAClasses;
import GreenSQAClasses.Project;
import GreenSQAClasses.ProjectManager;
import GreenSQAClasses.Client;
import GreenSQAClasses.Collaborator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Enterprise {
	private String name;
	// Create a list to hold rows List<Row> rowList = new ArrayList<>(); //
	private Project[] listOfProjects= new Project[10];
	private int indexProjects=0;
	private ProjectManager[] listOfProjectManager= new ProjectManager[10];
	private int indexProjectManager=0;
	private Client [] listOfClient= new Client[10];
	private int indexClients=0;
	private Collaborator [] listOfCollaborator = new Collaborator[40];
	private int indexCollaborator=0;
	
	public Enterprise(String name) {
		super();
		this.name = name;
	} 
	
	public void registerClients(String name, String id, String phone) {
		listOfClient[(int) indexClients]= new Client(name, id, phone);
		indexClients++;
	}
		
	
	public void registerProjectManager(String name, String phone, String id) {
		ProjectManager manager= new ProjectManager(name, phone, id);
		this.listOfProjectManager[this.indexProjectManager]=manager;
		this.indexProjectManager++;	
	}
	
	public void registerCollaborators(String name, String id,  String phone, String position) {
	this.listOfCollaborator[(int) indexCollaborator]=new Collaborator(name, id, phone, position);
	this.indexCollaborator++;	
	}
	 
	
	public void createProject(String name, Calendar startDate, Calendar finalDate, double budget, String code, ProjectManager manager, Client client) {
		listOfProjects[(int) this.indexProjects]=new Project(name, startDate, finalDate, budget, code, manager, client);
		indexProjects++;
	}
	
	//metodo de busqueda y assignación 
	
	public ProjectManager searchManager(String id) {
		for(int i=0;i<this.listOfProjectManager.length;i++) {
			if(this.listOfProjectManager[i].getId().equals(id)) {
				return this.listOfProjectManager[i]; 
			}
		}
		return null;
		
	}
	 
	
	public Project searchProject(String code) {
		for(int i=0;i<indexProjects;i++) {
			if(listOfProjects[i].getCode().equals(code)) {	
				return listOfProjects[i]; 
			}
		}
		return null;
	}
	public int obtainProjectNumber(String code) {
		for(int i=0;i<indexProjects;i++) {
			if(listOfProjects[i].getCode().equals(code)) {
				return i;}
			}
		return -1;
	}
	
	
	public Collaborator searchCollaborator(String id) {
		for(int i=0;i<indexCollaborator;i++) {
			if(listOfCollaborator[i].getId().equals(id)) {	
				return listOfCollaborator[i]; 
			}
		}
		return null;
	}
	
	public  Client searchClient(String id) {
		for(int i=0;i<indexClients;i++) {
			if(listOfClient[i].getId().equals(id)) {	
				return listOfClient[i]; 
			}
		}
		return null;
	}
	
	public void menusRegisterManager() {
		Scanner console= new Scanner(System.in);
		String name;
		String phone;
		String id;
		
		System.out.println("MENU: PROJECT MANAGER CREATION");
		System.out.print("Type the Manager's Name: ");
		name=console.next();
		System.out.print("Type the Manager's phone: ");
		phone=console.next();
		System.out.print("Type the Manager's ID: ");
		id=console.next();
		registerProjectManager(name,phone,id);
		
	}
	
	public void menusRegisterClients() {
		Scanner console= new Scanner(System.in);
		String name;
		String phone;
		String id;
		
		System.out.println("MENU: CLIENT CREATION");
		System.out.println("Type the Client's Name: ");
		name=console.next();
		System.out.println("Type the Client's phone: ");
		phone=console.next();
		System.out.println("Type the Client's ID: ");
		id=console.next();
		registerClients(name,id, phone);
		
	}
	
	public void menusRegisterCollaborators() {
		Scanner console= new Scanner(System.in);
		String name;
		String phone;
		String id;
		String position;
		
		System.out.println("MENU: COLLABORATOR CREATION");
		System.out.println("Type the Collaborator's Name: ");
		name=console.next();
		System.out.println("Type the Collaborator's phone: ");
		phone=console.next();
		System.out.println("Type the Collaborator's ID: ");
		id=console.next();
		System.out.println("Type the  Collaborator's Position: ");
		position=console.next();
		registerCollaborators(name,id, phone, position);
	}
	

	
	public void menuCreateProject() {
		Scanner console= new Scanner(System.in);
		
		//Variables para la creación de la empresa
		String nameProject;
		String startDateS;
		String finalDateS;
		double budget; 
		String code; 
		int monthsPerStage=0;
		String projectManagerId;
		String clientId;


		System.out.println("MENU: PROJECT CREATION");
		System.out.println("Type the ProjectName: ");
		nameProject = console.next();
		System.out.println("Type the Start Date of the Project (dd/mm/yyyy) ");
		startDateS = console.next();
		String[] parts = startDateS.split("/");
		int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1; 
        int year = Integer.parseInt(parts[2]);
        Calendar startDate= Calendar.getInstance();
        startDate.set(year, month, day);
		

		System.out.print("Type the Final Date of the Project (dd/mm/yyyy)");
		finalDateS = console.next();
		parts = finalDateS.split("/");
		day = Integer.parseInt(parts[0]);
        month = Integer.parseInt(parts[1]) - 1; 
        year = Integer.parseInt(parts[2]);
        Calendar finalDate= Calendar.getInstance();
        finalDate.set(year, month, day);
		
		System.out.print("Type the budget of the project");
		budget = console.nextDouble();
		System.out.print("Type the identification code of the project");
		code = console.next();
		
		System.out.print("Type the Project's client id");
		clientId = console.next();
		
		System.out.print("Type the Project's Manager id");
		projectManagerId = console.next();
				
		createProject(nameProject, startDate, finalDate, budget, code, searchManager(projectManagerId), searchClient(clientId));
		System.out.println("Type the starts dates and duration of each stage");
		for(int i=0;i<6;i++) {
			System.out.println("Type the duration in months of the stage number "+(i+1));
			monthsPerStage=console.nextInt();
			listOfProjects[(int) indexProjects-1].assignDates(i, startDate, monthsPerStage);	
		}
		searchManager(projectManagerId).addProjects(code);
		searchClient(clientId).addProject(code);
	}
	
	public void menuApproveStage() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: PROJECT CREATION");
		System.out.print("Type the Project Code: ");
		codeProject= console.next();
		numProject=obtainProjectNumber(codeProject);
		System.out.println("Type the Stage Number to Approve: ");
		System.out.println("1: START");
		System.out.println("2: ANALYSIS");
		System.out.println("3: DESIGN");
		System.out.println("4: EXECUTION");
		System.out.println("5: CLOSE");
		System.out.println("6: TRACING AND PROYECT CONTROL");
		numStage= console.nextInt();
		numStage=numStage-1;
		listOfProjects[numProject].culminateStage(numStage, true);
		if(numStage!=0) {
			if(listOfProjects[numProject].getSpecificStage(numStage-1).isApproved()==false) {
				System.out.println("The previous stage has not been approved, thus the next stage cannot be activated");
			}
			else if(listOfProjects[numProject].getSpecificStage(numStage).isApproved()==true){
				listOfProjects[numProject].culminateStage(numStage, true);
				System.out.println("The stage has been approved, and the next stage has been approved");
				
			}
		}
			
		
	}
	
	
	public void menuCreateCapsule() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.println("MENU: PROJECT CREATION");
		System.out.println("Type the Project Code: ");
		codeProject= console.next();
		numProject=obtainProjectNumber(codeProject);
		System.out.println("Type the Stage Number: ");
		System.out.println("1: START");
		System.out.println("2: ANALYSIS");
		System.out.println("3: DESIGN");
		System.out.println("4: EXECUTION");
		System.out.println("5: CLOSE");
		System.out.println("6: TRACING AND PROYECT CONTROL");
		numStage= console.nextInt();
		numStage=numStage-1;
		if(listOfProjects[numProject].getSpecificStage(numStage).isAvaiable()==false) {
			System.out.println("The stage is not yet avaiable");
		}
		else
		{
			System.out.println("SELECT A CAPSULE TYPE");
			System.out.println("1: TECHNIQUE");
			System.out.println("2: MANAGEMENT");
			System.out.println("3: DOMAIN");
			System.out.println("5: EXPERIENCES");
			int capsuleType=console.nextInt();
			capsuleType=capsuleType-1;
			System.out.println("TYPE THE ID OF THE COLLABORATOR");
			String id=console.next();
			searchCollaborator(id);
			System.out.println("TYPE THE DESCRIPTION OF THE CAPSULE");
			String description=console.next();
			System.out.println("TYPE THE LEARNING OF THE CAPSULE");
			String learning=console.next();
			System.out.println("TYPE THE IDENTIFICATION CODE OF THE CAPSULE");
			String code=console.next();
			
			listOfProjects[numProject].getSpecificStage(numStage).createCapsule(capsuleType, searchCollaborator(id), description, learning, code,codeProject, (numStage+1));
			System.out.println(listOfProjects[numProject].getSpecificStage(numStage).getSpecificCapsule(0).toString());
			
		}
		
	}
	
	public void menuApproveCapsule() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: PROJECT CREATION");
		System.out.print("Type the Project Code: ");
		codeProject= console.next();
		numProject=obtainProjectNumber(codeProject);
		System.out.println("Type the Stage Number: ");
		System.out.println("1: START");
		System.out.println("2: ANALYSIS");
		System.out.println("3: DESIGN");
		System.out.println("4: EXECUTION");
		System.out.println("5: CLOSE");
		System.out.println("6: TRACING AND PROYECT CONTROL");
		numStage= console.nextInt();
		numStage=numStage-1;
		System.out.println("Type the capsule's number to approve");
		int capsuleNumber=console.nextInt();
		listOfProjects[numProject].getSpecificStage(numStage).approveCapsule(capsuleNumber, true);
		
	}
	
	public void menuApproveCapsuleToPublish() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: PROJECT CREATION");
		System.out.print("Type the Project Code: ");
		codeProject= console.next();
		numProject=obtainProjectNumber(codeProject);
		System.out.println("Type the Stage Number: ");
		System.out.println("1: START");
		System.out.println("2: ANALYSIS");
		System.out.println("3: DESIGN");
		System.out.println("4: EXECUTION");
		System.out.println("5: CLOSE");
		System.out.println("6: TRACING AND PROYECT CONTROL");
		numStage= console.nextInt();
		numStage=numStage-1;
		System.out.println("Type the capsule's number to approve its publication");
		int capsuleNumber=console.nextInt();
		listOfProjects[numProject].getSpecificStage(numStage).approveToPublish(capsuleNumber, true);
		
	}
	
	public void menuPublishCapsule() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: PROJECT CREATION");
		System.out.print("Type the Project Code: ");
		codeProject= console.next();
		numProject=obtainProjectNumber(codeProject);
		System.out.println("Type the Stage Number: ");
		System.out.println("1: START");
		System.out.println("2: ANALYSIS");
		System.out.println("3: DESIGN");
		System.out.println("4: EXECUTION");
		System.out.println("5: CLOSE");
		System.out.println("6: TRACING AND PROYECT CONTROL");
		numStage= console.nextInt();
		numStage=numStage-1;
		System.out.println("Type the capsule's number to publish");
		int capsuleNumber=console.nextInt();
		System.out.println("Type the HTML or URL of the capsule");
		String urlCapsule=console.next();
		listOfProjects[numProject].getSpecificStage(numStage).publishCapsule(capsuleNumber, urlCapsule);
		
	}
	
	public void menuConsultCapsulebyKeywords() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: PROJECT CREATION");
		System.out.print("Type the Project Code: ");
		codeProject= console.next();
		numProject=obtainProjectNumber(codeProject);
		System.out.println("Type the Stage Number: ");
		System.out.println("1: START");
		System.out.println("2: ANALYSIS");
		System.out.println("3: DESIGN");
		System.out.println("4: EXECUTION");
		System.out.println("5: CLOSE");
		System.out.println("6: TRACING AND PROYECT CONTROL");
		numStage= console.nextInt();
		numStage=numStage-1;
		System.out.println("How many kewywords will you search?");
		int indexKeywords=console.nextInt();
		String keywords[] = new String[1000000];
		for (int i=0;i<indexKeywords;i++) {
			System.out.println("Type the "+(i+1)+" keyword: ");
			keywords[i]=console.next();
		}
		
		listOfProjects[numProject].getSpecificStage(numStage).searchCapsuleKeywords(keywords);
		
		
	}
	public void menuConsultCapsulebyText() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: PROJECT CREATION");
		System.out.print("Type the Project Code: ");
		codeProject= console.next();
		numProject=obtainProjectNumber(codeProject);
		System.out.println("Type the Stage Number: ");
		System.out.println("1: START");
		System.out.println("2: ANALYSIS");
		System.out.println("3: DESIGN");
		System.out.println("4: EXECUTION");
		System.out.println("5: CLOSE");
		System.out.println("6: TRACING AND PROYECT CONTROL");
		numStage= console.nextInt();
		numStage=numStage-1;
		System.out.print("Type the text to search: ");
		String text=console.next();
		listOfProjects[numProject].getSpecificStage(numStage).searchCapsuleText(text);
	
	}
	
	

	
	
}
