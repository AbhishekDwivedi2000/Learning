package com.example.Learning.entity;

import com.example.Learning.bean.StudentBean;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = " student")
public class Student extends BaseEntity {

    @Column(name = "firstName")
    @Size(min = 2, message = "name should have 2 character atleast")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Integer studentId;
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Student(String isDeleted, String isActive, String createdBy, String updatedBy, String firstName, String lastName, Integer studentId, String emailId, String phoneNumber) {
        super(isDeleted, isActive, createdBy, updatedBy);
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }



    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId=" + studentId +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
       }
}
