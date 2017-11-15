package com.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Category;
import com.service.CategoryService;

@Path("/category")
public class CategoryResource {

		CategoryService service;
		
		
		public CategoryResource() {
				service = new CategoryService();
		}


		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Category> getAllCategories()
		{
				List<Category> list = new ArrayList<>();
				list = service.getAllCategories();
				
				return list;
		}
}
