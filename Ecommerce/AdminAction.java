package Ecommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AdminAction {
	
	private static Scanner s= new Scanner(System.in);
	
	static HashMap<Integer, ProductDetails> productList = DataBase.returnProductList();
	static HashMap<String, UserDetails> userList = DataBase.returnUserList();
	
	static void displayAllUser() {
		if (userList.isEmpty()) {
            System.out.println("No user to display.");
            System.out.println("--------------------------------");
        } 
        else {
            for (HashMap.Entry<String, UserDetails> entry : userList.entrySet()) {
                System.out.println("id : " + entry.getValue().getUserId()+"\nname : " + entry.getValue().getUserName() + "\npassword : "+ entry.getValue().getPassword());
                System.out.println("--------------------------------");
            }
        }
	}
	
	static void displayParticularUser() {
		if(userList.isEmpty()) {
			System.out.println("No user is there to display.");
			System.out.println("--------------------------------");
		}
		else {
	    System.out.println("Enter product ID : ");
	    s.nextLine();
	    for(HashMap.Entry<String,UserDetails> entry : userList.entrySet()){    
	    	System.out.println("id : "+entry.getValue().getUserId());    
	    } 
	    String userId=s.nextLine();
	    System.out.println("--------------------------------");
	    System.out.println("name : "+userList.get(userId).getUserName()+"\npassword : "+userList.get(userId).getPassword());
	    System.out.println("--------------------------------");
	    System.out.println("Cart : ");
		    UserDetails ud = userList.get(userId);
			if(ud.getCartItems().isEmpty()) {
				System.out.println("No items is there in cart to display.");
				System.out.println("--------------------------------");
			}
			else {
		    for(HashMap.Entry<Integer,Integer> entry : ud.getCartItems().entrySet()){    
		    	System.out.println("id : "+productList.get(entry.getKey()).getProductId()+"\nname : "+productList.get(entry.getKey()).getProductName()+"\nprice per quantity : "+ productList.get(entry.getKey()).getPrice()+"\nquantity : "+ud.getCartItems().get(entry.getKey())+"\ntotal price : "+ (productList.get(entry.getKey()).getPrice() * ud.getCartItems().get(entry.getKey())));
		    System.out.println("--------------------------------");
		    }
		   } 
		}
	}
	
	static void updateUser() {
		
	}
	
	static void deleteAllUser() {
		if(userList.isEmpty()) {
			System.out.println("No items is there to delete.");
			System.out.println("--------------------------------");
		}
		else {
	        userList.clear();
	        System.out.println("All products added are deleted.");
	        System.out.println("--------------------------------");
		}
	}
	
	static void deleteParticularUser() {
		
	}
	
	static void displayAllProduct() {
		if (productList.isEmpty()) {
            System.out.println("No items to display.");
            System.out.println("--------------------------------");
        } 
        else {
            for (HashMap.Entry<Integer, ProductDetails> entry : productList.entrySet()) {
                System.out.println("id : " + entry.getValue().getProductId()+"\nuserCode : "+entry.getValue().getUserCode() + "\nname : " + entry.getValue().getProductName() + "\nprice : "+ entry.getValue().getPrice());
                System.out.println("--------------------------------");
            }
        }
	}
	
	static void displayParticularProduct() {
		if(productList.isEmpty()) {
			System.out.println("No items is there to display.");
			System.out.println("--------------------------------");
		}
		else {
	    System.out.println("Enter product ID : ");
	    for(HashMap.Entry<Integer,ProductDetails> entry : productList.entrySet()){    
	    	System.out.println("id : "+entry.getValue().getProductId());    
	    } 
	    int productId=s.nextInt();
	    System.out.println("--------------------------------");
	    System.out.println("name : "+productList.get(productId).getProductName()+"\nprice : "+productList.get(productId).getPrice());
	    System.out.println("--------------------------------");
		}
	}
	
	static void updateProduct() {
		if(productList.isEmpty()) {
			System.out.println("No items is there to update.");
			System.out.println("--------------------------------");
		}
		else {
			    System.out.println("Enter product ID : ");
			    for(HashMap.Entry<Integer,ProductDetails> entry : productList.entrySet()){    
				    	 System.out.println("id : "+entry.getValue().getProductId());
				   } 
			    int productId=s.nextInt();
			    s.nextLine();
			    System.out.println("Enter user code : ");
			    String userCode=s.nextLine();
			    System.out.println("Enter product name : ");
			    String productName=s.nextLine();
			    System.out.println("Enter product price : ");
			    int price=s.nextInt();
			    ProductDetails newNode = new ProductDetails(productId,userCode,productName,price);
			    productList.put(productId,newNode);
			    System.out.println("--------------------------------");
			    System.out.println(productName+" updated successfully.");
			    System.out.println("--------------------------------");
		}
	}
	
	static void deleteAllProduct() {
		if(productList.isEmpty()) {
			System.out.println("No items is there to delete.");
			System.out.println("--------------------------------");
		}
		else {
	        productList.clear();
	        System.out.println("All products added are deleted.");
	        System.out.println("--------------------------------");
		}
	}
	
	static void deleteParticularProduct() {
		if(productList.isEmpty()) {
			System.out.println("No items is there to update.");
			System.out.println("--------------------------------");
		}
		else {

			    System.out.println("Enter product ID : ");
			    for(HashMap.Entry<Integer,ProductDetails> entry : productList.entrySet()){    
				    	 System.out.println("id : "+entry.getValue().getProductId());
				   }
			    int productId=s.nextInt();
			    System.out.println("--------------------------------");
			    System.out.println(productList.get(productId).getProductName()+" is deleted successfully.");
			    productList.remove(productId);
			    System.out.println("--------------------------------");
		}
	}

	static void adminActionMain(String adminId){
		boolean state=true;
	    UserAuth ua=new UserAuth();
	    while(state){
	        System.out.println("Enter 1 for display all user.");
	        System.out.println("Enter 2 for display particular user.");
	        System.out.println("Enter 3 for update user.");
	        System.out.println("Enter 4 for delete all user.");
	        System.out.println("Enter 5 for delete particular user.");
	        System.out.println("Enter 6 for display all product.");
	        System.out.println("Enter 7 for display particular product.");
	        System.out.println("Enter 8 for update product.");
	        System.out.println("Enter 9 for delete all product.");
	        System.out.println("Enter 10 for delete particular product.");
	        System.out.println("Enter 11 for exit.");
	        int option=s.nextInt();
	        System.out.println("--------------------------------");
	        switch(option){
	            case 1:displayAllUser();break;
	            case 2:displayParticularUser();break;
	            case 3:updateUser();break;
	            case 4:deleteAllUser();break;
	            case 5:deleteParticularUser();break;
	            case 6:displayAllProduct();break;
	            case 7:displayParticularProduct();break;
	            case 8:updateProduct();break;
	            case 9:deleteAllProduct();break;
	            case 10:deleteParticularProduct();break;
	            case 11:ua.userAuthMain();state=false;break;
	            default :System.out.println("Enter valid input.");
	            		System.out.println("--------------------------------");break;
	        }
	    }
	    System.out.println("--------------------------------");
	    System.out.println("Shop closed...!");
	    System.out.println("--------------------------------");
	}
}
