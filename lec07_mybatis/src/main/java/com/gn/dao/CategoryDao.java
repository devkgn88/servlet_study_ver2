package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Category;

public class CategoryDao {
    public List<Category> selectAll() {
        SqlSession session = SessionTemplate.getSqlSession(true);
        List<Category> list = session.selectList("com.gn.mapper.CategoryMapper.selectAll");
        session.close();
        return list;
    }	
}
