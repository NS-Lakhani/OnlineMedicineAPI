package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.DBConnection;
import com.model.Category;
import com.model.Order;
import com.model.Product;

public class MedicineDao {
	
		private Connection conn = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		public List<Product> getAllProducts() throws SQLException 
		{
				List<Product> productList = new ArrayList<>();
				try{
						conn = DBConnection.getConnection();
						String sql = "SELECT * FROM PRODUCT_MASTER ORDER BY PR_ID";
						ps = conn.prepareStatement(sql);
						rs = ps.executeQuery();
						
						while (rs.next())
						{
							Product product = new Product();
							product.setId(rs.getInt(1));
							product.setProductCode(rs.getInt(2));
							product.setProductName(rs.getString(3));
							product.setProductCategoryId(rs.getInt(4));
							product.setProductPrice(rs.getDouble(5));
							product.setProductImagePath(rs.getString(6));
							product.setProductDescription(rs.getString(7));
							product.setProductStatus(rs.getBoolean(8));
							product.setProductPrescriptionReq(rs.getBoolean(9));
							product.setProductTabStrips(rs.getInt(10));
							productList.add(product);
						}	
				}
				catch(SQLException e)
				{
						e.printStackTrace();
				}
				catch(Exception e)
				{
						e.printStackTrace();
				}
				finally
				{
					if (conn != null)
						conn.close();
				}
				return productList;
		}
	
		public List<Category> getAllCategories() throws SQLException 
		{
				List<Category> list = new ArrayList<>();
				
				try{
						conn = DBConnection.getConnection();
						String sql = "SELECT * FROM CATEGORY_MASTER ORDER BY CAT_ID";
						ps = conn.prepareStatement(sql);
						rs = ps.executeQuery();
						
						while (rs.next())
						{
								Category category = new Category();
								category.setId(rs.getInt(1));
								category.setCategoryName(rs.getString(2));
								
								list.add(category);
						}	
				}
				catch(SQLException e)
				{
						e.printStackTrace();
				}
				catch(Exception e)
				{
						e.printStackTrace();
				}
				finally
				{
					if (conn != null)
						conn.close();
				}
				return list;
		}

		public Product getProduct(int id) throws SQLException 
		{
				Product product = new Product();
				try{
					conn = DBConnection.getConnection();
					String sql = "SELECT * FROM PRODUCT_MASTER WHERE PR_ID = ?";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, id);
					rs = ps.executeQuery();
				
					while (rs.next())
					{
						product = new Product();
						product.setId(rs.getInt(1));
						product.setProductCode(rs.getInt(2));
						product.setProductName(rs.getString(3));
						product.setProductCategoryId(rs.getInt(4));
						product.setProductPrice(rs.getDouble(5));
						product.setProductImagePath(rs.getString(6));
						product.setProductDescription(rs.getString(7));
						product.setProductStatus(rs.getBoolean(8));
						product.setProductPrescriptionReq(rs.getBoolean(9));
						product.setProductTabStrips(rs.getInt(10));
					}	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (conn != null)
						conn.close();
				}
				return product;
			}
		
			public Category getCategory(int id) throws SQLException 
			{
				Category category = new Category();
				
				try{
					conn = DBConnection.getConnection();
					String sql = "SELECT * FROM CATEGORY_MASTER WHERE CAT_ID = ?";
					ps = conn.prepareStatement(sql);
					ps.setInt(1,id);
					rs = ps.executeQuery();
					
					if (rs.next())
					{
						category = new Category();
						category.setId(rs.getInt(1));
						category.setCategoryName(rs.getString(2));
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (conn != null)
						conn.close();
				}
				return category;
			}

			public List<String> getAllProductsBySearchText(String searchText) throws SQLException 
			{
				List<String> productList = new ArrayList<>();
				try{
						conn = DBConnection.getConnection();
						String sql = "SELECT PR_NAME FROM PRODUCT_MASTER WHERE PR_NAME LIKE ?";
						ps = conn.prepareStatement(sql);
						ps.setString(1, '%' + searchText + '%');
						rs = ps.executeQuery();
						
						while (rs.next())
						{
							productList.add(rs.getString(1));
						}	
				}
				catch(SQLException e)
				{
						e.printStackTrace();
				}
				catch(Exception e)
				{
						e.printStackTrace();
				}
				finally
				{
					if (conn != null)
						conn.close();
				}
				return productList;
			}
			
			public boolean addProduct(int code, String name, int catId, double price, String image, String desc, boolean status, boolean presReq, int tabStrips) throws SQLException
			{
				int res = 0;
				
				try{
					conn = DBConnection.getConnection();
					String sql = "INSERT INTO PRODUCT_MASTER (PR_CODE, PR_NAME, PR_CATEGORY_ID, PR_PRICE, PR_IMAGE, PR_DESC, PR_STATUS, PR_PRESCRIPTION_REQ, PR_TAB_STRIPS) VALUES(?,?,?,?,?,?,?,?,?)";
					ps = conn.prepareStatement(sql);
					ps.setInt(1, code);
					ps.setString(2, name);
					ps.setInt(3, catId);
					ps.setDouble(4, price);
					ps.setString(5, image);
					ps.setString(6, desc);
					ps.setBoolean(7, status);
					ps.setBoolean(8, presReq);
					ps.setInt(9, tabStrips);
					
					res = ps.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (conn != null)
						conn.close();
				}
				if (res == 1)
					return true;
				else
					return false;				
			}

			public boolean placeOrder(int orderNo, int userId, int productId, Date orderDate, int orderQty, double orderPrice, double orderTotal) throws SQLException 
			{
					int res = 0;
					
					try{
						conn = DBConnection.getConnection();
						String sql = "INSERT INTO ORDER_MASTER (OM_ORDER_NUMBER, OM_USER_ID, OM_PROUDCT_ID, OM_DATE, OM_QUANTITY, OM_UNIT_PRICE, OM_TOTAL) VALUES(?,?,?,?,?,?,?)";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, orderNo);
						ps.setInt(2, userId);
						ps.setInt(3, productId);
						ps.setDate(4, orderDate);
						ps.setInt(5, orderQty);
						ps.setDouble(6, orderPrice);
						ps.setDouble(7, orderTotal);
						
						res = ps.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						if (conn != null)
							conn.close();
					}
					if (res == 1)
						return true;
					else
						return false;
			}
			
			public List<Order> getAllOrders() throws SQLException 
			{
				List<Order> list = new ArrayList<>();
				
				try{
					conn = DBConnection.getConnection();
					String sql = "SELECT * FROM ORDER_MASTER ORDER BY OM_ID";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					
					while (rs.next())
					{
						Order order = new Order();
						order.setOrderId(rs.getInt(1));
						order.setOrderNumber(rs.getInt(2));
						order.setUserId(rs.getInt(3));
						order.setProductId(rs.getInt(4));
						order.setOrderDate(rs.getDate(5));
						order.setOrderQuantity(rs.getInt(6));
						order.setOrderUnitPrice(rs.getDouble(7));
						order.setOrderTotal(rs.getDouble(8));
						
						list.add(order);
					}	
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if (conn != null)
						conn.close();
				}
				return list;
			}
}