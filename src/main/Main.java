package main;
import GreenSQAClasses.Enterprise;
import java.util.Scanner;
import java.io.File;
public class Main {

	public static void main(String[] args) {
		Scanner console= new Scanner(System.in);
		Enterprise greenSQA= new Enterprise("Green SQA");
		int control = 99;
		do {
			System.out.println("\n\n\nPRINCIPAL MENU");
			System.out.println("Options: ");
			System.out.println("1.REGISTER MANAGERS: ");
			System.out.println("2.REGISTER COLLABORATORS: ");
			System.out.println("3.REGISTER CLIENTS: ");
			System.out.println("4.REGISTER PROYECTS: ");
			System.out.println("5.APPROVE A STAGE");
			System.out.println("6.CREATE INFORMATION CAPSULE: ");
			System.out.println("7.CONSULT INFORMATION CAPSULE BY KEYWORDS");
			System.out.println("8.CONSULT INFORMATION CAPSULE BY TEXT");
			System.out.println("9.APPROVE INFORMATION CAPSULE: ");
			System.out.println("10.APPROVE INFORMATION CAPSULE TO PUBLISH: ");
			System.out.println("11.PUBLISH INFORMATION CAPSULE: ");
			System.out.print("\nTYPE YOUR OPTION (99 EXIT): ");
			control = console.nextInt();
			switch(control) {
				case 1: 
					greenSQA.menusRegisterManager();
					System.out.println("The Manager has been succesfully registred");
					break;
				
				case 2: 
					greenSQA.menusRegisterCollaborators();
					System.out.println("The Collaborator has been succesfully registred");
					break;
				
				case 3: 
					greenSQA.menusRegisterClients();
					System.out.println("The Client has been succesfully registred");
					break;
				
				case 4: 
					greenSQA.menuCreateProject();
					System.out.println("The Project has been succesfully registred");
					break;
					
				case 5: 
					greenSQA.menuApproveStage();
					break;
				
				case 6: 
					greenSQA.menuCreateCapsule();
					System.out.println("The Capsule has been succesfully registred");
					break;
				
				case 7: 
					greenSQA.menuConsultCapsulebyKeywords();
					break;
				
				case 8: 
					greenSQA.menuConsultCapsulebyText();
					break;
				
				case 9: 
					greenSQA.menuApproveCapsule();
					System.out.println("The capsule has been succesfully approved");
					break;
				
				case 10: 
					greenSQA.menuApproveCapsuleToPublish();
					System.out.println("The manager has been succesfully registred");
					break;
				
				case 11:
					greenSQA.menuPublishCapsule();
					break;
					
			}
		} while (control != 99);
	}

}


