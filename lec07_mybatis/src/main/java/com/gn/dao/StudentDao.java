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
    
    public Student selectOne(int studentNo) {
        SqlSession session = SessionTemplate.getSqlSession(true);
        Student s = session.selectOne("com.gn.mapper.StudentMapper.selectOne", studentNo);
        session.close();
        return s;
    }
    
    public int insert(Student s) {
        SqlSession session = SessionTemplate.getSqlSession(true);
        int result = session.insert("com.gn.mapper.StudentMapper.insert", s);
        session.close();
        return result;
    }

}
