package com.resource;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
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
import com.model.JSONResponse;
import com.model.Product;
import com.service.MedicineService;

@Path("/medicine")
public class MedicineResource {

			private boolean success = false;
			private String message = "";
			
			MedicineService medicineService;
			
			JSONResponse jsonResponse;
			
			public MedicineResource() {
				super();
				medicineService = new MedicineService();
				jsonResponse = new JSONResponse();
			}

			@GET
			@Path("/products")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getAllProducts() throws SQLException
			{
					List<Product> productList = new ArrayList<>();					
					try{
							productList = medicineService.getAllProducts();
							if (productList.isEmpty())
								message = "No products available";
							else
								message = "Data retrieved successfully";
							success  = true;
					}
					catch(SQLException e)
					{
							e.printStackTrace();
							success = false;
							message = e.getMessage();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						success = false;
						message = e.getMessage();
					}					
					
					jsonResponse.setsuccess(success);
					jsonResponse.setMessage(message);
					jsonResponse.setData(productList);
					
					return Response.status(200).entity(jsonResponse).build();
			}
			
			@GET
			@Path("/products/{id}")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getProduct(@PathParam("id") int id) throws SQLException
			{
					Product product = new Product();
					try{
						product = medicineService.getProduct(id);
						success = true;
						if (product.isRecordAvailable())
							message = "Data retrieved successfully";
						else
							message = "No such product available";
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						success = false;
						message = e.getMessage();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						success = false;
						message = e.getMessage();
					}
					
					jsonResponse.setsuccess(success);
					jsonResponse.setMessage(message);
					if (product.isRecordAvailable())
						jsonResponse.setData(product);
					else
						jsonResponse.setData("[]");

					return Response.status(200).entity(jsonResponse).build();
			}
		
			@GET
			@Path("/categories")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getAllCategories() throws SQLException
			{
					List<Category> categoryList = new ArrayList<>();
					try{		
							categoryList = medicineService.getAllCategories();
							success = true;
							
							if (categoryList.isEmpty())
								message = "No categories available";
							else
								message = "Data retrieved successfully";
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						success = false;
						message = e.getMessage();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						success = false;
						message = e.getMessage();
					}
					
					jsonResponse.setsuccess(success);
					jsonResponse.setMessage(message);
					jsonResponse.setData(categoryList);

					return Response.status(200).entity(jsonResponse).build();
			}
			
			@GET
			@Path("/categories/{id}")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getCategory(@PathParam("id") int id) throws SQLException
			{
					Category category = new Category();
					try{
							category = medicineService.getCategory(id);
							success = true;
							
							if (category.isRecordAvailable())
								message = "Data retrieved successfully";
							else
								message = "No such categories available";
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						success = false;
						message = e.getMessage();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						success = false;
						message = e.getMessage();
					}
					
					jsonResponse.setsuccess(success);
					jsonResponse.setMessage(message);
					if (category.isRecordAvailable())
						jsonResponse.setData(category);
					else
						jsonResponse.setData("[]");

					return Response.status(200).entity(jsonResponse).build();
			}
			
			@GET
			@Path("/products/search/{searchText}")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getAllProductsBySearchText(@PathParam("searchText") String searchText) throws SQLException
			{
					List<String> productList = new ArrayList<>();
					try{
						productList = medicineService.getAllProductsBySearchText(searchText);
						message = "Data retrieved successfully";
						success = true;
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						success = false;
						message = e.getMessage();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						success = false;
						message = e.getMessage();
					}
					
					jsonResponse.setsuccess(success);
					jsonResponse.setMessage(message);
					jsonResponse.setData(productList);

					return Response.status(200).entity(jsonResponse).build();
			}
			
//			@POST
//			@Path("/products")
//			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//			public Response addProduct(@PathParam("code") int code,
//																@PathParam("name") String name,
//																@PathParam("catId") int catId,
//																@PathParam("price") double price,
//																@PathParam("image") String image,
//																@PathParam("desc") String desc,
//																@PathParam("status") boolean status,
//																@PathParam("presReq") boolean presReq,
//																@PathParam("tabStrips") int tabStrips) throws SQLException
//			{
//					try{
//					4		boolean result = medicineService.addProduct(code, name, catId, price, image, desc, status, presReq, tabStrips);
//							success = true;
//							message = "Product added successfully";
//					}
//					catch(SQLException e)
//					{
//						e.printStackTrace();
//						success = false;
//						message = e.getMessage();
//					}
//					catch(Exception e)
//					{
//						e.printStackTrace();
//						success = false;
//						message = e.getMessage();
//					}
//					
//					jsonResponse.setsuccess(success);
//					jsonResponse.setMessage(message);
//					//jsonResponse.setData(productList);
//
//					return Response.status(200).entity(jsonResponse).build();
//			}
			
			
			@POST
			@Path("/order")
			@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
			@Produces(MediaType.APPLICATION_JSON)
			public Response placeOrder(@FormParam("orderNo") int orderNo,
																@FormParam("userId") int userId,
																@FormParam("productId") int productId,
																@FormParam("orderDate") String orderDate,
																@FormParam("orderQty") int orderQty,
																@FormParam("orderPrice") double orderPrice) throws SQLException, ParseException
			{
					double total = orderQty * orderPrice;
					
					Timestamp sqlFormat = Timestamp.valueOf(orderDate);
					
					boolean result = false;
					
					try{
						result = medicineService.placeOrder(orderNo, userId, productId, sqlFormat, orderQty, orderPrice, total);
						message = "Order placed successfully";
						success = result;
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						success = result;
						message = e.getMessage();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						success = result;
						message = e.getMessage();
					}
					
					jsonResponse.setsuccess(success);
					jsonResponse.setMessage(message);
					//jsonResponse.setData(order);

					return Response.status(200).entity(jsonResponse).build();
			}
			
//			@POST
//			@Path("/abc")
//			@Consumes({MediaType.APPLICATION_JSON})
//			@Produces(MediaType.TEXT_HTML)
//			public Response abc(Order ord)
//			{
//					return Response.status(200).entity("Hi").build();
//			}
}
