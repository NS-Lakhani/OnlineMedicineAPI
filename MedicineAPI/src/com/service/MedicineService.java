package com.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dao.MedicineDao;
import com.model.Category;
import com.model.Order;
import com.model.Product;

public class MedicineService {
	
		MedicineDao dao;
		
		public MedicineService(){
			super();
			dao = new MedicineDao();
		}
		
		public List<Product> getAllProducts() throws Exception 
		{
				List<Product> productList = new ArrayList<>();
				try{
					productList = dao.getAllProducts();
				}
				catch(Exception e)
				{
						throw e;
				}
				return productList;
		}
		
		public List<Category> getAllCategories() throws Exception
		{
				List<Category> categoryList = new ArrayList<>();
				categoryList = dao.getAllCategories();
				
				return categoryList;
		}

		public Product getProduct(int id) throws Exception 
		{
				Product product = new Product();
				product = dao.getProduct(id);
				
				return product;
		}
		
		public Category getCategory(int id) throws Exception
		{
			Category category = new Category();
			category = dao.getCategory(id);
				
			return category;
		}

		public List<String> getAllProductsBySearchText(String searchText) throws Exception 
		{
			List<String> productList = new ArrayList<>();
			productList = dao.getAllProductsBySearchText(searchText);
			
			return productList;
		}
		
		public boolean addProduct(int code, String name, int catId, double price, String image, String desc, boolean status, boolean presReq, int tabStrips) throws Exception
		{
				boolean result = dao.addProduct(code, name, catId, price, image, desc, status, presReq, tabStrips);
				return result;	
		}

		public boolean placeOrder(int orderNo, int userId, int productId, Timestamp orderDate, int orderQty, double orderPrice, double orderTotal) throws Exception 
		{
				boolean result = dao.placeOrder(orderNo, userId, productId, orderDate, orderQty, orderPrice, orderTotal);
				return result;
		}
		
		public List<Order> getAllOrders() throws Exception 
		{
			List<Order> orderList = new ArrayList<>();
			orderList = dao.getAllOrders();
			
			return orderList;
		}
}
