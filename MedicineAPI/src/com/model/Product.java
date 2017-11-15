package com.model;

public class Product {

		private int id;
		private int productCode;
		private String productName;
		private int productCategoryId;
		private double productPrice;
		private String productImagePath;
		private String productDescription;
		private boolean productStatus;
		private boolean productPrescriptionReq;
		private int productTabStrips;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getProductCode() {
			return productCode;
		}
		public void setProductCode(int productCode) {
			this.productCode = productCode;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getProductCategoryId() {
			return productCategoryId;
		}
		public void setProductCategoryId(int productCategoryId) {
			this.productCategoryId = productCategoryId;
		}
		public double getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}
		public String getProductImagePath() {
			return productImagePath;
		}
		public void setProductImagePath(String productImagePath) {
			this.productImagePath = productImagePath;
		}
		public String getProductDescription() {
			return productDescription;
		}
		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}
		public boolean isProductStatus() {
			return productStatus;
		}
		public void setProductStatus(boolean productStatus) {
			this.productStatus = productStatus;
		}
		public boolean isProductPrescriptionReq() {
			return productPrescriptionReq;
		}
		public void setProductPrescriptionReq(boolean productPrescriptionReq) {
			this.productPrescriptionReq = productPrescriptionReq;
		}
		public int getProductTabStrips() {
			return productTabStrips;
		}
		public void setProductTabStrips(int productTabStrips) {
			this.productTabStrips = productTabStrips;
		}
		
		public Product(int id, int productCode, String productName, int productCategoryId, double productPrice,
				String productImagePath, String productDescription, boolean productStatus, boolean productPrescriptionReq,
				int productTabStrips) {
			super();
			this.id = id;
			this.productCode = productCode;
			this.productName = productName;
			this.productCategoryId = productCategoryId;
			this.productPrice = productPrice;
			this.productImagePath = productImagePath;
			this.productDescription = productDescription;
			this.productStatus = productStatus;
			this.productPrescriptionReq = productPrescriptionReq;
			this.productTabStrips = productTabStrips;
		}
		public Product() {
			super();
		}	
}
