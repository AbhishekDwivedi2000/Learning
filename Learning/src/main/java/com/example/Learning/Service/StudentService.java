package com.example.Learning.Service;

import com.example.Learning.Exception.StudentNotFoundException;
import com.example.Learning.Repository.StudentRepo;
import com.example.Learning.bean.StudentBean;
import com.example.Learning.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StudentService implements IStudentService{

    public final Logger logger= LogManager.getLogger(getClass());
    @Autowired
    private StudentRepo studentRepo;


 @Override
    public void addStudent(StudentBean studentBean) {
        logger.info("Start to Add Student");
       saveStudent(studentBean);
       logger.info("Student saved successfully");

    }

    @Override
    public List<StudentBean> getStudent() {

            List<Student> list = studentRepo.findAll();
            List<StudentBean> listBean = new ArrayList();

                for (Student student : list)
                {
                    listBean.add(convertStudentEntityToBean(student));
                }
               return  listBean;
        }


    @Override
    public StudentBean getone(Integer  studentId) {

        Student student = studentRepo.findById(studentId).orElse(null);
        if (student == null)
            throw new StudentNotFoundException("studentId:" +studentId);
        StudentBean studentBean = convertStudentEntityToBean(student);

        return studentBean;
    }





    @Override
    public void deleteStudent(Integer studentId) {


         studentRepo.deleteById(studentId);



    }


    @Override
    public void updateStudent(StudentBean studentBean, Integer studentId) {

          saveStudent(studentBean);



    }




    private void saveStudent(StudentBean studentBean) {
     studentRepo.save(convertToStudentEntity(studentBean));
        
    }

    public StudentBean  convertStudentEntityToBean(Student student)
    {
      StudentBean studentBean = new StudentBean();
       studentBean.setFirstName(student.getFirstName());
       studentBean.setStudentId(student.getStudentId());
       studentBean.setLastName(student.getLastName());
       studentBean.setEmailId(student.getEmailId());
       studentBean.setPhoneNumber(student.getPhoneNumber());
       return studentBean;
    }

    private Student convertToStudentEntity(StudentBean studentBean)
    {
        Student entity = new Student();
        entity.setFirstName(studentBean.getFirstName());
        entity.setStudentId(studentBean.getStudentId());
        entity.setLastName(studentBean.getLastName());
        entity.setEmailId(studentBean.getEmailId());
        entity.setPhoneNumber(studentBean.getPhoneNumber());
         entity.setUpdatedBy("Sanjay");
        entity.setCreatedBy("Sanjay");
        entity.setActive("false");
        entity.setIsDeleted("true");
         return entity;
    }




}
