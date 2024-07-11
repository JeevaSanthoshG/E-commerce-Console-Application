package Ecommerce;

import java.util.HashMap;
import java.util.Scanner;

public class AdminAuth {
	
	HashMap <String,String> adminList=DataBase.adminList;
	private static Scanner s = new Scanner(System.in);

	public void register() {
		System.out.println("Enter adminId: ");
		s.nextLine();
		String adminId=s.nextLine();
		System.out.println("Enter Password : ");
		String adminPassword=s.nextLine();
		System.out.println("Enter Reference : ");
		String reference=s.nextLine();
		System.out.println("-------------------");
		if(adminList.containsKey(adminId)) {
			System.out.println("Admin already exist...!");
			System.out.println("-------------------");
		}
		else if(!adminId.equals("") && !adminPassword.equals("") && !reference.equals("")){
			if(adminList.containsKey(reference)) {
				adminList.put(adminId, adminPassword);
				System.out.println("Register successfull...!");
				System.out.println("-------------------");
			}
			else {
				System.out.println("Reference invalid...!");
				System.out.println("-------------------");
			}
		}
		else {
			System.out.println("Register unsuccessfull because, AdminId, AdminPassword and Reference all fields are required.");
			System.out.println("-------------------");
		}
	}
	
	void login() {
		System.out.println("Enter adminId : ");
		s.nextLine();
		String adminId=s.nextLine();
		System.out.println("Enter Password : ");
		String adminPassword=s.nextLine();
		System.out.println("-------------------");
		if(!adminList.containsKey(adminId)) {
			System.out.println("User not exist please register...!");
			System.out.println("-------------------");
		}
		else if(!adminId.equals("") && !adminPassword.equals("")){
			if(adminList.containsKey(adminId) && adminPassword.equals(adminList.get(adminId))) {
				System.out.println("Welcome "+adminId+"...!");
				System.out.println("-------------------");
				AdminAction.adminActionMain(adminId);
			}
			else {
				System.out.println("Invalid password...!");
				System.out.println("-------------------");
			}
		}
		else {
			System.out.println("Login unsuccessfull because, AdminId and Password all fields are required.");
			System.out.println("-------------------");
		}
	}

	void adminAuthMain() {
		AdminAuth aob=new AdminAuth();
		boolean state=true;
		while(state){
			System.out.println("Admin");
	        System.out.println("Enter 1 for Register.");
	        System.out.println("Enter 2 for Login.");
	        System.out.println("Enter 3 for Exit.");
	        int option=s.nextInt();
	        System.out.println("-------------------");
	        switch(option){
	            case 1:aob.register();break;
	            case 2:aob.login();break;
	            case 3:AppMain am=new AppMain();
	            am.main(null);
	            	   state=false;
	            	   break;
	            default: System.out.println("Invalid input, enter valid input...!");
	        }
	    }
	}

}
