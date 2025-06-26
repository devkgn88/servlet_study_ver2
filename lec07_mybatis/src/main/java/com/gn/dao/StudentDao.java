package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Student;

public class StudentDao {
    public List<Student> selectAll() {
        SqlSession session = SessionTemplate.getSqlSession(true);
        List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectAll");
        session.close();
        return list;
    }	
}
