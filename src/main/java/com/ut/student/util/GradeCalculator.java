package com.ut.student.util;

import com.ut.student.model.StudentModel;
import com.ut.student.model.SubjectModel;

public class GradeCalculator {

    private final StudentModel student;

    public GradeCalculator(StudentModel student){
        this.student = student;
    }

    public float totalMark(){
        float totalSum = 0f;
        for(SubjectModel s: this.student.getSubjectModelList()){
            totalSum += s.getMarksObtained();
        }
        return totalSum;
    }

    public String studentGrade(){
        float studentMark  = totalMark();
        if (studentMark >= 33.33 && studentMark < 45) return "E";
        if (studentMark >= 45 && studentMark < 55) return "D";
        if (studentMark >= 55 && studentMark < 70) return "C";
        if (studentMark >= 70 && studentMark < 85) return "B";
        if (studentMark >= 85 && studentMark < 90) return "A";
        if (studentMark >= 90) return "A+";
        return "F";

    }

}
