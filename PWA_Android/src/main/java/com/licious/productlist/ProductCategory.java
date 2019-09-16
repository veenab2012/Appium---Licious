package com.licious.productlist;

public enum ProductCategory {

	CHICKEN("Chicken"),
	LAMB_GOAT("Lamb & Goat")
	;
	
	String value="";
	private ProductCategory(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
}
