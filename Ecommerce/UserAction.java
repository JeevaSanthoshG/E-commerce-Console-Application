package Ecommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserAction {
	
	static HashMap<Integer, ProductDetails> productList = DataBase.returnProductList();
	static HashMap<String, UserDetails> userList = DataBase.returnUserList();
	
	private static Scanner s= new Scanner(System.in);

    static void insert(String userCode) {
        System.out.println("Enter product ID : ");
        int productId = s.nextInt();
        System.out.println("Enter product name : ");
        String productName = s.next();
        System.out.println("Enter product price : ");
        int price = s.nextInt();
        ProductDetails newProductDetails = new ProductDetails(productId, userCode, productName, price);
        productList.put(productId, newProductDetails);
        System.out.println(productName+" inserted successfully");
        System.out.println("--------------------------------");
    }

    static void displayAll() {
        if (productList.isEmpty()) {
            System.out.println("No items to display.");
            System.out.println("--------------------------------");
        } 
        else {
            for (HashMap.Entry<Integer, ProductDetails> entry : productList.entrySet()) {
                System.out.println("id : " + entry.getValue().getProductId() + "\nname : " + entry.getValue().getProductName() + "\nprice : "+ entry.getValue().getPrice());
                System.out.println("--------------------------------");
            }
        }
    }

	static void displayParticular(){
		if(productList.isEmpty()) {
			System.out.println("No items is there to display.");
			System.out.println("--------------------------------");
		}
		else {
	    Scanner s=new Scanner(System.in);
	    System.out.println("Enter product ID : ");
	    for(HashMap.Entry<Integer,ProductDetails> entry : productList.entrySet()){    
	    	System.out.println("id : "+entry.getValue().getProductId());    
	    } 
	    int productId=s.nextInt();
	    System.out.println("--------------------------------");
	    System.out.println("name : "+productList.get(productId).getProductName()+"\nprice : "+productList.get(productId).getPrice());
	    System.out.println("--------------------------------");
	    s.close();
		}
	}

	static void update(String userId) {
		System.out.println("You can update only the values of product which is updated by this account.");
		System.out.println("--------------------------------");
		int count=0;
		if(productList.isEmpty()) {
			System.out.println("No items is there to update.");
			System.out.println("--------------------------------");
		}
		else {
			for(HashMap.Entry<Integer,ProductDetails> entry : productList.entrySet()){    
			     if(entry.getValue().getUserCode().equals(userId)) {
			    	 count++;
			     }
			   } 
			if(count > 0) {
			    System.out.println("Enter product ID : ");
			    for(HashMap.Entry<Integer,ProductDetails> entry : productList.entrySet()){    
				     if(entry.getValue().getUserCode().equals(userId)) {
				    	 System.out.println("id : "+entry.getValue().getProductId());
				     }
				   } 
			    int productId=s.nextInt();
			    s.nextLine();
			    System.out.println("Enter product name : ");
			    String productName=s.nextLine();
			    System.out.println("Enter product price : ");
			    int price=s.nextInt();
			    ProductDetails newNode = new ProductDetails(productId,userId,productName,price);
			    productList.put(productId,newNode);
			    System.out.println("--------------------------------");
			    System.out.println(productName+" updated successfully.");
			    System.out.println("--------------------------------");
			}
			else {
				System.out.println("No items are added using this account.");
				System.out.println("--------------------------------");
			}
		}
	}	

	static void deleteAll(String userId) {
		System.out.println("You can delete only the values of product which is updated by this account.");
		System.out.println("--------------------------------");
		if(productList.isEmpty()) {
			System.out.println("No items is there to delete.");
			System.out.println("--------------------------------");
		}
		else {
	        ArrayList<Integer> keysToRemove = new ArrayList<>();
	        for (HashMap.Entry<Integer, ProductDetails> entry : productList.entrySet()) {
	            if (entry.getValue().getUserCode().equals(userId)) {
	                keysToRemove.add(entry.getKey());
	            }
	        }
	        for (Integer key : keysToRemove) {
	            productList.remove(key);
	        }
	        System.out.println("All products added using this account are deleted.");
	        System.out.println("--------------------------------");
	    }
	}

	static void deleteParticular(String userId) {
		System.out.println("You can delete only the values of product which is updated by this account.");
		System.out.println("--------------------------------");
		if(productList.isEmpty()) {
			System.out.println("No items is there to update.");
			System.out.println("--------------------------------");
		}
		else {
			int count=0;
			for(HashMap.Entry<Integer,ProductDetails> entry : productList.entrySet()){    
			     if(entry.getValue().getUserCode().equals(userId)) {
			    	 count++;
			     }
			   } 
			if(count > 0) {
			    System.out.println("Enter product ID : ");
			    for(HashMap.Entry<Integer,ProductDetails> entry : productList.entrySet()){    
				     if(entry.getValue().getUserCode().equals(userId)) {
				    	 System.out.println("id : "+entry.getValue().getProductId());
				     }
				   }
			    int productId=s.nextInt();
			    System.out.println("--------------------------------");
			    System.out.println(productList.get(productId).getProductName()+" is deleted successfully.");
			    productList.remove(productId);
			    System.out.println("--------------------------------");
			}
			else {
				System.out.println("No items are added using this account to delete.");
				System.out.println("--------------------------------");
			}
		}
	}

	static void addCart(String userId) {
		UserDetails ud = userList.get(userId);
		if(productList.isEmpty()) {
			System.out.println("No items in the cart.");
			System.out.println("--------------------------------");
		}
		else {
	    System.out.println("Enter product ID to add to cart : ");
	    for(HashMap.Entry<Integer,ProductDetails> entry : productList.entrySet()){    
	    System.out.println("id : "+entry.getValue().getProductId());    
	   } 
	    int productId=s.nextInt();
	    System.out.println("Enter the number of quantity : ");
	    int quantity=s.nextInt();
	    ud.getCartItems().put(productId, quantity);
	    System.out.println("Successfully added to cart.");
	    System.out.println("--------------------------------");
		}
	}

	static void displayAllCart(String userId) {
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

	static void displayParticularCart(String userId) {
		UserDetails ud = userList.get(userId);
		if(ud.getCartItems().isEmpty()) {
			System.out.println("No items is there in cart to display.");
			System.out.println("--------------------------------");
		}
		else {
	    System.out.println("Enter product ID : ");
	    for(HashMap.Entry<Integer,Integer> entry : ud.getCartItems().entrySet()){    
	    	System.out.println("id : "+entry.getKey());    
	    } 
	    int productId=s.nextInt();
	    System.out.println("--------------------------------");
	    System.out.println("name : "+productList.get(productId).getProductName()+"\nprice per quantity : "+ productList.get(productId).getPrice()+"\nquantity : "+ud.getCartItems().get(productId)+"\ntotal price : "+ (productList.get(productId).getPrice() * ud.getCartItems().get(productId)) );
	    System.out.println("--------------------------------");
		}
	}

	static void updateParticularCart(String userId) {
		UserDetails ud = userList.get(userId);
		if(ud.getCartItems().isEmpty()) {
			System.out.println("No items is there in cart to update.");
			System.out.println("--------------------------------");
		}
		else {
	    System.out.println("Enter product ID to update : ");
	    for(HashMap.Entry<Integer,Integer> entry : ud.getCartItems().entrySet()){    
	    	System.out.println("id : "+entry.getKey());    
	    } 
	    int productId=s.nextInt();
	    System.out.println("--------------------------------");
	    System.out.println("Enter quantity: ");
	    int quantity=s.nextInt();
	    ud.getCartItems().put(productId,quantity);
	    System.out.println("--------------------------------");
		}
	}

	static void deleteParticularCart(String userId) {
		UserDetails ud = userList.get(userId);
		if(ud.getCartItems().isEmpty()) {
			System.out.println("No items is there in cart to delete.");
			System.out.println("--------------------------------");
		}
		else {
	    System.out.println("Enter product ID to delete: ");
	    for(HashMap.Entry<Integer,Integer> entry : ud.getCartItems().entrySet()){    
	    System.out.println("id : "+entry.getKey());    
	    } 
	    int productId=s.nextInt();
	    System.out.println("--------------------------------");
	    ud.getCartItems().remove(productId);
	    System.out.println("Deleted...!");
	    System.out.println("--------------------------------");
		}
	}

	static void deleteAllCart(String userId) {
		UserDetails ud = userList.get(userId);
		if(ud.getCartItems().isEmpty()) {
			System.out.println("Nothing added to cart for delete.");
			System.out.println("--------------------------------");
		}
		else {  
			ud.getCartItems().clear();
			System.out.println("All items in cart were Deleted...!");
			System.out.println("--------------------------------");
		}
	}


	static void confirmOrder(String userId) {
		UserDetails ud = userList.get(userId);
		if(ud.getCartItems().isEmpty()) {
			System.out.println("Nothing added to cart for order.");
			System.out.println("--------------------------------");
		}
		else {
		System.out.println("Ordered Products are : ");
		System.out.println("--------------------------------");
		int totalAmt=0;
		for(HashMap.Entry<Integer,Integer> entry : ud.getCartItems().entrySet()){    
	    	System.out.println("id : "+productList.get(entry.getKey()).getProductId()+"\nname : "+productList.get(entry.getKey()).getProductName()+"\nprice per quantity : "+ productList.get(entry.getKey()).getPrice()+"\nquantity : "+ud.getCartItems().get(entry.getKey())+"\ntotal price : "+ (productList.get(entry.getKey()).getPrice() * ud.getCartItems().get(entry.getKey())));
	    	totalAmt+=productList.get(entry.getKey()).getPrice() * ud.getCartItems().get(entry.getKey());
	    	System.out.println("--------------------------------");
		}  
		System.out.println("Total amount : "+totalAmt);
		System.out.println("--------------------------------");
		ud.getCartItems().clear();
		System.out.println("Order confirmed...!");
		System.out.println("--------------------------------");
		}
	}

	static void userActionMain(String userId) {
		    boolean state=true;
		    UserAuth ua=new UserAuth();
		    while(state){
		        System.out.println("Enter 1 for insert.");
		        System.out.println("Enter 2 for display all.");
		        System.out.println("Enter 3 for display particular.");
		        System.out.println("Enter 4 for update particular.");
		        System.out.println("Enter 5 for delete all.");
		        System.out.println("Enter 6 for delete particular.");
		        System.out.println("Enter 7 for add to cart with quantity.");
		        System.out.println("Enter 8 for display all cart item.");
		        System.out.println("Enter 9 for display particular cart item.");
		        System.out.println("Enter 10 for update particular cart item.");
		        System.out.println("Enter 11 for delete particular cart item.");
		        System.out.println("Enter 12 for delete all cart item.");
		        System.out.println("Enter 13 for confirm order.");
		        System.out.println("Enter 14 for exit.");
		        int option=s.nextInt();
		        System.out.println("--------------------------------");
		        switch(option){
		            case 1:insert(userId);break;
		            case 2:displayAll();break;
		            case 3:displayParticular();break;
		            case 4:update(userId);break;
		            case 5:deleteAll(userId);break;
		            case 6:deleteParticular(userId);break;
		            case 7:addCart(userId);break;
		            case 8:displayAllCart(userId);break;
		            case 9:displayParticularCart(userId);break;
		            case 10:updateParticularCart(userId);break;
		            case 11:deleteParticularCart(userId);break;
		            case 12:deleteAllCart(userId);break;
		            case 13:confirmOrder(userId);break;
		            case 14:ua.userAuthMain();state=false;break;
		            default :System.out.println("Enter valid input.");
		            		System.out.println("--------------------------------");break;
		        }
		    }
		    System.out.println("--------------------------------");
		    System.out.println("Shop closed...!");
		    System.out.println("--------------------------------");
		}
}