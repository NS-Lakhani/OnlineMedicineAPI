package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.CategoryDaoImpl;
import com.model.Category;

public class CategoryServiceImpl implements CategoryService{

		CategoryDaoImpl dao;
		
		public CategoryServiceImpl() {
			dao = new CategoryDaoImpl();
		}
		@Override
		public List<Category> getAllCategories() 
		{
			List<Category> list = new ArrayList<>();
			list = dao.getAllCategories();
			
			return list;
	}

}
