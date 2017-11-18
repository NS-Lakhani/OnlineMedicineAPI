package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.DBConnection;
import com.model.Category;
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
						String sql = "SELECT * FROM PRODUCT_MASTER";
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
						String sql = "SELECT * FROM CATEGORY_MASTER";
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

}
