package com.model;

public class Category {

		private int id;
		private String categoryName;
		private boolean recordAvailable;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public Category(int id, String categoryName) {
			this.id = id;
			this.categoryName = categoryName;
		}

		public Category() {
			// TODO Auto-generated constructor stub
		}

		public boolean isRecordAvailable() {
			return recordAvailable;
		}

		public void setRecordAvailable(boolean recordAvailable) {
			this.recordAvailable = recordAvailable;
		}

}
