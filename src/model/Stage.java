package model;
import model.Capsule;
import java.util.Calendar;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * This Class is to instantiate a stage of a project with its needed attributed:
 * stage name: "START", "ANALYSIS", "DESIGN", "EXECUTION", "CLOSE", "TRACING", or "PROYECT CONTROL"
 * duration in months
 * availability
 * planned start dtae
 * planned final date
 * real start date
 * real final date
 *
 *Also, the stage will store its information capsules in a capsules array. 
 * @author luism
 *
 */
public class Stage {
	private static Calendar currentDate=Calendar.getInstance();
	private String name; 
	private int stageNumber;
	private int stageMonths;
	private boolean isAvaiable; 
	private boolean isApproved; 
	private Calendar planedStartDate; 
	private Calendar planedFinalDate;
	private Calendar realStartDate;
	private Calendar realFinalDate; 
	private Capsule []capsules = new Capsule[50];
	private String [] capsuleType= {"TECHNIQUE", "MANAGEMENT", "DOMAIN", "EXPERIENCES"};
	private int capsuleIndex=0;
	private int technique=0;
	private int management=0;
	private int domain=0;
	private int experiencies=0;
	
	


	/**
	 * Method to create a capsule in the stage
	 * @param selectCapsuleType
	 * @param collaborator
	 * @param description
	 * @param learning
	 * @param code
	 * @param ProjectCode
	 * @param stageCapsuleNumber
	 */


	public void createCapsule(int selectCapsuleType, Collaborator collaborator, String description, String learning, String code, String ProjectCode, int stageCapsuleNumber) {
		this.capsules[this.capsuleIndex]= new Capsule(this.capsuleIndex,capsuleType[selectCapsuleType], collaborator, description, learning, code, ProjectCode, stageCapsuleNumber);
		if(selectCapsuleType==0){
			this.technique++;

		}else if(selectCapsuleType==1){
			this.management++;
			

		}else if(selectCapsuleType==2){
			this.domain++;

		}else if(selectCapsuleType==3){
			this.experiencies++;
		}
		this.capsuleIndex++;
	}
	/**
	 * Method to obtain a capsule number position in the array that stores it in the stage 
	 * @param code
	 * @return
	 */
	public int obtainCapsuleNumber(String code) {
		for(int i=0;i<capsuleIndex;i++) {
			if(this.capsules[i].getCode().equals(code)) {
				return i;}
			}
		return -1;
	}
	/**
	 * Method to approve the information of a capsule that is stored the stage
	 * @param capsuleNumber
	 * @param approve
	 */
	
	public void approveCapsule(int capsuleNumber, boolean approve) {
		this.capsules[capsuleNumber].setApproved(approve);
		this.capsules[capsuleNumber].setApprovalDate(currentDate);
	}

	/**
	 * Method to approve the publication of a capsule that is stored in the stage
	 * @param capsuleNumber
	 * @param approve
	 */
	public void approveToPublish(int capsuleNumber, boolean approve)
	{
		if(this.capsules[capsuleNumber].isApproved()==true) {
		this.capsules[capsuleNumber].setApprovedToPublish(approve);
		}else {
			System.out.println("The capsule has not been yet approved");
		}
		
		
	}
	/**
	 * Method to publish a capsule that his information has been previously approved and was also approved to be published
	 * @param capsuleNumber
	 * @param html
	 */
	public void publishCapsule(int capsuleNumber, String html) {
		
		if(this.capsules[capsuleNumber].isApproved()==true && this.capsules[capsuleNumber].isApprovedToPublish()==true) {
			this.capsules[capsuleNumber].setHtml(html);
			
		}else if(this.capsules[capsuleNumber].isApproved()==false && this.capsules[capsuleNumber].isApprovedToPublish()==false) {
			System.out.println("The capsule is not approved to be published");
		}
		else {
			System.out.println("The capsule is not approved to be published");
		}
		
		
	}
	
