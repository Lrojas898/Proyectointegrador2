package GreenSQAClasses;
import java.util.Arrays;
import java.util.Calendar;
import GreenSQAClasses.Collaborator;
import GreenSQAClasses.Project;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Capsule {
	
	
	private int capsuleNumber;
	private String type;
	private String learning;
	private String description;
	private Collaborator collaborator;
	private String projectCode;
	private String html;
	private boolean isApproved;
	private Calendar approvalDate;
	private boolean isApprovedToPublish;
	private String[] keywords= new String[10000000];
	private int indexKeywords=0;
	
	//this, corresponde al objeto, sin this corresponde a la clase
	public Capsule(int capsuleNumber, String type, Collaborator collaborator, String description, String learning) {
		this.capsuleNumber = capsuleNumber;
		this.type = type;
		this.collaborator=collaborator;
		this.collaborator.addCapsule(this.capsuleNumber);
		this.description=description;
		this.learning=learning;
		String stringKeywords=this.description+this.learning;
		String [] foundKeywords=stringKeywords.split("#");
		this.keywords= new String[(foundKeywords.length-1)/2];
		this.indexKeywords=0;
		for(int i=1;i<foundKeywords.length;i+=2) {
			this.keywords[indexKeywords]=foundKeywords[i];
			this.indexKeywords++;
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

	


	public String[] getKeywords() {
		return keywords;
	}
	
	public String getSpecificKeyword(int index) {
		return keywords[index];
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "Capsule [capsuleNumber=" + capsuleNumber + ", type=" + type + ", learning=" + learning
				+ ", description=" + description + ", collaborator=" + collaborator + ", projectCode=" + projectCode
				+ ", html=" + html + ", isApproved=" + isApproved + ", approvalDate=" + approvalDate
				+ ", isApprovedToPublish=" + isApprovedToPublish + ", keywords=" + Arrays.toString(keywords)
				+ ", indexKeywords=" + indexKeywords + "]";
	} 
	

}
