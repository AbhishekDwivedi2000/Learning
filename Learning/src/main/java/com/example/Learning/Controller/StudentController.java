package com.example.Learning.Controller;


import com.example.Learning.Service.IStudentService;
import com.example.Learning.bean.ResponseBean;
import com.example.Learning.bean.StudentBean;
import com.example.Learning.util.ConstantsValues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController

@RequestMapping("/api/v1/student")
public class StudentController {
@Autowired
IStudentService iStudentService;
    private static final Logger logger = LogManager.getLogger(StudentController.class);


    @PostMapping("/")
    public ResponseEntity<StudentBean> addStudentTask( @Valid @RequestBody StudentBean studentBean) {

        iStudentService.addStudent(studentBean);

        return ResponseEntity.created(null).build();
    }

    @GetMapping("/student")
    List<StudentBean> getposts(){
        return iStudentService.getStudent();
    }

    @GetMapping("/{studentId}")
    public StudentBean getstudent( @PathVariable Integer studentId)
    {
        StudentBean bean = iStudentService.getone(studentId);

        return bean;
    }



    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<ResponseBean> deleteTaskByEmployeeTaskID(@PathVariable Integer studentId) {
        iStudentService.deleteStudent(studentId);
        return ResponseEntity.ok(null);
    }
    @PutMapping("/{studentId}")
    public ResponseEntity<ResponseBean> updateStudentByStudentId(@PathVariable Integer studentId,@RequestBody StudentBean studentBean)
{
        studentBean.setStudentId(studentId);
        iStudentService.updateStudent(studentBean,studentId);
        return ResponseEntity.ok(new ResponseBean(ConstantsValues.RESP_OK, ConstantsValues.SUCCESSFULL,null));
    }
}