	/**
	 * Method to search a capsule by its keywords
	 * @param keywords
	 * @return capsule searched
	 */
	
	
	public String searchCapsuleKeywords(String keywords[]) {
		Scanner console= new Scanner(System.in);
		int optional;
		for(int c=0;c<this.capsuleIndex;c++) {
			for(int r=0;r<this.capsules[c].getKeywords().length;r++) {
				for(int k=0;k<keywords.length;k++) {
					if(this.capsules[c].getSpecificKeyword(r).equals(keywords[k])) {
						if(this.capsules[c].isApproved()==true && this.capsules[c].isApprovedToPublish()==true){
						System.out.println("Is this the capsule you were searching?");
						System.out.println(this.capsules[c].toString());
						System.out.println("YES [1] NO [2]");
						optional=console.nextInt();
						if(optional==1) {
							break;
						}

						}
						
						
					}
					
				}
				
			}
		}
		return null;	
	}
	/**
	 * Method to search a capsule by a fragment of its description or learning 
	 * @param text
	 * @return capsule searched
	 */
	
	public Capsule searchCapsuleText(String text) {
		Scanner console= new Scanner(System.in);
		int optional=0;
		for(int i=0;i<this.capsuleIndex;i++) {
			
				if((this.capsules[i].getDescription().contains(text)) || (this.capsules[i].getLearning().contains(text))) {
					if(this.capsules[i].isApproved()==true && this.capsules[i].isApprovedToPublish()==true){
						System.out.println("Is this the capsule you were searching?");
						System.out.println(this.capsules[i].toString());
						System.out.println("YES [1] NO [2]");
						optional=console.nextInt();
						if(optional==1) {
							return this.capsules[i];
						}
						}	
					}
					
				
			}
		return null;
	}


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStageNumber() {
		return stageNumber;
	}

	public void setStageNumber(int stageNumber) {
		this.stageNumber = stageNumber;
	}

	public int getStageMonths() {
		return stageMonths;
	}

	public void setStageMonths(int stageMonths) {
		this.stageMonths = stageMonths;
	}

	public boolean isAvaiable() {
		return isAvaiable;
	}

	public void setAvaiable(boolean isAvaiable) {
		this.isAvaiable = isAvaiable;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Calendar getPlanedStartDate() {
		return planedStartDate;
	}

	public void setPlanedStartDate(Calendar planedStartDate) {
		this.planedStartDate = planedStartDate;
	}

	public Calendar getPlanedFinalDate() {
		return planedFinalDate;
	}

	public void setPlanedFinalDate(Calendar planedFinalDate) {
		this.planedFinalDate = planedFinalDate;
	}

	public Calendar getRealStartDate() {
		return realStartDate;
	}

	public void setRealStartDate(Calendar realStartDate) {
		this.realStartDate = realStartDate;
	}

	public Calendar getRealFinalDate() {
		return realFinalDate;
	}

	public void setRealFinalDate(Calendar realFinalDate) {
		this.realFinalDate = realFinalDate;
	}


	public Stage(String name, int stageNumber, boolean isAvaiable) {
		this.name = name;
		this.stageNumber = stageNumber;
		this.isAvaiable = isAvaiable;
	}
	
		
	public Capsule[] getCapsules() {
		return capsules;
	}
	public Capsule getSpecificCapsule(int index) {
		return this.capsules[index];
	}

	public void setCapsules(Capsule[] capsules) {
		this.capsules = capsules;
	}

	public int getTechnique() {
		return this.technique;
	}

	public void setTechnique(int technique) {
		this.technique = technique;
	}

	public int getManagement() {
		return this.management;
	}

	public void setManagement(int management) {
		this.management = management;
	}

	public int getDomain() {
		return this.domain;
	}

	public void setDomain(int domain) {
		this.domain = domain;
	}

	public int getExperiencies() {
		return this.experiencies;
	}

	public void setExperiencies(int experiencies) {
		this.experiencies = experiencies;
	}


	public int getCapsuleIndex() {
		return this.capsuleIndex;
	}

	public void setCapsuleIndex(int capsuleIndex) {
		this.capsuleIndex = capsuleIndex;
	}
	
	
	
	

}
