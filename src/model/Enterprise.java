package model;
import model.Project;

import model.ProjectManager;
import model.Client;
import model.Stage;
import model.Collaborator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
/**
 * Administrator class, this class will instantiate the objects of all used classes in the program: ProjectManager, Collaborator, Client, Project, Stage, Capsule. An Enterprise object  has only  one attribute: name
 *
 */

public class Enterprise {

	private String name;
	private Project[] listOfProjects= new Project[10];
	private int indexProjects=0;
	private ProjectManager[] listOfProjectManager= new ProjectManager[10];
	private int indexProjectManager=0;
	private Client [] listOfClient= new Client[10];
	private int indexClients=0;
	private Collaborator [] listOfCollaborator = new Collaborator[40];
	private int indexCollaborator=0;
	/**
	 * Constructor method of enterprise: given a name an object enterprise will be instantiated.
	 * @param name
	 */
	
	public Enterprise(String name) {
		super();
		this.name = name;
	} 
	/**
	 * Method to instantiate the active clients of the company. 
	 * 
	 * @param name
	 * @param id
	 * @param phone
	 */
	public void registerClients(String name, String id, String phone) {
		listOfClient[(int) indexClients]= new Client(name, id, phone);
		indexClients++;
	}
	/**
	 * Method to instantiate the active project managers of the company. 
	 * @param name
	 * @param phone
	 * @param id
	 */
	
	public void registerProjectManager(String name, String phone, String id) {
		ProjectManager manager= new ProjectManager(name, phone, id);
		this.listOfProjectManager[indexProjectManager]=manager;
		this.indexProjectManager++;	
	}
	
	/**
	 * Method to instantiate the active collaborators of the company. 
	 * @param name
	 * @param id
	 * @param phone
	 * @param position
	 */
	public void registerCollaborators(String name, String id,  String phone, String position) {
	this.listOfCollaborator[(int) indexCollaborator]=new Collaborator(name, id, phone, position);
	this.indexCollaborator++;	
	}
	/**
	 * Method to instantiate the active projects of the company. 
	 * @param name
	 * @param startDate
	 * @param finalDate
	 * @param budget
	 * @param code
	 * @param manager
	 * @param client
	 */
	 
	
	public void createProject(String name, Calendar startDate, Calendar finalDate, double budget, String code, ProjectManager manager, Client client) {
		Project project= new Project(name, startDate, finalDate, budget, code, manager, client);
		this.listOfProjects[indexProjects]=project;
		this.indexProjects++;
	}

	public String projectWithMoreCapsules(){
		int greater=0;
		String projectName="";
		for(int i=0;i<this.indexProjects;i++){
			if(this.listOfProjects[i].countTotalCapsules()>=greater){
				greater=this.listOfProjects[i].countTotalCapsules();
				projectName=this.listOfProjects[i].getName();
			}
		}
		return projectName;

	}
	
	
	/**
	 * Method to search a registered project manager by its id.
	 * @param id
	 * @return the project manager (object) searched
	 */
	
	public ProjectManager searchManager(String id) {
		for(int i=0;i<this.listOfProjectManager.length;i++) {
			if(this.listOfProjectManager[i].getId().equals(id)) {
				return this.listOfProjectManager[i]; 
			}
		}
		return null;
		
	}
	/**
	 * Method to search a registered project  by its code.
	 * @param code
	 * @return the project (object) searched 
	 */
	
	public Project searchProject(String code) {
		for(int i=0;i<this.indexProjects;i++) {
			if(this.listOfProjects[i].getCode().equals(code)) {	
				return this.listOfProjects[i]; 
			}
		}
		return null;
	}
	
	/**
	 * Method to obtain the position of an specific project in the array that stores all created projects of the company
	 * @param code
	 * @return the project position in the array
	 */
	public int obtainProjectNumber(String code) {
		for(int i=0;i<this.indexProjects;i++) {
			if(this.listOfProjects[i].getCode().equals(code)) {
				return i;}
			}
		return -1;
	}
	
