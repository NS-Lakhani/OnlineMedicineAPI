package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.DBConnection;
import com.model.Product;

public class MedicineDao {
	
	public List<Product> getAllProducts() 
	{
			List<Product> productList = new ArrayList<>();
			
			try{
					Connection conn = DBConnection.getConnection();
					String sql = "SELECT * FROM PRODUCT_MASTER";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					
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
			catch(Exception e)
			{
					e.printStackTrace();
			}
		return productList;
	}

}
