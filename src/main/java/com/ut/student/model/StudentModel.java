package com.ut.student.model;

import lombok.*;

import java.util.List;



public class StudentModel {

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSubjectModelList(List<SubjectModel> subjectModelList) {
        this.subjectModelList = subjectModelList;
    }

    private String name;
    private int rollNo;
    private String className;

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getClassName() {
        return className;
    }

    public List<SubjectModel> getSubjectModelList() {
        return subjectModelList;
    }

    private List<SubjectModel> subjectModelList;

    public StudentModel(String name, int rollNo, String className, List<SubjectModel> subjectModelList){
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
        this.subjectModelList = subjectModelList;
    }
}