	/**
	 * Method to search a registered project manager by its id.
	 * @param id
	 * @return the collaborator searched
	 */
	public Collaborator searchCollaborator(String id) {
		for(int i=0;i<this.indexCollaborator;i++) {
			if(this.listOfCollaborator[i].getId().equals(id)) {	
				return this.listOfCollaborator[i]; 
			}
		}
		return null;
	}
	/**
	 * Method to search a registred collaborator by his or her name 
	 * @param name
	 * @return
	 */

	public Collaborator searchCollaboratorByName(String name) {
		for(int i=0;i<this.indexCollaborator;i++) {
			if(this.listOfCollaborator[i].getName().equals(name)) {	
				return this.listOfCollaborator[i]; 
			}
		}
		return null;
	}
	
	/**
	 * Method to search a registered client by its id.
	 * @param id
	 * @return the client searched
	 */
	public  Client searchClient(String id) {
		for(int i=0;i<this.indexClients;i++) {
			if(this.listOfClient[i].getId().equals(id)) {	
				return this.listOfClient[i]; 
			}
		}
		return null;
	}
	
	/**
	 * This menu method will display the menu required to register a project manager. It will demand the attributes to instantiate a new project manager: name, phone, id. 
	 */
	
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
	/**
	 * This menu method will display the menu required to register a client. It will demand the attributes to instantiate a new project client: name, phone, id. 
	 */
	
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
	/**
	 * This menu method will display the menu required to register a project manager. It will demand the attributes to instantiate a new collaborator: name, phone, id, position. 
	 */
	
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
	
/**
 * This menu method will display the menu required to register a new project in the company. It will demand the required attributed to create a project: project name, planed start date, planed final date, budget, identification code, the project manager assigned, the client. The stages will be created automatically ("START", "ANALYSIS", "DESIGN", "EXECUTION", "CLOSE", "TRACING", "PROYECC CONTROL"), but its duration in months will be demanded.
 */
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
		

		System.out.print("Type the Final Date of the Project (dd/mm/yyyy) ");
		finalDateS = console.next();
		parts = finalDateS.split("/");
		day = Integer.parseInt(parts[0]);
        month = Integer.parseInt(parts[1]) - 1; 
        year = Integer.parseInt(parts[2]);
        Calendar finalDate= Calendar.getInstance();
        finalDate.set(year, month, day);
		
		System.out.print("Type the budget of the project: ");
		budget = console.nextDouble();
		System.out.print("Type the identification code of the project: ");
		code = console.next();
		
		System.out.print("Type the Project's client id: ");
		clientId = console.next();
		
		System.out.print("Type the Project's Manager id: ");
		projectManagerId = console.next();
				
