package com.model;

public class JSONResponse {
		
		private boolean success;
		private String message;
		private Object data;
		
		public boolean issuccess() {
			return success;
		}
		public void setsuccess(boolean success) {
			this.success = success;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		
		public JSONResponse(boolean success, String message, Object data) {
			super();
			this.success = success;
			this.message = message;
			this.data = data;
		}
		public JSONResponse() {}

}
