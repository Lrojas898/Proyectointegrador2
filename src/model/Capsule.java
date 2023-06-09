package model;
import java.util.Arrays;
import java.util.Calendar;
import model.Collaborator;
import model.Project;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This Class is to create a information capsule for a particular stage of a project with its  specify attributes:
 * Capsule Type
 * Collaborator who created it 
 * description
 * identification code
 * @author luism
 *
 */
public class Capsule {
	
	
	private int capsuleNumber;
	private String code;
	private String type;
	private String learning;
	private String description;
	private Collaborator collaborator;
	private String projectCode;
	//Especificar que se informa sobre el numero de la etapa y no la etapa
	private int stageNumber;
	private String html;
	private boolean isApproved;
	private Calendar approvalDate;
	private boolean isApprovedToPublish;
	private String[] keywords= new String[10000000];

	
	/**
	 * Constructor method of capsule
	 * @param capsuleNumber
	 * @param type
	 * @param collaborator
	 * @param description
	 * @param learning
	 * @param code
	 * @param projectCode
	 * @param stageNumber
	 */
	
	public Capsule(int capsuleNumber, String type, Collaborator collaborator, String description, String learning, String code, String projectCode, int stageNumber) {
		this.capsuleNumber = capsuleNumber;
		this.type = type;
		this.collaborator=collaborator;
		this.collaborator.addCapsule(this.capsuleNumber);
		this.description=description;
		this.learning=learning;
		this.code=code;
		this.projectCode=projectCode;
		this.stageNumber=stageNumber;
		String stringKeywords=this.description+this.learning;
		int indexKeywords=0;
		for(int i=0;i<stringKeywords.length();i++){
			if(stringKeywords.charAt(i)== '#' ){
				indexKeywords++;
			}
		}
		
		this.keywords=new String[indexKeywords/2];
		int index=0;
		int startIndex=stringKeywords.indexOf("#");
		while(startIndex!=-1){
			int endIndex=stringKeywords.indexOf("#", startIndex+1);
		
		if(endIndex!=-1){
			String word= stringKeywords.substring(startIndex+1, endIndex);
			keywords[index]=word;
			index++;
			startIndex=stringKeywords.indexOf("#", endIndex+1);
		}else{
			break;
		}
	}

	}
	

	public int getCapsuleNumber() {
		return capsuleNumber;
	}

	public void setCapsuleNumber(int capsuleNumber) {
		this.capsuleNumber = capsuleNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLearning() {
		return learning;
	}


	public void setLearning(String learning) {
		this.learning = learning;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Calendar getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Calendar approvalDate) {
		this.approvalDate = approvalDate;
	}

	public boolean isApprovedToPublish() {
		return isApprovedToPublish;
	}

	public void setApprovedToPublish(boolean isApprovedToPublish) {
		this.isApprovedToPublish = isApprovedToPublish;
	}
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String[] getKeywords() {
		return this.keywords;
	}
	
	public String getSpecificKeyword(int index) {
		return this.keywords[index];
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public Collaborator getCollaborator() {
		return this.collaborator;
	}

	/**
	 * to string method
	 */
	public String toString() {
		String approvalMenssage;
		if(this.isApproved==false) {
			approvalMenssage="The capsule has not been approved";
		}
		else {
			approvalMenssage="The capsule has been approved";
		}
		
		String approvalMenssagePublish;
		if(this.isApprovedToPublish==false) {
			approvalMenssagePublish="The capsule has not been approved to be published";
		}
		else {
			approvalMenssagePublish="The capsule has been approved to be published ";
		}
		
		
		if(this.isApproved==false){
			return "Capsule [Capsule type= " + type + "\n"+ ", Capsue Learning=" + learning
			+  "\n"+  " Capsule description=" + description + "\n"+  " Collaborator=" + collaborator.getId() + "\n"+  " Project Code where the Capsule is stored= "  + projectCode+ "\n" + " Stage Number where the capsule is stored "+stageNumber+ "\n"+
			 " Capsule html=" + html + " Is the Capsule Approved? =" + approvalMenssage + "\n"+" approvalDate = The capsule has not been approved" 
			+ "\n"+ " Is the capsule Approved to be Publish? = " + approvalMenssagePublish +"\n"+  " Capsule keywords = " + Arrays.toString(keywords)
			+  "]";
		}

		return "Capsule [Capsule type= " + type + "\n"+ ", Capsue Learning=" + learning
				+  "\n"+  ", Capsule description=" + description + "\n"+  ", Collaborator=" + collaborator.getId() + "\n"+  ", Project Code where the Capsule is stored= "  + projectCode+ "\n" + ", Stage Number where the capsule is stored "+stageNumber+
				"\n"+ " Capsule html=" + html +"\n" +", Is the Capsule Approved? =" + approvalMenssage + "\n"+ ", approvalDate = " + approvalDate.getTime()
				+ "\n"+ ", Is the capsule Approved to be Publish? = " + approvalMenssagePublish +"\n"+  ", Capsule keywords = " + Arrays.toString(keywords)
				+  "]";
	} 
	

}
