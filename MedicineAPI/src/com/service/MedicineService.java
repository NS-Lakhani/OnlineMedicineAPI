package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.MedicineDao;
import com.model.Product;

public class MedicineService {
	
		MedicineDao dao;
		
		public MedicineService(){
			super();
			dao = new MedicineDao();
		}
		
		public List<Product> getAllProducts() 
		{
			List<Product> productList = new ArrayList<>();
			productList = dao.getAllProducts();
			
			return productList;
		}

}
