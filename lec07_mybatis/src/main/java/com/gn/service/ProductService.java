package com.gn.service;

import java.util.List;

import com.gn.dao.ProductDao;
import com.gn.dto.Product;

public class ProductService {
	private ProductDao dao = new ProductDao();
	
	public List<Product> searchProduct(Product param){
		return dao.searchProduct(param);
	}
}
