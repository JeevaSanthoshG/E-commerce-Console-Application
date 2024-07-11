package Ecommerce;

import java.util.Scanner;

public class AppMain {
	
	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean state=true;
	    UserAuth ua=new UserAuth();
	    AdminAuth aa=new AdminAuth();
	    while(state){
	        System.out.println("Enter 1 for Admin.");
	        System.out.println("Enter 2 for User.");
	        System.out.println("Enter 3 for Exit");
	        int option=s.nextInt();
	        System.out.println("--------------------------------");
	        switch(option){
	            case 1:state=false;aa.adminAuthMain();break;
	            case 2:state=false;ua.userAuthMain();break;
	            case 3:
	            	state=false;
	            	System.out.println("******************************");
	            	System.out.println("*   Program Terminated...!   *");
	            	System.out.println("******************************");
	            	break;
	            default :System.out.println("Enter valid input.");
	            		 System.out.println("--------------------------------");
	            		 break;
	        }
	    }
	}
}