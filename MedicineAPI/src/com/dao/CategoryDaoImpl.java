package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.connection.DBConnection;
import com.model.Category;

public class CategoryDaoImpl implements CategoryDao {
		
		@Override
		public List<Category> getAllCategories() 
		{
				List<Category> list = new ArrayList<>();
				
				try{
						Connection conn = DBConnection.getConnection();
						String sql = "SELECT * FROM CATEGORY_MASTER";
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						
						while (rs.next())
						{
								Category category = new Category();
								category.setId(rs.getInt(1));
								category.setCategoryName(rs.getString(2));
								
								list.add(category);
						}	
				}
				catch(Exception e)
				{
						e.printStackTrace();
				}
			return list;
		}

}
