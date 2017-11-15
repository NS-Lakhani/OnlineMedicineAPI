package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.CategoryDao;
import com.model.Category;

public class CategoryService{

		CategoryDao dao;
		
		public CategoryService() {
			dao = new CategoryDao();
		}

		public List<Category> getAllCategories() 
		{
			List<Category> list = new ArrayList<>();
			list = dao.getAllCategories();
			
			return list;
	}

}
