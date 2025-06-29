package com.gn.service;

import java.util.List;

import com.gn.dao.CategoryDao;
import com.gn.dto.Category;

public class CategoryService {
	
	private CategoryDao dao = new CategoryDao();

	public List<Category> getCategoryList(){
        return dao.selectAll();
	}
}
