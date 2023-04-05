package GreenSQAClasses;
import java.util.Calendar; 
import java.util.GregorianCalendar;
import java.util.Date;
import GreenSQAClasses.Stage;
import GreenSQAClasses.ProjectManager;
import GreenSQAClasses.Enterprise;

public class Project {
	
//cadena de responsabilidades
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
	//clase o nombre
	private ProjectManager manager; 
	private Client client;
	//CAMBIAR CONSTRUCCTRES, 
	//HACER MENU 
	
	
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
	
	public void assignDates( int stageNumber,Calendar startDate, int stageMonths ) {
		this.stages[stageNumber].setPlanedStartDate(startDate);
		startDate.add(startDate.MONTH, stageMonths);
		this.stages[stageNumber].setPlanedFinalDate(startDate);
	}

	public void activateStage(int stageNumber, boolean avaiability) {
		this.stages[stageNumber].setAvaiable(avaiability);
		this.stages[stageNumber].setRealStartDate(currentDate);}
	
	public void culminateStage(int stageNumber, boolean finished) {
		this.stages[stageNumber].setApproved(finished);
		this.stages[stageNumber].setRealFinalDate(currentDate);
		this.stages[stageNumber+1].setAvaiable(true);
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
