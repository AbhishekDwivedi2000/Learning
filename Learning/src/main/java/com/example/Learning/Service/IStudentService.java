package com.example.Learning.Service;

import com.example.Learning.bean.StudentBean;

import java.util.List;

public interface IStudentService {

    void addStudent(StudentBean studentBean) ;
    List<StudentBean> getStudent() ;
  //  List<StudentBean>students();
    void deleteStudent(Integer studentId);
    void updateStudent(StudentBean studentBean,Integer studentId) ;
    StudentBean getone(Integer studentId);



}
