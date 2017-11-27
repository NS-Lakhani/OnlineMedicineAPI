package com.resource;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
			public Product getProduct(@PathParam("id") int id) throws SQLException
			{
					Product product = new Product();
					product = medicineService.getProduct(id);
					
					return product;
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
			
			@GET
			@Path("/categories/{id}")
			@Produces(MediaType.APPLICATION_JSON)
			public Category getCategory(@PathParam("id") int id) throws SQLException
			{
				Category category = new Category();
				category = medicineService.getCategory(id);
					
				return category;
			}
			
			@GET
			@Path("/products/search/{searchText}")
			@Produces(MediaType.APPLICATION_JSON)
			public List<String> getAllProductsBySearchText(@PathParam("searchText") String searchText) throws SQLException
			{
					List<String> productList = new ArrayList<>();
					productList = medicineService.getAllProductsBySearchText(searchText);
					
					return productList;
			}
			
			@POST
			@Path("/products")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			public Response addProduct(@FormParam("code") int code,
																@FormParam("name") String name,
																@FormParam("catId") int catId,
																@FormParam("price") double price,
																@FormParam("image") String image,
																@FormParam("desc") String desc,
																@FormParam("status") boolean status,
																@FormParam("presReq") boolean presReq,
																@FormParam("tabStrips") int tabStrips) throws SQLException
			{
					boolean result = medicineService.addProduct(code, name, catId, price, image, desc, status, presReq, tabStrips);
					if (result)
						return Response.status(200).entity("Product added successfully").build();
					else
						return Response.status(200).entity("something went wrong").build();
			}
			
			
			@POST
			@Path("/products/order")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			public Response placeOrder(@FormParam("orderNo") int orderNo,
																@FormParam("userId") int userId,
																@FormParam("productId") int productId,
																@FormParam("orderDate") Date orderDate,
																@FormParam("orderQty") int orderQty,
																@FormParam("orderPrice") double orderPrice) throws SQLException
			{
					double total = orderQty * orderPrice;
					boolean result = medicineService.placeOrder(orderNo, userId, productId, orderDate, orderQty, orderPrice, total);
					if (result)
						return Response.status(200).entity("Order placed successfully").build();
					else
						return Response.status(200).entity("something went wrong").build();
			}
}
