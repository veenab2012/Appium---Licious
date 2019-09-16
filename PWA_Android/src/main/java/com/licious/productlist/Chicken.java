package com.licious.productlist;

public enum Chicken {
	
	CURRY_CUT_SMALL("Chicken - Curry Cut (Small)"),
	CURRY_CUT_LARGE("Chicken (Skinless) - Curry Cut (Large)"),
	BREAST_BONELESS("Chicken Breast Boneless   ")
	;
	
	String value = "";
	private Chicken(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