		createProject(nameProject, startDate, finalDate, budget, code, searchManager(projectManagerId), searchClient(clientId));
		System.out.println("Type the starts dates and duration of each stage");
		for(int i=0;i<6;i++) {
			System.out.println("Type the Start Date of the Stage (dd/mm/yyyy) ");
			String stageStartDateS = console.next();
			String[] stageParts = startDateS.split("/");
			int stageDay = Integer.parseInt(parts[0]);
        	int stageMonth = Integer.parseInt(parts[1]) - 1; 
        	int stageYear = Integer.parseInt(parts[2]);
        	Calendar stageStartDate= Calendar.getInstance();
        startDate.set(stageYear, stageMonth, stageDay);
			System.out.println("Type the duration in months of the stage number "+(i+1));
			monthsPerStage=console.nextInt();
			this.listOfProjects[(int) this.indexProjects-1].assignDates(i, stageStartDate, monthsPerStage);	
		}
		searchManager(projectManagerId).addProjects(code);
		searchClient(clientId).addProject(code);
	}
	
	/**
	 * This menu method will display the menu required to approve a stage of a specific project. It will demand the project code whose stage will be approved, in order to deactivate it and activate the next stage. 
	 */
	
	public void menuApproveStage() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: APPROVE STAGE");
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
	/**
	 * 
	 * This menu method will display the menu required to create a capsule of a specific stage in a project. It will demand the project code and the stage number whose capsule will be created. And the needed attributed to create a capsule: capsuleType, the collaborator who create it , description, learning, capsule identification code, project code, stage number
	 *
	 */
	
	public void menuCreateCapsule() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.println("MENU: CREATE CAPSULE");
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
		console.nextLine();
		numStage=numStage-1;
		if(this.listOfProjects[numProject].getSpecificStage(numStage).isAvaiable()==false) {
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
			console.nextLine();
			capsuleType=capsuleType;
			System.out.println("TYPE THE ID OF THE COLLABORATOR");
			String id=console.nextLine();
			searchCollaborator(id);
			System.out.println("TYPE THE DESCRIPTION OF THE CAPSULE");
			String description=console.nextLine();
			System.out.println("TYPE THE LEARNING OF THE CAPSULE");
			String learning=console.nextLine();
			System.out.println("TYPE THE IDENTIFICATION CODE OF THE CAPSULE");
			String code=console.nextLine();
			
			this.listOfProjects[numProject].getSpecificStage(numStage).createCapsule(capsuleType, searchCollaborator(id), description, learning, code,codeProject, (numStage+1));
			System.out.println(this.listOfProjects[numProject].getSpecificStage(numStage).getSpecificCapsule(0).toString());
			
		}
		
	}
	/**
	 * This menu method will display the menu required to approve a specific capsule in a stage of a particular project. It will demand the needed information to access the capsule and change it approval attribute to true.
	 */
	
	public void menuApproveCapsule() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: APPROVE CAPSULE");
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
		System.out.println("Type the capsule's code to approve");
		String capsuleCode=console.next();
		int capsuleNumber=this.listOfProjects[numProject].getSpecificStage(numStage).obtainCapsuleNumber(capsuleCode);
		this.listOfProjects[numProject].getSpecificStage(numStage).approveCapsule(capsuleNumber, true);
		
	}
	/**
	 * This menu method will display the menu required to approve the publication of a specific capsule in a stage of a particular project. It will demand the needed information to access the capsule and change it publication approval attribute to true.
	 */
	public void menuApproveCapsuleToPublish() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: APPROVE CAPSULE TO PUBLISH");
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
		System.out.println("Type the capsule's code to approve");
		String capsuleCode=console.next();
		int capsuleNumber=this.listOfProjects[numProject].getSpecificStage(numStage).obtainCapsuleNumber(capsuleCode);
		this.listOfProjects[numProject].getSpecificStage(numStage).approveToPublish(capsuleNumber, true);
		
	}
	/**
	 * This menu method will display the menu required to obtain the url or html needed to publish a capsule. It will demand the needed information to access the capsule, and add its html or url
	 */
	
	public void menuPublishCapsule() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: PUBLISH CAPSULE");
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
		System.out.println("Type the capsule's code to publish");
		String capsuleCode=console.next();
		int capsuleNumber=this.listOfProjects[numProject].getSpecificStage(numStage).obtainCapsuleNumber(capsuleCode);
		System.out.println("Type the HTML or URL of the capsule");
		String urlCapsule=console.next();
		this.listOfProjects[numProject].getSpecificStage(numStage).publishCapsule(capsuleNumber, urlCapsule);
		
	}
	/**
	 * This menu method will display the menu required to access a capsule information or attributed by its keywords in the learning or description
	 */
	
	public void menuConsultCapsulebyKeywords() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: CONSULT CAPSULE BY KEYWORDS");
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
		
		this.listOfProjects[numProject].getSpecificStage(numStage).searchCapsuleKeywords(keywords);
		
		
	}
	
	/**
	 * This menu method will display the menu required to access a capsule information or attributed by a fragment of the text contained in the description or learning of the capsule
	 */
	public void menuConsultCapsulebyText() {
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: CONSULT CAPSULE BY TEXT");
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
		this.listOfProjects[numProject].getSpecificStage(numStage).searchCapsuleText(text);
	
	}
	/**
	 * This menu method will display the menu required to search if a collaborator has registred a capsule in almost one of the registred projects
	 */

	public void menuConsultCollaboratorbyName(){
		Scanner console=new Scanner(System.in);
		String name;
		boolean collaboratorCreation=false;
		System.out.print("MENU: CONSULT COLLABORATOR BY NAME");
		System.out.print("Type the Collaborator's name: ");
		name=console.next();
		if(searchCollaboratorByName(name).getCapsulesIndex()>0){
			collaboratorCreation=true;
		}

		if(collaboratorCreation==true){
			System.out.println("The collaborator has registred a capsule in almost one of the different projects");
		}
		else if(collaboratorCreation==false){
			System.out.println("The collaborator has NOT registred a capsule in almost one of the different projects");
		}
	
	}

	public void menuInformcapsulesRegistredbyType(){
		int technique=0; 
		int management=0; 
		int domain=0; 
		int experiencies=0; 
		for(int p=0;p<this.indexProjects;p++){
			for(int s=0;s<6;s++){
				technique=technique+this.listOfProjects[p].getSpecificStage(s).getTechnique();
				management=management+this.listOfProjects[p].getSpecificStage(s).getManagement();
				domain=domain+this.listOfProjects[p].getSpecificStage(s).getDomain();
				experiencies= experiencies+this.listOfProjects[p].getSpecificStage(s).getExperiencies();
			}

		}
		System.out.println("In all the registred projects has been created: ");
		System.out.println("TECHNIQUE CAPSULES: "+technique);
		System.out.println("MANAGEMENT CAPSULES: "+management);
		System.out.println("DOMAIN CAPSULES: "+domain);
		System.out.println("EXPERIENCES CAPSULES: "+experiencies);

	}

	
	public void menuProjectWithMoreCapsules(){
		System.out.println("At this moment the project with more capsules is: ");
		System.out.println(projectWithMoreCapsules());
		
	}
	/**
	 * This menu method will display the menu required to print all the learning of the capsules in a project for a specific stage 
	 */

	public void menuLearningperStage(){
		String codeProject;
		int numProject;
		int numStage;
		Scanner console= new Scanner(System.in);
		System.out.print("MENU: CONSULT LEARNING PER STAGE");
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
		int lenght; 
		lenght= searchProject(codeProject).getSpecificStage(numStage).getCapsuleIndex();
		String [] learnings= new String[lenght];
		System.out.println("The learnings per stage are: ");
		for(int i=0;i<lenght;i++ ){
			learnings[i]=searchProject(codeProject).getSpecificStage(numStage).getSpecificCapsule(i).getLearning();
			System.out.println(learnings[i]);
		}
	}


		
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project[] getListOfProjects() {
		return this.listOfProjects;
	}

	public void setListOfProjects(Project[] listOfProjects) {
		this.listOfProjects = listOfProjects;
	}

	public int getIndexProjects() {
		return this.indexProjects;
	}

	public void setIndexProjects(int indexProjects) {
		this.indexProjects = indexProjects;
	}

	public ProjectManager[] getListOfProjectManager() {
		return this.listOfProjectManager;
	}

	public void setListOfProjectManager(ProjectManager[] listOfProjectManager) {
		this.listOfProjectManager = listOfProjectManager;
	}

	public int getIndexProjectManager() {
		return this.indexProjectManager;
	}

	public void setIndexProjectManager(int indexProjectManager) {
		this.indexProjectManager = indexProjectManager;
	}

	public Client[] getListOfClient() {
		return this.listOfClient;
	}

	public void setListOfClient(Client[] listOfClient) {
		this.listOfClient = listOfClient;
	}

	public int getIndexClients() {
		return this.indexClients;
	}

	public void setIndexClients(int indexClients) {
		this.indexClients = indexClients;
	}

	public Collaborator[] getListOfCollaborator() {
		return this.listOfCollaborator;
	}

	public void setListOfCollaborator(Collaborator[] listOfCollaborator) {
		this.listOfCollaborator = listOfCollaborator;
	}

	public int getIndexCollaborator() {
		return this.indexCollaborator;
	}

	public void setIndexCollaborator(int indexCollaborator) {
		this.indexCollaborator = indexCollaborator;
	}
	
	

	
	
}
