package com.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Category;
import com.model.Product;
import com.service.MedicineService;

@Path("/medicine")
public class MedicineResource {

			MedicineService medicineService;
			
			public MedicineResource() {
				super();
				medicineService = new MedicineService();
			}

			@GET
			@Path("/products")
			@Produces(MediaType.APPLICATION_JSON)
			public List<Product> getAllProducts() throws SQLException
			{
					List<Product> productList = new ArrayList<>();
					productList = medicineService.getAllProducts();
					
					return productList;
			}
			
			@GET
			@Path("/products/{id}")
			@Produces(MediaType.APPLICATION_JSON)
			public Product getProduct(@PathParam("product") String id)
			{
					
					return new Product();
			}
		
			@GET
			@Path("/categories")
			@Produces(MediaType.APPLICATION_JSON)
			public List<Category> getAllCategories() throws SQLException
			{
					List<Category> categoryList = new ArrayList<>();
					categoryList = medicineService.getAllCategories();
					
					return categoryList;
			}
}
