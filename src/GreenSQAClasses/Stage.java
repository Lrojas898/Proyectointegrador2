package GreenSQAClasses;
import GreenSQAClasses.Capsule;
import java.util.Calendar;
import java.util.Scanner;

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

	public void createCapsule(int selectCapsuleType, Collaborator collaborator, String description, String learning, String code, String ProjectCode, int stageCapsuleNumber) {
		this.capsules[this.capsuleIndex]= new Capsule(this.capsuleIndex,capsuleType[selectCapsuleType], collaborator, description, learning, code, ProjectCode, stageCapsuleNumber);
		capsuleIndex++;
	}
	
	public void approveCapsule(int capsuleNumber, boolean approve) {
		this.capsules[capsuleNumber].setApproved(approve);
		this.capsules[capsuleNumber].setApprovalDate(currentDate);
	}
	public void approveToPublish(int capsuleNumber, boolean approve)
	{
		if(this.capsules[capsuleNumber].isApproved()==true) {
		this.capsules[capsuleNumber].setApprovedToPublish(approve);
		}else {
			System.out.println("The capsule has not been yet approved");
		}
		
		
	}
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
	
	
	
	public String searchCapsuleKeywords(String keywords[]) {
		Scanner console= new Scanner(System.in);
		int optional;
		for(int c=0;c<this.capsuleIndex;c++) {
			for(int r=0;r<this.capsules[c].getKeywords().length;r++) {
				for(int k=0;k<keywords.length;k++) {
					if(this.capsules[c].getSpecificKeyword(r).equals(keywords[k])) {
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
		return null;	
	}
	
	public Capsule searchCapsuleText(String text) {
		Scanner console= new Scanner(System.in);
		int optional=0;
		for(int i=0;i<this.capsules.length;i++) {
			
				if((this.capsules[i].getDescription().contains(text)) || (this.capsules[i].getLearning().contains(text))) {
					
					System.out.println("Is this the capsule you were searching?");
					System.out.println(this.capsules[i].toString());
					System.out.println("YES [1] NO [2]");
					optional=console.nextInt();
					if(optional==1) {
						return this.capsules[i];}
					}	
				
			}
		return null;
	}
	
	
	
	

}
