package com.model;

import java.sql.Timestamp;

public class Order {

		private int orderId;
		private String orderNumber;
		private int userId;
		private int productId;
		private Timestamp orderDate;
		private int orderQuantity;
		private double orderUnitPrice;
		private double orderTotal;
	
		public int getOrderId() {
			return orderId;
		}
		
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		
		public String getOrderNumber() {
			return orderNumber;
		}

		public void setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
		}

		public Timestamp getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Timestamp orderDate) {
			this.orderDate = orderDate;
		}

		public int getOrderQuantity() {
			return orderQuantity;
		}
		
		public void setOrderQuantity(int orderQuantity) {
			this.orderQuantity = orderQuantity;
		}
		
		public double getOrderUnitPrice() {
			return orderUnitPrice;
		}
		
		public void setOrderUnitPrice(double orderUnitPrice) {
			this.orderUnitPrice = orderUnitPrice;
		}

		public double getOrderTotal() {
			return orderTotal;
		}
		
		public void setOrderTotal(double orderTotal) {
			this.orderTotal = orderTotal;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public Order() {
			super();
		}		
		
}
