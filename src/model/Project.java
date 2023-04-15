package model;
import java.util.Calendar; 

import java.util.GregorianCalendar;
import java.util.Date;
import model.Stage;
import model.ProjectManager;
import model.Enterprise;
import model.Capsule;

/**
 * This Class is to create the projects of the company with specify attributes:
 * Project Name
 * Planed Start Date
 * Planed Final Date
 * Budget
 * Identification code
 * Its assigned project manager
 * The client 
 * The duration of each predefined stage: "START", "ANALYSIS", "DESIGN", "EXECUTION", "CLOSE", "TRACING", "PROYECC CONTROL"
 * @author luism
 *
 */

public class Project {
	

	private String name;
	private int projectNumber;
	private final String stageNames[]={"START", "ANALYSIS", "DESIGN", "EXECUTION", "CLOSE", "TRACING", "PROYECC CONTROL"};
	private Calendar startDate;
	private Calendar finalDate;
	private Calendar currentDate= Calendar.getInstance();
	private double budget; 
	private String code; 
	private Stage [] stages= new Stage[6];
	private int [] stageMonths;
	private ProjectManager manager; 
	private Client client;
	private int totalCapsules;

	
	/**
	 * Constructor method of project given the name, planed start date and final date, its budget, identification code, project manager and client, an object project will be instantiated.
	 * @param name
	 * @param startDate
	 * @param finalDate
	 * @param budget
	 * @param code
	 * @param manager
	 * @param client
	 */
	
	
	public Project(String name, Calendar startDate, Calendar finalDate, double budget, String code, ProjectManager manager, Client client) {
		this.name = name;
		this.startDate = startDate;
		this.finalDate = finalDate;
		this.budget = budget;
		this.code = code;
		for(int stagesIndex=0;stagesIndex<6;stagesIndex++) {
			if(stagesIndex==0) {
				this.stages[(int) stagesIndex]= new Stage(stageNames[stagesIndex],stagesIndex,true);
			}
			else {
				this.stages[(int) stagesIndex]= new Stage(stageNames[stagesIndex],stagesIndex,false);
			}
		}
		this.manager=manager;
		this.client=client;
		
	}
	/**
	 * Method to calcule the final planed date of a project's stage accordingly or its start date and duration in months 
	 * @param stageNumber
	 * @param startDate
	 * @param stageMonths
	 */
	
	public void assignDates( int stageNumber,Calendar startDate, int stageMonths ) {
		this.stages[stageNumber].setPlanedStartDate(startDate);
		startDate.add(startDate.MONTH, stageMonths);
		this.stages[stageNumber].setPlanedFinalDate(startDate);
	}
	/**
	 * Method to activate a specific stage of a project given its number
	 * @param stageNumber
	 * @param avaiability
	 */

	public void activateStage(int stageNumber, boolean avaiability) {
		this.stages[stageNumber].setAvaiable(avaiability);
		this.stages[stageNumber].setRealStartDate(currentDate);}
	/**
	 * Method to approve a specific stage of a project and to activate its subsequent stage given the stage number what will be approved
	 * @param stageNumber
	 * @param finished
	 */
	
	public void culminateStage(int stageNumber, boolean finished) {
		this.stages[stageNumber].setApproved(finished);
		this.stages[stageNumber].setRealFinalDate(currentDate);
		this.stages[stageNumber+1].setAvaiable(true);
	}
	/**
	 * Method to calculate the total capsules of the project per stage 
	 * @return
	 */
	public int countTotalCapsules(){
		for(int i=0;i<6;i++){
			this.totalCapsules=this.totalCapsules+(this.stages[i].getCapsuleIndex()+1);
		}
		return this.totalCapsules;
	}

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Calendar getStartDate() {
		return startDate;
	}




	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}




	public Calendar getFinalDate() {
		return finalDate;
	}




	public void setFinalDate(Calendar finalDate) {
		this.finalDate = finalDate;
	}




	public Calendar getCurrentDate() {
		return currentDate;
	}




	public void setCurrentDate(Calendar currentDate) {
		this.currentDate = currentDate;
	}




	public double getBudget() {
		return budget;
	}




	public void setBudget(double budget) {
		this.budget = budget;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public Stage[] getStages() {
		return stages;
	}




	public void setStages(Stage[] stages) {
		this.stages = stages;
	}
	
	public Stage getSpecificStage(int index) {
		return this.stages[index];
	}




	public int[] getStageMonths() {
		return stageMonths;
	}




	public void setStageMonths(int[] stageMonths) {
		this.stageMonths = stageMonths;
	}




	public ProjectManager getManager() {
		return manager;
	}




	public void setManager(ProjectManager manager) {
		this.manager = manager;
	}




	public Client getClient() {
		return client;
	}




	public void setClient(Client client) {
		this.client = client;
	}




	public String[] getStageNames() {
		return stageNames;
	}


	
	
	
	
	
	

	
	
	
	
	
	

}
