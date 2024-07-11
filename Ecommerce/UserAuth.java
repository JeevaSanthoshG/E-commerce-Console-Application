package Ecommerce;

import java.util.*;

public class UserAuth {
	
	HashMap <String,UserDetails> userList=DataBase.userList;
	private static Scanner s = new Scanner(System.in);
	
	public void register() {
		System.out.println("Enter Mobile Number and it is your user ID : ");
		s.nextLine();
		String userId=s.nextLine();
		System.out.println("Enter Name : ");
		String userName=s.nextLine();
		System.out.println("Enter Password : ");
		String password=s.nextLine();
		System.out.println("-------------------");
		
		if(userList.containsKey(userId)) {
			System.out.println("User already exist...!");
			System.out.println("-------------------");
		}
		else if(!userId.equals("") && !userName.equals("") && !password.equals("")){
			UserDetails newUserDetails=new UserDetails(userId,userName,password, null);
			userList.put(userId, newUserDetails);
			System.out.println("Register successfull...!");
			System.out.println("-------------------");
		}
		else {
			System.out.println("Register unsuccessfull because, Mobile number, Name and Password all fields are required.");
			System.out.println("-------------------");
		}
	}
	
	void login() {
		System.out.println("Enter Mobile Number : ");
		s.nextLine();
		String userId=s.nextLine();
		System.out.println("Enter Password : ");
		String password=s.nextLine();
		System.out.println("-------------------");
		if(!userList.containsKey(userId)) {
			System.out.println("User not exist please register...!");
			System.out.println("-------------------");
		}
		else if(!userId.equals("") && !password.equals("")){
			if(UserDetails.accountAuth(userId,password)) {
				System.out.println("Welcome "+userList.get(userId).getUserName()+"...!");
				System.out.println("-------------------");
				UserAction.userActionMain(userId);
			}
			else {
				System.out.println("Invalid password...!");
				System.out.println("-------------------");
			}
		}
		else {
			System.out.println("Login unsuccessfull because, Mobile number and Password all fields are required.");
			System.out.println("-------------------");
		}
	}

	void userAuthMain() {
		UserAuth aob=new UserAuth();
		String n="yes";
		while(!n.equals("no")){
	        System.out.println("Enter 1 for Register.");
	        System.out.println("Enter 2 for Login.");
	        int option=s.nextInt();
	        System.out.println("-------------------");
	        switch(option){
	            case 1:aob.register();break;
	            case 2:aob.login();break;
	            default: System.out.println("Invalid input...!");
	        }
	    }
	}
}