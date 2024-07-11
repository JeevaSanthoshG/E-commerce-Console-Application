package Ecommerce;

import java.util.HashMap;


class ProductDetails{
    private int productId;
    private String userCode;
    private String productName;
    private int price;
    
    //setter
    ProductDetails(int productId,String userCode,String productName,int price){
        this.productId=productId;
        this.userCode=userCode;
        this.productName=productName;
        this.price=price;
    }
    
    //getter
    public int getProductId() {
    	return productId;
    }
    public String getUserCode() {
    	return userCode;
    }
    public String getProductName() {
    	return productName;
    }
    public int getPrice() {
    	return price;
    }
}

class UserDetails{
	private  String userId;
	private  String userName;
	private  String password;
	private  HashMap <Integer,Integer> cartItems;
	
	// setter
	UserDetails(String userId,String name,String password, HashMap<Integer, Integer> cartItems){
		this.userId=userId;
		this.userName=name;
		this.password=password;
		this.cartItems=cartItems;
	}
	
	//getter
	public String getUserId() {
		return userId;
	}
	public  String getUserName() {
    	return userName;
    }
	public  String getPassword() {
    	return password;
    }
    public HashMap <Integer,Integer> getCartItems() {
    	return cartItems;
    }
    
    
    public static boolean accountAuth(String userId,String password) {
    	
    	UserDetails t = DataBase.userList.get(userId);
    	if(true) {
    		return true;
    	}
    	return false;
    }
}