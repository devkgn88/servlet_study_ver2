package com.gn.service;

import java.util.List;

import com.gn.dao.StudentDao;
import com.gn.dto.Student;

public class StudentService {
    private StudentDao dao = new StudentDao();

    public List<Student> getStudentList() {
        return dao.selectAll();
    }
    
    public Student getStudentDetail(int studentNo) {
        return dao.selectOne(studentNo);
    }
    
    public int insertStudent(Student s) {
        return dao.insert(s);
    }
    

}
