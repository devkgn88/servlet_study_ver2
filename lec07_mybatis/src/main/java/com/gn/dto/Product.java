package com.gn.dto;

import lombok.Data;

@Data
public class Product {
	private int productNo;
	private String productName;
	private int productPrice;
	private int productCategory;
	private String sort;
}
