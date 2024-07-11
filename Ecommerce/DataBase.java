package Ecommerce;

import java.util.HashMap;

public class DataBase {
    static HashMap<String, UserDetails> userList = new HashMap<String, UserDetails>();

    static HashMap<Integer, ProductDetails> productList = new HashMap<Integer, ProductDetails>();
    
    static HashMap<String, String> adminList = new HashMap<String, String>();

    static {
        productList.put(101, new ProductDetails(101, "1", "Rice", 55));
        productList.put(102, new ProductDetails(102, "9080802151", "Wheat", 60));
        productList.put(103, new ProductDetails(103, "8778121406", "Dhal", 120));
        productList.put(104, new ProductDetails(104, "9080802151", "Corn", 80));
        productList.put(105, new ProductDetails(105, "1", "Millet", 180));
        userList.put("8778121406", new UserDetails("8778121406", "jeeva", "123", new HashMap<Integer, Integer>() {{
            put(101, 10);
            put(102, 12);
        }}));
        userList.put("9080802151", new UserDetails("9080802151", "kavin", "123", new HashMap<Integer, Integer>() {{
            put(103, 9);
            put(104, 11);
        }}));
        userList.put("1", new UserDetails("1", "santhosh", "1", new HashMap<Integer, Integer>() {{
            put(101, 11);
            put(105, 12);
        }}));
        adminList.put("admin", "123");
        adminList.put("2", "2");
    }

    public static HashMap<Integer, ProductDetails> returnProductList() {
        return productList;
    }
    public static HashMap<String, UserDetails> returnUserList() {
        return userList;
    }
    public static HashMap<String, String> returnAdminList() {
        return adminList;
    }
}
