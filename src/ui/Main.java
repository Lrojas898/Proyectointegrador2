package ui;
import model.Enterprise;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
//gitHub Repository: https://github.com/Lrojas898/Proyectointegrador2.git
/**
 * This is the main class of the program. It will display all the menus required to register a project and create its information capsules per stage
 *
 * 
 * The program starts by instantiating an enterprise object where it will be stored all projects, its stages, and specific capsules. Enterprise will also registred its employees (project managers and collaborator) and clients. The user is asked to type a int value (in optional) to choose which action will do. The user can choose in this first version: 
 * 1.REGISTER MANAGER ( to register a project manager)
 * 2.REGISTER COLLABORATOR (to register a collaborator, those employees who create the capsules)
 * 3.REGISTER CLIENTS (to register the company's clients)
 * 4.REGISTER PROYECTS (to register the projects)
 * 5.APPROVE A STAGE (to approve a specific stage of a registered project)
 * 6.CREATE INFORMATION CAPSULE (to create an information capsule in a specific stage of a project)
 * 7.CONSULT INFORMATION CAPSULE BY KEYWORDS (consult a capsule by its keywords)
 * 8.CONSULT INFORMATION CAPSULE BY TEXT (consult a capsule by a fraction of its text)
 * 9.APPROVE INFORMATION CAPSULE  (approve the information or data in a capsule)
 * 10.APPROVE INFORMATION CAPSULE TO PUBLISH (approve that a previous capsule whose information has been approved can be published)
 * 11.PUBLISH INFORMATION CAPSULE (to obtain the url or html to publish a capsule)
 *
 * Once one option is selected, the program will call the methods in the enterprise class to do as requested.
 * Finally, a confirmation message will be displayed when the option selected is finished. 
 *
 * @author Luis Manuel Rojas Correa (A00399289)
 *
 */


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		/**
	     * Object (console) for the Scanner class. This class is for the user to enter values from the keyboard.
	     */
		Scanner console= new Scanner(System.in);
		Enterprise greenSQA= new Enterprise("Green SQA");
		int control = 99;
		greenSQA.readManagers();
		greenSQA.readClients();
		greenSQA.readEmployees();
		greenSQA.readProjects();
		greenSQA.readCapsules();
		
			do {
				System.out.println("\n\n\nPRINCIPAL MENU");
				System.out.println("Options: ");
				System.out.println("1.REGISTER MANAGERS ");
				System.out.println("2.REGISTER COLLABORATORS ");
				System.out.println("3.REGISTER CLIENTS ");
				System.out.println("4.REGISTER PROYECTS ");
				System.out.println("5.APPROVE A STAGE");
				System.out.println("6.CREATE INFORMATION CAPSULE ");
				System.out.println("7.CONSULT INFORMATION CAPSULE BY KEYWORDS");
				System.out.println("8.CONSULT INFORMATION CAPSULE BY TEXT");
				System.out.println("9.APPROVE INFORMATION CAPSULE ");
				System.out.println("10.APPROVE INFORMATION CAPSULE TO PUBLISH ");
				System.out.println("11.PUBLISH INFORMATION CAPSULE ");
				System.out.println("12.INFORM IF A COLLABORATOR HAS REGISTRED A CAPSULE IN A PROJECT");
				System.out.println("13.CONSULT THE PROJECT WITH MORE CAPSULES REGISTRED");
				System.out.println("14.INFORM THE TOTAL CAPSULES REGISTRED BY TYPE");
				System.out.println("15.INFORM LEARNINGS PER STAGE IN A PROJECT");
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
					case 12: 
						greenSQA.menuConsultCollaboratorbyName();
						break;
					case 13: 
						greenSQA.menuProjectWithMoreCapsules();
						break;
					case 14:
						greenSQA.menuInformcapsulesRegistredbyType();
						break;
					case 15:
						greenSQA.menuLearningperStage();
						break;
	
				}
			} while (control != 99);
	}

		}
			
			

			
		


